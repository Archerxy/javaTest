package leetcode;


//leetcode  https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
public class LargestRectangle {
	private int[] heights;
	private int[] a;  //sorted array
    public int largestRectangleArea(int[] heights) {
    	if(heights.length == 0) return 0;
    	
    	this.heights = heights;
    	sort(heights);
    	int s = a[0]*heights.length;
    	for(int i = 1; i < a.length; i++) {
    		if(a[i] == a[i-1]) {
    			continue;
    		}
    		int maxContinuePiece = maxContinuous(a[i]);
    		if(s < maxContinuePiece*a[i]) {
    			s = maxContinuePiece*a[i];
    		}
    	}
    	return s;
    }
    
    private int maxContinuous(int minHeight) {
    	int begin = 0,end = 0,count = 1;
    	boolean beginFlag = false;
    	for(int i = 0; i < heights.length; i++) {
    		if(heights[i] >= minHeight) {
    			if(!beginFlag) {
    				begin = i;
    				beginFlag = true;
    			}
    			end = i;
    		} else {
    			if(count < end-begin+1) {
    				count = end-begin+1;
    			}
    			begin = i;
    			end = i;
    			beginFlag = false;
    		}
    		if(i == heights.length - 1) {
    			if(count < end-begin+1) {
    				count = end-begin+1;
    			}
    		}
    	}
    	return count;
    }
    private void sort(int[] arr) {
		a = new int[arr.length];
		
		int[] h = new int[arr.length];
		int[] barrel0 = new int[256],barrel1 = new int[256],barrel2 = new int[256],barrel3 = new int[256];
		for (int i = 0; i < arr.length; i++)
		{	
			a[i] = arr[i];
	    	++barrel0[a[i]&0b11111111];
	    	++barrel1[(a[i]>>8)&0b11111111];
	    	++barrel2[(a[i]>>16)&0b11111111];
	    	++barrel3[a[i]>>24];
		}
		for(int i = 1; i < 256; i++) {
			barrel0[i] += barrel0[i-1];
			barrel1[i] += barrel1[i-1];
			barrel2[i] += barrel2[i-1];
			barrel3[i] += barrel3[i-1];
		}
		for(int i = a.length-1; i >= 0; i--) {
			h[--barrel0[a[i]&0b11111111]] = a[i];
		}
		for(int i = a.length-1; i >= 0; i--) {
			a[--barrel1[(h[i]>>8)&0b11111111]] = h[i];
		}
		for(int i = a.length-1; i >= 0; i--) {
			h[--barrel2[(a[i]>>16)&0b11111111]] = a[i];
		}
		for(int i = a.length-1; i >= 0; i--) {
			a[--barrel3[h[i]>>24]] = h[i];
		}
	}
    
    public void test() {
    	int[] a = new int[] {1,2,2};
    	System.out.println(largestRectangleArea(a));
    }
}
