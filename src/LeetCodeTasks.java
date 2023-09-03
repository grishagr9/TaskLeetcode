import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.util.regex.Pattern;

public class LeetCodeTasks {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=list&envId=r6k4xxd2
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 1; i <prices.length; i++) {
            if(prices[i]<min)
                min = prices[i];
            if(prices[i]-min>max)
                max = prices[i]-min;
        }
        return max;
    }
    //https://leetcode.com/problems/pascals-triangle/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        res.add(cur);
        for (int i = 1; i < numRows; i++) {
            cur = new ArrayList<>();
            var listcur = res.get(i-1);
            cur.add(1);
            for (int j = 1; j <listcur.size(); j++) {
                cur.add(listcur.get(j-1)+listcur.get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
    //https://leetcode.com/problems/pascals-triangle-ii/
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 0; i <rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j <res.size(); j++) {
                cur.add(res.get(j-1)+res.get(j));
            }
            cur.add(1);
            res = cur;
        }
        return res;
    }
    //https://leetcode.com/problems/three-divisors/
    public boolean isThree(int n) {
        var sqr = Math.sqrt(n);
        for (int i = 2; i <sqr; i++) {
            if(sqr%i==0)
                return false;
        }
        return sqr%1==0;
    }
    //https://leetcode.com/problems/counting-bits/description/?envType=daily-question&envId=2023-09-01
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i]= (int)Arrays.stream(Integer.toBinaryString(i).split("")).filter(x-> Objects.equals(x, "1")).count();
        }
        return ans;
    }
    int countOne(int a){
        var array = Integer.toBinaryString(a).toCharArray();
        Character[] ar = new Character[array.length];
        for (int i = 0; i <ar.length; i++) {
            ar[i]=array[i];
        }
        return (int)Arrays.stream(ar).filter(x->x=='1').count();
    }
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int counter = 0;
        int result = -1;
        char[] array = s.toCharArray();
        for (int i = 0; i <s.length(); i++) {
            if(hashMap.containsKey(array[i]))
            {
                int ind = hashMap.get(array[i]);
                if(counter>result)
                    result = counter;
                hashMap.put(array[i],i);
                counter = i-ind;
            }else{
                hashMap.put(array[i],i);
                counter++;
            }
        }
        return Math.max(counter, result);
    }
    public int maxProfit2(int[] prices) {
        boolean haveAct = false;
        int sum = 0;
        int prev = prices[0];
        for (int i = 1; i <prices.length; i++) {

        }
        return sum;
    }
    public int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i <nums.length; i++) {
            if(hashSet.contains(nums[i]))
                hashSet.remove(nums[i]);
            else
                hashSet.add(nums[i]);
        }
        return (int)hashSet.toArray()[0];
    }
    public boolean isN(char c){
        return Character.isAlphabetic(c)||Character.isDigit(c);
    }
    public boolean isPalindrome(String s) {
        int end = s.length()-1;
        for (int start = 0; start <s.length(); start++) {
            char b1 = s.charAt(start);
            char b2 = s.charAt(end);
            while (start<s.length() && !isN(s.charAt(start))){
                start++;
            }
            while (end>=0 && !isN(s.charAt(end))){
                end--;
            }
            if(start>=s.length()||end<0)
                break;
            if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end)))
                return false;
            else {
                end--;
            }
        }
        return true;
    }
    public static void test(String s){
        for (int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c + " " +Character.isAlphabetic(c));
        }
    }
    public static void main(String[] args) {
        LeetCodeTasks leetCodeTasks = new LeetCodeTasks();
        System.out.println(leetCodeTasks.isPalindrome(
                "A man, a plan, a canal: Panama"));
    }
}
