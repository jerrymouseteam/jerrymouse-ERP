package com.jerrymouse.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trial {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Date date = new Date("1452450660000");
		DateFormat dateFormatdd = new SimpleDateFormat("dd-mm-yyyy");
		System.out.println(date);
	}
}
