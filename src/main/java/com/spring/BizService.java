package com.spring;

import org.springframework.stereotype.Service;

//This annotation is used to created object of BizService
//@Controller , @Repository , @Component
@Service
public class BizService {

	public void foo() {
		System.out.println("Hey I am foo");
		System.out.println("Hey I am foo");
		System.out.println("Hey I am foo");
		System.out.println("Hey I am foo");
		System.out.println("Hey I am foo");
	}
}
