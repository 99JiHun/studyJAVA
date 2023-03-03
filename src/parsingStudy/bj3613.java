package parsingStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
public class bj3613 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[]args) throws IOException{
        String str = br.readLine();
        String[] arr = str.split("");
        int err = 0;
        int pivot2 = 0;
        int small = 0;
        int big = 0;
        int special = 0;
        ArrayDeque que = new ArrayDeque<String>();
        que.clear();
        for(String n : arr){
            que.add(n);
        }
        while(!que.isEmpty()){
            String n = String.valueOf(que.poll());
            if(n.charAt(0)>=65&&n.charAt(0)<=90){
                big++;
            }
            else if(n.charAt(0)>=97&&n.charAt(0)<=122){
                small++;
            }
            else if(n.charAt(0)==95){
                special++;
            }
        } //소문자, 대문자, 언더바, 다른 문자 보는거
        if(special>0){ //c++ >> java
            if(big>0){
                bw.write("Error!"); //c++인데 대문자가 있으면
                pivot2 = 1;
            }
            else if(small==0){ //c++인데 특수문자만 존재할 때
                bw.write("Error!");
                pivot2 = 1;
            }
        }

        if(pivot2==0){
            for(int i=0;i<arr.length;i++){
                if(arr[i].equals("_")){// c++?
                    if(i==0){
                        err = 0;
                        bw.write("Error!");
                        break;  
                    }
                    if(i+1==arr.length){
                        err = 0;
                        bw.write("Error!");
                        break;
                    }
                    else{
                        if((char)(arr[i+1].charAt(0)-32)>=65&&(char)(arr[i+1].charAt(0)-32)<=90){
                            que.add((char)(arr[i+1].charAt(0)-32));
                            i++;
                            err = 1;
                        }
                        else{
                            if(arr[i].charAt(0) >= 97 &&arr[i].charAt(0) <= 122){
                                que.add((char)(arr[i+1].charAt(0)));
                                i++;
                                err = 1;
                            }
                            else{
                                err = 0;
                                bw.write("Error!");
                                break;
                            }
                        }
                    }
                }
                else{
                    if(arr[i].charAt(0) >= 65 &&arr[i].charAt(0) <= 90){
                        if(i==0){
                            bw.write("Error!");
                            err = 0;
                            break;
                        }
                        que.add("_");
                        que.add((char)(arr[i].charAt(0)+32));
                        err = 1;
                    }
                    else{
                        if(big==0&&special==0){
                            err=1;
                        }
                        que.add(arr[i]);
                    }
                }
            }
        }
        if(err == 0){
            br.close();
            bw.flush();
            bw.close();
        }
        else{
            while(!que.isEmpty()){
                bw.write(String.valueOf(que.poll()));
            }
            br.close();
            bw.flush();
            bw.close();
        }
    }
}
