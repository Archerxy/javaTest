package sorts;

public class ShellSort implements Sort {
	private int length;
	@Override
	public void sort(int[] array) {
		this.length = array.length;
		int[] h_arr = generateH(this.length);
		int h_index = h_arr.length - 1;
		while(h_index >= 0) {
			int h = h_arr[h_index];
			for(int index = 0; index < h; index++) {
				for(int i = h + index; i < this.length; i = i + h) {
					for(int j = i; j >= h; j = j - h) {
						if(array[j] < array[j-h]) {
							array[j] = array[j]^array[j-h];
							array[j-h] = array[j]^array[j-h];
							array[j] = array[j]^array[j-h];
						}else break;
					}
				}
			}
			h_index--;
		}
	}
	
	private int[] generateH(int length) {
		int[] res = new int[(int)(Math.log(2*length+1)/Math.log(3))];//以3底的对数
		for(int i = 0; i < res.length; i++) {
			res[i] = (int)((Math.pow(3, i+1)-1)/2);
		}
		return res;
	}
}
