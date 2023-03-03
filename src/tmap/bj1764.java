package tmap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
public class bj1764 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            int i = 0;
            while(true){
                if(o1.length()<=i)return-1;
                if(o2.length()<=i)return 1;
                int data = o1.charAt(i) - o2.charAt(i);
                if(data!=0)return data;
                i++;
            }
        };
    };
    public static void main(String[] args) throws NumberFormatException, IOException{
        Integer[] NK = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        Map<String,Boolean> map = new HashMap<String,Boolean>();
        List<String> list = new ArrayList<String>();
        for(int i=0;i<NK[0];i++){
            String key = br.readLine();
            map.put(key, true);
        }
        for(int j=0;j<NK[1];j++){
            String searchKey = br.readLine();
            if(map.get(searchKey)!=null){
                list.add(searchKey);
            }
        }
        list.sort(comparator);
        bw.write(list.size()+"\n");
        for(String data : list){
            bw.write(data+"\n");
        }
        bw.flush();
        bw.close();
    }
}