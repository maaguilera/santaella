package com.maacsport.util;

public class Pad {

	    private static String constroiString(short tam, char c)
	    {
	        StringBuffer buffer = new StringBuffer();
	        while (tam-- > 0) buffer.append("" + c);
	        return buffer.toString();
	    }

	    public static String left(String val, short tamanho)
	    {
	        return (constroiString((short) (tamanho - val.length()), ' ') + val);
	    }

	    public static String right(String val, short tamanho)
	    {
	        return (val + constroiString((short) (tamanho - val.length()), ' '));
	    }

	    public static String left(String val, char c, short tamanho)
	    {
	        return (constroiString((short) (tamanho - val.length()), c) + val);
	    }

	    public static String leftUnpadPad(String val, char c, short tamanho)
	    {
	        if (val.length() > tamanho)
	            val = unpadLeft(val, c);
	        return constroiString((short) (tamanho - val.length()), c) + val;
	    }

	    public static String right(String val, char c, short tamanho)
	    {
	        return (val + constroiString((short) (tamanho - val.length()), c));
	    }

	    public static String left(short val, char c, short tamanho)
	    {
	        return (left("" + val, c, tamanho));
	    }

	    public static String right(short val, char c, short tamanho)
	    {
	        return (right("" + val, c, tamanho));
	    }

	    public static String left(int val, char c, short tamanho)
	    {
	        return (left("" + val, c, tamanho));
	    }

	    public static String right(int val, char c, short tamanho)
	    {
	        return (right("" + val, c, tamanho));
	    }

	    public static String unpadLeft(String val, char c)
	    {
	        try
	        {
	            int indexPadLeft = 0;
	            while (val.charAt(indexPadLeft) == c && indexPadLeft < val.length()) indexPadLeft++;
	            return val.substring(indexPadLeft, val.length());
	        }
	        catch (StringIndexOutOfBoundsException e)
	        {
	            return "";
	        }
	    }

	    public static String truncateRight(String val, char c, short tamanho)
	    {
	        return truncate(val, c, tamanho, true);
	    }

	    public static String truncateLeft(String val, char c, short tamanho)
	    {
	        return truncate(val, c,  tamanho, false);
	    }

	    private static String truncate(String val, char c, short tamanho, boolean right)
	    {
	        val = val.trim();
	        if(val.length() > tamanho)
	        {
	            return val.substring(right? 0 : val.length() - (tamanho +1), right? tamanho : val.length());
	        }else{
	            if(right)
	                return Pad.right(val, c, tamanho);
	            else
	                return Pad.left(val, c, tamanho);
	        }
	    }

	    public static void main(String args[])
	    {
	        System.out.println(left(1, '0', (short) 5));
	        System.out.println(left("1", '0', (short) 5));
	        System.out.println(right(1, '0', (short) 5));
	        System.out.println(right("1", '0', (short) 5));

	        System.out.println(unpadLeft("000112200001111000011111000", '0'));
	    }
	    
}
