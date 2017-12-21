package action;
import action.Msg;
import java.io.*;
import java.util.ArrayList;
import client.*;
import common.*;
/**
 * This class constructs the UI for a chat client.  It implements the
 * chat interface in order to activate the display() method.
 * Warning: Some of the code here is cloned in ServerConsole 
 */
public class ClientConsole implements ChatIF
{
	public gui.Menu_controller mc;
	public gui.win2_Controller win2;
  //Class variables *************************************************
  /**
   * The default port to connect on.
   */
  final public static int DEFAULT_PORT = 5555;
  //Instance variables **********************************************
  
  /**
   * The instance of the client that created this ConsoleChat.
   */
  ChatClient client;

  
  //Constructors ****************************************************

  /**
   * Constructs an instance of the ClientConsole UI.
   *
   * @param host The host to connect to.
   * @param port The port to connect on.
   */
  public ClientConsole(String host, int port,gui.Menu_controller mc) 
  {
	
	this.mc=mc;
    try  
    {
        client= new ChatClient(host, port, this);
    } 
    catch(IOException exception) 
    {
      System.out.println("Error: Can't setup connection!"+ " Terminating client.");
      System.exit(1); 
    }
  }
  
  public void SetWin2_Controller(gui.win2_Controller controller)
  {
	  this.win2=controller;  
  }
  //Instance methods ************************************************
  
  /**
   * This method waits for input from the console.  Once it is 
   * received, it sends it to the client's message handler with the Msg(object).
   */
  public void accept(Object msg ) 
  {	 
		 try
		    {    	
		    	client.handleMessageFromClientUI(msg);      
		    }
		 catch (Exception ex) 
		    {
		      System.out.println
		        ("Unexpected error while reading from console!");
		    }
	}

  /**
   * This method overrides the method in the ChatIF interface.  It
   * sends the results to the Client
   * this method finds out who send the request and sends back.
   * 
   * @param.
   */
  public void displaytoGUI(Object message) 
  {	 
	 
	   if(message instanceof ArrayList<?>)
	   {
		    mc.setNames(message);
	   }
	   if(message instanceof Msg)
		   
	   {
		   Msg check= (Msg)message;
		   
		 if(  check.getType().equals("SELECT"))
				 {
			   win2.setDetails(message);
				 }
		 
	   }//else its an update query
  }   
  //Class methods ***************************************************
}
//End of ConsoleChat class