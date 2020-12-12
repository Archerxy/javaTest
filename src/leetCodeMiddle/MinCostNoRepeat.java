package leetCodeMiddle;

public class MinCostNoRepeat {
	public int minCost(String s, int[] cost) {
	    int d = 0;
	    char[] cs = s.toCharArray();
	    int ans = Integer.MAX_VALUE;
	    while(d < cs.length){
	        if(!hasRepeat(d,cs)){
	            ans = Math.min(cost[d],ans);
	        }
	        ++d;
	    }
	    return ans;
	}
	
	boolean hasRepeat(int d, char[] cs){
	    int i = 1, last = cs.length;
	    if(d == 0){
	        i = 2;
	    }
	    if(d == last-1){
	        last = last-1;
	    }
	    for(; i < last; ++i){
	        if(i==d){
	            if(cs[i-1] == cs[i+1])
	                return true;
	        } else if (i-1==d) {
	            if(cs[i-2] == cs[i])
	                return true;
	        } else {
	            if(cs[i] == cs[i-1])
	                return true;
	        }
	    }
	    return false;
	}
	
	public void test() {
		int[] a = new int[] {1,2,3,4,5};
		String s = "abaac";
		System.out.println(minCost(s,a));
	}
}
