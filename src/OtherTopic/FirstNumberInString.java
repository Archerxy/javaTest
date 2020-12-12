package OtherTopic;

public class FirstNumberInString {
	public int numberInString(String s) throws Exception {
		StringBuilder sb = new StringBuilder();
		for(char c: s.toCharArray()) {
			if(((int)'0' > (int)c || (int)'9' < (int)c) && sb.length() > 0) {
				if(sb.toString().equals("-"))
					sb.deleteCharAt(0);
				else 
					break;
			}
			if(((int)'0' <= (int)c && (int)'9' >= (int)c)||c=='-')
				sb.append(c);
		}
		String ans = sb.toString();
		if(ans.compareTo("2147483648") > 0 || ans.compareTo("-2147483648") > 0)
			throw new Exception("Number out of Integer");
		return Integer.parseInt(ans);
	}

	//²âÊÔµ¥Ôª
	public void test() {
		String s = "a--2147483649c3";
		try {
			System.out.println(numberInString(s));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
