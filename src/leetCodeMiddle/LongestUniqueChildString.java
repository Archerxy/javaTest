package leetCodeMiddle;

//https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/

public class LongestUniqueChildString {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.isEmpty())
            return 0;
        char[] cs = s.toCharArray();
        int[] cMap = new int[256];
        int l = 0, r = 0;
        int ans = 0;
        while(r < cs.length){
            if(cMap[cs[r]] <= l)
                ans = Math.max(r-l+1,ans);
            else 
                l = cMap[cs[r]];
            cMap[cs[r]] = r+1;
            ++r;
        }
        return ans;
    }
    public void test() {
    	String a = "abbca";
    	System.out.println(lengthOfLongestSubstring(a));
    }
}
