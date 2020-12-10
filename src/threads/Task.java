package threads;

import java.util.Calendar;
import java.util.Date;
import java.util.PriorityQueue;

public class Task implements Runnable{
	@Override
	public void run() {
//		PriorityQueue<Integer> queue = ThreadLocalVar.queue;
//		synchronized(queue) {
//			ThreadLocalVar.localVar.set((int) Math.round(Math.random()*100000));
//			queue.add((int) Math.round(Math.random()*100000));
//		}
//		System.out.println("task first is: "+queue.peek());
		
		Calendar cal = Calendar.getInstance();
		for(int i = 0; i < 3; ++i) {
			cal.add(Calendar.SECOND, 10);
			ParkThread.addDate(cal.getTime());
		}
	}
}
