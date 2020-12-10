package leetcode;

public class EatApples3 {
	int len = 65536;
	int[] map;
    
    public int minDays(int n) {
		int l = Math.min(n, len);
		map = new int[l+1];
		map[0] = 0;
		for(int i = 1; i < l+1; ++i) {
			map[i] = map[i-1]+1;
			if(i%2==0)
				map[i] = Math.min(map[i/2]+1, map[i]);
			if(i%3==0)
				map[i] = Math.min(map[i/3]+1, map[i]);
		}
		if(n < len)
			return map[l];
		while((n-=len)>0)
			piece(n>len?len:n);
		return 0;
    }

	void piece(int n) {
		int l = n%len==0?len:n%len;
		int[] newMap = new int[l+1];
		newMap[0] = map[len];
		for(int i = 1; i < l+1; ++i) {
			newMap[i] = newMap[i-1]+1;
			newMap[i] = Math.min(newMap[i-11]+1, newMap[i]);
		}
		map = newMap;
	}
    
    public void test() {
    	int res = minDays(9);
    	System.out.println(res);
    }

}
