package GRP;

public class jieun {
    static final int MAXLOVE = 100;
    static final int MINLOVE = 0;
    static boolean myFault = false; static int myFaultCount = 0; static boolean yourFault = false; static int yourFaultCount = 0;
    
    private static void LoveAlgorithm(int yourLOVE){
        if(yourLOVE > MAXLOVE){
            System.out.println("나에게는 너무 과분한거 같아");
            return;
        }
        if(yourLOVE < MINLOVE){
            System.out.println("나를 더이상 사랑하지 않는거야?");
            return;
        }
        if(yourLOVE > MINLOVE && yourLOVE < MAXLOVE){
            int yourLoveStore = yourLOVE;
            int myLoveStore = yourLOVE + 5;
            while(yourLoveStore > MINLOVE && myLoveStore > MINLOVE){
                System.out.println("사랑해");
                if(myFault && myFaultCount>=2){
                    myFaultCount = 0; myFault = false;
                    yourLoveStore--;
                }
                if(yourFault && yourFaultCount>=2){
                    yourFaultCount = 0; yourFault = false;
                    myLoveStore--;
                }

            }
        }
    }
}
