package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class streamStudy {
    public static String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        List<String> newIdList = new ArrayList<String>(Arrays.asList(new_id.split("")));
        ListIterator newIdIt = newIdList.listIterator();
        while(newIdIt.hasNext()){
            String data = (String) newIdIt.next();
            if("-".equals(data)){
                continue;
            }
            else if("_".equals(data)){
                continue;
            }
            else if(".".equals(data)){
                continue;
            }
            else{
                int dataNumber = data.charAt(0);
                if(dataNumber>=48&&dataNumber<=57){
                    continue;
                }
                else if(dataNumber>=97&&dataNumber<=122){
                    continue;
                }
                else{
                    newIdIt.remove();
                }
            }
        }
        
        while(newIdIt.hasPrevious()){
            String data = (String) newIdIt.previous();
            if(newIdIt.hasNext()){
                if(newIdIt.nextIndex()==newIdList.size()-1){
                    continue;
                }
                if(".".equals(data)){
                    newIdIt.next();
                    String nextData = (String) newIdIt.next();
                    if(".".equals(nextData)){
                        newIdIt.remove();
                    }
                    else{
                        newIdIt.previous();
                    }
                    newIdIt.previous();
                }
            }
        }
        String firstData = "";
        String lastData = "";
        if(newIdList.size()!=0){
            firstData = newIdList.get(0);
        }
        else{
            newIdList.add("a");
            firstData = "a";
            lastData = "a";
        }
        while(firstData.equals(".")){
            newIdList.remove(0);
            if(newIdList.size()==0)break;
            firstData = newIdList.get(0);
        }
        if(newIdList.size()!=0){
            lastData = newIdList.get(newIdList.size()-1);
        }
        else{
            newIdList.add("a");
            firstData = "a";
            lastData = "a";
        }
        while(lastData.equals(".")){
            newIdList.remove(newIdList.size()-1);
            if(newIdList.size()==0)break;
            lastData = newIdList.get(newIdList.size()-1);
        }
        if(newIdList.size()>=16){
            while(newIdList.size()!=15){
                newIdList.remove(newIdList.size()-1);
            }
        }
        if(newIdList.size()!=0){
            lastData = newIdList.get(newIdList.size()-1);
        }
        else{
            newIdList.add("a");
            firstData = "a";
            lastData = "a";
        }
        while(lastData.equals(".")){
            newIdList.remove(newIdList.size()-1);
            if(newIdList.size()==0)break;
            lastData = newIdList.get(newIdList.size()-1);
        }
        if(newIdList.size()<=2){
            while(newIdList.size()!=3){
                newIdList.add(newIdList.get(newIdList.size()-1));
            }
        }
        answer = newIdList.stream().map(String::valueOf).collect(Collectors.joining());
        return answer;
    }
    public static void main(String[] args){
        String str = "=.=";
        // String lowStr = str.toLowerCase();
        // // System.out.println(lowStr);
        // // IntStream is = "23one1seven".chars();
        // // int[] isArr = is.toArray();
        // // for(int data : isArr){
        // //     System.out.println((char)data);
        // // }
        // List li1 = new ArrayList<>();
        // String[] arr = lowStr.split("");
        // List<String> li2 = new ArrayList<String>(Arrays.asList(arr));
        // // li1.add(3);
        // // li1.add(4);
        // // System.out.print(li1);
        // // li1.add(1,2);
        // // System.out.print(li1);
        // System.out.println(li2);
        // System.out.println(li2.size());
        // Iterator it = li2.iterator();
        // while(it.hasNext()){
        //     String data = (String) it.next();
        //     if("a".equals(data)){
                
        //         it.remove();
        //     }
        // }
        // li2.get(li2.size()-1);
        // // li2.set(0,null);
        // // li2.remove(2);
        // String n = "a";
        // int d = n.charAt(0);
        // System.out.println(li2);
        // System.out.println(li2.get(li2.size()-1));
        
        // System.out.println(solution(str));
        // Stack st = new Stack<>();
        // double[] a = new double[5];
        // a[0] = 0.3;
        // a[1] = 0.2;
        // a[2] = 1.3;
        // a[3] = 0.02;
        // for(double data : a){
        //     System.out.println(data);
        // }
        // Arrays.sort(a);
        // List li = new LinkedList<Integer>();
        // if(li.size()==0){
        //     li.add(1);
        // }
        // else{
        //     li.set(1, 4);
        // }
        
        Map<Double,Object> map = new HashMap<Double,Object>();
        double[] dli = {0.125,0.428,0.5,-1,0};
        List li = new ArrayList<>();
        
        map.put(0.125,"1");
        map.put(0.428, "2");
        map.put(0.5, "34");
        // map.put(0.5,"4");
        map.put((double)0, "5");
        Arrays.sort(dli);
        for(int i = 4;i>=0;i--){
            System.out.print(map.get(dli[i]));
        }
        if(map.get(0.5)!=null){
            System.out.print(map.get(0.5));
        }
        // for(double data : dli){
        //     System.out.println(map.get(data));
        // }
        Collection col = map.values();
        Iterator it = col.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
    }
    
}
