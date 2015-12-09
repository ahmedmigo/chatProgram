/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientchatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class messagelistener extends Thread { 
    ServerSocket server;
    int port;
    public messagelistener(int port) { // constructor
        this.port=port;
        System.out.println("clientchatting.messagelistener.<init>()" + port);
        try {
            server= new ServerSocket(port);
            System.out.println("P2P Client ServerSocket listener");
        } catch (IOException ex) {
            Logger.getLogger(messagelistener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @Override
    public void run(){
        while(true)
        {
             try {
                Socket clientsocket = server.accept();
                InputStream is= clientsocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line= br.readLine();
                 System.out.println("clientchatting.messagelistener.run()" + line);
                if(line!=null){
                     mainscreen_p2p.chat.append(line + System.lineSeparator());
                }
            /*if(server.accept()==null)
            {
                System.out.println("clientchatting.messagelistener.run()" + "server accept null");
                break;
            }*/
                }   
            catch (IOException ex) {
                 Logger.getLogger(messagelistener.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    
}
