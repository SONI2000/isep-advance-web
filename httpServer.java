package isepLab03;

import java.lang.* ;
import java.util.* ;
import java.io.* ;
import java.net.*;


public class httpServer {
	
	
	public static void main(String [] args) throws FileNotFoundException, IOException{
		
		String result="";
		Properties prop=new Properties();
		String propFileName="config.properties";
		
		// read properties file
		
		prop.load(new FileInputStream(propFileName));
		
	
		int port = Integer.parseInt(prop.getProperty("Port"));
		String webroot= prop.getProperty("WebRoot");
		
		
		
		// creating a socket 
	    //open a socket 1.3
				
				ServerSocket mysocket = new ServerSocket(port);
				while(true) {
					new HttpConnection(mysocket.accept(),prop);   //1
				}
				
				Date time = new Date(System.currentTimeMillis());
				
					//retrive the socket
				 DataInputStream din= new DataInputStream(mysocket.getInputStream()); //2
				 String line;
				 
				 while((line = din.readLine()) != null) // read request content
			        { 
				 String[] sentenceList = line.split("[!?.:]+");
				 System.out.println(sentenceList);
				 
				 
				 // processing a request
				 
				 PrintStream printstream= new PrintStream(webroot);
				
				 // to find extensions
				 File file = new File(webroot);
				 String  mimeType = mimeTypesMap.getContentType(file);  //3
				
				 //to fetch the server name
				 InetAddress ip = InetAddress.getLocalHost();
				 String hostname = ip.getHostName();
				 
				 printstream.println("Date: "+time);
				 
				 // file existance
				 File tempFile = new File(webroot);
				 boolean exists = tempFile.exists();
				 
				 // to check the directory
				 File direct = new File("/resources/tp03");
				 boolean dir=direct.isDirectory();
				 
				 if(mimeType==".txt" || mimeType==".html") // here we use multiple file type acceptance
				 {
					
					  // if no error 
					 if(exists==true && din!=null ) // file exits and not empty
					 { 
					 printstream.println("Server:"+hostname);
					 printstream.println("content-type: text/html  /n/n");
					 printstream.println(line);
					 
					 }
					  else{
								 // bad request 
								 if(exists==true) //file exits but empty
								 {                                            // how to fetch html page
							     printstream.println("Server:"+hostname);
								 printstream.println("content-type: text/html  /n/n");
								 printstream.println( "<HEAD><TITLE>Bad Request</TITLE></HEAD> /n"
								                     +"<BODY><H1>Bad Request /n</H1>"
								                     +"<p>Votre navigateur Internet a envoyé une requête que ce serveur ne peut pas traiter.</P> /n"
								                     +"</BODY>");
								    }
								 
									 else{
													 // file not found
										 printstream.println("Server:"+hostname);
										 printstream.println("content-type: text/html  /n/n");
			  						     printstream.println("<HEAD> <TITLE> File not found </ TITLE> </ HEAD> /n "
													     + "<BODY> <H1> File not found </ H1> /n"
													 	 + "<p>The resource / rep1 / a_resource is not present on this server.</P> /n"
													 	 + " </ BODY>");
									       }
							  }
			}	 			 
	}// end of while
		                
		                  
		          mysocket.close(); //socket closed
					
	}
					
					
}
		
	


