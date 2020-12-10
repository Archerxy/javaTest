package leetcode;

public class Game24Point {
	private int[] nums;
	private int[][] numsOrder;
    public boolean judgePoint24(int[] nums) {
        this.nums = nums;
        this.numsOrder = new int[][] {{0,1,2,3},{0,1,3,2},{0,2,1,3},{0,2,3,1},{0,3,1,2},{0,3,2,1},
        							  {1,0,2,3},{1,0,3,2},{1,2,0,3},{1,2,3,0},{1,3,0,2},{1,3,2,0},
        							  {2,1,0,3},{2,1,3,0},{2,0,1,3},{2,0,3,1},{2,3,1,0},{2,3,0,1},
        							  {3,1,2,0},{3,1,0,2},{3,2,1,0},{3,2,0,1},{3,0,1,2},{3,0,2,1}};
        
        return addLast()||subLast()||mulLast()||devidedLast();
    }
    
    private boolean addLast() {
    	for(int i = 0; i <= 12; i++) {
    		for(int[] p: numsOrder) {
        		if(canGet2(i,24-i,p)||canGet3(i,24-i,p)) return true;
    		}
    	}
    	return false;
    }
    
    private boolean subLast() {
    	for(int i = 81; i > 24;) {
    		for(int[] p: numsOrder) {
        		if(canGet2(i,i-24,p)||canGet3(i,i-24,p)) return true;
    		}
    		if(i == 81) i = 72;
    		else if(i == 72) i = 64;
    		else --i;
    	}
    	return false;
    }
    
    private boolean mulLast() {
		for(int[] p: numsOrder) {
    		if(canGet2(5,24f/5f,p)||canGet3(5f,24f/5f,p)) return true;
    		if(canGet2(7,24f/7f,p)||canGet3(7,24f/7f,p)) return true;
    		if(canGet2(9,8f/3f,p)||canGet3(9,8f/3f,p)) return true;
    		if(canGet2(15,8f/5f,p)) return true;
    		if(canGet2(16,3f/2f,p)) return true;
    		if(canGet2(18,4f/3f,p)) return true;
    		if(canGet2(1,24,p)||canGet3(1,24,p)) return true;
    		if(canGet2(2,12,p)||canGet3(2,12,p)) return true;
    		if(canGet2(3,8,p)||canGet3(3,8,p)) return true;
    		if(canGet2(4,6,p)||canGet3(4,6,p)) return true;
    		if(canGet2(24,1,p)||canGet3(24,1,p)) return true;
    		if(canGet2(12,2,p)||canGet3(12,2,p)) return true;
    		if(canGet2(8,3,p)||canGet3(8,3,p)) return true;
    		if(canGet2(6,4,p)||canGet3(6,4,p)) return true;
		}
    	return false;
    }
    
    private boolean devidedLast() {
		for(int[] p: numsOrder) {
    		if(canGet2(1,1f/24f,p)||canGet3(1,1f/24f,p)) return true;
    		if(canGet2(2,1f/12f,p)||canGet3(2,1f/12f,p)) return true;
    		if(canGet2(3,1f/8f,p)||canGet3(3,1f/8f,p)) return true;
    		if(canGet2(4,1f/6f,p)||canGet3(4,1f/6f,p)) return true;
    		if(canGet2(5,5f/24f,p)||canGet3(5,5f/24f,p)) return true;
    		if(canGet2(6,1f/4f,p)||canGet3(6,1f/4f,p)) return true;
    		if(canGet2(7,7f/24f,p)||canGet3(7,7f/24f,p)) return true;
    		if(canGet2(8,1f/3f,p)||canGet3(8,1f/3f,p)) return true;
    		if(canGet2(9,3f/8f,p)||canGet3(9,3f/8f,p)) return true;
    		if(canGet2(12,1f/2f,p)) return true;
    		if(canGet2(15,5f/8f,p)) return true;
    		if(canGet2(16,2f/3f,p)) return true;
    		if(canGet2(18,3f/4f,p)) return true;
    		if(canGet2(2,48,p)||canGet3(2,48,p)) return true;
    		if(canGet2(3,72,p)||canGet3(3,72,p)) return true;
		}
    	return false;
    }
    
