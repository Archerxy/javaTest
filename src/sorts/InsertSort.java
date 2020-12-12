package sorts;

public class InsertSort implements Sort {
	@Override
	public void sort(int[] array) {
		int length = array.length;
		for(int i = 1; i < length; i++) {
			for(int j = i; j > 0; j--) {
				if(array[j]<array[j-1]) {
					int tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
				}else break;
			}
		}
	}

}
