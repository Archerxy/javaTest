package leetcode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import utils.File;

public class SparseSimilarity {

    public List<String> computeSimilarities(int[][] docs) {
    	for(int i = 0; i < docs.length; i++) {
    		Arrays.sort(docs[i]);
    	}
        List<String> list = new LinkedList<>();
        long cost1 = 0, cost2 = 0, cost3 = 0, b1, b2, b3 = System.currentTimeMillis();
        for(int i = 0; i < docs.length-1; i++){
            int[] line1 = docs[i];
            for(int j = i+1; j < docs.length; j++){
                int[] line2 = docs[j];
                b1 = System.currentTimeMillis();
                cost1 += (b1-b3);
                double n = rate(line1,line2);
                b2 = System.currentTimeMillis();
                cost2 += (b2-b1);
                if(Double.compare(n,0) > 0){
                	n = Math.round(n*10000)/10000d;
                    list.add(i+","+j+": "+(n+"000").substring(0,6));
                }
                b3 = System.currentTimeMillis();
                cost3 += (b3-b2);
            }
        }
        System.out.println(cost1+"    "+cost2+"    "+cost3);
        return list;
    }

	private double rate(int[] line1, int[] line2){
		int l1 = 0, l2 = 0;
		int coSet = 0, inSet = 0;
		while(l1 < line1.length && l2 < line2.length) {
			if(line1[l1] == line2[l2]) {
				coSet++;
				l1++;
				l2++;
				continue;
			} 
			if(line1[l1] < line2[l2]) {
				l1++;
				continue;
			}
			if(line1[l1] > line2[l2]) {
				l2++;
				continue;
			}
		}
		inSet = line1.length + line2.length - coSet;
		return (double)coSet/(double)inSet;
	}

    private double rate2(int[] line1, int[] line2){
        HashMap<Integer,Integer> map = new HashMap<>(500);
        for(int n: line1){
            map.put(n,1);
        }
        int merge = 0;
        for(int n: line2){
            if(map.containsKey(n))
                merge++;
            else 
                map.put(n,1);
        }
        return (double)merge/(double)map.size();
    }
    
    public void test() throws FileNotFoundException, IOException {
    	List<String> S = File.readFile("E:\\myProject\\javaProject\\ceshi1.txt");
    	int[][] a = new int[S.size()][];
    	for(int j = 0; j < S.size(); j++) {
    		String[] si = S.get(j).split(",");
    		int[] ai = new int[si.length];
    		for(int i = 0; i < si.length; i++) {
    			ai[i] = Integer.valueOf(si[i].trim());
    		}
    		a[j] = ai;
    	}
    	this.computeSimilarities(a);
    }
}
