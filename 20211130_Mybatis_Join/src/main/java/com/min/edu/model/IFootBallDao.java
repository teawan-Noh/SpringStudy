package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.All_Dto;
import com.min.edu.dto.Player_Dto2;
import com.min.edu.dto.Team_Dto;
import com.min.edu.dto.Team_Dto3;

public interface IFootBallDao {

	/**
	 * 이전과 동일 방식으로 처리
	 * 하나의 DTO에 객체 두개의 테이블 컬럼을 모두 등록하여 매핑될 수 있도록함
	 * 하나의 객체에 모든 매핑을 가지고 있기 때문에 편하게 사용할 수 있다
	 * 하지만 컬럼
	 */
	public List<All_Dto> combine1();
	
	/**
	 * 각 테이블에 매핑이되는 DTO 객체를 따로 생성한 후
	 * 부모자식관계 혹은 조인 후 발생되는 개수에 따라서 한 객체에 다른 DTO의 객체를 멤버필드로 사용
	 * MyBatis의 Mapper.xml(resultMap)에서는 호출시 OGNL(Object Graph Notation Language) 방식으로 접근
	 */
	public List<Team_Dto> combine2();
	
	/**
	 * MyBatis Mapper에서 &lt;<collection>&dt;을 사용하여 resultMap을 선언하여 연결
	 * Team_Dto에 Palyer_Dto를 멤버필드로 생성한 객체이기 때문에 
	 * Collection을 사용하면 team의 개수만큼 출력
	 * team 테이블이 15개의 row를 가지고 있기 떄문에 join된 결과는 15개만 출력된다
	 */
	public List<Team_Dto> combine3();
	
	/**
	 * MyBatis Mapper에서 &lt;<collection>&dt;을 사용하여 resultMap을 선언하여 연결
	 * Palyer_Dto에 Team_Dto를 멤버필드로 생성한 객체이기 때문에 
	 * Collection을 사용하면 Palyer의 개수만큼 출력
	 * play 테이블이 480개의 row를 가지고 있기 때문에 join된 결과는 180개만 출력된다
	 * PLAYER_NAME = '곽기훈'이 같은 POSITION, BACK_NO TEAM_ID를 가지고 있기 때문에 하나로 판별
	 */
	public List<Player_Dto2> combine4();
	 /**
	  * MyBatis Mapper에 Collection을 사용하여 처리한다.
	  * 추가적으로 메인(부모 테이블)객체에 1:n관계를 출력하기 위하여 List로 멤버필드를 선언한다.
	  */
	public List<Team_Dto3> combine5();
}
