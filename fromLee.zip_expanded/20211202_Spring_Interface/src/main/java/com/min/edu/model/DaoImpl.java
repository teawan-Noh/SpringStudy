package com.min.edu.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.EduVo;

@Repository
public class DaoImpl implements IDao{
	
	//Logger의 Arguements가 사용되는 클래스 위치를 넣어주는 이유는
	//logger는 메모리의 Trance 를 따라서 생성이 되기 때문에 다른 Log 작동과 구분을 위해서
	//출력되는 클래스를 입력한다.
	private Logger logger = LoggerFactory.getLogger(DaoImpl.class);
	//패키지는 뜻하는 것이 아니라 Mapper의 구분을 위해서 사용함
	private final String NS = "com.min.edu.model.DaoImpl.";
	
	//Autowired는 Spring Container에 단 한개만 존재하는 bean으로 선언된 타입을 자동으로 DI(주입) 해준다.
	//만약 같은 타입으로 생성된 여러개의 bean이 있다면 @Resource를 통해서 id를 작성하여 선택으로 DI(주입)한다.
	//root-context.xml에 <bean class="SqlSessionTemplate">을 지향하고 있다. 
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<EduVo> selectBoard() {
		logger.info("사용자 logger {}" , "selectBoard");
		return sqlSession.selectList(NS+"selectBoard");
	}
	
	@Override
	public int insertBoard(EduVo vo) {
		logger.info("사용자 logger {}" , "insertBoard");
		//logger.info("처음 입력받았던 VO의 seq : {}", vo.getSeq());
		int n = sqlSession.insert(NS+"insertBoard",vo);
		logger.info("작동 후 VO의 seq : {}", vo.getSeq());
		return n;
	}
	
	@Override
	public int updateBoard() {
		logger.info("사용자 logger {}" , "updateBoard");
		return sqlSession.update(NS+"updateBoard");
	}
	
}
