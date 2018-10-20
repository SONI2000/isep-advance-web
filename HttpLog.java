package isepLab03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Date;


class HttpLog
{

	  PrintWriter writer;
  HttpLog (String logFile) throws FileNotFoundException, UnsupportedEncodingException
  {
    
	   writer = new PrintWriter(logFile, "UTF-8"); 
  }
  
  
 
   public void add (String address, String request, int status) throws IOException
  {
   
	   Date time = new Date(System.currentTimeMillis()); // current date
	   
	 
	   writer.println("["+address+"] "+" ["+time+"] "+" ["+request+"] "+" ["+status+"] ");
	   writer.close();
	   
	   
	   
	   InetAddress ip = InetAddress.getLocalHost();// to fetch it address
	   
	   
	  
  }
   
   
}

