package com.springinaction.chapter01.knight;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightApp {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("knight.xml");
		// BeanFactory를 사용하면 AOP가 제대로 처리되지 않음. 반드시 ApplicationContext를 사용할 것.
		IKnight knight = (IKnight) ctx.getBean("knight");
		knight.embarkOnQuest();
	}
}