    private boolean canGet2(float num1, float num2, int[] p) {
    	if(Math.round(100*((float)(nums[p[0]])+(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])+(float)(nums[p[3]])-num2))==0) return true;
    	if(Math.round(100*((float)(nums[p[0]])+(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])-(float)(nums[p[3]])-num2))==0) return true;
    	if(Math.round(100*((float)(nums[p[0]])+(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])*(float)(nums[p[3]])-num2))==0) return true;
    	if(Math.round(100*((float)(nums[p[0]])+(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])/(float)(nums[p[3]])-num2))==0) return true;
    	if(Math.round(100*((float)(nums[p[0]])-(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])+(float)(nums[p[3]])-num2))==0) return true;
    	if(Math.round(100*((float)(nums[p[0]])-(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])-(float)(nums[p[3]])-num2))==0) return true;
    	if(Math.round(100*((float)(nums[p[0]])-(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])*(float)(nums[p[3]])-num2))==0) return true;
    	if(Math.round(100*((float)(nums[p[0]])-(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])/(float)(nums[p[3]])-num2))==0) return true;
    	if(Math.round(100*((float)(nums[p[0]])*(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])+(float)(nums[p[3]])-num2))==0) return true;
    	if(Math.round(100*((float)(nums[p[0]])*(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])-(float)(nums[p[3]])-num2))==0) return true;
    	if(Math.round(100*((float)(nums[p[0]])*(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])*(float)(nums[p[3]])-num2))==0) return true;
    	if(Math.round(100*((float)(nums[p[0]])*(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])/(float)(nums[p[3]])-num2))==0) return true;
    	if(Math.round(100*((float)(nums[p[0]])/(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])+(float)(nums[p[3]])-num2))==0) return true;
    	if(Math.round(100*((float)(nums[p[0]])/(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])-(float)(nums[p[3]])-num2))==0) return true;
    	if(Math.round(100*((float)(nums[p[0]])/(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])*(float)(nums[p[3]])-num2))==0) return true;
    	if(Math.round(100*((float)(nums[p[0]])/(float)(nums[p[1]])-num1))==0&&Math.round(100*((float)(nums[p[2]])/(float)(nums[p[3]])-num2))==0) return true;
    	return false;
    }

    private boolean canGet3(float num1, float num2, int[] p) {
    	if(Math.round(100*((float)(nums[p[0]])-num1))==0&&genBy3(num2,p)) return true;
    	return false;
    }
    
    private boolean genBy3(float num, int[] p) {
    	if(Math.round(100*((float)(nums[p[1]])+(float)(nums[p[2]])+(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])+(float)(nums[p[2]])-(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])+(float)(nums[p[2]])*(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*(((float)(nums[p[1]])+(float)(nums[p[2]]))*(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])+(float)(nums[p[2]])/(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*(((float)(nums[p[1]])+(float)(nums[p[2]]))/(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])-(float)(nums[p[2]])+(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])-(float)(nums[p[2]])-(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])-(float)(nums[p[2]])*(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*(((float)(nums[p[1]])-(float)(nums[p[2]]))*(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])-(float)(nums[p[2]])/(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*(((float)(nums[p[1]])-(float)(nums[p[2]]))/(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])*(float)(nums[p[2]])+(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])*((float)(nums[p[2]])+(float)(nums[p[3]]))-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])*(float)(nums[p[2]])-(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])*((float)(nums[p[2]])-(float)(nums[p[3]]))-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])*(float)(nums[p[2]])*(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])*(float)(nums[p[2]])/(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])*((float)(nums[p[2]])/(float)(nums[p[3]]))-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])/(float)(nums[p[2]])+(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])/((float)(nums[p[2]])+(float)(nums[p[3]]))-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])/(float)(nums[p[2]])-(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])/((float)(nums[p[2]])-(float)(nums[p[3]]))-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])/(float)(nums[p[2]])*(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])/((float)(nums[p[2]])*(float)(nums[p[3]]))-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])/(float)(nums[p[2]])/(float)(nums[p[3]])-num))==0) return true;
    	if(Math.round(100*((float)(nums[p[1]])/((float)(nums[p[2]])/(float)(nums[p[3]]))-num))==0) return true;
    	return false;
    }
    
    public void test() {
    	int[] a = new int[] {8,3,8,3};
    	System.out.print(judgePoint24(a));
    }
}
