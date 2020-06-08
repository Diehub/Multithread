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
public class MultiThread {

    /**
     * @param args the command line arguments
     */
    static  int counter = 0;
    private static synchronized void increment(){
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

    
    public MultiThread() {
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new NewThread();
        try{
            for (int i=16; i>0; i--){
                System.out.println("Main Thread : "+ i);
                Thread.sleep(150);
            }
        } catch (InterruptedException e){
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
        
        process();
        System.out.print(counter);
        
        Runner1 t1 = new Runner1();
        Runner2 t2 = new Runner2();

        t1.start();
        t2.start();


        try { //main thread menunggu kedua thread ini finish
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("finish----------------");
 
    }

    
    
    static class NewThread implements Runnable{
        Thread t;
        NewThread(){
            t = new Thread(this, "Demo Thread");
            System.out.println("Child Thread : "+ t);
            t.start();
        }
        
    public void run(){
            try{
                for (int i=16; i>0; i--){
                    System.out.println("Child Thread : "+ i);
                    Thread.sleep(200);
                }
            } catch (InterruptedException e){
                System.out.println("Child interrupted");
            }
            System.out.println("Exiting child thread.");
            System.out.println("Runner begin!");
        }
    }
    
}

 
