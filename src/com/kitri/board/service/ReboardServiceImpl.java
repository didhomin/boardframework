package com.kitri.board.service;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.board.dao.CommonDao;
import com.kitri.board.dao.ReboardDao;
import com.kitri.board.model.ReBoardDto;
import com.kitri.util.BoardConstance;
@Service
public class ReboardServiceImpl implements ReboardService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int writeArticle(ReBoardDto reboardDto) {
		
		return sqlSession.getMapper(ReboardDao.class).writeArticle(reboardDto);
	}

	@Override 
	public ReBoardDto getArticle(int seq) {
		sqlSession.getMapper(CommonDao.class).updateHit(seq);
		return sqlSession.getMapper(ReboardDao.class).getArticle(seq);
	}

	@Override
	public List<ReBoardDto> listArticle(Map<String,String> queryString) {
		int pg = Integer.parseInt(queryString.get("pg"));
		int end = pg * BoardConstance.LIST_SIZE;
		int start = end - BoardConstance.LIST_SIZE;
		queryString.put("start", start+"");
		queryString.put("end", end+"");
		return sqlSession.getMapper(ReboardDao.class).listArticle(queryString);
	}

	@Override
	public void replyArticle(ReBoardDto reboardDto) {
		ReboardDao reboardDao = sqlSession.getMapper(ReboardDao.class);
		reboardDao.updateStep(reboardDto);
		reboardDao.replyArticle(reboardDto);
		reboardDao.updateReply(reboardDto.getPseq());
	}

	@Override
	public int modifyArticle(ReBoardDto reboardDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteArticle(String seq) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
