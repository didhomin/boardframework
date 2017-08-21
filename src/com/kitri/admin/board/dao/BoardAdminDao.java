package com.kitri.admin.board.dao;

import java.util.List;

import com.kitri.admin.board.model.*;

public interface BoardAdminDao {
	public List<BoardListDto> boardList();
	List<CategoryDto> categoryList();
	void categoryMake(String cname);
	List<BoardTypeDto> boardTypeList();
	void boardMake(BoardListDto bdto);
}
