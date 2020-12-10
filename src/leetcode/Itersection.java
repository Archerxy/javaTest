package leetcode;

public class Itersection {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        //(x1-x2)*y + x2*y1 = (y1-y2)*x + x1*Y2
        // y = a1*x+b1
        // y = a2*x+b2
    	double[] s1 = new double[] {start1[0],start1[1]};
    	double[] e1 = new double[] {end1[0],end1[1]};
    	double[] s2 = new double[] {start2[0],start2[1]};
    	double[] e2 = new double[] {end2[0],end2[1]};
    	int x = 0, y = 1;
        double a1 = (e1[y]-s1[y])/(e1[x]-s1[x]);
        double a2 = (e2[y]-s2[y])/(e2[x]-s2[x]);
        if(Double.isInfinite(a1)&&Double.isInfinite(a2)) {
        	if(Double.compare(s1[x], s2[x]) == 0) {
        		double[] min1;
        		if(Double.compare(s1[y], e1[y]) < 0) {
        			min1 = s1;
        		}else {
        			min1 = e1;
        		}
        		double[] min2;
        		if(Double.compare(s2[y], e2[y]) < 0) {
        			min2 = s2;
        		}else {
        			min2 = e2;
        		}
        		if(Double.compare(min1[y], min2[y]) < 0) {
        			return min1;
        		}else {
        			return min2;
        		}
        	}else {
        		return new double[] {};
        	}
        }else {
        	if(Double.compare(a1, a2) == 0) {
        		
        	}
        }
        
        return new double[] {};
    }
}
