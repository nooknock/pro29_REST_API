package com.myspring.pro29.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//REST ��� ����ϱ� ���� spring �����ӿ�ũ 4.1.1�� pom���� ����
@RestController
@RequestMapping("/test/*")
public class TestController {

	public static final Logger logger=LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/ssdf")
	public String asdfa(){
		return "zsawq";
	}
	
	@RequestMapping("/member")
	public MemberVO member(){
		MemberVO member=new MemberVO("hong","1234","ȫ�浿","hong@test.com");
		
		return member;
	}
	
	@RequestMapping("/memberList")
	public List<MemberVO> listMembers() {
		List<MemberVO> list= new ArrayList<MemberVO>();
		
		for(int i=0;i<10;i++) {
			MemberVO vo=new MemberVO();
			vo.setId("hong"+i);
			vo.setPwd("1234");
			vo.setName("ȫ�浿"+i);
			vo.setEmail("hong"+i+"@test.com");
			list.add(vo);
		}
		return list;
	}
	
	@RequestMapping("/memberMap")
	public Map<Integer, MemberVO> membersMap() {
		Map<Integer, MemberVO> map= new HashMap<Integer, MemberVO>();
		
		for(int i=0;i<10;i++) {
			MemberVO vo=new MemberVO();
			vo.setId("hong"+i);
			vo.setPwd("1234");
			vo.setName("ȫ�浿"+i);
			vo.setEmail("hong"+i+"@test.com");
			map.put(i,vo);
		}
		return map;
	}
	
	//Annotation which indicates that a method parameter should be bound to a URI template variable. Supported for RequestMapping annotated handler methods in Servlet environments. 
	@RequestMapping(value = "/notice1/{num1}",method=RequestMethod.GET)
	public String notice1(@PathVariable(value = "num1") String num1) throws Exception{
		
		return num1;
	}
	
	@RequestMapping(value = "/notice2/{num2}",method=RequestMethod.GET)
	public int notice2(@PathVariable(value = "num2") int num2) throws Exception{
		
		return num2;
	}

	//HttpMessageConverter : Strategy interface that specifies a converter that can convert from and to HTTP requests and responses.
	
	//Annotation indicating a method parameter should be bound to the body of the web request.
	//The body of the request is passed through an HttpMessageConverter to resolve the method argument depending on the content type of the request. Optionally, automatic validation can be applied by annotating the argument with @Valid. 
	@RequestMapping(value = "/info",method = {RequestMethod.GET,RequestMethod.POST})
	void modify(@RequestBody MemberVO vo){
		logger.info(vo.toString());
	}
	
	//@RestController�� ������ View�� �������� ���� ä �����͸� �����ϹǷ� ���� �������� ���ܰ� �߻��� �� �ִ�.
	//���ܿ� ���� �� �� ������ ��� �ʿ��� ��� ResponseEntity Ŭ������ ���
	//ResponseEntity�� HTTP �����ڵ带 �����Ͽ� ������ �� �ִ�.
	//�ۿ��� HTTP ���� �ڵ带 �ν��� �� �ִ� ����� �̿��� �ֹ� ���³� ���� �߻��� �˷���
	//ResponseEntity:Extension of HttpEntity that adds an HttpStatusCode status code. Used in RestTemplate as well as in @Controller methods.
	@RequestMapping("/memberList2")
	public ResponseEntity<List<MemberVO>> listMembers2() {
		List<MemberVO> list= new ArrayList<MemberVO>();
		
		for(int i=0;i<10;i++) {
			MemberVO vo=new MemberVO();
			vo.setId("hong"+i);
			vo.setPwd("1234");
			vo.setName("ȫ�浿"+i);
			vo.setEmail("hong"+i+"@test.com");
			list.add(vo);
		}
		return new ResponseEntity(list, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping("/res3")
	public ResponseEntity res3(){
		
		
		HttpHeaders responseHeaders=new HttpHeaders();//Constructs a new, empty instance of the HttpHeaders object.
		responseHeaders.add("Content-Type", "text/html;charset=utf-8");
		String message="<script>";
		message += "alert('�� ȸ���� ����մϴ�.');";
		message +="location.href='/pro29/test/membersList2';";
		message += "</script>";
		return new ResponseEntity(message,responseHeaders,HttpStatus.CREATED);
	}
}
