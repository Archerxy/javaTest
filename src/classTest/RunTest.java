package classTest;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map.Entry;

public class RunTest {
	static Queue<String> strQueue;
	
	static {
		strQueue = new ConcurrentLinkedQueue<>();
		strQueue.add("as");
	}
	
	public static String[] getList() {
		String[] strArr = new String[strQueue.size()];
		strQueue.toArray(strArr);
		return strArr;
	}
}
