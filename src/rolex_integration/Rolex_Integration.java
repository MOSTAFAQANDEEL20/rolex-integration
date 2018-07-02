/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rolex_integration;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LABS- 119
 */
public class Rolex_Integration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Runnable r = new Runnable1();
        Thread t = new Thread(r);
        Runnable r2 = new Runnable2();
        Thread t2 = new Thread(r2);
        t.start();
        t2.start();
    }

}

class Runnable2 implements Runnable {

    public void run() {
        for (int i = 0; i < 3; i++) {
            JOptionPane.showMessageDialog(null, "thread1 run every four seconds");

            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Runnable2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}

class Runnable1 implements Runnable {

    public void run() {
        for (int i = 0; i < 3; i++) {
            JOptionPane.showMessageDialog(null, "thread2 run every two seconds");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Runnable2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
