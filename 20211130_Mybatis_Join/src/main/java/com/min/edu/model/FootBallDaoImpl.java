package com.min.edu.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.All_Dto;
import com.min.edu.dto.Player_Dto2;
import com.min.edu.dto.Team_Dto;
import com.min.edu.dto.Team_Dto3;
import com.min.edu.mybatis.SqlSessionFactioryManager;

public class FootBallDaoImpl implements IFootBallDao {

	private Logger log = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactioryManager.getFactory();
	
	private final String NS1 = "com.min.edu.join1.";
	private final String NS2 = "com.min.edu.join2.";
	private final String NS3 = "com.min.edu.join3.";
	private final String NS4 = "com.min.edu.join4.";
	private final String NS5 = "com.min.edu.join5.";
	
	@Override
	public List<All_Dto> combine1() {
		log.info("하나의 단일 DTO 조인 매핑");
		SqlSession session = manager.openSession();
		List<All_Dto> lists = session.selectList(NS1+"jobCombine1");
		return lists;
	}

	@Override
	public List<Team_Dto> combine2() {
		log.info("각각의 DTO를 생성후 OGNL방식으로 접근");
		SqlSession session = manager.openSession();
		List<Team_Dto> lists = session.selectList(NS2+"jobCombine2");
		return lists;
	}

	@Override
	public List<Team_Dto> combine3() {
		log.info("각각의 DTO를 생성후 Collection(team->player)방식으로 접근");
		SqlSession session = manager.openSession();
		List<Team_Dto> lists = session.selectList(NS3+"jobCombine3");
		return lists;
	}

	@Override
	public List<Player_Dto2> combine4() {
		log.info("각각의 DTO를 생성후 Collection(player->team)방식으로 접근");
		SqlSession session = manager.openSession();
		List<Player_Dto2> lists = session.selectList(NS4+"jobCombine4");
		return lists;
	}
	
	@Override
	public List<Team_Dto3> combine5() {
		log.info("각각의 DTO를 생성후 Collection(team-> List<player>)을 사용하여 Mapping");
		SqlSession session = manager.openSession();
		List<Team_Dto3> lists = session.selectList(NS5+"jobCombine5");
		return lists;
	}

}
