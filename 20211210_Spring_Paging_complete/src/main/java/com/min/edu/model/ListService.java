package com.min.edu.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dtos.ListDto;
import com.min.edu.dtos.PagingDto;

@Service
public class ListService implements IListService{

	@Autowired
	private IListDao dao;
	
	@Override
	public List<ListDto> selectPaging(PagingDto paging) {
		return dao.selectPaging(paging);
	}

	@Override
	public int selectTotalPaging() {
		return dao.selectTotalPaging();
	}

	@Override
	public boolean listInsert(ListDto list) {
		return dao.listInsert(list);
	}

	@Override
	public boolean deleteAll() {
		return dao.deleteAll();
	}

}
