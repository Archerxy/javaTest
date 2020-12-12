package leetCodeMiddle;
import java.util.*;

public class LeastNumberOfUnique {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n: arr){
            if(map.containsKey(n))
                map.put(n,map.get(n)+1);
            else 
                map.put(n,1);
        }
        List<int[]> list = new LinkedList<>();
        for(int n: map.keySet()){
            list.add(new int[]{n,map.get(n)});
        }
        Collections.sort(list,new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
        });
        if(list.get(0)[1] > k) return list.size();
        while(k > 0) {
            if(list.get(0)[1] <= k) {
                k = k - list.get(0)[1];
                list.remove(0);
            } else
            	k = 0;
        }
        return list.size();
    }
    
    public void test() {
    	int[] a = new int[]{2,1,1,3,3,3};
    	System.out.println(findLeastNumOfUniqueInts(a,3));
    }
}
