package com.min.edu.dao;

import java.util.List;

import com.min.edu.dto.BikeDto;

public interface IBikeDao {

	public int bikeInsert(List<BikeDto> dtos);
	public int bikeDelete();
	
}
