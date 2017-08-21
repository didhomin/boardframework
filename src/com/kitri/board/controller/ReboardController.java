package com.kitri.board.controller;

import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kitri.board.model.MemoDto;
import com.kitri.board.model.ReBoardDto;
import com.kitri.board.service.CommonService;
import com.kitri.board.service.MemoService;
import com.kitri.board.service.ReboardService;
import com.kitri.member.model.MemberDto;
import com.kitri.util.PageNavigation;

@Controller
@RequestMapping("/reboard")
public class ReboardController {

	@Autowired
	private ReboardService reboardService;
	@Autowired
	private MemoService memoService;
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping(value="/write.html",method=RequestMethod.GET)
	public ModelAndView write(@RequestParam Map<String,String> queryString) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("qs",queryString);
		mav.setViewName("write");
		return mav;
	}
	@RequestMapping(value="/write.html",method=RequestMethod.POST)
	public ModelAndView write(@RequestParam Map<String,String> queryString,ReBoardDto reboardDto, HttpSession session ) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto= (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
		int seq = commonService.getNextSeq();
		reboardDto.setSeq(seq);
		reboardDto.setId(memberDto.getId());
		reboardDto.setName(memberDto.getName());
		reboardDto.setEmail(memberDto.getEmail1()+"@"+memberDto.getEmail2());
		reboardDto.setRef(seq);
		int cnt = reboardService.writeArticle(reboardDto);
		mav.addObject("qs",queryString);
		mav.addObject("seq",seq);
		mav.setViewName("writeOk");
		} else {
			mav.setViewName("/index");//로그인페이지로이동
		}
		return mav;
	}
	
	@RequestMapping(value="/view.html",method=RequestMethod.GET)
	public ModelAndView view(@RequestParam Map<String,String> queryString,@RequestParam("seq") int seq
			,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		ReBoardDto reDto = null;
		List<MemoDto> list =null;
		if(memberDto!=null) {
			reDto = reboardService.getArticle(seq);
			list = memoService.listMemo(seq);
		}
		mav.addObject("list",list);
		mav.addObject("qs",queryString);
		mav.addObject("article",reDto);
		mav.setViewName("view");
		return mav;
	}
	
	
	@RequestMapping(value="/list.html",method=RequestMethod.GET)
	public ModelAndView list(@RequestParam Map<String,String> queryString,HttpSession session,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		List<ReBoardDto> list = reboardService.listArticle(queryString);
		PageNavigation page = commonService.makePageNavigation(queryString);
		page.setRoot(request.getContextPath());
		page.setNavigator();
		mav.addObject("qs",queryString);
		mav.addObject("page",page);
		mav.addObject("articleList",list);
		mav.setViewName("list");
		return mav;
	}
	@RequestMapping(value="/reply.html", method=RequestMethod.GET)
	public ModelAndView reply(@RequestParam Map<String, String> queryString,
			@RequestParam("seq") int seq, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		ReBoardDto reboardDto = null;
		if(memberDto != null) {
			reboardDto = reboardService.getArticle(seq);
		}
		mav.addObject("qs", queryString);
		mav.addObject("article", reboardDto);
		mav.setViewName("reply");
		return mav;
	}
	@RequestMapping(value="/reply.html",method=RequestMethod.POST)
	public ModelAndView relpy(@RequestParam Map<String,String> queryString,ReBoardDto reboardDto, HttpSession session ) {
		ModelAndView mav = new ModelAndView();
		MemberDto memberDto= (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = commonService.getNextSeq();
			reboardDto.setSeq(seq);
			reboardDto.setId(memberDto.getId());
			reboardDto.setName(memberDto.getName());
			reboardDto.setEmail(memberDto.getEmail1()+"@"+memberDto.getEmail2());
			reboardService.replyArticle(reboardDto);
			mav.addObject("qs",queryString);
			mav.addObject("seq",seq);
			mav.setViewName("writeOk");
		} else {
			mav.setViewName("/index");//로그인페이지로이동
		}
		return mav;
	}
}
