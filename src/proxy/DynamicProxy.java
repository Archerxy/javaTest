package proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import net.sf.cglib.proxy.Enhancer;

public class DynamicProxy {
	public Object invoke(Object target,String methodName, Object...args) 
			throws NoSuchMethodException, SecurityException,
				   IllegalAccessException, IllegalArgumentException, 
				   InvocationTargetException {
		
		Object targetProxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new LogInvocationHandler(target));
		Method method = targetProxy.getClass().getDeclaredMethod(methodName);
		method.setAccessible(true);
		return method.invoke(targetProxy, args);
	}
	
	public Object cgLibInvoke(Object target, String methodName, Object...args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Enhancer en = new Enhancer();
		en.setSuperclass(target.getClass());
		en.setCallback(new LogMethodInterceptor());
		Object targetProxy = en.create();
		Method method = targetProxy.getClass().getDeclaredMethod(methodName);
		return method.invoke(targetProxy, args);
	}
}
