package com.kitri.board.dao;

import java.util.List;
import java.util.Map;

import com.kitri.board.model.AlbumDto;

public interface AlbumDao {
	int	writeArticle(AlbumDto adto);
	AlbumDto getArticle(int seq);
	List<AlbumDto> listArticle(Map<String,String> map);
	
	int modifyArticle(AlbumDto adto);
	int deleteArticle(String seq);
}
