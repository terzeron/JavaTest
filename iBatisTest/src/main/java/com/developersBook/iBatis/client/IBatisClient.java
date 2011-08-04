package com.developersBook.iBatis.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.developersBook.iBatis.service.ITradeService;

public class IBatisClient {
	public static void main(String[] args) {
		try {
			System.out.println("IBatisClient started");
			System.out.println(" ");
			
			// load spring beans
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			System.out.println("Classpath loaded");
			System.out.println(" ");
			ITradeService service = (ITradeService) ctx.getBean("tradingService");
			// getTrade
			int tradeId = 1;
			System.out.println("BEFORE: " + service.getTrade(tradeId));
			
			// update trade
			service.executeTrade(tradeId);
			System.out.println("AFTER : " + service.getTrade(tradeId));
            System.out.println(" ");
            System.out.println("Hurry!!!! Its done!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
