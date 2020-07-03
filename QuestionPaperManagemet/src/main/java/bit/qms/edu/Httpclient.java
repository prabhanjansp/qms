package bit.qms.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import bit.qms.edu.response.QuestionResponse;
import io.vertx.core.json.Json;

public class Httpclient {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String url = "http://localhost:8080/qms/questions";
		@SuppressWarnings("unused")
		String email = "yourname@gmail.com";
		@SuppressWarnings("unused")
		String password = "yourpass";
		 
		 
		URL urlObj = new URL(url);
		HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();
		 
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod("POST");
		 
		String parameters = "{\r\n" + 
				"	\"questionId\":\"1.ba\",\r\n" + 
				"	\"questionStatement\":\"Explain File Structure\",\r\n" + 
				"	\"subject\":\"DS\",\r\n" + 
				"	\"marks\":\"05\",\r\n" + 
				"	\"userId\":\"1234\",\r\n" + 
				"	\"label\":\"chapter1\"\r\n" + 
				"	}";
		 
		 
		OutputStreamWriter writer = new OutputStreamWriter(
		    httpCon.getOutputStream());
		writer.write(parameters);
		writer.flush();
		
		
	      InputStreamReader isReader = new InputStreamReader(httpCon.getInputStream());
	      //Creating a BufferedReader object
	      BufferedReader reader = new BufferedReader(isReader);
	      
	      StringBuffer sb = new StringBuffer();
	      String str;
	      while((str = reader.readLine())!= null){
	         sb.append(str);
	      }
	      
	      QuestionResponse questionResponse = Json.decodeValue(sb.toString(), QuestionResponse.class);
	      System.out.println(questionResponse.getquestionStatement());
	      
	}

}
