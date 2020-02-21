package sorts;

public class MergeSort implements Sort {	
	private int[] array;
	private int[] tmp;

	@Override
	public void sort(int[] array) {
		this.array = array;
		this.tmp = new int[array.length];
		for(int arrLen = 1; arrLen < array.length; arrLen = 2*arrLen) {
			divideArr(arrLen);
		}
	}

	private void divideArr(int arrLen){
		for(int i = 0; i < array.length ; i += 2*arrLen) {
			//最后剩余不足一个arrLen时放入后一个数组,放之前先做一次并归排序
			if(i+2*arrLen-1 < array.length && array.length - 1 <= i+3*arrLen-1) {
				merge(i+arrLen,i+2*arrLen-1,i+2*arrLen,array.length - 1);
				merge(i,i+arrLen-1,i+arrLen,array.length - 1);
				break;
			}else {
				if(i+2*arrLen-1 > array.length - 1) {
					merge(i,i+arrLen-1,i+arrLen,array.length - 1);
					break;
				}else {
					merge(i,i+arrLen-1,i+arrLen,i+2*arrLen-1);
				}
			}
		}
	}
	
	private void merge(int a1,int a2,int b1,int b2){
		int index = 0,begin = a1;
		while(a1<=a2 && b1<=b2) {
			if(array[a1] < array[b1]) {
				tmp[index++] = array[a1++];
			}else if(array[a1]==array[b1]) {
				tmp[index++] = array[a1++];
				tmp[index++] = array[b1++];
			}else if(array[a1]>array[b1]) {
				tmp[index++] = array[b1++];
			}
		}
		for(;a1<=a2;a1++) {
			tmp[index++] = array[a1];
		}
		for(;b1<=b2;b1++) {
			tmp[index++] = array[b1];
		}
		for(int i = 0; i < b2-begin+1; i++){
			array[i+begin]=tmp[i];
		}
	}
}

