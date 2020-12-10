package anotation;

@Config
public class ExtendsWithAnotation extends WithAnotation {
	
	public boolean isOk(String token) {
		return token.equals("123456");
	}
}
