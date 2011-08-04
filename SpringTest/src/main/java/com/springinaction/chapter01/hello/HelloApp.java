package com.springinaction.chapter01.hello;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.FileSystemResource;

public class HelloApp {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("hello.xml"));
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/hello.xml"));
		GreetingService greetingService = (GreetingService) factory.getBean("greetingService");
		greetingService.sayGreeting();
	}
}
