package com.kitri.board.service;

import java.util.List;

import com.kitri.board.model.MemoDto;

public interface MemoService {
	void writeMemo(MemoDto memberDto);
	List<MemoDto> listMemo(int seq);
	void modifyMemo(MemoDto memberDto);
	void deleteMemo(int mseq);
}
