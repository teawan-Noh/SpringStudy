package com.min.edu.model;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.dtos.ListDto;
import com.min.edu.dtos.PagingDto;

@Repository
public class ListDao implements IListDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String NS="com.min.edu.model.ListDao.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<ListDto> selectPaging(PagingDto paging) {
		logger.info("*********** 페이징 DAO selectPaging************** {}", new Date());
		return sqlSession.selectList(NS + "selectPaging",paging);
	}

	@Override
	public int selectTotalPaging() {
		return sqlSession.selectOne(NS+"selectTotalPaging");
	}

	@Override
	public boolean listInsert(ListDto list) {
		return sqlSession.insert(NS+"listInsert",list) == 1? true : false;
	}

	@Override
	public boolean deleteAll() {
		return sqlSession.delete(NS+"deleteAll") == 0? true : false;
	}

}
