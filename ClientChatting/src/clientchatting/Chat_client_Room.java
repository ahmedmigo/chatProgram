package clientchatting;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Chat_client_Room implements Runnable{
    
    Socket SOCK;
    Scanner INPUT;
    Scanner SEND = new Scanner(System.in);
    PrintWriter OUT;
    Vector<String> onlineUsers;
   public Chat_client_Room (Socket X) 
    {
        this.SOCK = X;
    }
   public Chat_client_Room ()
   {
   }
    
    public void run()
    {
        try
        {
            try
            {
                INPUT = new Scanner(SOCK.getInputStream());
                OUT = new PrintWriter(SOCK.getOutputStream());
                OUT.flush();
                CheckStream();
            }
            finally
            {
                SOCK.close();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
  
    
   
    public void CheckStream()
    {
        while(true)
        {
            RECEIVE();
         
        }
    }
    
    public void RECEIVE()
    {
       if(INPUT.hasNext())
        {
            String MESSAGE = INPUT.nextLine();
                System.out.println("chatting.A_Chat_Client.RECEIVE()");
                chattRoomGUI.chatarea.append(MESSAGE + "\n");
        }
    }
    public void SEND(String x)
    {
        OUT.println(chattRoomGUI.UserName + ": " + x);
        OUT.flush();
        chattRoomGUI.messagearea.setText("");
    }
    
    
    
}
