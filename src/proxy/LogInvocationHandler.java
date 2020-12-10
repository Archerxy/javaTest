package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler {
	private Object src;
	
	public LogInvocationHandler(Object src) {
		this.src = src;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			System.out.println("�������ǰ");
			Object val = method.invoke(src, args);
			System.out.println("������ú�");
			return val;
        } catch (InvocationTargetException e){
            e.printStackTrace();
        }
		return null;
	}
}
