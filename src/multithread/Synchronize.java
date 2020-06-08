/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithread;

/**
 *
 * @author user
 */
public class Synchronize {
    static  int counter = 0;
    private static void increment(){
        ++counter;
    }

    private static void process(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<1000;i++){
                    increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<100;i++){
                    increment();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
