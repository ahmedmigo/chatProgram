/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchatting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import static serverchatting.Server.Clist;

/**
 *
 * @author SerMiGO
 */
public class ChatRoomServer {
    public connectedlist Clist = new connectedlist();
    int PORT;
    public ChatRoomServer(int port) throws IOException{
        PORT = port;
    }
    public void Run() throws IOException
    {
         try
        {
            ServerSocket SERVER = new ServerSocket(PORT);
            System.out.println("Waiting for clients...");
          
            while(true)
            {
                Socket SOCK = SERVER.accept();
              // System.out.println("Client connected from: " + SOCK.getLocalAddress().getHostName());
                Scanner INPUT = new Scanner(SOCK.getInputStream());
                String UserName = INPUT.nextLine();
                String p2pPort = INPUT.nextLine();
                connectedClient tempClient = new connectedClient(SOCK, UserName,Integer.parseInt(p2pPort));
                Clist.AddClient(tempClient);
                
                A_Chat_Server_Return CHAT = new A_Chat_Server_Return(SOCK);
                Thread X = new Thread(CHAT);
                X.start();
                 
                 
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    
    }
}