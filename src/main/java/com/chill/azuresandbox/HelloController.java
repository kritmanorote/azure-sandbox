package com.chill.azuresandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
    private DummyRepository dummyRepository;
	
	@GetMapping("/")
	public String index() {
		return "Azure Sandbox " + dummyRepository.findById(1);
	}

}