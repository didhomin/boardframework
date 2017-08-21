package com.kitri.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SmartEditorController {

	@RequestMapping(value="/file_uploader_html5.html",method=RequestMethod.POST)
	@ResponseBody
	public String multiUpload(HttpServletRequest request) {
		StringBuffer sb = null;
		try {
			String filename = request.getHeader("file-name");
			String ext = filename.substring(filename.lastIndexOf('.'));//.jpg
			String realPath = request.getServletContext().getRealPath("/SE2");
			String saveDiectory = realPath + File.separator + "upload" + File.separator;
			File dir = new File(saveDiectory);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			String savename = UUID.randomUUID().toString()+ext;
			InputStream is =request.getInputStream();
			OutputStream os = new FileOutputStream(saveDiectory+savename);
			int read=0;
			byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
			while((read = is.read(b,0,b.length))!=-1) {
				os.write(b, 0, read);
			}  
			if(is!=null)
				is.close();
			if(os!=null) {
				os.flush();
				os.close();
			}
			sb=new StringBuffer();
			sb.append("&bNewLine=true")
			.append("&sFileName="+filename)
			.append("&sFileURL="+request.getContextPath()+"/SE2/upload/"+savename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
}
