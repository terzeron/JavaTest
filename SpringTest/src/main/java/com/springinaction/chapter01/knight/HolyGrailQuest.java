package com.springinaction.chapter01.knight;

public class HolyGrailQuest implements IQuest {
	public HolyGrailQuest() {}
	
	private String getLastClassName(String fullClassName) {
		String [] arr = fullClassName.split("\\.");
		if (arr.length > 0) {
			return arr[arr.length - 1];
		} else {
			return "NoQuest";
		}
	}
	
	public HolyGrail embark() throws QuestFailedException {
		HolyGrail grail = new HolyGrail();
		String fullClassName = getClass().getName();
		String lastClassName = getLastClassName(fullClassName);
		System.out.println("embarking on a " + lastClassName + "...");
		return grail;
	}
}
