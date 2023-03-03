package programers;

public class programer2 {
    public static int solution(String dartResult) {
        int answer = 0;
        int[] dartArr = dartResult.chars().toArray();
        int calValue = 0;
        int[] calArr = new int[dartArr.length/2];
        int calIndex = 0;
        boolean nextDart = true;
        for(int data : dartArr){
            if(data>=48&&data<=57){
                if(nextDart){
                    String val = String.valueOf((char)data);
                    calValue = Integer.parseInt(val);
                    nextDart = false;
                }
                else{
                    calArr[calIndex++] = calValue;
                    String val = String.valueOf((char)data);
                    calValue = Integer.parseInt(val);
                }
                continue;
            }
            else{
                if(data == 83){//S
                    calValue = (int)Math.pow(calValue,1);
                    continue;
                }
                else if(data == 68){//D
                calValue = (int)Math.pow(calValue,2);
                    continue;
                }
                else if(data == 84){//T
                    calValue = (int)Math.pow(calValue,3);
                    continue;
                }
                if(data == 42){//*
                    if(calIndex==0){
                        calValue*=2;
                    }
                    else{
                       for(int i=calIndex-1;i<calIndex;i++){
                            calArr[i]*=2;
                        }
                        calValue*=2;
                    }
                }
                else if(data == 35){//#
                    calValue*=-1;
                }
            }
        }
        calArr[calIndex++] = calValue;
        for(int data : calArr){
            answer += data;
        }
        return answer;
    }
    public static void main(String[] args){
        String str = "1D2S#10S";
        solution(str);
    }
}
