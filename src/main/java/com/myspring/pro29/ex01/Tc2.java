package com.myspring.pro29.ex01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/t2")
public class Tc2 {

	@RequestMapping("/21")
	public String po(){
		return "zs";
	}
}
