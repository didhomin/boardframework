package com.kitri.board.service;

import java.util.List;

import com.kitri.board.model.AlbumDto;

public interface AlbumService {
	int	writeArticle(AlbumDto adto);
	AlbumDto getArticle(int seq);
	List<AlbumDto> listArticle(int bcode,int pg,String key, String word);
	
	int modifyArticle(AlbumDto adto);
	int deleteArticle(String seq);
}
