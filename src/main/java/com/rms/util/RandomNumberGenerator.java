package com.rms.util;

import java.util.Random;

public class RandomNumberGenerator {
	
	public static StringBuffer getRandom4digit() {
		Random rand = new Random();
		int randome4digit= rand.nextInt(10000);
		
		return new StringBuffer().append("E-").append(randome4digit);
	}
	
//	public static void main(String[] args) {
//		System.out.println(getRandom4digit());;
//	}


}
