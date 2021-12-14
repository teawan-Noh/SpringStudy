package com.min.edu.model;

import java.util.List;

import com.min.edu.dtos.ListDto;
import com.min.edu.dtos.PagingDto;

public interface IListService {
	public List<ListDto> selectPaging(PagingDto paging);
	public int selectTotalPaging();
	
	public boolean listInsert(ListDto list);
	public boolean deleteAll();
	
}
