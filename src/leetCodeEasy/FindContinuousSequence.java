package leetCodeEasy;

import java.util.ArrayList;

public class FindContinuousSequence {
    public int[][] findContinuousSequence2(int N) {
        //m�� ����Ϊx ��Ϊ1 �Ȳ����к�ΪN, (x + x + m - 1)*m/2 = N
        //���� (2x + m - 1)*m = 2*N
        //���� x = (2 * N + m * (1 - m))/(2 * m) > 0, xΪ������
    	ArrayList<int[]> res = new ArrayList<>();
        for (int m = 1; 2*N-m*m+m>0; m++) {
            int remainder = (2*N-m*m+m)%(2*m);
            if (remainder == 0 && m != 1) {//we r not adding the single N
                int[] arr = new int[m];
                arr[0] = (2 * N + m * (1 - m))/(2 * m);//�������
                for(int i = 1; i < m; i++) arr[i] = arr[i-1] + 1;
                res.add(0,arr);//ͷ������
            }
        }
        return res.toArray(new int[0][]);
    }
}
