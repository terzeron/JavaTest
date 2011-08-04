package com.springinaction.chapter01.knight;

//import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Assert;

public class KnightOfTheRoundTableTest  {
	@Test
	public void testEmbarkOnQuest() throws GrailNotFoundException, QuestFailedException {
		KnightOfTheRoundTable knight = new KnightOfTheRoundTable("Bedivere");	
		HolyGrail grail = (HolyGrail) knight.embarkOnQuest();
		Assert.assertNotNull(grail);
		Assert.assertTrue(grail.isHoly());
	}
}
