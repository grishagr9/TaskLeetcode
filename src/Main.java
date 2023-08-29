import java.awt.List;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res = 0;
        int prev = 1001;
        var arr = s.toCharArray();
        for(int i = 0; i<arr.length; i++){
             int cur = map.get(arr[i]);
             if(cur>prev)
                 res+=cur-prev*2;
             else
                 res+=cur;
             prev = cur;
        }
        return res;
    }
    public static String longestCommonPrefix(String[] strs) {
        char[][] matrix = new char[strs.length][];
        for (int i = 0; i< strs.length; i++){
            matrix[i]=strs[i].toCharArray();
        }
        int count = 0;
        boolean f = true;
        while(f) {
            try {


                char c = matrix[0][count];
                for (int i = 0; i < strs.length; i++) {
                    char cur = matrix[i][count];
                    if (c != cur) {
                        f = false;
                        break;
                    }
                }
                if (!f)
                    break;
                count++;
            }catch (Exception e){
                break;
            }
        }
        if(count==0)
            return "";
        return strs[0].substring(0,count);
    }
    public static  boolean task(String s){

        Stack<Character> queue =  new Stack<>();
        char[] array = s.toCharArray();
        for (int i = 0; i< array.length;i++){
            if(array[i]=='(' || array[i]=='[' || array[i]=='{')
                queue.add(array[i]);
            else {
                if(queue.empty())
                    return false;
                if (array[i] == ')')
                    if(queue.peek() == '(')
                        queue.pop();
                    else
                        return false;
                if (array[i] == ']')
                    if(queue.peek() == '[')
                        queue.pop();
                    else
                        return false;
                if (array[i] == '}')
                    if(queue.peek() == '{')
                        queue.pop();
                    else
                        return false;
            }
        }
        return queue.empty();
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res;
        if(list1!=null && list2!=null) {
            if (list1.val < list2.val) {
                res = new ListNode(list1.val);
                list1 = list1.next;
            }
            else {
                res = new ListNode(list2.val);
                list2 = list2.next;
            }
        }
        else
            if(list1!=null) {
                res = new ListNode(list1.val);
                list1 = list1.next;
            }
            else
                if(list2!=null) {
                    res = new ListNode(list2.val);
                    list2 = list2.next;
                }
                else
                    res = null;
        ListNode res1 = res;
        while(list1!=null || list2!=null) {
            if(list1!=null && list2!=null) {
                if (list1.val < list2.val) {
                    res.next = new ListNode(list1.val);
                    res = res.next;
                    list1 = list1.next;
                } else {
                    res.next = new ListNode(list2.val);
                    res = res.next;
                    list2 = list2.next;
                }
            }
            else
                if(list1!=null) {
                    res.next = new ListNode(list1.val);
                    res = res.next;
                    list1 = list1.next;
                }
                    else{
                        res.next = new ListNode(list2.val);
                        res = res.next;
                        list2 = list2.next;
                    }
        }
        return res1;
    }
    public static void PrintList(ListNode p){
        while (p!=null){
            System.out.print(p.val+" ");
            p = p.next;
        }
    }
    public static int removeDuplicates(int[] nums) {
        int duplicateCount = 0;
        //[11111233]

        int tracker = 0;
        for (int x=1; x<nums.length; x++){
            if(nums[tracker] != nums[x]){
                tracker++;
                nums[tracker]=nums[x];
            } else{
                duplicateCount++;
            }
        }
        return nums.length-duplicateCount;
    }
    public static int[] plusOne(int[] digits) {
        int i = digits.length-1;
        while(true){
            if(digits[i]+1>9){
                digits[i]=0;
                i--;
            }
            else {
                digits[i]+= 1;
                break;
            }
            if(i<0){
                int[] res = new int[digits.length+1];
                res[0]=1;
                for(int j=0; j<digits.length;j++){
                    res[j+1]=digits[j];
                }
                return res;
            }
        }
        return digits;
    }
    public static int climbStairs(int n) {
        if(n==0||n==1)
            return 1;
        return climbStairs(n-2)+climbStairs(n-1);
    }
    public static int removeElement(int[] nums, int val) {
        int ind = nums.length-1;
        for(int i = 0; i<=ind; i++){
            while(nums[i]==val){
                nums[i]=nums[ind];
                nums[ind]=val;
                ind--;
                if(ind<0)
                    return 0;
                if(ind<i)
                    break;
            }
        }
        return ind+1;
    }
    public static int strStr(String haystack, String needle) {
       /* for(int i = 0; i<=haystack.length()-needle.length();i++){
            if(haystack.substring(i, needle.length() + i).equals(needle))
                return i;
        }
        return -1;*/
        if(haystack.contains(needle))
            return haystack.indexOf(needle);
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(strStr("butsad","sad"));
    }
}