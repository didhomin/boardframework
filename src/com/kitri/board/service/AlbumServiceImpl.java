package com.kitri.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.board.dao.AlbumDao;
import com.kitri.board.model.AlbumDto;

@Service
public class AlbumServiceImpl implements AlbumService {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int writeArticle(AlbumDto adto) {
		return sqlSession.getMapper(AlbumDao.class).writeArticle(adto);
	}

	@Override
	public AlbumDto getArticle(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlbumDto> listArticle(int bcode, int pg, String key, String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyArticle(AlbumDto adto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteArticle(String seq) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
