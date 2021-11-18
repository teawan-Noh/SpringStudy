package com.min.edu.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.JobsVO;
import com.min.edu.model.IJobsBindingDao;
import com.min.edu.model.IJobsDynamicDao;
import com.min.edu.model.IJobsIUDDao;
import com.min.edu.model.IJobsSelectService;
import com.min.edu.model.JobsBindingDaoImpl;
import com.min.edu.model.JobsDynamicDaoImpl;
import com.min.edu.model.JobsIUDDaoImpl;
import com.min.edu.model.JobsSelectServiceImpl;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class MyBatis_Main {

	public static void main(String[] args) {
//		Logger logger = Logger.getLogger(MyBatis_Main.class);
//		logger.trace("이제는 로그도 할 수 있는 개발자");
//		
//		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
//		SqlSession session = manager.openSession(true); //true 는 오토커밋, false는 트랜잭션이 걸린상태
//		List<JobsVO> lists = session.selectList("com.min.edu.jobs.selectAll"); //Mapper.xml에 있는 namespace명.id
//		System.out.println(lists);
		
		IJobsSelectService service = new JobsSelectServiceImpl();
//		int n = service.select01("IT_PROG");
//		System.out.println("select01의 결과 : " + n);
	
//		JobsVO vo = service.select02("IT_PROG");
//		System.out.println(vo);
		
//		List<JobsVO> lists = service.select03();
//		for (JobsVO vo : lists) {
//			System.out.println(vo);
//		}
		
//		List<JobsVO> lists = service.select03_1();
//		for (JobsVO jvo : lists) {
//			System.out.println(jvo);
//		}
		
//		Map<String, JobsVO> jobs = service.select04();
//		System.out.println(jobs);
		
		//jobs중에 IT_FROP를 찾아서 JOB_TITLE을 출력
//		Set<String> job_id_key = jobs.keySet();
//		System.out.println(job_id_key);
//		System.out.println(job_id_key.contains("IT_PROG"));
		
		//Set은 java.util.Set Interface : 값의 중복이 없고 순서도 없음 : 출력할 방법이 없음
		//Set의 값을 무작위로 출력하기 위해서(객체가 비워질때까지) => Iterator 타입으로 변경
		//Iterator Pattern을 통해서 출력
//		Iterator<String> keys = job_id_key.iterator();
//		while (keys.hasNext()) {
//			String str = (String) keys.next();
////			System.out.println(jobs.get(str)); // =>map
////			JobsVO j = jobs.get(str);
////			System.out.println(j);
//			
//			Map<String, Object> m = (Map<String, Object>) jobs.get(str);
//			System.out.println(m.get("JOB_TITLE"));
//		}
		
//		JobsVO resultVo = service.select05(new JobsVO("IT_PROG", "Programmer"));
//		System.out.println(resultVo);
		
//		Map<String, Object> inMap = new HashMap<String, Object>();
//		inMap.put("jobid", "IT_PROG");
//		inMap.put("jobtitle", "Programmer");
//		
//		List<JobsVO> l = service.select06(inMap);
//		if(l.size() == 0) {
//			System.out.println("검색 결과가 없습니다");
//		}else {
//			System.out.println(l.get(0));
//		}
		
//		Object obj = 7000;
//		List list = service.select07(obj);
//		for (Object o : list) {
//			System.out.println((JobsVO)o);
//		}
		
		
		//--------------insert 부터 2021-11-16
		IJobsIUDDao iduDao = new JobsIUDDaoImpl();
//		JobsVO vo = new JobsVO("Goodee", "Academy", 1000, 4000, 0);
//		System.out.println("입력되는 VO 값: " + vo);
//		int success_Cnt = iduDao.insert01(vo);
//		System.out.println("insert 성공한 갯수 : " + success_Cnt);
//		System.out.println("입력 후 VO 값" + vo);
		
		//update 사용키 : newid, newtitle, oldid, seq
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("newid", "구디");
//		map.put("newtitle", "학원");
//		map.put("oldid", "goodee");
//		map.put("seq", "23");
//		
//		int cnt = iduDao.update01(map);
//		System.out.println("성공한 row의 수 : " + cnt);
		
		//delete
//		int cnt = iduDao.delete01(23);
//		System.out.println("삭제한 row의 수 : " + cnt);
		
		
		//2021-11-17
//		IJobsBindingDao dao = new JobsBindingDaoImpl();
//		Map<String, Object> map = new HashMap<String, Object>();
		//binding01
//		map.put("column", "JOB_ID");  //xml에 column
////		map.put("column", "'1'='1' or '1'");  //sql injection 예시 -> 전체리스트가 나옴
//		map.put("value", "IT_PROG");  //xml에 value
//		JobsVO vo = dao.binding01(map);
//		System.out.println(vo);
		
		//binding02
//		map.put("id", "IT");
//		JobsVO vo = dao.binding02(map);
//		System.out.println(vo);
		//If
		IJobsDynamicDao dynamic = new JobsDynamicDaoImpl();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("job_id", "AD_PRES");
//		List<JobsVO> lists = dynamic.getJobsIf(map);
		
		//List
//		String[] chks = {"IT_PROG", "AD_PRES"};
//		List<String> lists = Arrays.asList(chks);  //배열을 리스트로
//		List<JobsVO> jLists = dynamic.getJobsList(lists);
//		System.out.println(jLists);
		
		//Map
//		Map<String, String[]> map = new HashMap<String, String[]>();
//		map.put("job_ids", chks);
//		List<JobsVO> jLists = dynamic.getJobsMap(map);
//		System.out.println(jLists);
		
		
		//20211118
		//choose
//		JobsVO vo = new JobsVO();
//		System.out.println("아무것도 넣지 않고 객체만 넣는다");
//		System.out.println(dynamic.getJobsChoose(vo));
		
//		vo.setJob_id("IT_PROG");
//		System.out.println("JOB_ID만 입력한다");
//		System.out.println(dynamic.getJobsChoose(vo));
		
//		vo.setJob_title("Programmer");
//		System.out.println("JOB_TITLE만 입력한다");
//		System.out.println(dynamic.getJobsChoose(vo));
		
//		vo.setJob_id("IT_PROG");
//		vo.setJob_title("Programmer");
//		System.out.println("JOB_ID와 JOB_TITLE 입력한다");
//		System.out.println(dynamic.getJobsChoose(vo));
		
		
		//trim
//		JobsVO vo = new JobsVO();
//		vo.setJob_id("IT_PROG");
//		vo.setJob_title("Programmer");
//		System.out.println(dynamic.getJobsTrim(vo));
		
		//set
		JobsVO vo = new JobsVO();
//		vo.setJob_title("Program");
		vo.setMin_salary(1500);
//		System.out.println(dynamic.updateJobsSet(vo));
		System.out.println(dynamic.updateJobsTrim(vo));
	}

}
