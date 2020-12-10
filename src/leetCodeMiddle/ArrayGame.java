package leetCodeMiddle;

import java.util.*;

public class ArrayGame {
    public int getWinner(int[] arr, int k) {
        int[] tmp = new int[arr.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ptr = 1;;++ptr){
            if(ptr >= arr.length){
                ptr = 1;
                int head = arr[0];
                arr = tmp;
                arr[0] = head;
            }
            if(arr[0] > arr[ptr]){
                tmp[ptr] = arr[ptr];
            } else {
                tmp[ptr] = arr[0];
                arr[0] = arr[ptr];
            }
            int count = map.getOrDefault(arr[0],0)+1;
            if(count >= k)
                return arr[0];
            map.put(arr[0],count);
        }
    }
    
    public void test () {
    	int[] a = new int[] {1,11,22,33,44,55,66,77,88,99};
    	System.out.println(getWinner(a,1000000000));
    }
}
