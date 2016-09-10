package com.maacsport.util;



public class Util {
	
	public static double getDouble(String d,double byDefault) {
		double dd=-1;
		
		if ( d!=null && !d.toLowerCase().equals("n/a")) {
			
			dd=Double.parseDouble(d);
		} else {
			dd=-1;
		}
		return dd;
		
	}
	public static double getDouble(String d) {
		return getDouble(d,-1);
		
	}
	
	
	
	public static int getInt(String d,int byDefault) {
		return (d.toLowerCase().equals("n/a") || d==null)?byDefault:Integer.parseInt(d);
		
	}
	public static int getInt(String d) {
		return getInt(d,-1);
		
	}
	
	
	
	public static long getLong(String d,long byDefault) {
		return ( d.toLowerCase().equals("n/a") || d==null)?byDefault:Long.parseLong(d);
		
	}
	public static long getLong(String d) {
		return getLong(d,-1);
		
	}
	
	public static String getString(String d,String byDefault) {
		return (d.toLowerCase().equals("n/a") || d==null)?byDefault:d;
		
	}
	public static String getString(String d) {
		return getString(d,"n/a");
		
	}
	
	public static String getPad(int source) {
		return getPadL(""+source,"0",2);
	}
	public static String getPadL(int source,int tamano) {
		return getPadL(""+source,"0",tamano);
	}
	public static String getPadL(String source,int tamano) {
		return getPadL(source,"0",tamano);
	}
	public static String getPadL(int source ,String t,int tamano) {
		return getPadL(""+source,t,tamano);
	}
	
	public static String getPadL(String source ,String t,int tamano) {
		String result=source;
		
		while (result.length()<tamano)	result = t+result;
		
		return result;
	}
}

