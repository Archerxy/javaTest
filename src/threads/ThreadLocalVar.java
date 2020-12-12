package threads;

import java.util.PriorityQueue;

public class ThreadLocalVar {
	public static PriorityQueue<Integer> queue = new PriorityQueue<>();
	
	public static ThreadLocal<Integer> localVar = new ThreadLocal<>();
}
