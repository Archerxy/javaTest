package interview;
import java.util.*;

public class Interview {
	
	PriorityQueue<String> queue = new PriorityQueue<>();
	
	static Interview self;
	
	private Interview() {
		
	}
	
	public static Interview getSingleton() {
		synchronized(self) {
			if(self == null)
				self = new Interview();
		}
		return self;
	}
	
	void test2() {
		Date now = Calendar.getInstance().getTime();
//		LinkedList<Task> taskList = new LinkedList<>();
//		while(queue.peek().getTime().isAfter(now)) {
//			taslList.add(queue.poll());
//		}
	}
	
	public void task() {
//		int a = 9;
//		String s = "sajasj";
//		LinkedList<Integer> l = new LinkedList<>();
		
		String a1 = "as";
		String a2 = "as";
		System.out.println(a1==a2);
	}
	
	void firstUnrepeatedChar(String s) {
		char[] chars = s.toCharArray();
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i = 0; i < chars.length; ++i) {
			map.put(chars[i], map.getOrDefault(chars[i], 0)+1);
		}
		char theChar = ' ';
		int index = 0;
		for(int i = 0; i < chars.length; ++i) {
			if(map.getOrDefault(chars[i], 0) == 1) {
				theChar = chars[i];
				index = i;
				break;
			}
		}
//		Collections.synchronizedMap();
		synchronized(queue) {
			Thread.currentThread();
		}
		System.out.println(theChar+","+index);
	}
	
	void minDistanceToTheChar(String s, char theChar) {
		char[] chars = s.toCharArray();
		int[] charPlace = new int[chars.length];
		int lastIndex = 0;
		for(int i = 0; i < chars.length; ++i) {
			if(chars[i] == theChar) {
				charPlace[lastIndex] = i;
				++lastIndex;
			}
		}
		int[] ans = new int[chars.length];
		for(int i = 0; i < chars.length; ++i) {
			ans[i] = Math.abs(i-charPlace[0]);
			for(int j = 1; j < lastIndex; ++j) {
				ans[i] = Math.min(ans[i], Math.abs(i-charPlace[j]));
			}
		}
		System.out.println(Arrays.toString(ans));
	}
	
	public void test() {
		String s = "loveleetcode";
		char c = 'e';
//		firstUnrepeatedChar(s);
//		minDistanceToTheChar(s,c);
		task();
	}
}
