/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchatting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author SerMiGO
 */
public class connectedClient {
    private Socket clientSocket = new Socket () ; 
    private String clientName = "" ;  
    private ServerSocket p2psocket;
    private int ServerPort;
    //add here the GUI object for the p2pGUI
    public connectedClient ()
    {
        clientSocket = null;
        clientName = "";
    }
    public connectedClient (Socket s,String N,int port)throws IOException{
          clientSocket = s;
          clientName = N;
         // p2psocket = new ServerSocket(port);
          ServerPort = port;
    }
    public void setClient(Socket s,String N)
    {
         clientSocket = s;
         clientName = N;
    }
    public int getServerPort()
    {
        return ServerPort;
    }
    public String getClientName ()
    {
        return clientName;
    }
    public Socket getSocket ()
    {
        return clientSocket;
    }
    //add here the function of the p2p to run the GUI p2pGUI.setVisable(true)
}
