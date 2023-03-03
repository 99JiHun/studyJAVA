package THREAD;
import java.awt.*;
class Task implements Runnable{
    public void run(){}
}
public class threadStudy extends Thread{
    public threadStudy(String name){
        setName(name);
    }
    public void run(){
        for(int i=0;i<200000000;i++){
        }
        System.out.println(getName());
    }
    public static void main(String[] args){
        // System.out.println("main thread");
    //     Thread thread = new Thread(new Runnable() {
    //        public void run(){
    //             System.out.println("th2");
    //        } 
    //     });
    // Task t = new Task();
        // Toolkit toolkit = Toolkit.getDefaultToolkit(); //toolkit 객체 얻기
        // Thread th1 = new Thread(new Runnable() {
        //    public void run(){
        //     for(int i=0;i<5;i++){
        //         toolkit.beep();
        //         try{Thread.sleep(500);}catch(Exception e){}
        //     }
        //    } 
        // });
        // th1.start();
        // Thread th2 = new Thread(new Task() {
        //     @Override
        //     public void run(){
        //         for(int i=0;i<5;i++){
        //             System.out.println("띵");
        //             try{Thread.sleep(500);}catch(Exception e){}
        //         }
        //     }
        // });
        // th2.start();

        // Thread th3 = new Thread(){
        //     public void run(){

        //     }
        // };
        for(int i=1;i<=10;i++){
            Thread th3 = new threadStudy("Thread"+i);
            if(i!=10)th3.setPriority(Thread.MIN_PRIORITY);
            else{th3.setPriority(Thread.MAX_PRIORITY);}
            th3.start();
        }
    }
    
}
