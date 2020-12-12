package leetcode;

//https://leetcode-cn.com/problems/volume-of-histogram-lcci/

public class VolumeOfHistogram {
    private int[] height;
    
    public int trap(int[] height) {
    	if(height.length <= 2)
    		return 0;
    	this.height = height;
        int sum = 0;
        int start = 0, end = 0;
        for(int i = 0; i < height.length; ++i) {
        	if(height[start] < height[i]) {
        		start = i;
        		end = i;
        	}
        }
        while(start>0 || end < height.length-1){
            int h = findHighest(start,end);
            if(start > h) {
            	for(int i = h+1; i < start; ++i) {
            		sum += height[h]-height[i];
            	}
            	start = h;
            }
            if(end < h) {
            	for(int i = end+1; i < h; ++i) {
            		sum += height[h]-height[i];
            	}
            	end = h;
            }
        }
        return sum;
    }

    private int findHighest(int start, int end){
    	int p = -1, max = -1;
    	for(int i = 0; i < start; ++i) {
    		if(max < height[i]) {
    			max = height[i];
    			p = i;
    		}
    	}
    	for(int i = end+1; i < height.length; ++i) {
    		if(max < height[i]) {
    			max = height[i];
    			p = i;
    		}
    	}
        return p;
    }
    
    public void test() {
//    	int[] a = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
    	int[] a = new int[] {4,2,3};
    	System.out.println(trap(a));
    }
}
