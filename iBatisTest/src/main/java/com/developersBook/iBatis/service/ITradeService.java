package com.developersBook.iBatis.service;

import com.developersBook.iBatis.domain.Trade;

public interface ITradeService {
	public Trade getTrade(long tradeId) throws Exception;
	public void executeTrade(long tradeId) throws Exception;
}
