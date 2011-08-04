package com.springinaction.chapter01.knight;

public interface IKnight {
	Object embarkOnQuest() throws QuestFailedException;
	String getName();
}
