package com.maacsport.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class MainCreatePdfItext {

	public static void main(String[] args) {
		MyItext my =new MyItext();
		try {
			
			//final File f = new File(MainCreatePdfItext.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		
			java.net.URL url =MainCreatePdfItext.class.getProtectionDomain().getCodeSource().getLocation();
			System.out.println(url.getPath());
		    my.create("/Users/maaguilera/teste_"+new Date().getTime()+".pdf");
		} catch( Exception e) {
		e.printStackTrace();
		}

	}

}
