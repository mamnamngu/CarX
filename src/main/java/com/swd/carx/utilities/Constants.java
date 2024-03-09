package com.swd.carx.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public final class Constants {

	//PREVENT OBJECT INSTANTIATION
	private Constants() {
		
	}
	
	public static final HashMap<Integer, String> STATUSES = new HashMap<>();
	static {
		STATUSES.put(0,"active");
		STATUSES.put(1,"inactive");
		STATUSES.put(2,"withdrawn");
		STATUSES.put(3,"past");
		STATUSES.put(4, "yet to come");
		STATUSES.put(5,"deleted");
	}
	public static final int DEFAULT_STATUS = 0;
	public static final int DELETED_STATUS = 5;
	
	//DATES
	public static final Date START_DATE = new Date(01/01/2023);
	public static final Date currentDate() {
		return new Date();
	}
	//TOURNAMENTS
	public static final long DEFAULT_TOURNAMENTID = 1;
	
	//ACCOUNTS
	public static final int USERNAME_MIN_LENGTH = 6;
	public static final int PASSWORD_MIN_LENGTH = 6;
	
	//Password must contain at least one number and one uppercase letter
	public static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d).+$";
	
	//ROLES
	public static final HashMap<Integer, String> ROLES = new HashMap<>();
	static {
		ROLES.put(0, "umpire");
		ROLES.put(1, "school assistant");
		ROLES.put(2, "admin");
	}
	public static final int DEFAULT_ROLE = 1;
	
	//YEARS
	public static final int DEFAULT_YEAR = 2024;
	
	//LOCATIONS
	public static final String DEFAULT_LOCATION = "'FPT University Library'";
	
	//TEAMS
	public static final String DEFAULT_AVATAR = "https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fcar%20models%2Fdefault%20car%20type%20avatar.jpg?alt=media&token=9718a570-999f-4290-9a9c-7289c2f3707e";
	
	//CARS IN RACE
	public static final int SCORE_MAX = 100;
	public static final int SCORE_MIN = 0;
	
	//STRING OPERATIONS
	public static final String regex(String string) {
		String tmp = string.toLowerCase();
		return "%" + tmp + "%";
	}
	
	//STRING TO INTEGER
	public static final Integer strToInt(String str) {
		try {
	        return Integer.parseInt(str);
	    } catch (NumberFormatException e) {
	        return null;
	    }
	}
	
	//DATE FORMAT
	public static final Date strToDateLow(String dateStr) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");	
	     try {
	         Date date = dateFormat.parse(dateStr);
	         return date;
	     } catch (ParseException e) {
	         System.out.println("Error parsing date: " + e.getMessage());
	         return START_DATE;
	     }
     }
	
	public static final Date strToDateUp(String dateStr) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");	
	     try {
	         Date date = dateFormat.parse(dateStr);
	         return date;
	     } catch (ParseException e) {
	         System.out.println("Error parsing date: " + e.getMessage());
	         return currentDate();
	     }
    }
	
	//TEXT AREA LENGTH
	public static final int NVACHAR_MAX_LENGTH = 3000;
	public static final int NVARCHAR_DEFAULT_LENGTH = 300;
}
