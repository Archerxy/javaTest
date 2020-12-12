package leetCodeMiddle;
import java.util.*;

public class StringInAllOrders {
    char[] cs;
    char[] str;
    LinkedList<String> ans = new LinkedList<>();

    public String[] permutation(String s) {
        cs = s.toCharArray();
        str = new char[s.length()];
        dfs(0);
        String[] res = new String[ans.size()];
        ans.toArray(res);
        return res;
    }

    private void dfs(int i) {
        if(i >= cs.length) {
            ans.add(String.valueOf(str));
            return;
        }
        boolean[] selected = new boolean[256]; //做过决策的
        for(int j = i; j < cs.length; ++j) {
            if(selected[cs[j]])
                continue;
            selected[cs[j]] = true;

            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;

            str[i] = cs[i];
            dfs(i+1);

            tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;
        }
    }
    
    public void test() {
    	String a = "abc";
    	System.out.println(Arrays.toString(permutation(a)));
    }
}
