package sorts;

public class HeapSort {
	public void sort(int[] list) {
	    for(int i = (list.length)/2 - 1; i >= 0; --i)
	    	adjustHead(list, list.length, i);
	    for(int i = list.length - 1; i >= 1; --i) {
	        list[0] = list[i]^list[0];
	        list[i] = list[i]^list[0];
	        list[0] = list[i]^list[0];
	        adjustHead(list, i, 0);
	    }
	}
	void adjustHead(int[] list, int len, int i) {
	    int parent = i,tmp = list[i], child = 2*i+1;
	    while (child < len) {
	        if (child + 1 < len && list[child] < list[child+1])
	            ++child;
	        if (list[child] > tmp) {
	            list[parent] = list[child];
	            parent = child;
	            child = 2*child+1;
	        } else
	            break;
	    }
	    list[parent] = tmp;
	}
}
