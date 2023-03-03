package programers;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        String[] todayYMD = today.split("\\.");
        String[][] termsData = new String[terms.length][2];
        String[][] privaciesData = new String[privacies.length][2];
        for(int i = 0;i<terms.length;i++){
            termsData[i] = terms[i].split(" ");
        }
        int ansIndex = 0;
        for(int i=0;i<privacies.length;i++){
            boolean delData = false;
            privaciesData[i] = privacies[i].split(" ");
            for(int j=0;j<terms.length;j++){
                if(termsData[j][0].equals(privaciesData[i][1])){
                    String[] str = privaciesData[i][0].split("\\.");
                    int year = Integer.parseInt(str[0]);
                    int mon = Integer.parseInt(str[1]);
                    int day = Integer.parseInt(str[2]);
                    int termsMon = Integer.parseInt(termsData[j][1]);
                    int monPlusTermsMon = mon+termsMon;
                    while(monPlusTermsMon>=12){
                        monPlusTermsMon -= 12;
                        year++;
                    }
                    mon = monPlusTermsMon;
                    day--;
                    if(day==0){
                        day = 28;
                        mon--;
                    }
                    if(mon==0){
                        year--;
                        mon = 12;
                    }
                    int tYear = Integer.parseInt(todayYMD[0]);
                    int tMonth = Integer.parseInt(todayYMD[1]);
                    int tDay = Integer.parseInt(todayYMD[2]);
                    if(tYear < year){
                        delData = true;
                    }
                    else{
                        if(tYear == year){
                            if(tMonth < mon){
                                delData = true;
                            }
                            else{
                                if(tMonth == mon){
                                    if(tDay < day){
                                    delData = true;
                                    }
                                    else{
                                        if(tDay == day){
                                        delData = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                }
            }
            if(!delData){
                if(ansIndex == 0 ){
                    answer = new int[1];
                    answer[0] = i+1;
                    ansIndex++;
                }
                else{
                    int[] temp = new int[ansIndex+1];
                    for(int k=0;k<ansIndex;k++){
                        temp[k] = answer[k];
                    }
                    temp[ansIndex++] = i+1;
                    answer = temp;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        String today = "2022.05.19";
        String[] terms = {"A 6","B 12","C 19"};
        String[] privacies = {"2021.05.02 C", "2021.01.01 B", "2022.02.19 C", "2022.02.20 C"};
        Map<String,Integer> map = new HashMap<String,Integer>();
        solution(today,terms,privacies);
    }
}
