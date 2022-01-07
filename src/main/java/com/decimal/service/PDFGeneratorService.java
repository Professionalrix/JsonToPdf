package com.decimal.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.decimal.User;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PDFGeneratorService {
	
	private List<User> listUsers ;
	
	
	 public PDFGeneratorService(List<User> listUsers) {
		this.listUsers = listUsers;
	}
	 
	 private void writeTableData(PdfPTable table) {
	        for (User user : listUsers) {
	            table.addCell(String.valueOf(user.getTransactionType()));
	            table.addCell(user.getCreditValue());
	            table.addCell(user.getStatus());
	            table.addCell(user.getDate());
	            table.addCell(user.getTime());
	        }
	    }

	private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	       // cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(5);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        //font.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("Transaction Type", font));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Loyality Points", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Transaction Status", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Date", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Time", font));
	        table.addCell(cell);       
	    }
	     
	   
	     
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	      //  font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("List of Users", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(5);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
	

}
