package THREAD;
class Task implements Runnable{
    public void run(){}
}
public class threadStu extends Thread{
    static Thread th1 = new Thread(new Task(){
        @Override
        public void run(){
            int cnt = 1;
            while(cnt<=10){
                System.out.println(cnt + " + " + cnt + " = " + (cnt+cnt));
                cnt++;
            }
        }
    });
    static Thread th2 = new Thread(new Task(){
        @Override
        public void run(){
            try{
                th1.join();
                int cnt = 1;
                while(cnt<=10){
                    System.out.println(cnt + " * " + cnt + " = " + (cnt*cnt));
                    cnt++;
                }
                
            }catch(InterruptedException e){}
        }
        
    });
    public static void main(String[] args){
        th1.start();
        th2.start();
    }
}
