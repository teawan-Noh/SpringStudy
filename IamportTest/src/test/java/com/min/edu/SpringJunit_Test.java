package com.min.edu;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.dao.IPaymentsDao;
import com.min.edu.model.dao.IProductsDao;
import com.min.edu.vo.PaymentsVo;
import com.min.edu.vo.ProductsVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SpringJunit_Test {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired 
	private IProductsDao dao;
	
	@Autowired
	private IPaymentsDao pdao;
	
	@Test
	public void test() {
//		assertNotNull(context);
//		List<ProductsVo> obj = dao.productSelectAll();
//		assertNotNull(obj);
		
		List<PaymentsVo> obj = pdao.paymentSelectAll();
		assertNotNull(obj);
	}

}
