package threads;

public class Enter {
	public void test() {
		Thread pa = new Thread(new ParkThread());
		pa.start();
		
		for(int i = 0; i < 100; ++i) {
			(new Thread(new Task())).start();
		}
	}
}
