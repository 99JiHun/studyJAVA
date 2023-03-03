package programers;

import java.sql.*;
import java.util.*;
public class mapStudy {
    static public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Integer> reportScoreMap = new HashMap<String,Integer>();
        Map<String,Object> reportListMap = new HashMap<String,Object>();
        List[] list = new List[id_list.length];
        int listIndex = 0;
        for(String idList : id_list){
            reportScoreMap.put(idList,0);
            list[listIndex] = new ArrayList<Integer>();
            reportListMap.put(idList,list[listIndex++]);
        }
        for(String rpName : report){
            String[] rpData = rpName.split(" ");
            String who = rpData[0];
            String rpWho = rpData[1];
            List li =  (ArrayList) reportListMap.get(who);
            Iterator it = li.iterator();
            boolean overLap = false;
            while(it.hasNext()){
                String name = (String)it.next();
                if(rpWho.equals(name)){
                    overLap = true;
                    break;
                }
            }
            if(!overLap){
                reportScoreMap.replace(rpWho,reportScoreMap.get(rpWho)+1);
                li.add(rpWho);
                reportListMap.replace(who,li);
            }
        }
        
        for(String idList : id_list){
            int rps = reportScoreMap.get(idList);
            if(rps >= k){
                int scoreIndex = 0;
                for(String reportIdList : id_list){
                    if(idList.equals(reportIdList)){
                        scoreIndex++;
                        continue;}
                    List li = (List) reportListMap.get(reportIdList);
                    Iterator it = li.iterator();
                    while(it.hasNext()){
                        String name = (String) it.next();
                        if(name.equals(idList)){
                            answer[scoreIndex]++;
                        }
                    }
                    scoreIndex++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", "sini");
        map.put("age", 13); 
        map.put("job", "student");
        // System.out.println(map.keySet());
        // System.out.println(map.values());
        // System.out.println(map.toString());
        // System.out.println(map.get("age"));
        // map.replace("age", 18);
        // System.out.println(map.get("age"));
        
        Collection<Object> col = map.values();
            
        Iterator<Object> it = col.iterator();
        while(it.hasNext()){
            System.out.println(it.getClass());
            System.out.println(it.next());
        }
        String[] id_list ={"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        solution(id_list,report,k);
    }
}
