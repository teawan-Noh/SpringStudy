package com.min.edu.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.vo.EduVo;

/*
 * @Service 클래스는
 * Transaction의 PointCut의 대상이 되는 *Service*를 가지고 있다.
 * 따라서 하위의 모든 메소드, 메소드이면서 모든 argument를 Transaction처리 된다.
 * 현재는 root-context.xml의 AOP Transaction 설정에 의해서 exception이 발생했을 경우
 * rollback-for="Exception(대문자로 시작)"처리 되어있다.
 */
@Service
public class ServiceImpl implements IService{

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
	 * n : 기존에 입력되어 있는 delflag를 Y로 변경한다.
	 * m : 신규로 입력된 
	 */
	@Transactional
	@Override
	public int transactionTest(EduVo vo) {
		int n = dao.updateBoard();//모든 기존의 컬럼의 delflag를 Y로 변경함
		int m = dao.insertBoard(vo);//신규로 데이터를 입력함
		return n+m;
	}
}
