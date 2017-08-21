package com.kitri.board.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.board.dao.CommonDao;
import com.kitri.util.BoardConstance;
import com.kitri.util.PageNavigation;
@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int getNextSeq() {
		
		return sqlSession.getMapper(CommonDao.class).getNextSeq();
	}

	@Override
	public PageNavigation makePageNavigation(Map<String,String> queryString) {
		PageNavigation pageNavigation = new PageNavigation();
		int newArticleCount = sqlSession.getMapper(CommonDao.class).newArticleCount(Integer.parseInt(queryString.get("bcode")));
		pageNavigation.setNewArticleCount(newArticleCount);
		int totalArticleCount =sqlSession.getMapper(CommonDao.class).totalArticleCount(queryString);
		pageNavigation.setTotalArticleCount(totalArticleCount);
//		int totalPageCount =totalArticleCount % BoardConstance.LIST_SIZE==0 ? totalArticleCount/BoardConstance.LIST_SIZE : totalArticleCount/BoardConstance.LIST_SIZE+1;
		int totalPageCount = (totalArticleCount-1 )/ BoardConstance.LIST_SIZE+1;
		pageNavigation.setTotalPageCount(totalPageCount);
		int pg =Integer.parseInt(queryString.get("pg"));
		pageNavigation.setNowFirst(pg <=BoardConstance.PAGE_SIZE);
//		pageNavigation.setNowEnd((totalPageCount-1)/BoardConstance.PAGE_SIZE*BoardConstance.PAGE_SIZE<pg);
		pageNavigation.setNowEnd((totalPageCount-1)/BoardConstance.PAGE_SIZE == (pg-1)/BoardConstance.PAGE_SIZE);
		pageNavigation.setPageNo(pg);
		
		
		
		return pageNavigation;
	}
	
}
