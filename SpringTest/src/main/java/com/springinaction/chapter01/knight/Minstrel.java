package com.springinaction.chapter01.knight;

import org.apache.log4j.Logger;

/**
 * @author terzeron
 *
 */
public class Minstrel {
	private static final Logger SONG = Logger.getLogger(Minstrel.class);
	
	public Minstrel() {}
	
	public void singBefore(IKnight knight) {
		SONG.info("Fa la la; Sir " + knight.getName() + " is so brave!");
	}
	
	public void singAfter(IKnight knight) {
		SONG.info("Tee-hee-he; Sir " + knight.getName() + " did embark on a quest!");
	}
}
