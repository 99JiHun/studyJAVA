package BIT;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.*;
public class bj273802 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] bArr; static List<List> linkB; static Long[] aArr; static boolean errPivot = false;
    public static List addList(long data){
        List li = new ArrayList<>();
        li.add(data);
        return li;
    }
    public static void addDataList(long data,int curIndex){
            long possiData = 0;
            if(possiData <= aArr[curIndex]){
                if(linkB.get(curIndex).isEmpty()){
                    linkB.add(addList(possiData));
                }
                else{
                    linkB.get(curIndex).add(possiData);
                }
            }
    }
    public static void linkBarr(long data,int curIndex){
        if(linkB.isEmpty()||curIndex==0){
            String[] dataArr = Long.toBinaryString(data).split("");
            int carryIndex = 0;
            for(int i=dataArr.length-1;i>=0;i--){
                if("1".equals(dataArr[i])){
                    long curValue = (long) Math.pow(2,carryIndex);
                    linkB.add(addList(curValue));
                    return;
                }
                carryIndex++;
            }
            linkB.add(addList(0));
        }
        else{
            if(curIndex>=aArr.length){
                errPivot = true;
                return;
            }
            int preIndex = curIndex-1;
            if(preIndex>=aArr.length){
                errPivot = true;
                return;  
            }
            if(linkB.size()!=curIndex){
                errPivot = true;
                return;
            }
            Long[] curArr = (Long[]) linkB.get(preIndex).toArray(Long[]::new);
            if(Arrays.toString(curArr).equals("null")){
                errPivot = true;
                return;
            }
            List nList = new ArrayList<>();
            nList.add((long)-1);
            linkB.add(nList);
            for(long curData : curArr){
                long possiData = 0;
                // addDataList(aArr[preIndex] - curData,curIndex);
                // addDataList(aArr[preIndex], curIndex);
                
                possiData = aArr[preIndex] - curData;
                if(possiData <= aArr[curIndex] && curData <= possiData){
                    if(linkB.get(curIndex).get(0).toString().equals("-1")){
                        linkB.set(curIndex,addList(possiData));
                        // linkB.add(addList(possiData));
                    }
                    else{

                        linkB.get(curIndex).add(possiData);
                    }
                }
                possiData = aArr[preIndex];
                if(possiData <= aArr[curIndex] && curData <= possiData){
                    if(linkB.get(curIndex).get(0).toString().equals("-1")){//linkB.get(curIndex) == null
                        linkB.set(curIndex,addList(possiData));
                        // linkB.add(addList(possiData));
                    }
                    else{

                        linkB.get(curIndex).add(possiData);
                    }
                }
                possiData = aArr[curIndex];
                if(possiData <= aArr[curIndex] && curData <= possiData){
                    if(linkB.get(curIndex).get(0).toString().equals("-1")){
                        linkB.set(curIndex,addList(possiData));
                        // linkB.add(addList(possiData));
                    }
                    else{

                        linkB.get(curIndex).add(possiData);
                    }
                }
            }
            if(linkB.get(curIndex).get(0).toString().equals("-1")){
                errPivot = true;
                return;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        bArr = new long[N];
        aArr = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).boxed().toArray(Long[]::new);
        linkB = new LinkedList<List>();
        linkB.clear();
        int index = 0;
        for(long data : aArr){
            linkBarr(data,index);
            Long[] curArr = (Long[]) linkB.get(index).toArray(Long[]::new);
            Arrays.sort(curArr);
            Stream<Long> distinctArr = Arrays.asList(curArr).stream().distinct();
            Long[] curArrDis = (Long[]) distinctArr.toArray(Long[]::new);
            linkB.set(index++, Arrays.asList(curArrDis));
        }
        linkB.add(addList(aArr[aArr.length-1]));
        if(errPivot){
            bw.write("No");
        }
        else{
            long[] finArr = new long[N];
            Arrays.fill(finArr, (long) -1);
            finArr[0] = (long) linkB.get(0).get(0);
            for(int i=1;i<N;i++){
                if(finArr[i-1]==-1){
                    bw.write("No");
                    errPivot = true;
                    break;
                }
                Long[] arr = (Long[]) linkB.get(i).toArray(Long[]::new);
                for(long data : arr){
                    if(finArr[i-1] <= data && (data|finArr[i-1]) == aArr[i-1]){
                        finArr[i] = data;
                        break;
                    }
                }
            }
            if(!errPivot){
                bw.write("Yes\n");
                for(long data : finArr){
                    bw.write(String.valueOf(data) + " ");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}   