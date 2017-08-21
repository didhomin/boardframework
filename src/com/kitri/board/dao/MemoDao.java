package com.kitri.board.dao;

import java.util.List;

import com.kitri.board.model.MemoDto;

public interface MemoDao {
	void writeMemo(MemoDto memberDto);
	List<MemoDto> listMemo(int seq);
	void modifyMemo(MemoDto memberDto);
	void deleteMemo(int mseq);
}
