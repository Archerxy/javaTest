package classTest;

import java.util.concurrent.Semaphore;

public class Run {
	volatile int n = 10;
	Semaphore a = new Semaphore(2);
	public void run1() throws InterruptedException {
		while((n--)>0) {
			a.acquire();
			if(n%2==0)
				System.out.println("run1");
			a.release();
			int i = 1000;
			while((i--)>0) {}
		}
	}

	public void run2() throws InterruptedException {
		while((n--)>0) {
			a.acquire();
			if(n%2==1)
				System.out.println("run2");
			a.release();
			int i = 1000;
			while((i--)>0) {}
		}
	}
}
