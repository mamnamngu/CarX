package com.swd.carx;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swd.carx.utilities.Constants;
import com.swd.carx.view.Status;

@RestController
public class TestController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("/test")
	public String test() {
		return "Test";
	}
	
	@GetMapping("/statuses")
	public List<Status> getStatuses() {
		List<Status> ls = new ArrayList<Status>();
		for (int i : Constants.STATUSES.keySet()) {
			Status x = new Status();
			x.setStatus(i);
			x.setStatusTxt(Constants.STATUSES.get(i));
			
			ls.add(x);
		}
		return ls;
	}
}
