package OtherTopic;

import java.util.*;
public class LargestStringNumber {
    public static void solution(){
        Scanner reader = new Scanner(System.in);
        String s = reader.next();
        reader.close();
        String[] sArr = s.split(",");

        Arrays.sort(sArr, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1+o2;
				String s2 = o2+o1;
				return s2.compareTo(s1);
			}
        });
        
        System.out.println(Arrays.toString(sArr));
    }
}

// 9899,99998,899999,99,999
// 1324,4321,2341,4123
// 99,899,9899,99899,999899,9999899