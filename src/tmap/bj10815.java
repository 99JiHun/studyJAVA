package tmap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class bj10815 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws NumberFormatException, IOException{
        int N = Integer.parseInt(br.readLine());
        String[] card = br.readLine().split(" ");
        Map<String,Boolean> cardMap = new HashMap<String,Boolean>();
        for(String data : card){
            cardMap.put(data,true);
        }
        int M = Integer.parseInt(br.readLine());
        String[] cardSeek = br.readLine().split(" ");
        for(String data : cardSeek){
            if(cardMap.get(data)!=null){
                bw.write("1");
            }
            else{
                bw.write("0");
            }
            bw.write(" ");
        }
        bw.flush();
        bw.close();
    }
}
