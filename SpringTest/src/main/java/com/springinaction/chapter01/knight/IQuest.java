package com.springinaction.chapter01.knight;

public interface IQuest {
	abstract Object embark() throws QuestFailedException;
}
