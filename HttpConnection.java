package isepLab03;

import java.io.DataInputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Properties;

public class HttpConnection implements Runnable{

	static DataInputStream din;
	static ServerSocket mysocket;
	
	
	public HttpConnection(){
		
		
	}
	
	 
		
	public void run() {
		
		try{
			String line;
			 while((line = din.readLine()) != null) // read request content
		        { 
			     String[] sentenceList = line.split("[!?.:]+");
			     System.out.println(sentenceList); // spling the answer into sentances
		     }
		 mysocket.close(); //socket closed
			 
		 }
		
		catch(Exception e){
		      System.out.println("exception found");	
			}
			
	 }//end of run
	
	
	public static void main(String[] args) 
	// TODO Auto-generated method stub
{
		Properties prop=new Properties();
		int port = Integer.parseInt(prop.getProperty("Port"));
		mysocket = new ServerSocket(port);
		
		
   while(true) {
  
	 // get the working socket
     din= new DataInputStream(mysocket.getInputStream());

    // instace for http connection
    HttpConnection httpd=new HttpConnection( socket, configuration);
      }

		// thread creation
		Thread thread=new Thread();
		thread.start();
		
           
		
		   InetAddress ip = InetAddress.getLocalHost();
		
		 // to get the status
		   URL u = new URL ( "http://www.example.com/");
		   HttpURLConnection huc =  ( HttpURLConnection )  u.openConnection (); 
		   huc.setRequestMethod ("GET");  //OR  huc.setRequestMethod ("HEAD"); 
		   huc.connect () ; 
		   int code = huc.getResponseCode() ;

		 //instantiating httpLog
		HttpLog httplog=new HttpLog("logfile.html");
		// i am facing the problem how to fetch request and pass it as argument
		add (ip,  request, code);
  }
}
	

