<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/public.jsp" %>
<%@ include file="/common/logincheck.jsp" %>
<!-- title -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('.link_board_03').click(function() {
		$('#bcode').val('${qs.bcode}');
		$('#pg').val('${qs.pg}');
		$('#key').val('${qs.key}');
		$('#word').val('${qs.word}');
//		$('#seq').val($(this).parents('tr').children('.bseq').text());
		$('#seq').val($(this).attr('data-seq'));
		$('#commonForm').attr('action','${root}/reboard/view.html').submit();
	});
	$('.newBtn').click(function() {
		$('#bcode').val('${qs.bcode}');
		$('#pg').val('1');
		$('#key').val('');
		$('#word').val('');
		$('#commonForm').attr('action','${root}/reboard/write.html').submit();
	});
	$('.replyBtn').click(function() {
		$('#bcode').val('${qs.bcode}');
		$('#pg').val('1');
		$('#key').val('');
		$('#word').val('');
		$('#seq').val('${article.seq}');
		$('#commonForm').attr('action', '${root}/reboard/reply.html').submit();
	});
	$('.newListArticle').click(function() {
		$('#bcode').val('${qs.bcode}');
		$('#pg').val('1');
		$('#commonForm').attr('action','${root}/reboard/list.html').submit();
	});
	$('.listArticle').click(function() {
		$('#bcode').val('${qs.bcode}');
		$('#pg').val('${qs.pg}');
		$('#key').val('${qs.key}');
		$('#word').val('${qs.word}');
		$('#commonForm').attr('action','${root}/reboard/list.html').submit();
	});
	$('#memoWriteBtn').click(function() {
		var content = $.trim($('#mcontent').val());
		if(content != '') {
			$.ajax({
				type : 'POST',
				dataType : 'json',
				url : '${root}/memo/write.html',
				data : {'seq' : '${article.seq}', 'mcontent' : content},
				success : function(data) {
					$('#mcontent').val('');
					makeMemoList(data);
					
				}
			});
		}
	});
});
function makeMemoList(data){
	var output = '';
	var len = data.memolist.length;
	for(var i=0;i<len;i++) {
		output+='<div class="row">';
		output+='<div class="col-sm-1">'+data.memolist[i].id+'</div>';
		output+='<div class="col-sm-9">'+data.memolist[i].mcontent+'</div>';
		output+='<div class="col-sm-1">'+data.memolist[i].mtime+'</div>';
		if('${userInfo.id}'==data.memolist[i].id) {
			output+='<div class="col-sm-1">수정 삭제</div>';
		}
		output+='</div>';
	}
	$('#memoView').empty();
	$('#memoView').append(output);	
}
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

<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<form name="bbsForm" id="bbsbbs" method="post"><input
		type="hidden" name="" value="">
	<tr>
		<td valign="bottom" nowrap><a href="#"><img class="newBtn"
			src="${root}/img/board/btn_write_01.gif" width="64" height="22"
			border="0" align="absmiddle" alt="글쓰기"></a> <a
			href="#"><img class="replyBtn"
			src="${root}/img/board/btn_reply.gif" width="40" height="22"
			border="0" align="absmiddle" alt="답글"></a></td>
		<td valign="bottom" width="100%" style="padding-left: 4px"></td>
		<td align="right" nowrap valign="bottom"><a
			href="#" class="newListArticle">최신목록</a> <font color="#c5c5c5">|</font>
		<a href="#" class="listArticle">목록</a> <font color="#c5c5c5">|</font>

		<a href="javascript:goBbsRead();"><img
			src="${root}/img/board/icon_up.gif" border="0" align="absmiddle"
			hspace="3">윗글</a> <font color="#c5c5c5">|</font> <a
			href="javascript:goBbsRead();">아랫글<img
			src="${root}/img/board/icon_down.gif" border="0" align="absmiddle"
			hspace="3"></a></td>
	</tr>
	<tr>
		<td colspan="3" height="5" style="padding: 0px"></td>
	</tr>
</table>

