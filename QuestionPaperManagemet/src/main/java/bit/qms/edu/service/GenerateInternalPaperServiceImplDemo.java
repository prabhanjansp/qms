package bit.qms.edu.service;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

public class GenerateInternalPaperServiceImplDemo {
	
	private String a,b,c,d,e,f;
	
	public GenerateInternalPaperServiceImplDemo(String a,String b,String c,String d,String e,String f) {

		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
		this.e=e;
		this.f=f;
	}
	
	public void generateFile( ) {
		
	}
	private static final String FILE_NAME = "C:\\Users\\puran\\OneDrive\\Desktop\\qms\\itext2.pdf";

    public static void main(String[] args) {
        writeUsingIText();
    }

    private static void writeUsingIText() {

        Document document = new Document();
        document.setPageSize(PageSize.A4);

        try {

        	File f =new File(FILE_NAME);
        	f.createNewFile();
            PdfWriter.getInstance(document, new FileOutputStream(f));

            //open
            document.open();
            
            
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{1, 7});
            table.addCell(createImageCell()).setBorder(0);;
            table.addCell(createTextCell("BANGALORE INSTITUTE OF TECHNOLOGY")).setBorder(0);;
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
            document.add( Chunk.NEWLINE );
            document.add(blamk);

         
            document.add( Chunk.NEWLINE );

            
            Paragraph q4 = new Paragraph();
            q4.add("Subjet name :                                                                      Subject Code:");
            q4.setAlignment(Element.ALIGN_CENTER);
            document.add( Chunk.NEWLINE );
            
             Font h4 = new Font();
            h4.setStyle(Font.NORMAL);
            h4.setSize(50);
            document.add(q4);

            
            Paragraph q5 = new Paragraph();
            q5.add("Subjet name" );
            q5.setAlignment(Element.ALIGN_CENTER);
            document.add( Chunk.NEWLINE );
            
             Font h5 = new Font();
            h5.setStyle(Font.NORMAL);
            h5.setSize(50);
            document.add(q5);
            
            
            Paragraph q6 = new Paragraph();
            q6.add("Date:                                    Time:75m                                        Max Marks:30");
            q6.setAlignment(Element.ALIGN_CENTER);
            document.add( Chunk.NEWLINE );
            document.add( Chunk.NEWLINE );
            
            
            
             Font h6 = new Font();
            h6.setStyle(Font.NORMAL);
            h6.setSize(50);
            document.add(q6);
            
            
            Paragraph q7 = new Paragraph();
            q7.add("Answer the following questions:" );
            q7.setAlignment(Element.ALIGN_CENTER);
            document.add( Chunk.NEWLINE );
            document.add(Chunk.NEWLINE);
            document.add(q7);

            document.add(Chunk.NEWLINE);
            
            Font h7 = new Font();
            h7.setStyle(Font.NORMAL);
            h7.setSize(50);

			PdfPTable table1 = new PdfPTable(3);
			table1.setWidths(new int[] { 1, 9, 1 });
			table1.addCell("SI.NO");
			table1.addCell("Questions");
			table1.addCell("Marks");
			
			table1.addCell(createCell("1","2"));
			table1.addCell(createQuestionCell("Explain 1 ExplainExplainExplainExplainExplainExplainExplain ExplainExplainExplain ExplainExplainExplainExplain"
					+ "ExplainExplainExplainExplainExplain"
					+ "Explain","Explain 2 ExplainExplainExplainExplain ExplainExplainExplain ExplainExplain ExplainExplain"
							+ "ExplainExplainExplain ExplainExplain  Explain ExplainExplain Explain"));
			table1.addCell(createCell("10","20"));
				
			document.add(table1);
            
            
        
      
            //document.add(new Paragraph("This is my paragraph 3", f));

            //close
            document.close();

            System.out.println("Done");
         
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public static PdfPCell createImageCell() throws DocumentException, IOException {
    	
        
        //Add Image
          Image image1 = Image.getInstance("BIT.png");
          image1.setLeft(0);
          //image1.setAbsolutePosition(100f, 550f);
          //Scale to new height and new width of image
          image1.scaleAbsolute(75, 75);
          //Add to document
          //document.add(image1);
          
        PdfPCell cell = new PdfPCell(image1, true);
        cell.setVerticalAlignment(Element.ALIGN_TOP);

        return cell;
    }
    
    public static PdfPCell createTextCell(String text) throws DocumentException, IOException {
        PdfPCell cell = new PdfPCell();
       
        cell.setVerticalAlignment(Element.ALIGN_TOP);
        //cell.setBorder(Rectangle.);
        
        

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
        p3.add("\n"
        		+ "Or"
        		+ "\n\n");
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
      p1.add(val1+"\n\n\n\n");
      p1.setAlignment(Element.ALIGN_TOP);
      
      
       Font h3 = new Font();
      h3.setStyle(Font.NORMAL);
      h3.setSize(80);
      cell.addElement(p1);

      Paragraph p2 = new Paragraph();
      p2.add(val2+"\n\n\n\n");
      p2.setAlignment(Element.ALIGN_BASELINE);

      cell.addElement(p2);
      
      return cell;
  	

    	
    }

}
