package threads;

import java.util.PriorityQueue;

public class TaskLength implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 100; ++i) {
			if(i%5==0) {
				System.out.println("len first is: "+ThreadLocalVar.queue.peek());
//				System.out.println("local is: "+ThreadLocalVar.localVar.get());
//				synchronized(ThreadLocalVar.queue) {
//					System.out.println("len first is: "+ThreadLocalVar.queue.peek());
//				}
			}
		}
	}

}
