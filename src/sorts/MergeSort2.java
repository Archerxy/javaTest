package sorts;

public class MergeSort2 implements Sort{
	private int[] array;
	private int[] temp;
	public void sort(int []array){
	    this.temp = new int[array.length];
	    this.array = array;
	    sort(0,array.length-1);
	}
	private void sort(int left,int right){
	    if(left<right){
	        int mid = (left+right)/2;
	        sort(left,mid);
	        sort(mid+1,right);
	        merge(left,mid,right);
	    }
	}
	private void merge(int left,int mid,int right){
	    int i = left;//左序列指针
	    int j = mid+1;//右序列指针
	    int t = 0;//临时数组指针
	    while (i<=mid && j<=right){
	        if(array[i]<=array[j]){
	            temp[t++] = array[i++];
	        }else {
	            temp[t++] = array[j++];
	        }
	    }
	    while(i<=mid){//将左边剩余元素填充进temp中
	        temp[t++] = array[i++];
	    }
	    while(j<=right){//将右序列剩余元素填充进temp中
	        temp[t++] = array[j++];
	    }
	    t = 0;
	    //将temp中的元素全部拷贝到原数组中
	    while(left <= right){
	        array[left++] = temp[t++];
	    }
	}
}
