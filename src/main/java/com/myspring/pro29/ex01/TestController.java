package com.myspring.pro29.ex01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//REST ��� ����ϱ� ���� spring �����ӿ�ũ 4.1.1�� pom���� ����
@RestController
@RequestMapping("/test/*")
public class TestController {

	@RequestMapping("/ssdf")
	public String asdfa(){
		return "zsawq";
	}
	
	@RequestMapping("/member")
	public MemberVO member(){
		MemberVO member=new MemberVO("hong","1234","ȫ�浿","hong@test.com");
		
		return member;
	}
	
}
