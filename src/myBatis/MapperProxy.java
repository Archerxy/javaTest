package myBatis;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class MapperProxy<T> implements InvocationHandler, Serializable {
	 
	  private static final long serialVersionUID = -6424540398559729838L;
	  private final SqlSession sqlSession;
	  private final Class<T> mapperInterface;
	  private final Map<Method, MapperMethod> methodCache;
	 
	  public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface, Map<Method, MapperMethod> methodCache) {
	    this.sqlSession = sqlSession;
	    this.mapperInterface = mapperInterface;
	    this.methodCache = methodCache;
	  }
	 
	  @Override
	  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	    try {
	      if (Object.class.equals(method.getDeclaringClass())) {
	        return method.invoke(this, args);
	      } else if (isDefaultMethod(method)) {
	        return invokeDefaultMethod(proxy, method, args);
	      }
	    } catch (Throwable t) {
	      throw t;
	    }
	    final MapperMethod mapperMethod = cachedMapperMethod(method);
	    return mapperMethod.execute(sqlSession, args);
	  }
	 
	  private MapperMethod cachedMapperMethod(Method method) {
	    return methodCache.computeIfAbsent(method, k -> new MapperMethod(mapperInterface, method, sqlSession.getConfiguration()));
	  }
	 
	  private Object invokeDefaultMethod(Object proxy, Method method, Object[] args)
	      throws Throwable {
	    final Constructor<MethodHandles.Lookup> constructor = MethodHandles.Lookup.class
	        .getDeclaredConstructor(Class.class, int.class);
	    if (!constructor.isAccessible()) {
	      constructor.setAccessible(true);
	    }
	    final Class<?> declaringClass = method.getDeclaringClass();
	    return constructor
	        .newInstance(declaringClass,
	            MethodHandles.Lookup.PRIVATE | MethodHandles.Lookup.PROTECTED
	                | MethodHandles.Lookup.PACKAGE | MethodHandles.Lookup.PUBLIC)
	        .unreflectSpecial(method, declaringClass).bindTo(proxy).invokeWithArguments(args);
	  }
	 
	  private boolean isDefaultMethod(Method method) {
	    return (method.getModifiers()
	        & (Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC)) == Modifier.PUBLIC
	        && method.getDeclaringClass().isInterface();
	  }
}
