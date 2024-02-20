package com.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.tournamentManagement.Umpire;
import com.carx.repository.tournamentManagement.UmpireRepository;


@Service
public class UmpireService {

	@Autowired
	private UmpireRepository umpireRepo;
}
