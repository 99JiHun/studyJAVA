package parsingStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import netscape.javascript.JSObject;

public class rotto {
    private static URL url;
    private static BufferedReader br;
    private static HttpURLConnection con;

    public static void main(String[] args) throws MalformedURLException, IOException{
        url = new URL("https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=1");
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        br = new BufferedReader(new InputStreamReader(con.getInputStream(),"EUC-KR"));

        String temp;
        while((temp=br.readLine())!=null){
            System.out.println(temp);
        }
        br.close(); //HTTP통신 //소켓 통신 해보기!
        
    }
}
