package com.min.edu.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.vo.EduVo;
/*
 * @Service 클레스는 Transaction의 Pointcut의 대상이되는 *Service를 가지고 있다
 * 따라서 하위의 모든 메소드, 메소드 모든 argument를 Transaction 처리 된다.
 * 현재는 root-context.xml의 AOP Transaction 설정에 의해서 exception이 발생했을 경우 rollback-for="exception" 처리되어 있다
 */
@Service
public class ServiceImpl implements IService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IDao dao;

	@Transactional(readOnly = true)
	@Override
	public List<EduVo> selectBoard() {
		return dao.selectBoard();
	}
	
	@Transactional
	@Override
	public int insertBoard(EduVo vo) {
		return dao.insertBoard(vo);
	}

	/*
	 * Transaction발생 시나리오
	 * n : 기존에 입력되어 있는 delflag를 Y로 변경함
	 * m : 신규로 입력된 값을 delflag
	 */
	@Transactional
	@Override
	public int TransactionTest(EduVo vo) {
		int n = dao.updateBoard(); 
		int m = dao.insertBoard(vo);
		return n+m;
	}
}