<table border="0" cellpadding="5" cellspacing="0" width="100%">
	<tr>
		<td class="bg_board_title_02" colspan="2" height="2"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
	<tr height="28">
		<td class="bg_board_title" colspan="2" style="padding-left: 14px">
		<b><font class="text"> ${article.subject } </font></b></td>
	</tr>
	<tr>
		<td class="bg_board_title_02" colspan="2" height="1"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
	<tr height="26">
		<td width="100%" style="padding-left: 14px"><font class="stext">번호
		:</font> <font class="text_commentnum">${article.seq }</font> &nbsp; <font
			class="stext">글쓴이 :</font> <a href="javascript:;"
			onClick="showSideView();" class="link_board_02">${article.name }</a><br>
		</td>
		<td style="padding-right: 14px" nowrap class="stext">조회 : <font
			class="text_commentnum">${article.hit }</font> &nbsp; 스크랩 : <font
			class="text_commentnum">0</font> &nbsp; 날짜 : <font
			class="text_commentnum">${article.logtime }</font></td>
	</tr>
	<tr>
		<td class="bg_board_title_02" colspan="2" height="1"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
</table>

<table border="0" cellpadding="15" cellspacing="0" width="100%">
	<tr valign="top">
		<td bgcolor="#ffffff" width="100%" class="text"
			style="padding-bottom: 8px; line-height: 1.3" id="clix_content">



		<P>${article.content }</P>



		</td>
		<td nowrap valign="top" align="right" style="padding-left: 0px">

		</td>
	</tr>
</table>

<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td class="bg_board_title_02" height="1"
			style="overflow: hidden; padding: 0px"></td>
	</tr>
</table>

<!-- 하단 페이징 -->
<table cellpadding="0" cellspacing="0" border="0" width="100%">
	<tr>
		<td colspan="3" height="5" style="padding: 0px"></td>
	</tr>
	<tr valign="top">
		<td nowrap><a href="#"><img class="newBtn"
			src="${root}/img/board/btn_write_01.gif" width="64" height="22"
			border="0" align="absmiddle" alt="글쓰기"></a> <a
			href="#"><img class="replyBtn"
			src="${root}/img/board/btn_reply.gif" width="40" height="22"
			border="0" align="absmiddle" alt="답글"></a></td>
		<td style="padding-left: 4px" width="100%"><a href=""
			target="new"><img src="${root}/img/board/btn_print.gif"
			width="30" height="18" border="0" align="absmiddle" alt="인쇄"></a></td>

		<td align="right" nowrap><a href="#" class="newListArticle">최신목록</a>
		<font color="#c5c5c5">|</font> <a href="#" class="">목록</a>
		<font color="#c5c5c5">|</font> <a href="javascript:goBbsRead();"><img
			src="${root}/img/board/icon_up.gif" border="0" align="absmiddle"
			hspace="3">윗글</a> <font color="#c5c5c5">|</font> <a
			href="javascript:goBbsRead();">아랫글<img
			src="${root}/img/board/icon_down.gif" border="0" align="absmiddle"
			hspace="3"></a></td>
	</tr>
</table>
<br>
<div class="row">
<div class="col-sm-1">댓글</div>
	<form class="form-group input-group-lg" name="memoForm" id="memoForm" action="">
	<div class="col-sm-10">
		<textarea class="form-control" name="mcontent" id="mcontent" style="" ></textarea>
	</div>
	<div class="col-sm-1">
		<input class="btn btn-lg btn-info" type="button" id="memoWriteBtn" value="등록">
	</div>
	</form>
</div>
<hr/>
<div id="memoView">
<c:forEach items="${list }" var="i">
<div class="row">
		<div class="col-sm-1">${i.id}</div>
		<div class="col-sm-9">${i.mcontent}</div>
		<div class="col-sm-1">${i.mtime}</div>
		<c:if test="${userInfo.id eq i.id}">
			<div class="col-sm-1">수정 삭제</div>
		</c:if>
</div>
</c:forEach>
</div>
</body>
</html>