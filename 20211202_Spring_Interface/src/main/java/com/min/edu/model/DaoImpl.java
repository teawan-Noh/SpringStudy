package com.min.edu.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.EduVo;

@Repository
public class DaoImpl implements IDao {
	//Logger의 Arguments를 사용되는 클레스위치를 넣어주는 이유는 
	//logger는 메모리의 Trance를 따라서 생성이 되기 때문에 다른 Log작동과 구분을 위하여
	//출력되는 클레스를 입력한다.
//	private Logger logger = LoggerFactory.getLogger(IDaoImpl.class);
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//페키지를 뜻하는것이 아니라 Mapper의 구분을 위해서 사용한다.
	private final String NS = "com.min.edu.moel.DaoImpl.";
	
	//Autowired는 Spring container에 단 한개만 존재하는 bean으로 선언된 타입을 자동으로 DI(주입) 해준다
	// 만약 같은 타입으로 생성된 여러개의 bean이 있다면 @Resource를 통해서 id를 작성하여 선택적으로 DI(주입)한다
	// root-context.xml에 <bean class="SqlSessionTemplate">을 지향하고 있다.
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//dao는 aop로 로그처리를 했으므로 로그 안찍어줘도 되지만 수업용으로 찍음 service는 찍어줘야함
	@Override
	public List<EduVo> selectBoard() {
		logger.info("사용자 logger {}", "selectBoard");
		return sqlSession.selectList(NS+"selectBoard");
	}
	
	@Override
	public int insertBoard(EduVo vo) {
		logger.info("사용자 logger {}", "insertBoard");
		logger.info("&&&& 처음 입력 받았던 VO의 seq : {}", vo.getSeq());
		int n = sqlSession.insert(NS+"insertBoard", vo);
		logger.info("&&&& 작동 후 VO의 seq : {}", vo.getSeq());
		return n;
	}

	@Override
	public int updateBoard() {
		logger.info("사용자 logger {}", "updateBoard");
		return sqlSession.update(NS+"updateBoard");
	}

}
