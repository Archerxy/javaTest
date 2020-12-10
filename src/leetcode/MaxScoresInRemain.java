package leetcode;

public class MaxScoresInRemain {
	Integer[][] map;
    public int stoneGameV(int[] sv) {
        for(int i = 1; i < sv.length; ++i)
            sv[i] += sv[i-1];
        map = new Integer[sv.length][sv.length];
        return next(sv,0,sv.length-1, 0);
    }

    int next(int[] sum, int s, int e, int startV){
        if(s >= e)
            return 0;
        if(map[s][e] != null) return map[s][e];
        int max = Integer.MIN_VALUE;
        for(int i = s; i < e; ++i){
            int left = sum[i]-startV, right = sum[e]-sum[i];
            if(left < right){
                int nextV = next(sum, s, i,s>0?sum[s-1]:0);
                if(max < left+nextV)
                    max = left+nextV;
            } else if (left > right){
                int nextV = next(sum, i+1, e, sum[i]);
                if(max < right+nextV)
                    max = right+nextV;
            } else {
                int nextV = Math.max(next(sum,s,i,s>0?sum[s-1]:0),next(sum,i+1,e,sum[i]));
                if(max < left +nextV)
                    max = left+nextV;
            }
        }
        map[s][e] = max;
        return max;
    }
	
	
	public void test() {
		int[] a = new int[] {1,1,8,27,64,125,216,343,512,729,1000,1331,1728,2197,2744,3375,4096,4913,5832,
				6859,8000,9261,10648,12167,13824,15625,17576,19683,21952,24389,27000,29791,32768,35937,39304,
				42875,46656,50653,54872,59319,64000,68921,74088,79507,85184,91125,97336,103823,110592,117649,
				125000,132651,140608,148877,157464,166375,175616,185193,195112,205379,216000,226981,238328,
				250047,262144,274625,287496,300763,314432,328509,343000,357911,373248,389017,405224,421875,
				438976,456533,474552,493039,512000,531441,551368,571787,592704,614125,636056,658503,681472,
		        704969,729000,753571,778688,804357,830584,857375,884736,912673,941192,970299};
		long t1 = System.currentTimeMillis();
		System.out.println(stoneGameV(a));
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
	}
	
}
