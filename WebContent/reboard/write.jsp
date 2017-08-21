<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<%@ include file="/common/logincheck.jsp" %>

<!-- title -->
<script src="${root }/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
var oEditors = [];
$(document).ready(function() {
	
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "content", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "${root}/SE2/SmartEditor2Skin.jsp", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});
	
	$('#writeBtn').click(function() {
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
		var contents = $.trim(oEditors[0].getContents());
		if($('#subject').val()=="") {
			return alert("제목을입력하세요");
		}else if(contents === '<p>&nbsp;</p>' || contents === '') {
			return alert("내용을입력하세요");
			oEditors.getById['content'].exec('FOCUS');
		}else {
			$('#writeForm').attr('action','${root}/reboard/write.html').attr('method','post').submit();
		}
	});
});
</script>
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td><img src="${root}/img/board/m_icon_board.gif" width="9"
			height="9" border="0" align="absmiddle" style="margin-top: -2px">
		<b>자유게시판</b> &nbsp;<font style="font-size: 8pt">|</font>&nbsp; 자유로운 글을
		올리는 공간입니다<br>
		</td>
		<td align="right"></td>
	</tr>
	<tr>
		<td colspan="2" height="19"></td>
	</tr>
</table>

<table border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td><img src="${root}/img/board/icon_arrow_04.gif" width="4"
			height="11" border="0" align="absmiddle" vspace="4"></td>
		<td width="100%" style="padding-left: 4px"><b>글쓰기</b></td>
	</tr>
	<tr>
		<td colspan="2" height="2" class="bg_board_title_02"></td>
	</tr>
</table>
<br>

<form id="writeForm" name="writeForm" method="post" action=""
	style="margin: 0px">
<div id="attach_file_hdn"></div>

<input type="hidden" name="bcode" value="${qs.bcode }">
<input type="hidden" name="pg" value="1">
<input type="hidden" name="key" value="">
<input type="hidden" name="word" value="">

<table border="0" cellpadding="5" cellspacing="0" 
	style="table-layout: fixed">

	<tr valign="top">
		<td width="95" nowrap style="padding-left: 8px; padding-top: 10px"><img
			src="${root}/img/board/e_dot.gif" width="4" height="4" border="0"
			align="absmiddle"> <b>제목</b></td>
		<td colspan="5"><input name="subject" id="subject" type="text"
			size="76" maxlength="150" class="inp_02" style="
			value=""><img src="${root}/img/board/i_info.gif" width="12"
			height="11" border="0" align="absmiddle" vspace="8"
			style="margin: 3 3 0 6"><font class="stext">최대 한글 75자,
		영문 150자</font><br>
	</tr>
	<tr>
		<td  nowrap style="padding-left: 8px; padding-top: 10px"
			colspan="5"><img src="${root}/img/board/e_dot.gif" width="4"
			height="4" border="0" align="absmiddle"> <b>글내용</b> <textarea id="content"
			name="content" class="inp_02" cols="67" rows="25" scrollbars="no"></textarea>
		</td>
	</tr>
</table>
<table  cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td height="5" style="padding: 0px"></td>
	</tr>
	<tr>
		<td class="bg_board_title_02" height="1"></td>
	</tr>
</table>

<table border="0" cellpadding="2" cellspacing="0" width="630">
	<tr>
		<td height="10" style="padding: 0px"></td>
	</tr>
	<tr>
		<td align="center"><a href="#"><img id="writeBtn"
			src="${root}/img/board/btn_register.gif" width="42" height="21"
			border="0" name="register" value="" alt="등록"></a> <a
			href="javascript:history.back();"><img
			src="${root}/img/board/b_cancel.gif" width="42" height="21"
			border="0" name="cencel" value="" alt="취소"></a></td>
	</tr>
</table>
</form>
<br>
<br>
</body>
</html>