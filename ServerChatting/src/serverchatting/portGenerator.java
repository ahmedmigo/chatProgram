/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchatting;

/**
 *
 * @author SerMiGO
 */
public class portGenerator {
    int port;

    public portGenerator() {
        port = 1235;
    }
    
    public int getport()
    {
        int x = port;
        port ++;
        return port;
    }
}
