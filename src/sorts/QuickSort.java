package sorts;

public class QuickSort implements Sort {
	private int[] array;
	@Override
	public void sort(int array[]) {
		this.array = array;
		loop(0,array.length-1);
	}
	public void loop(int low,int high) {
		if(low < high) {
			int left = low, right = high;
			int key = array[low];
			while(left < right) {
				for(; left < right; right--) { 
					if(array[right] < key) {
						array[left] = array[right];
						break;
					}
				}
				for(; left < right; left++) {
					if(array[left]>key) {
						array[right] = array[left];
						break;
					}
				}
			}
			array[right] = key;
			loop(low,left - 1);
			loop(right + 1,high);
		}
	}
}
