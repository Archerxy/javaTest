package OtherTopic;

import java.util.Scanner;

public class PlansForPlace {
    public static void done(){
        Scanner reader = new Scanner(System.in);
        reader.useDelimiter("\n");
        String[] l1 = reader.next().trim().split(" ");
        int N = Integer.valueOf(l1[0]);
        int D = Integer.valueOf(l1[1]);
        String[] l2 = reader.next().trim().split(" ");
        reader.close();
        long[] Ns = new long[N];
        for(int i = 0; i < l2.length; ++i){
            Ns[i] = Long.valueOf(l2[i]);
        }
        long ans = 0l;
        int s = 0;
        while(s < N-2){
        	int p = dicco(Ns,D,s,s,N-1);
            ans += (p-s)*(p-s-1)/2;
            ++s;
        }
        System.out.println(ans%99997867);
    }
    
    private static int dicco(long[] l, int D,int S, int s, int e) {
    	if(s >= e-1) {
    		if(l[e] - l[S] > D)
    			return s;
    		return e;
    	}
    	if(l[(s+e)/2] - l[S] < D) {
    		return dicco(l,D,S,(s+e)/2,e);
    	} else {
    		return dicco(l,D,S,s,(s+e)/2);
    	}
    }
}
