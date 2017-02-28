package com.maacsport.util;

import java.io.IOException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class MyItextPDFEventListener extends PdfPageEventHelper {
 
	 private String realPath="";
	
	public MyItextPDFEventListener(String realPath) {
		this.realPath=realPath;
	}
	
	 @Override
	 
	         public void onEndPage(PdfWriter writer, Document document)
	 
	         {
	 
	                 PdfContentByte canvas = writer.getDirectContentUnder();
	                 
	                 Phrase watermark = new Phrase("Hermandad de La Verónica", new Font(FontFamily.TIMES_ROMAN, 25, Font.NORMAL, BaseColor.LIGHT_GRAY));
	 
	                 ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 260, 150, 20);
	                 
	                 Image background;
					try {
						/*background = Image.getInstance("/Users/maaguilera/testes/veronica1.jpg");
						 float width = background.getWidth();
		                 
                         float height = background.getHeight();
                         
                         background.setTransparency(transparency);
     
                         writer.getDirectContentUnder().addImage(background, width, 0, 0, height, 0, 0);
                         */
                         
                         Image image = Image.getInstance(realPath+"/veronica3.png");
                         image.scaleToFit(90f, 90f);
                         image.setAbsolutePosition(350,75);
                         
                         canvas.saveState();
                        
                         PdfGState state = new PdfGState();
                         state.setFillOpacity(0.3f);
                         canvas.setGState(state);
                         canvas.addImage(image);
                         canvas.restoreState();
                         
					} catch (BadElementException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                 
	                                    
	 
	         }
	 
}


