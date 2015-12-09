package serverchatting;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class A_Chat_Server_Return implements Runnable
{
    
    Socket SOCK;
    private Scanner INPUT;
    private PrintWriter OUT;
    String MESSAGE = "";
    portGenerator pGenerator = new portGenerator(); 
    public A_Chat_Server_Return(Socket X)
    {
        this.SOCK=X;
    }
  
    public void CheckConnection() throws IOException
    {
        if(!SOCK.isConnected())
        {
            for(int i = 1; i <= Server.Clist.getSize(); i++)
            {
                if(Server.Clist.getsocket(i)==SOCK)
                {
                    Server.Clist.RemoveClient(SOCK);
                }
            }
            for(int i = 1; i <=  Server.Clist.getSize(); i++)
            {
                Socket TEMP_SOCK = (Socket) Server.Clist.getsocket(i-1);
                PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
                TEMP_OUT.println(TEMP_SOCK.getLocalAddress().getHostName()+" disconnected!");
            }
            
        }
    }
    
    public void run()
    {
        try
        {
            try
            {
                INPUT = new Scanner(SOCK.getInputStream());
                OUT = new PrintWriter(SOCK.getOutputStream());
                
                while(true)
                {
                    CheckConnection();
                    
                    if(!INPUT.hasNext())
                    {
                        return;
                    }
                    
                    MESSAGE = INPUT.nextLine();
                    if (MESSAGE.contains("#@P2P")){
                    String Sender = INPUT.nextLine();
                    int j ;
                        System.out.println("serverRecive p2p Request " + MESSAGE.substring(5));
                    for(int i = 0; i < Server.Clist.getSize(); i++)
                    {  
                        System.out.println(Server.Clist.getClientName(i) + MESSAGE.substring(5));
                        if (Server.Clist.getClientName(i).equals(MESSAGE.substring(5)))
                        {
                             for(j = 0; j < Server.Clist.getSize(); j++)
                             {
                                  System.out.println(Server.Clist.getClientName(j) + Sender);
                                 if (Server.Clist.getClientName(j).equals(Sender))
                                 {
                                     
                                     System.out.println(Server.Clist.getClientName(j)+" " +Sender);
                                    Socket TEMP_SOCK = (Socket) Server.Clist.getsocket(j);
                                    PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
                                    TEMP_OUT.println("#@P2P"+Integer.toString(Server.Clist.getconnectedclient(i).getServerPort()));
                                    TEMP_OUT.flush();
                                     System.out.println("#@P2P"+Integer.toString(Server.Clist.getconnectedclient(i).getServerPort()));
                                    break;
                                 }
                             }
                                Socket TEMP_SOCK = (Socket) Server.Clist.getsocket(i);
                                PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
                                TEMP_OUT.println("#@P2!"+Integer.toString(Server.Clist.getconnectedclient(j).getServerPort()));
                                TEMP_OUT.flush();
                                 System.out.println("#@P2!"+Integer.toString(Server.Clist.getconnectedclient(j).getServerPort()));
                                TEMP_OUT.println("#@P2!"+Server.Clist.getconnectedclient(j).getClientName());
                                TEMP_OUT.flush();
                                 System.out.println("#@P2!"+Server.Clist.getconnectedclient(j).getClientName());
                                 break;
                                
                        }
                    }
                    }
                    else if (MESSAGE.contains("#@Seen"))
                    {
                    for(int i = 1; i <= Server.Clist.getSize(); i++)
                    {
                        Socket TEMP_SOCK = (Socket) Server.Clist.getsocket(i-1);
                        PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
                        TEMP_OUT.println(MESSAGE);
                        TEMP_OUT.flush();
                        System.out.println("Sent to: " + TEMP_SOCK.getLocalAddress().getHostName());
                    }
                    }
                   else if (MESSAGE.contains("#@CR?"))
                   {
                       System.out.println("Chat Room Requiest Recieved" + MESSAGE);
                       int size = Integer.parseInt(MESSAGE.substring(5));
                       String[] x = new String[size];
                       int port =  pGenerator.getport();
                       ChatRoomServer CRoom = new ChatRoomServer(port);
                       System.out.println("Chat Room Requiest Recieved" + size);
                       for(int z = 0;z < size ;z++)
                       {
                           x[z] = INPUT.nextLine();
                           System.out.println(x[z]);
                       }
                       for(int j = 0; j < size;j++)
                       {
                        for(int i = 0; i < Server.Clist.getSize(); i++)
                        {
                           if(x[j].equals(Server.Clist.getClientName(i)))
                           {
                           CRoom.Clist.AddClientRoom(Server.Clist.getconnectedclient(i));
                           Socket TEMP_SOCK = (Socket) Server.Clist.getsocket(i);
                           PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
                               System.out.println(MESSAGE);
                           TEMP_OUT.println(MESSAGE);
                           TEMP_OUT.flush();
                           for(int z = 0;z < size ;z++)
                            {
                                TEMP_OUT.println(x[z]);
                                TEMP_OUT.flush();
                            }
                            TEMP_OUT.println(Integer.toString(port));
                            TEMP_OUT.flush();
                            break;
                            }
                        }
                           
                       }
                   CRoom.Run();
                   }
                    else {
                    System.out.println("Client said: " + MESSAGE);
                    
                    for(int i = 1; i <= Server.Clist.getSize(); i++)
                    {
                        Socket TEMP_SOCK = (Socket) Server.Clist.getsocket(i-1);
                        PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
                        TEMP_OUT.println(MESSAGE);
                        TEMP_OUT.flush();
                        System.out.println("Sent to: " + TEMP_SOCK.getLocalAddress().getHostName());
                    }
                    }
                }
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
    
}
