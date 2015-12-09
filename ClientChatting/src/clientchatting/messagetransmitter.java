/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientchatting;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class messagetransmitter extends Thread {
    
    
    String message, hostname;
    int port;
    public messagetransmitter(String message, String hostname, int port){
        this.message=message;
        this.hostname=hostname;
        this.port=port;
}
     public messagetransmitter(){
        
    }
     
     
     @Override
    public void run() {
         System.out.println("hostname" + hostname + port);
        try {
            Socket TEMP_SOCK = new Socket("192.168.43.165", port);
            System.out.println(message);
            PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
            TEMP_OUT.println(hostname +": "+message);
            TEMP_OUT.flush();
        } catch (IOException ex) {
            Logger.getLogger(messagetransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
