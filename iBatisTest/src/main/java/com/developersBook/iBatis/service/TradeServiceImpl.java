package com.developersBook.iBatis.service;

import com.developersBook.iBatis.domain.Trade;
import com.ibatis.sqlmap.client.SqlMapClient;

public class TradeServiceImpl implements ITradeService {
	protected SqlMapClient sqlMap = null;
	
 	public void setSqlMapClient(SqlMapClient sqlMap) {
 		this.sqlMap = sqlMap;
 	}

	public Trade getTrade(long tradeId) throws Exception {
		// TODO Auto-generated method stub
		return (Trade) sqlMap.queryForObject("trading.getTrade", tradeId);
	}

	public void executeTrade(long tradeId) throws Exception {
		// TODO Auto-generated method stub
		sqlMap.update("trading.executeTrade", tradeId);
	}
}
