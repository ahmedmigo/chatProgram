/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchatting;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author SerMiGO
 */
public class Server {
    public static connectedlist Clist = new connectedlist();

    public Server() throws IOException{
    try
        {
            
            
            final int PORT = 1234;
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
    public void main(String[] args) throws IOException
    { 
    
    }
}
