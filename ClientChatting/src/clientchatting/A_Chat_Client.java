package clientchatting;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class A_Chat_Client implements Runnable{
    
    Socket SOCK;
    Scanner INPUT;
    Scanner SEND = new Scanner(System.in);
    PrintWriter OUT;
    Vector<String> onlineUsers;
   public A_Chat_Client(Socket X) 
    {
        this.SOCK = X;
    }
   public A_Chat_Client()
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
    
    public void DISCONNECT() throws IOException
    {
        OUT.println(ClientGUI.UserName + " has disconnected.");
        OUT.flush();
        SOCK.close();
        JOptionPane.showMessageDialog(null, "You disconnected");
        System.exit(0);
    }
    
    
   /* public void DISCONNECTt() throws IOException
    {
        //OUT.println(AdminGUI.UserName + " has disconnected.");
        OUT.flush();
        SOCK.close();
        JOptionPane.showMessageDialog(null, "You disconnected");
        System.exit(0);
    }
    */
    
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
            
            if(MESSAGE.contains("#?!"))
            {
                ClientGUI.setDef(MESSAGE.substring(3));
               // onlineUsers.add(MESSAGE.substring(3));
                //ClientGUI.onlineUsr.setListData(onlineUsers);
               // AdminGUI.onlineusers.setListData(CurrentUsers);
            }
            else if (MESSAGE.contains("#?*"))
            {
                ClientGUI.removeDef(MESSAGE.substring(3));
            }
            else if (MESSAGE.contains("#@P2P")){
                ClientGUI.runP2P(ClientGUI.onlineUsr.getSelectedValue(),Integer.parseInt(MESSAGE.substring(5)));
                System.out.println("ClientRecieve TargetP2Pport");
                System.out.println(ClientGUI.onlineUsr.getSelectedValue() + MESSAGE.substring(5));
            }
            else if (MESSAGE.contains("#@P2!")){
                String Temp = INPUT.nextLine();
                ClientGUI.runP2P(Temp.substring(5),Integer.parseInt(MESSAGE.substring(5)));
                System.out.println("ClientRecieve P2Pport Request");
            }
            else if (MESSAGE.contains("#@Seen"))
            {
                if(MESSAGE.substring(6).equals(ClientGUI.UserName));
                else
                {
                ClientGUI.jSeen.setText(ClientGUI.jSeen.getText() + MESSAGE.substring(6) + ", ");
                }
            }
            else if (MESSAGE.contains("#@CR?"))
            {
                System.out.println("ClientRecieve Chatroom Request");
                String[] x = new String[Integer.parseInt(MESSAGE.substring(5))];
                for(int z = 0;z < Integer.parseInt(MESSAGE.substring(5));z++)
                {
                   x[z] = INPUT.nextLine();
                }
                int port = Integer.parseInt(INPUT.nextLine());
                System.out.println("ClientRecieve Chatroom Request on "+ port);
                ClientGUI.runCRoom(x, port);
            
            }
            else
            {
                System.out.println("chatting.A_Chat_Client.RECEIVE()");
                ClientGUI.chatarea.append(MESSAGE + "\n");
                ClientGUI.flagSeen = 0;
                ClientGUI.jSeen.setText("");
            }
        }
    }

     public void p2pRequest(String x)
    {
        OUT.println("#@P2P"+ x);
        OUT.flush();
        OUT.println(ClientGUI.UserName);
        OUT.flush();
    }
     public void CRoomRequest(String[] x,int size)
     {
        OUT.println("#@CR?"+ Integer.toString(size));
        OUT.flush();
        System.out.println(size);
        for (int i=0; i<size;i++)
        {
        OUT.println(x[i]);
        OUT.flush();
            System.out.println(x[i]);
        }
        OUT.flush();
         
     }
    public void sendSeen (String x)
    {
        OUT.println("#@Seen"+ x);
        OUT.flush(); 
    }
    public void SEND(String x)
    {
        OUT.println(ClientGUI.UserName + ": " + x);
        OUT.flush();
        ClientGUI.messagearea.setText("");
    }
    
    
    
}
