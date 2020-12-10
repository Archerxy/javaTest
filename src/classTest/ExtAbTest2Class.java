package classTest;

public class ExtAbTest2Class extends AbTestClass {
	public String name = "test2";

	public void sayHello() {
		System.out.println("test2 h");
	}

	@Override
	public void sayWorld() {
		System.out.println("test2 w");
	}
	
}