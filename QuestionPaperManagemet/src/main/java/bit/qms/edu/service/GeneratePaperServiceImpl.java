package bit.qms.edu.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import bit.qms.edu.model.QuestionModel;

public class GeneratePaperServiceImpl {

	public static final String[] questionOrdering = { "1.a", "1.b", "1.c", "2.a", "2.b", "2.c", "3.a", "3.b", "3.c" };

	public GeneratePaperServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public String generate(String fileId, Map<String, QuestionModel> questionsMap, String code, String name, String date) {
		String path ="C:\\Users\\puran\\OneDrive\\Desktop\\qms\\"+fileId + ".pdf";

		Document document = new Document();
		document.setPageSize(PageSize.A4);

		try {

			PdfWriter.getInstance(document, new FileOutputStream(new File(path)));

			// open
			document.open();

			PdfPTable table = new PdfPTable(2);
			table.setWidthPercentage(100);
			table.setWidths(new int[] { 1, 7 });
			table.addCell(createImageCell()).setBorder(0);
			;
			table.addCell(createTextCell("BANGALORE INSTITUTE OF TECHNOLOGY")).setBorder(0);
			;
			document.add(table);

			/*
			 * Paragraph q = new Paragraph(); q.add("BANGALORE INSTITUTE OF TECHNOLOGY");
			 * q.setAlignment(Element.ALIGN_CENTER);
			 * 
			 * Font h = new Font(); h.setStyle(Font.BOLD); h.setSize(100); document.add(q);
			 * 
			 * Paragraph q1 = new Paragraph(); q1.add("K.R.ROAD, V.V.PURA,BENGALURU");
			 * q1.setAlignment(Element.ALIGN_CENTER);
			 * 
			 * Font h1 = new Font(); h1.setStyle(Font.NORMAL); h1.setSize(15);
			 * document.add(q1);
			 * 
			 * Paragraph q2 = new Paragraph(); q2.add("DEPARTMENT OF MCA");
			 * q2.setAlignment(Element.ALIGN_CENTER);
			 * 
			 * Font h2 = new Font(); h2.setStyle(Font.BOLD); h2.setSize(90);
			 * document.add(q2);
			 * 
			 * 
			 * 
			 * 
			 * Paragraph q3 = new Paragraph(); q3.add("INTERNAL TEST");
			 * q3.setAlignment(Element.ALIGN_CENTER); document.add( Chunk.NEWLINE );
			 * 
			 * Font h3 = new Font(); h3.setStyle(Font.NORMAL); h3.setSize(80);
			 * document.add(q3);
			 */

			Paragraph blamk = new Paragraph();
			document.add(blamk);
			document.add(Chunk.NEWLINE);
			document.add(blamk);

			document.add(Chunk.NEWLINE);

			Paragraph q4 = new Paragraph();
			q4.add("Subjet name :"+name     +                                                                 "\t \t \t Subject Code:"+code);
			q4.setAlignment(Element.ALIGN_CENTER);
			document.add(Chunk.NEWLINE);

			Font h4 = new Font();
			h4.setStyle(Font.NORMAL);
			h4.setSize(50);
			document.add(q4);

			Paragraph q5 = new Paragraph();
			q5.add("Subjet name");
			q5.setAlignment(Element.ALIGN_CENTER);
			document.add(Chunk.NEWLINE);

			Font h5 = new Font();
			h5.setStyle(Font.NORMAL);
			h5.setSize(50);
			document.add(q5);

			Paragraph q6 = new Paragraph();
			q6.add("Date:"+date+"                                    Time:75m                        Max Marks:30");
			q6.setAlignment(Element.ALIGN_CENTER);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);

			Font h6 = new Font();
			h6.setStyle(Font.NORMAL);
			h6.setSize(50);
			document.add(q6);

			Paragraph q7 = new Paragraph();
			q7.add("Answer the following questions:");
			q7.setAlignment(Element.ALIGN_CENTER);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(q7);

			document.add(Chunk.NEWLINE);

			Font h7 = new Font();
			h7.setStyle(Font.NORMAL);
			h7.setSize(50);

			PdfPTable table1 = new PdfPTable(3);
			table1.setWidths(new int[] { 1, 9, 1 });
			table1.addCell("SI.NO");
			PdfPCell cell = new PdfPCell();
			Paragraph p1 = new Paragraph();
			p1.add("Questions");
			p1.setAlignment(Element.ALIGN_CENTER);
			cell.addElement(p1);
			table1.addCell(cell);
			table1.addCell("Marks");

			table1.addCell(createCell("1", "2"));
			table1.addCell(createQuestionCell(questionsMap.get("1.a").getquestionStatement(),
					questionsMap.get("1.b").getquestionStatement()));
			table1.addCell(createCell(questionsMap.get("1.a").getmarks().toString(),
					questionsMap.get("1.b").getmarks().toString()));

			table1.addCell(createCell("3", "4"));
			table1.addCell(createQuestionCell(questionsMap.get("2.a").getquestionStatement(),
					questionsMap.get("2.b").getquestionStatement()));
			table1.addCell(createCell(questionsMap.get("2.a").getmarks().toString(),
					questionsMap.get("2.b").getmarks().toString()));

			table1.addCell(createCell("5", "6"));
			table1.addCell(createQuestionCell(questionsMap.get("3.a").getquestionStatement(),
					questionsMap.get("3.b").getquestionStatement()));
			table1.addCell(createCell(questionsMap.get("3.a").getmarks().toString(),
					questionsMap.get("3.b").getmarks().toString()));

			document.add(table1);

			document.close();

			System.out.println("File generated successfully");

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}

