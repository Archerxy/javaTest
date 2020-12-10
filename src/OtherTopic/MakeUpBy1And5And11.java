package OtherTopic;
public class MakeUpBy1And5And11 {
	int len = 65536;
	int[] map;
	public int makeUp(int n) {
		int l = Math.min(n, len);
		map = new int[l+1];
		map[0] = 0;
		for(int i = 1; i < l+1; ++i) {
			map[i] = map[i-1]+1;
			if(i >= 5)
				map[i] = Math.min(map[i-5]+1, map[i]);
			if(i >= 11)
				map[i] = Math.min(map[i-11]+1, map[i]);
		}
		if(n < len)
			return map[l];
		while((n-=len)>0)
			piece(n>len?len:n);
		return map[map.length-1];
	}
	
	void piece(int n) {
		int l = n%len==0?len:n%len, end = Math.min(11, l+1);
		int[] newMap = new int[l+1];
		newMap[0] = map[len];
		for(int i = 1; i < end; ++i) {
			newMap[i] = newMap[i-1]+1;
			if(i<5)
				newMap[i] = Math.min(newMap[i], map[len-5+i]+1);
			else 
				newMap[i] = Math.min(newMap[i], newMap[i-5]+1);
			newMap[i] = Math.min(newMap[i], map[len-11+i]+1);
		}
		for(int i = 11; i < l+1; ++i) {
			newMap[i] = Math.min(newMap[i-5]+1, newMap[i-1]+1);
			newMap[i] = Math.min(newMap[i-11]+1, newMap[i]);
		}
		map = newMap;
	}
	
	public void test() {
		System.out.println(makeUp(200000000));
	}
}
