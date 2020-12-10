package proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class LogMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object proxy, Method method, Object[] arg2, MethodProxy proxyMethod) throws Throwable {
		System.out.println("cglib代理前");
		Object res = proxyMethod.invokeSuper(proxy, arg2);
		System.out.println("cglib代理后");
		return res;
	}

}
