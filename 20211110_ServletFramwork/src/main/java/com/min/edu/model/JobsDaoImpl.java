package com.min.edu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.min.edu.common.DataBase;
import com.min.edu.dto.JobsDto;

public class JobsDaoImpl extends DataBase implements I_JobsDao {

	@Override
	public List<JobsDto> getAllJobs() {
		List<JobsDto> lists = new ArrayList<JobsDto>();
		//2단계
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY "
				+ "	FROM JOBS j ";
		try {
			conn = getConnection();
			System.out.println("2단계 커넥션 연결 성공");
			pstmt = conn.prepareStatement(sql);
			System.out.println("3단계 쿼리 준비 성공");
			rs = pstmt.executeQuery();
			System.out.println("4단계 쿼리 실행 성공");
			
			while (rs.next()) {
				int idx = 1;
				JobsDto dto = new JobsDto(
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getInt(idx++),
						rs.getInt(idx++));
				
				lists.add(dto);
				
			}
			System.out.println("5단계 결과값 받기");
			
		} catch (SQLException e) {
			System.out.println("getAllJobs 오류");
			e.printStackTrace();
		} finally{
			closed(rs, pstmt, conn);
		}
		
		
		return lists;
	}

}
