package com.maacsport.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.maacsport.model.VPerson;
import com.maacsport.model.VQuota;

public class MainCreatePdfItext {

	public static void main(String[] args) {
		MyItext my =new MyItext();
		try {
			
			//final File f = new File(MainCreatePdfItext.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		
			java.net.URL url =MainCreatePdfItext.class.getProtectionDomain().getCodeSource().getLocation();
			System.out.println(url.getPath());
			List<VQuota> vQuota = new ArrayList<VQuota>();
			VQuota q = new VQuota();
			q.setAmount(45.00);
			q.setAmountChar("Quarenta y cinco");
			q.setAno(2017);
			q.setConcept("Cuota ano -2017");
			
			q.setId(1212);
			q.setName("Aquilera Caballer, Miguel Angel");
			q.setToken("dercekfjwvjroigeoneknrefnovnevonwevofr");
			q.setTypeName("Hermano Adulto");
			
			VPerson v = new VPerson();
			
			v.setId("232323223");
			q.setvPerson(v);
			
			vQuota.add(q);
			
		    my.createIndividual("/Users/maaguilera/testes/teste_"+new Date().getTime()+".pdf",vQuota,"/Users/maaguilera/testes");
		    System.out.println("Final");
		} catch( Exception e) {
		e.printStackTrace();
		}

	}

}
