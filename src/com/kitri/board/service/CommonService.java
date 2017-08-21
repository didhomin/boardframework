package com.kitri.board.service;

import java.util.Map;

import com.kitri.util.PageNavigation;

public interface CommonService {

	
	int getNextSeq();
	PageNavigation makePageNavigation(Map<String,String> queryString);
}
