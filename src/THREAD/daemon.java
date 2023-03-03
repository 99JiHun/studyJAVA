package THREAD;
public class daemon extends Thread{

    public static void main(String[] args){
        AutoSaveThread thread = new AutoSaveThread();
        thread.setDaemon(true);
        thread.start();
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){}
        System.out.println("메인 종료");
    }
}
