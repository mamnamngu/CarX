package com.swd.carx.service.schoolManagement;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.schoolManagement.Assistant;
import com.swd.carx.entity.schoolManagement.School;
import com.swd.carx.repository.schoolManagement.AssistantRepository;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.AssistantDTO;


@Service
public class AssistantService {
	
	@Autowired
	private AssistantRepository assistantRepo;
	
	public List<Assistant> findAll(){
		return assistantRepo.findAll();
	}
	
	public Assistant findById(int id) {
		Assistant assistant = assistantRepo.findByAssistantId(id);
		return assistant;
	}
	
	//Admin filter
	public List<Assistant> findByCombinedQuery(String searchKey, Integer schoolId, Integer status) {
		if(searchKey == null) searchKey = "";
		else searchKey = searchKey.toLowerCase();
//		if(status == null) status = Constants.DEFAULT_STATUS;
		return assistantRepo.findByCombinedQuery(searchKey, schoolId, status);
	}
	
	//ADD
	public Assistant add(Assistant assistant) {
		return assistantRepo.save(assistant);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(int id) {
		Assistant assistant = findById(id);
		if(assistant == null) return false;
		assistant.setStatus(Constants.DELETED_STATUS);
		update(assistant);
		return assistant.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public Assistant update(Assistant newAssistant) {
		return add(newAssistant);
	}	
	
	//DISPLAY
	public List<AssistantDTO> display(List<Assistant> ls){
		List<AssistantDTO> list = new ArrayList<AssistantDTO>();
		
		for(Assistant x: ls) {
			AssistantDTO y = new AssistantDTO();
			y.setAssistantId(x.getAssistantId());
			y.setName(x.getName());
			y.setDOB(x.getDOB());
			y.setGender(x.isGender());
			y.setPhone(x.getPhone());
			y.setEmail(x.getEmail());
			y.setNote(x.getNote());
			y.setStatus(x.getStatus());
			y.setStatusTxt(Constants.STATUSES.get(x.getStatus()));
			
			//School
			School school = x.getSchool();
			y.setSchoolId(school.getSchoolId());
			y.setSchoolName(school.getSchoolName());
			
			list.add(y);
		}
		return list;
	}
}
