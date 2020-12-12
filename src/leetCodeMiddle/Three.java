package leetCodeMiddle;
import java.util.*;

public class Three {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long,Integer> map1 = new HashMap<>(nums1.length*(nums1.length-1)/2);
        Map<Long,Integer> map2 = new HashMap<>(nums2.length*(nums2.length-1)/2);
        for(int j = 0; j < nums2.length-1; ++j){
            for(int k = j+1; k < nums2.length; ++k){
                long n2 = (long)nums2[j]*(long)nums2[k];
                map2.put(n2,map2.getOrDefault(n2,0)+1);
            }
        }
        for(int j = 0; j < nums1.length-1; ++j){
            for(int k = j+1; k < nums1.length; ++k){
                long n1 = (long)nums1[j]*(long)nums1[k];
                map1.put(n1,map1.getOrDefault(n1,0)+1);
            }
        }
        int ans= 0 ;
        for(int i = 0; i < nums1.length; ++i){
        	long n1 = (long)nums1[i]*(long)nums1[i];
            ans += map2.getOrDefault(n1,0);
        }
        for(int i = 0; i < nums2.length; ++i){
        	long n2 = (long)nums2[i]*(long)nums2[i];
            ans += map1.getOrDefault(n2,0);
        }
        return ans;
    }
    
    public void test() {
    	int[] a1 = new int[] {7,4};
    	int[] a2 = new int[] {5,2,8,9};
    	System.out.println(numTriplets(a1,a2));
    }

}
