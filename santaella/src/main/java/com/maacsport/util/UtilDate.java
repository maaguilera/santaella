package com.maacsport.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class UtilDate {
	
	
public static Calendar  CalendarFromStringddmmyy(String ddmmyy,String delimitador,boolean getTime) {
	 
		
		String[] splitted = ddmmyy.split(delimitador);
		int year = Integer.parseInt(splitted[2]);
		int month = (Integer.parseInt(splitted[1])-1);
		int day = Integer.parseInt(splitted[0]);

		int hh=0;
		int mm=0;
		String pm="";
		
		if (getTime) {
			String[] splitted2 = ddmmyy.split(":");
		
		hh = Integer.parseInt(splitted2[0]);
		mm = Integer.parseInt(splitted2[1].substring(0, splitted2[1].length()-2));
		pm=splitted2[1].substring(splitted2[1].length()-2);
		
		}
		
		
		
		Calendar fecha = Calendar.getInstance();
		
		if (pm.toUpperCase().equals("PM")) {
			
			
			fecha.set(Calendar.AM_PM, Calendar.PM);
		}else {
			fecha.set(Calendar.AM_PM, Calendar.AM);
		}
		fecha.set(year, month, day,hh,mm,0); //TODO: PM
		
		return fecha;
	}
	public static Calendar  CalendarFromCVS2(String dateTrade,String timeTrade) {
	 
		
		String[] splitted = dateTrade.split("/");
		int year = Integer.parseInt(splitted[2]);
		int month = (Integer.parseInt(splitted[0])-1);
		int day = Integer.parseInt(splitted[1]);

		String[] splitted2 = timeTrade.split(":");
		int hh = Integer.parseInt(splitted2[0]);
		int mm = Integer.parseInt(splitted2[1].substring(0, splitted2[1].length()-2));
		
		String pm=splitted2[1].substring(splitted2[1].length()-2);
		
		Calendar fecha = Calendar.getInstance();
		
		if (pm.toUpperCase().equals("PM")) {
			
			
			fecha.set(Calendar.AM_PM, Calendar.PM);
		}else {
			fecha.set(Calendar.AM_PM, Calendar.AM);
		}
		fecha.set(year, month, day,hh,mm,0); //TODO: PM
		
		return fecha;
	}
public static Calendar  CalendarFromCVS(String dateTrade,String timeTrade) {
	 
		
		String[] splitted = dateTrade.split("/");
		int year = Integer.parseInt(splitted[2]);
		int month = (Integer.parseInt(splitted[0])-1);
		int day = Integer.parseInt(splitted[1]);

		String[] splitted2 = timeTrade.split(":");
		int hh = Integer.parseInt(splitted2[0]);
		int mm = Integer.parseInt(splitted2[1].substring(0, splitted2[1].length()-2));
		
		String pm=splitted2[1].substring(splitted2[1].length()-2);
		
		Calendar fecha = Calendar.getInstance();
		fecha.set(Calendar.AM_PM, 0);
		int hora=hh;
		
		 	if (pm.toUpperCase().equals("PM")) {
			if (hh==1) {
			  hora=13;
			} else if (hh==2) {
				hora=14;
			}else if (hh==3) {
				hora=15;
			}else if (hh==4) {
				hora=16;
			}else if (hh==5) {
				hora=17;
			}else if (hh==6) {
				hora=18;
			}else if (hh==7) {
				hora=19;
			}else if (hh==8) {
				hora=20;
			}else if (hh==9) {
				hora=21;
			}else if (hh==10) {
				hora=22;
			}else if (hh==11) {
				hora=23;
			}else if (hh==12) {
				hora=12;
			}
		}  else if (hh==12) {  // 0 -> am  12 -> pm 24 te mete um dia mais e am
			
				  hora=0;
		}
			 
		
		fecha.set(year, month, day,hora,mm,0); //TODO: PM
	
		
		return fecha;
	}
	
	
	

	

	public static String DateTimeFormat(Date d) {
		return (Pad.left(d.getYear(), '0', (short) 4) + "/" + Pad.left(d.getMonth() + 1, '0', (short) 2) + "/" + Pad.left(d.getDate(), '0', (short) 2) + "-" + Pad.left(d.getHours(), '0', (short) 2) + ":" + Pad.left(d.getMinutes(), '0', (short) 2) + ":" + Pad.left(d.getSeconds(), '0', (short) 2));
	}

	public static String DateTimeFormat(Calendar d) {
		return (Pad.left(d.get(Calendar.YEAR), '0', (short) 4) + "/" + Pad.left(d.get(Calendar.MONTH), '0', (short) 2) + "/" + Pad.left(d.get(Calendar.DATE), '0', (short) 2) + "-" + Pad.left(d.get(Calendar.HOUR), '0', (short) 2) + ":" + Pad.left(d.get(Calendar.MINUTE), '0', (short) 2) + ":" + Pad.left(d.get(Calendar.SECOND), '0', (short) 2));
	}
	

 public static Date sqlTimestampToDateTime(java.sql.Timestamp d) {
        if (d == null) return null;
        return new Date((short) d.getYear(), (short) d.getMonth(), (short) d.getDate(), (short) d.getHours(), (short) d.getMinutes(), (short) d.getSeconds());
    }
 
 public static String dateToString(Calendar x) {
     return x.get(x.YEAR) + "-" + x.get(x.MONTH) + "-" + x.get(x.DAY_OF_MONTH) + " " + x.get(x.HOUR_OF_DAY) + ":" + x.get(x.MINUTE) + ":" + x.get(x.SECOND);

 }
 public static String calendarToYYMMDD(Calendar x) {
     return x.get(x.YEAR) + Util.getPad(x.get(x.MONTH)) + Util.getPad(x.get(x.DATE));
 }
 public static String calendarToHHMM(Calendar x) {
     return Util.getPad(x.get(x.HOUR_OF_DAY)) + Util.getPad(x.get(x.MINUTE));
 }
 public static int calendarToYYMMDDint(Calendar x) {
	 
     return Integer.parseInt(calendarToYYMMDD(x));
 }
 
 
 public static java.sql.Timestamp  calendarToSqlTimestamp(Calendar x) {
	 
	

	//get a java.util.Date from the calendar instance.
	//this date will represent the current instant, or "now".
	java.util.Date now = x.getTime();

	//a java current time (now) instance
	java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
	
	return currentTimestamp;
	
	
	 
 }
 
 
 
 public static String calendarToString(Calendar x,String format) {
	    String strdate = null;
	    SimpleDateFormat sdf = new SimpleDateFormat(format);//YYYY/MM/DD    //YYYY-MM-DD

	    if (x != null) {
	    strdate = sdf.format(x.getTime());
	    }
	
   return strdate;
 }
 
//create a java calendar instance


}
