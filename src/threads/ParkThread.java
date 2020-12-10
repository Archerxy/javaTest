package threads;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ParkThread implements Runnable {
	static PriorityQueue<Date> queue = new PriorityQueue<>();
	static AtomicInteger ai = new AtomicInteger(0);
	
	static Thread curThread;
	
	@Override
	public void run() {
		curThread = Thread.currentThread();
		while(true) {
			if(ai.get() <= 0) {
				LockSupport.park();
			}
			List<Date> times = new LinkedList<>();
			Date now = new Date();
			synchronized(queue) {
				while(queue.peek() != null && queue.peek().before(now))
					times.add(queue.poll());
			}
			if(times.size() <= 0) {
				synchronized(queue) {
					if(queue.size() > 0) {
						long wait = queue.peek().getTime()-now.getTime();
						LockSupport.parkNanos(wait-1);
					}
				}
				continue;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			for(Date d: times) {
				System.out.println("now is:"+sdf.format(d));
			}
		}
	}
	
	public static void addDate(Date d) {
		synchronized(queue) {
			queue.add(d);
		}
		ai.incrementAndGet();
		LockSupport.unpark(curThread);
	}
}
