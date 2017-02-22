package com.maacsport.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableEvent;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

public class MyItext {
	
	private String documentName="";
	
	MyItext () {
		
	}
	
	
	void create(String name) throws IOException, DocumentException {
		
		
		// create document
		
		documentName=name;
		
        Document document = new Document(PageSize.A4, 36, 36, 90, 36);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(documentName));

        // add header and footer
        HeaderFooterPageEvent event = new HeaderFooterPageEvent();
        writer.setPageEvent(event);

        
        // watermaerk
      
        
        // write to document
        document.open();
        Chunk linebreak = new Chunk(new DottedLineSeparator());
        
        for (int i=1;i<10;i++) {
        	PdfPTable table= this.buildTableRecibo(12);
        	
            document.add(table);
            document.add(new Paragraph("  "));
            document.add(linebreak);
            if (i==3 ||  i==6 || i==9)document.newPage();
        } 
        	
        //document.add(new Paragraph("Adding a footer to PDF Document using iText."));
        
        
        document.close();
	
	}
	
	private PdfPTable buildTableRecibo(int columns) {
		
		DottedLineSeparator under = new DottedLineSeparator();
		under.setOffset(-2);
		under.setGap(2f);
		
    	// Creacion de una tabla
    	PdfPTable table = new PdfPTable(columns);
    	
    	table.setTableEvent(new BorderEvent());
    	
    	table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
    	 
    	// Agregar la imagen anterior a una celda de la tabla
    	PdfPCell cell;
    	
    	// row 1
    	cell = new PdfPCell(new Paragraph(" "));
    	cell.setColspan(9);
    	cell.setBorderColor(BaseColor.WHITE);
       	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    	table.addCell(cell);
    	
    	cell = new PdfPCell(new Paragraph("Recibo Nº: 3"));
    	cell.setColspan(3);
    	cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
    	cell.setBorderColor(BaseColor.WHITE);
    	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    	table.addCell(cell);
     	
     	// row 2
     	cell = new PdfPCell(new Paragraph(" "));
     	cell.setColspan(5);
       	cell.setBorderColor(BaseColor.WHITE);
    	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    	cell.setPaddingTop(10);
    	cell.setPaddingBottom(10);
    	table.addCell(cell);
    	
    	
     	cell = new PdfPCell(new Paragraph("______ de ___________ de _______"));
     	cell.setColspan(7);
     	cell.setBorderColor(BaseColor.WHITE);
    	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    	cell.setPaddingTop(10);
    	cell.setPaddingBottom(10);
     	table.addCell(cell);
     	
     	// row 3   	
      	cell = new PdfPCell(new Paragraph("Recibí de D. "));
      	cell.setColspan(3);
       	cell.setBorderColor(BaseColor.WHITE);
    	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    	cell.setPaddingBottom(10);
     	table.addCell(cell);
     	
     	Paragraph p= new Paragraph("    Miguel Angel Aguilera Caballero");
     	p.add(under);
     	cell = new PdfPCell(p);
     	cell.setColspan(8);
     	cell.setBorderColor(BaseColor.WHITE);
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingBottom(10);
     	table.addCell(cell);
     	
     	cell = new PdfPCell(new Paragraph(" "));
     	cell.setColspan(1);
       	cell.setBorderColor(BaseColor.WHITE);
    	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    	cell.setPaddingBottom(10);
    	table.addCell(cell);
     	
    	// row 4
     	cell = new PdfPCell(new Paragraph("la cantida de "));
     	cell.setBorderColor(BaseColor.WHITE);
     	cell.setColspan(3);
    	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    	cell.setPaddingBottom(10);
     	table.addCell(cell);
     	
     	p= new Paragraph("    #CUARENTA EUROS#");
     	p.add(under);
     	cell = new PdfPCell(p);
     	cell.setColspan(8);
     	cell.setBorderColor(BaseColor.WHITE);
     	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
     	cell.setPaddingBottom(10);
     	table.addCell(cell);
     	
     	cell = new PdfPCell(new Paragraph(" "));
     	cell.setColspan(1);
       	cell.setBorderColor(BaseColor.WHITE);
    	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    	cell.setPaddingBottom(10);
    	table.addCell(cell);
    	
     	
    	// row 5
     	cell = new PdfPCell(new Paragraph("por concepto de "));
     	cell.setColspan(3);
       	cell.setBorderColor(BaseColor.WHITE);
    	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    	cell.setPaddingBottom(20);
     	table.addCell(cell);
     	
     	p= new Paragraph("    CUOTA ADULTO - Año 2017");
     	p.add(under);
     	
     	cell = new PdfPCell(new Paragraph(p));
     	cell.setColspan(8);
     	cell.setBorderColor(BaseColor.WHITE);
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingBottom(20);
     	table.addCell(cell);
     	
     	cell = new PdfPCell(new Paragraph(" "));
     	cell.setColspan(1);
     	cell.setBorderColor(BaseColor.WHITE);
    	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    	cell.setPaddingBottom(20);
    	table.addCell(cell);
    	
    	
    	// row 6
     	
     	cell = new PdfPCell(new Paragraph("SON: #40,00# €uros"));
     	cell.setColspan(4);
     	cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
     	cell.setBorderColor(BaseColor.WHITE);
    	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    	cell.setPaddingBottom(10);
     	table.addCell(cell);
     	
     	cell = new PdfPCell(new Paragraph(" "));
     	cell.setColspan(1);
     	cell.setPaddingBottom(10);
       	cell.setBorderColor(BaseColor.WHITE);
    	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    	table.addCell(cell);
     	
     	cell = new PdfPCell(new Paragraph("Firmado:_______________________"));
     	cell.setColspan(6);
       	cell.setBorderColor(BaseColor.WHITE);
    	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    	cell.setPaddingBottom(10);
     	table.addCell(cell);
     	
     	cell = new PdfPCell(new Paragraph(" "));
     	cell.setColspan(1);
     	cell.setPaddingBottom(10);
       	cell.setBorderColor(BaseColor.WHITE);
    	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    	table.addCell(cell);
     	
     	
    	String textoCod= "esto los vmaos a encode con los campos";
    	
    	String encodedString = Base64.encodeBytes(textoCod.getBytes());
    	System.out.println("encodedString " + encodedString);
    	byte[] decodedBytes = Base64.decode(encodedString);
    	System.out.println("decodedString " + new String(decodedBytes));
    	
    	
    	Font font = new Font();
    	font.setSize(7.0f);
    	
     	cell = new PdfPCell(new Phrase(encodedString, font));
     	cell.setColspan(12);
       	cell.setBorderColor(BaseColor.WHITE);
     	table.addCell(cell);
    	
     	
    	
    	
    	return table;
    }
	
	/*private PdfPTable buildTableRecibo_ori(int columns) {
    	// Creacion de una tabla
    	PdfPTable table = new PdfPTable(columns);
    	
    	table.setTableEvent(new BorderEvent());
    	
    	table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
    	 
    	// Agregar la imagen anterior a una celda de la tabla
    	PdfPCell cell;
    	
      	
    	cell = new PdfPCell(new Paragraph("Recibo Nº: 3"));
    	cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
       	//cell.setBorderColor(BaseColor.WHITE);
    	cell.setBorderColorBottom(BaseColor.BLACK);
    	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    	
     	table.addCell(cell);
     	
     	cell = new PdfPCell(new Paragraph("______ de ___________ de _______"));
     	cell.setBorderColor(BaseColor.WHITE);
    	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    	cell.setPaddingTop(10);
    	cell.setPaddingBottom(10);
     	table.addCell(cell);
     	
      	cell = new PdfPCell(new Paragraph("Recibí de D.      " +" Miguel Angel Aguilera Caballero "));
       	cell.setBorderColor(BaseColor.WHITE);
    	cell.setBorderColorBottom(BaseColor.BLACK);
    	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    	cell.setPaddingBottom(10);
     	table.addCell(cell);
     	
     	cell = new PdfPCell(new Paragraph("la cantida de             #CUARENTA EUROS# "));
    	cell.setBorderColorBottom(BaseColor.BLACK);
    	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    	cell.setPaddingBottom(10);
     	table.addCell(cell);
     	
     	cell = new PdfPCell(new Paragraph("por concepto de   CUOTA ADULTO 2017"));
       	cell.setBorderColor(BaseColor.WHITE);
    	cell.setBorderColorBottom(BaseColor.BLACK);
    	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    	cell.setPaddingBottom(10);
     	table.addCell(cell);
     	
     	cell = new PdfPCell(new Paragraph("SON:     #40,00#     €uros"));
     	cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
       	cell.setBorderColor(BaseColor.WHITE);
    	cell.setBorderColorBottom(BaseColor.BLACK);
    	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    	cell.setPaddingBottom(10);
     	table.addCell(cell);
     	
     	cell = new PdfPCell(new Paragraph("Firmado:_______________________"));
       	cell.setBorderColor(BaseColor.WHITE);
    	cell.setBorderColorBottom(BaseColor.BLACK);
    	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
    	cell.setPaddingBottom(20);
     	table.addCell(cell);
     	
     	
    	
     	
    	
    	
    	return table;
    }*/
	
	private class BorderEvent implements PdfPTableEvent {
        public void tableLayout(PdfPTable table, float[][] widths, float[] heights, int headerRows, int rowStart, PdfContentByte[] canvases) {
            float width[] = widths[0];
            float x1 = width[0];
            float x2 = width[width.length - 1];
            float y1 = heights[0];
            float y2 = heights[heights.length - 1];
            PdfContentByte cb = canvases[PdfPTable.LINECANVAS];
            cb.rectangle(x1, y1, x2 - x1, y2 - y1);
            cb.stroke();
            cb.resetRGBColorStroke();
        }
    }
	

}