	public static PdfPCell createImageCell() throws DocumentException, IOException {

		// Add Image
		Image image1 = Image.getInstance("BIT.png");
		image1.setLeft(0);
		// image1.setAbsolutePosition(100f, 550f);
		// Scale to new height and new width of image
		image1.scaleAbsolute(75, 75);
		// Add to document
		// document.add(image1);

		PdfPCell cell = new PdfPCell(image1, true);
		cell.setVerticalAlignment(Element.ALIGN_TOP);

		return cell;
	}

	public static PdfPCell createTextCell(String text) throws DocumentException, IOException {
		PdfPCell cell = new PdfPCell();

		cell.setVerticalAlignment(Element.ALIGN_TOP);
		// cell.setBorder(Rectangle.);

		Paragraph q = new Paragraph();
		q.add("BANGALORE INSTITUTE OF TECHNOLOGY");
		q.setAlignment(Element.ALIGN_CENTER);

		Font h = new Font();
		h.setStyle(Font.BOLD);
		h.setSize(100);
		cell.addElement(q);

		Paragraph q1 = new Paragraph();
		q1.add("K.R.ROAD, V.V.PURA,BENGALURU");
		q1.setAlignment(Element.ALIGN_CENTER);

		Font h1 = new Font();
		h1.setStyle(Font.NORMAL);
		h1.setSize(15);
		cell.addElement(q1);

		Paragraph q2 = new Paragraph();
		q2.add("DEPARTMENT OF MCA");
		q2.setAlignment(Element.ALIGN_CENTER);

		Font h2 = new Font();
		h2.setStyle(Font.BOLD);
		h2.setSize(90);
		cell.addElement(q2);

		Paragraph blamk = new Paragraph();
		cell.addElement(blamk);
		cell.addElement(Chunk.NEWLINE);

		Paragraph q3 = new Paragraph();
		q3.add("INTERNAL TEST");
		q3.setAlignment(Element.ALIGN_CENTER);

		Font h3 = new Font();
		h3.setStyle(Font.NORMAL);
		h3.setSize(80);
		cell.addElement(q3);

		return cell;
	}

	private static PdfPCell createQuestionCell(String q1, String q2) {

		PdfPCell cell = new PdfPCell();
		Paragraph p1 = new Paragraph();
		p1.add(q1);
		p1.setAlignment(Element.ALIGN_CENTER);

		Font h3 = new Font();
		h3.setStyle(Font.NORMAL);
		h3.setSize(80);
		cell.addElement(p1);

		Paragraph p3 = new Paragraph();
		p3.add("\n" + "Or" + "\n\n");
		p3.setAlignment(Element.ALIGN_CENTER);
		cell.addElement(p3);

		Paragraph p2 = new Paragraph();
		p2.add(q2);
		p2.setAlignment(Element.ALIGN_CENTER);

		cell.addElement(p2);

		return cell;

	}

	private static PdfPCell createCell(String val1, String val2) {

		PdfPCell cell = new PdfPCell();
		Paragraph p1 = new Paragraph();
		p1.add(val1 + "\n\n\n\n");
		p1.setAlignment(Element.ALIGN_TOP);

		Font h3 = new Font();
		h3.setStyle(Font.NORMAL);
		h3.setSize(80);
		cell.addElement(p1);

		Paragraph p2 = new Paragraph();
		p2.add(val2 + "\n\n\n\n");
		p2.setAlignment(Element.ALIGN_BASELINE);

		cell.addElement(p2);

		return cell;

	}

}
