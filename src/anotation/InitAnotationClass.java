package anotation;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class InitAnotationClass {
	static Set<Class<?>> configClazzs = new HashSet<>();
	static List<WithAnotation> filters = new LinkedList<>();
	
	public static <T extends WithAnotation> void isOkComfirm(String token) {
		for(WithAnotation filter: filters) {
			if(!filter.isOk(token)) {
				System.out.println("is not ok.");
				return ;
			}
		}
		System.out.println("is ok.");
	}
	
	@SuppressWarnings("unchecked")
	public static void initScannerClass() {
		List<Class<?>> clazzs = Scanner.getAllClassByPackageName("anotation");
		for(Class<?> clazz: clazzs) {
			if(isConfigClass(clazz))
				configClazzs.add(clazz);
			if(isExtendsToWithAn(clazz))
				try {
					filters.add(((Class<? extends WithAnotation>) clazz).newInstance());
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
		}
		if(filters.size() == 0)
			try {
				filters.add(WithAnotation.class.newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
	}
	
	public static boolean isConfigClass(Class<?> clazz){
		for(Annotation an: clazz.getAnnotations()) {
			if(an.annotationType().equals(Config.class))
				return true;
		}
		return false;
	}

	public static boolean isExtendsToWithAn(Class<?> clazz){
		Class<?> sup = clazz.getSuperclass();
		if(sup != null && sup.equals(WithAnotation.class))
			return true;
		return false;
	}
	
	public static void test() {
		initScannerClass();
		isOkComfirm("12345");
	}
}
