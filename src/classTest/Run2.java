package classTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Run2 implements Runnable {
	Run run;
	public Run2(Run run) {
		this.run = run;
	}
	
	@Override
	public void run() {
		Method m;
		try {
			m = run.getClass().getDeclaredMethod("run2");
			m.invoke(run, null);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
