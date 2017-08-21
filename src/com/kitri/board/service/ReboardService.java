package com.kitri.board.service;

import java.util.List;
import java.util.Map;

import com.kitri.board.model.ReBoardDto;

public interface ReboardService {

	int	writeArticle(ReBoardDto reboardDto);
	ReBoardDto getArticle(int seq);
	List<ReBoardDto> listArticle(Map<String,String> queryString);
	void replyArticle(ReBoardDto reboardDto);
	
	int modifyArticle(ReBoardDto reboardDto);
	int deleteArticle(String seq);
	

}
