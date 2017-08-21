package com.kitri.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.board.dao.MemoDao;
import com.kitri.board.model.MemoDto;

@Service
public class MemoServiceImpl implements MemoService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void writeMemo(MemoDto memoDto) {
		sqlSession.getMapper(MemoDao.class).writeMemo(memoDto);		
	}

	@Override
	public List<MemoDto> listMemo(int seq) {
		return sqlSession.getMapper(MemoDao.class).listMemo(seq);
	}

	@Override
	public void modifyMemo(MemoDto memberDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMemo(int mseq) {
		// TODO Auto-generated method stub
		
	}

}
