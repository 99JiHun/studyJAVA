package parsingStudy;
import java.io.*;
import java.net.*;
public class bj15637 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader nread = new BufferedReader(new InputStreamReader(System.in));
        int[] winNum = new int[46];
        int N = Integer.parseInt(nread.readLine());
        for(int i=1;i<=700;i++){
        URL url = new URL("https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo="+i);
        URLConnection urlConnect = url.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnect.getInputStream()));
        String str = br.readLine();
        String[] arr = str.split(",");
        int []lotNumber = new int[6];
        if(arr[13].split("").length==13){
            lotNumber[0] = 10 * Integer.parseInt(arr[13].split("")[10]) + Integer.parseInt(arr[13].split("")[11]);
        }
        else{
            lotNumber[0] = Integer.parseInt(arr[13].split("")[10]);
        }
        if(arr[11].split("").length==12){
            lotNumber[1] = 10 * Integer.parseInt(arr[11].split("")[10]) + Integer.parseInt(arr[11].split("")[11]);
        }
        else{
            lotNumber[1] = Integer.parseInt(arr[11].split("")[10]);
        }
        if(arr[12].split("").length==12){
            lotNumber[2] = 10 * Integer.parseInt(arr[12].split("")[10]) + Integer.parseInt(arr[12].split("")[11]);
        }
        else{
            lotNumber[2] = Integer.parseInt(arr[12].split("")[10]);
        }
        if(arr[5].split("").length==12){
            lotNumber[3] = 10 * Integer.parseInt(arr[5].split("")[10]) + Integer.parseInt(arr[5].split("")[11]);
        }
        else{
            lotNumber[3] = Integer.parseInt(arr[5].split("")[10]);
        }
        if(arr[7].split("").length==12){
            lotNumber[4] = 10 * Integer.parseInt(arr[7].split("")[10]) + Integer.parseInt(arr[7].split("")[11]);
        }
        else{
            lotNumber[4] = Integer.parseInt(arr[7].split("")[10]);
        }
        if(arr[4].split("").length==12){
            lotNumber[5] = 10 * Integer.parseInt(arr[4].split("")[10]) + Integer.parseInt(arr[4].split("")[11]);
        }
        else{
            lotNumber[5] = Integer.parseInt(arr[4].split("")[10]);
        }  
        for(int win : lotNumber){
            winNum[win]++;
        }
    }
    bw.write(String.valueOf(winNum[N]));
    bw.flush();
    bw.close();
    }
}