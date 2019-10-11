package com.terzeron.java.encoding;

import com.thoughtworks.xstream.XStream;

import java.io.File;

public class EncodingTest {
	public static void main(String[] args) {
	
//		XStream xstream = new XStream(new DomDriver("MS949"));
//		xstream.alias("naver", LeagueRank.class);
//		xstream.alias("AL", League.class);
//		xstream.alias("CENT", Division.class);
//		xstream.alias("rank_data", RankData.class);
//		
//
//		LeagueRank leagueRank = (LeagueRank) xstream.fromXML(new File("/Users/terzeron/leagueRank.xml"));
		
		XStream xstream = new XStream();
		xstream.setMode(XStream.NO_REFERENCES);
		Object x = xstream.fromXML(new File("/Users/terzeron/leagueRank.xml"));
	}
}
