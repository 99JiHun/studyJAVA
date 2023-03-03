package programers;
import java.util.*;
import java.util.Collections;
public class emoji {
    public static int Max(int a,int b, int c, int d){
        if(a>b&&a>c&&a>d){
            return a;
        }
        else if(b>a&&b>c&&b>d){
            return b;
        }
        else if(c>a&&c>b&&c>d){
            return c;
        }
        else{
            return d;
        }
    }
    public static int[] selectPer(int[][] users, int money, int preMoney){//얼마 짜리인지
        int[] disMoney4321 = { (int)(money * (1-0.4)),(int)(money * (1-0.3)),(int)(money * (1-0.2)),(int)(money * (1-0.1))};
        int[] userSum = new int[4];
        int[] N4321 = new int[4];
        for(int i=0;i<users.length;i++){
            int rate = (int)Math.ceil(users[i][0]);

            switch(rate){
                case 10:
                    userSum[3]=disMoney4321[3];
                case 20:
                    userSum[2]=disMoney4321[2];
                case 30:
                    userSum[1]=disMoney4321[1];
                case 40:
                    userSum[0]=disMoney4321[0];
            }
            int k = 0;
            for(int data : userSum){
                if(data==0){
                    k++;
                    continue;
                }
                int totalMoney = preMoney + data;
                if(totalMoney >=users[i][1]){
                    N4321[k++]++;
                }
            }
            k=0;

        }
        int[] ans = new int[2];

        return ans;
    }
    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        //users 0열 이상 할인율 올림해서 10,20,30,40 으로 맞추기
        //Math.floor 로 올림
        int preMoney = 0;
        Integer[] emo = Arrays.stream(emoticons).boxed().toArray(Integer[]::new);
        Arrays.sort(emo,Collections.reverseOrder());
        for(int data : emo){
            int[] NPer = selectPer(users,data,preMoney); //0 n 1 per
            answer[0] += NPer[0];
            preMoney += NPer[1];
            answer[1] = NPer[1];
        }
        return answer;
    }
    public static void main(String[] args){
        int[][] users = {{40,10000},{25,10000}};
        int[] emoticons = {7000,9000};
        solution(users,emoticons);
    }
}
