package com.myspring.pro29.ex01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//REST 방식 사용하기 위해 spring 프레임워크 4.1.1로 pom에서 변경
@RestController
@RequestMapping("/test/*")
public class TestController {

	@RequestMapping("/ssdf")
	public String asdfa(){
		return "zsawq";
	}
	
	@RequestMapping("/member")
	public MemberVO member(){
		MemberVO member=new MemberVO("hong","1234","홍길동","hong@test.com");
		
		return member;
	}
	
}
