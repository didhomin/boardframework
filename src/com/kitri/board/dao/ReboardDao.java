package com.kitri.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kitri.board.model.ReBoardDto;
@Repository
public interface ReboardDao {
	
	int	writeArticle(ReBoardDto reboardDto);
	ReBoardDto getArticle(int seq);
	List<ReBoardDto> listArticle(Map<String,String> queryString);
	void replyArticle(ReBoardDto reboardDto);
	void updateStep(ReBoardDto reboardDto);
	void updateReply(int pseq);
	
	int modifyArticle(ReBoardDto reboardDto);
	int deleteArticle(String seq);
}
