package com.invtmgm.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Utils {

	public static String trimString(String str) {
		if (str == null || str.trim() == "") {
			return null;
		} else {
			return str.trim();
		}
	}
	
	public static java.sql.Date getSqlDate(Date utilDt) {
		if (utilDt == null) {
			return null;
		} else {
			java.sql.Date sqlDt = new java.sql.Date(utilDt.getTime());
			return sqlDt;
		}
	}
	
	public static LocalDate getLocalDateFromUtilDate(Date utilDt) {
		if (utilDt == null) {
			return null;
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(utilDt);
			LocalDate localeDt = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
			return localeDt;
		}
	}
	
	public static String parseDateToString(Date date) {
		if (date == null) {
			return null;
		} else {
			DateFormat df = new SimpleDateFormat("MM/dd/YYYY");
			String formattedDt = df.format(date);
			return formattedDt;
		}
	}
	
	public static double round(double value, int places) {
	    if (places < 0) {
	    	throw new IllegalArgumentException();
	    }
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
