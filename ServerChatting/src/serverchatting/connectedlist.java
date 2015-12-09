/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchatting;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.DefaultListModel;

/**
 *
 * @author SerMiGO
 */
public class connectedlist {
   private  LinkedList<connectedClient> Connectionlist = new LinkedList<connectedClient>();
   public DefaultListModel def= new DefaultListModel();
   public void AddClient(connectedClient X) throws IOException
   {
       def.add(Connectionlist.size(), X.getClientName());
       Connectionlist.add(X);
        Scanner INPUT;
        PrintWriter OUT;
        for (int i = 0; i< Connectionlist.size() -1 ;i++)
        {
        OUT = new PrintWriter(X.getSocket().getOutputStream());
        OUT.println("#?!" + Connectionlist.get(i).getClientName());
        OUT.flush();
        }
        for (int i = 0; i< Connectionlist.size() -1;i++)
        {
            OUT = new PrintWriter(Connectionlist.get(i).getSocket().getOutputStream());
            OUT.println("#?!" + X.getClientName());
            OUT.flush();
        }
   }
   public void AddClientRoom (connectedClient X)
   {
       Connectionlist.add(X);
   }
   public DefaultListModel getdef ()
   {
       return def;
   }
   public void RemoveClient(String X) throws IOException
   {
       Scanner INPUT;
       PrintWriter OUT;
       def.removeElement(X);
       for (int i = 0; i < Connectionlist.size(); i++) {
           if (Connectionlist.get(i).getClientName()== X){
               Connectionlist.get(i).getSocket().close();
               Connectionlist.remove(Connectionlist.get(i));
           }
	   }
        for (int i = 0; i< Connectionlist.size();i++)
        {
            OUT = new PrintWriter(Connectionlist.get(i).getSocket().getOutputStream());
            OUT.println("#?*" + X);
            OUT.flush();
        }
   }
      public void RemoveClient(Socket X) throws IOException
   {
       
       for (int i = 0; i < Connectionlist.size(); i++) {
           if (Connectionlist.get(i).getSocket()== X){
               Connectionlist.get(i).getSocket().close();
               Connectionlist.remove(Connectionlist.get(i));
              
           }
	   }
       
   }
   public connectedClient getconnectedclient(int i)
   {
       return(Connectionlist.get(i));
   }
   public int getSize()
   {
       return (Connectionlist.size());
   }
   public Socket getsocket (int i)
   {
       return(Connectionlist.get(i).getSocket());
   }
   
      public String getClientName (int i)
   {
       return(Connectionlist.get(i).getClientName());
   }
   
}
