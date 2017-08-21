package com.kitri.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.kitri.board.model.MemoDto;
import com.kitri.board.service.MemoService;
import com.kitri.member.model.MemberDto;

@Controller
@RequestMapping("/memo")
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	private JSONObject makeList(int seq) {
		List<MemoDto> list = memoService.listMemo(seq);
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		for (MemoDto memoDto : list) {
			JSONObject jobj = new JSONObject();
			jobj.put("mseq", memoDto.getMseq());
			jobj.put("seq", memoDto.getSeq());
			jobj.put("id", memoDto.getId());
			jobj.put("name", memoDto.getName());
			jobj.put("mcontent", memoDto.getMcontent());
			jobj.put("mtime", memoDto.getMtime());
			
			jarr.add(jobj);
		}
		json.put("memolist", jarr);
		return json;
	}
	
	@RequestMapping(value="/write.html", method=RequestMethod.POST)
	public @ResponseBody String write(MemoDto memoDto, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		memoDto.setId(memberDto.getId());
		memoDto.setName(memberDto.getName());
		memoService.writeMemo(memoDto);
		
		JSONObject json = makeList(memoDto.getSeq());
		return json.toJSONString();
	}
	
}











