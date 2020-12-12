package classTest;

import java.lang.reflect.Field;

public abstract class AbTestClass {
	public abstract void sayHello();
	public abstract void sayWorld();
	
	public void say() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = this.getClass().getDeclaredField("name");
		System.out.println((String)field.get(this));
	}
}
