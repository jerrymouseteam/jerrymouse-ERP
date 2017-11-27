package com.ERP.constants;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String args[]) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			System.out.println(dateFormat.format(new Date()));
			System.out.println((Date) dateFormat.parse("2017-11-27"));
		} catch (ParseException parseException) {
			throw new RuntimeException(parseException);
		}
	}
}
