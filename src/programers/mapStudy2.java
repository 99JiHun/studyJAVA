package programers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class mapStudy2 {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stageCount = new int[N];
        for(int stage : stages){
            if(stage-1<N){
                stageCount[stage-1]++;
            }
        }
        int userNum = stages.length;
        double[] failPer = new double[N];
        int failPerIndex = 0;
        Map<Double,String> failPerMap = new HashMap<Double,String>();
        for(int failNum : stageCount){
            double fail = 0.0;
            if(userNum!=0||failNum!=0){
                fail = ((double)failNum / (double)userNum);
                fail = Math.round(fail*1000)/1000.0;
                System.out.println(fail);
            }        
            if(failPerMap.get(fail)==null){
                failPerMap.put(fail,String.valueOf(failPerIndex+1));
                failPer[failPerIndex] = fail;
            }
            else{
                failPerMap.replace(fail,failPerMap.get(fail)+","+String.valueOf(failPerIndex+1));
                failPer[failPerIndex] = fail;
            }
            failPerIndex++;
            userNum-=failNum;
        }
        Arrays.sort(failPer);
        int ansIndex = 0;
        String ansStr = "";
        for(int i=N-1;i>=0;i--){
            if(i<N-1){
                if(failPer[i] == failPer[i+1]){
                    continue;
                }
            }
            ansStr += failPerMap.get(failPer[i])+",";
        }
        String[] ansArr = ansStr.split(",");
        for(String data : ansArr){
            answer[ansIndex++] = Integer.parseInt(data);
        } 
        return answer;
    }
    public static void main(String[] args){
        // int[] stages = {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        // solution(500,stages);
        String str = "2T*1D2T";
        IntStream arr = str.chars();
        int[] arr2 = arr.toArray();
        for(int data : arr2){
            System.out.println(data);
        }
    }
}
