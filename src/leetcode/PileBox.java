package leetcode;

import java.util.*;


public class PileBox {
    public int pileBox(int[][] box) {
        if(box == null || box.length == 0)
            return 0;
        Arrays.sort(box, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
            	if(o1[2] == o2[2]) {
            		return o1[1]+o1[0] - o2[1]-o2[0];
            	}
                return o1[2] - o2[2];
            }
        });
        LinkedList<Integer> l = new LinkedList<>();
        l.add(0);
        int ans = -1;
        int count  = box[0][2];
        int index = 0;
        for(int i = 0; i < box.length; ++i){
        	int last = l.getLast();
            if(box[last][0] < box[i][0]
            && box[last][1] < box[i][1]
            && box[last][2] < box[i][2]){
                count += box[i][2];
                ans = Math.max(ans,count);
                l.add(i);
            }
            if(i == box.length-1){
                while(l.size() > 0) {
                	int end = l.pollLast();
                	int start = l.getLast();
                	if(start < end -1)
                		break;
                    count -= box[end][2];
                }
                ans = Math.max(ans, count);
                i = index;
            }
        }
        return ans;
    }
    
    public void test() {
    	int[][] a = new int[][] {{3,4,5},{2,6,5},{3,7,6},{4,6,6},{5,7,7},{4,8,7},{5,9,8},{6,8,8},{7,9,9},{6,10,9}};
    	System.out.println(pileBox(a));
    }
}
