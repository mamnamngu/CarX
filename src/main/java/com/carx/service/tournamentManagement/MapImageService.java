package com.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.tournamentManagement.MapImage;
import com.carx.repository.tournamentManagement.MapImageRepository;


@Service
public class MapImageService {

	@Autowired
	private MapImageRepository mapImageRepo;
}
