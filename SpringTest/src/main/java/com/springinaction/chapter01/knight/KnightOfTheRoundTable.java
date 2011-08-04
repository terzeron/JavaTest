package com.springinaction.chapter01.knight;

public class KnightOfTheRoundTable implements IKnight {
	private String name;
	private HolyGrailQuest quest;
	//private Minstrel minstrel;
	
	public KnightOfTheRoundTable(String name) {
		this.name = name;
		quest = new HolyGrailQuest();
	}
	
	public HolyGrail embarkOnQuest() throws QuestFailedException {
		// AOP에서는 다음과 같은 명시적인 호출을 하지 않음 (xml에서 지정)
		//minstrel.singBefore(this);
		HolyGrail grail = quest.embark();
		//minstrel.singAfter(this);
		return grail;
	}
	
	public void setQuest(IQuest quest) {
		this.quest = (HolyGrailQuest) quest;
	}
	
	public String getName() {
		return name;
	}
	
//	public void setMinstrel(Minstrel minstrel) {
//		this.minstrel = minstrel;
//	}
}

