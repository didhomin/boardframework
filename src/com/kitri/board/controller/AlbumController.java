package com.kitri.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kitri.board.model.AlbumDto;
import com.kitri.board.service.AlbumService;
import com.kitri.board.service.CommonService;
import com.kitri.member.model.MemberDto;

@Controller
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
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
	public ModelAndView write(@RequestParam Map<String,String> queryString,AlbumDto albumDto,
			HttpSession session,@RequestParam("picture") MultipartFile picture,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		if(!picture.isEmpty()) {
			String original_name = picture.getOriginalFilename();
			
			DateFormat df = new SimpleDateFormat("yyMMdd");
			String today = df.format(new Date());
			String uploadDirectory = request.getRealPath("/upload")+File.separator+today;
			File dir = new File(uploadDirectory);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			String filename=today + System.nanoTime()+ original_name.substring(original_name.lastIndexOf("."));
			try {
				picture.transferTo(new File(uploadDirectory,filename));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			MemberDto memberDto= (MemberDto) session.getAttribute("userInfo");
			if(memberDto != null) {
				int seq = commonService.getNextSeq();
				albumDto.setSeq(seq);
				albumDto.setId(memberDto.getId());
				albumDto.setName(memberDto.getName());
				albumDto.setEmail(memberDto.getEmail1()+"@"+memberDto.getEmail2());
				albumDto.setOrignPicture(original_name);
				albumDto.setSaveFolder(today);
				albumDto.setSavePicture(filename);
				int cnt = albumService.writeArticle(albumDto);
				mav.addObject("qs",queryString);
				mav.addObject("seq",seq);
				mav.setViewName("writeOk");
			} else {
				mav.setViewName("/index");//로그인페이지로이동
			}
		}
		return mav;
	}
}
