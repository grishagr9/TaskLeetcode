import java.awt.List;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while (l <= r) {
            int mid =l + (r-l)/2;
            if (nums[mid] == target)
                return mid;
            else
                if (nums[mid] > target)
                    r = mid-1;
                else
                    l = mid+1;
        }

        return l;
    }
    public static int lengthOfLastWord(String s) {
        return s.split(" ")[s.split(" ").length-1].length();
    }
    public String addBinary(String a, String b) {
        char perenos = '0';
        char[] sum = new char[Math.max(a.length(),b.length())];
        int lenA = a.length()-1;
        int lenB = b.length()-1;
        char[] arrrr= new char[sum.length];
        Arrays.fill(arrrr,'0');
        String arr = String.valueOf(arrrr);
        for (int i = sum.length-1; i>=0;i--){
            int cur = a.charAt(lenA)+b.charAt(lenB)+perenos;
            if(cur>=146)
            {
                sum[i] = cur%2==0?'0':'1';
                perenos = '1';
            }
            else {
                perenos = '0';
                sum[i] = cur%2==0?'0':'1';
            }
            if(lenB>0) {
                lenB--;
            }else b = arr;
            if(lenA>0) {
                lenA--;
            }else a=arr;
        }
        return perenos>'0'? "1"+String.valueOf(sum) :String.valueOf(sum);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int perenos = 0;
        ListNode p = new ListNode();
        p.val = (l1.val + l2.val + perenos) % 10;
        perenos = (l1.val + l2.val) / 10;
        ListNode res = p;
        l1=l1.next;
        l2=l2.next;
        while(l1!=null||l2!=null){
            if(l1!=null && l2!=null) {
                p.next = new ListNode();
                p.next.val = (l1.val + l2.val + perenos) % 10;
                perenos = (l1.val + l2.val + perenos) / 10;
                l1 = l1.next;
                l2 = l2.next;
                p = p.next;
            }else if(l1!=null) {
                p.next = new ListNode();
                p.next.val=(l1.val + perenos) % 10;
                perenos = (l1.val + perenos) / 10;
                l1 = l1.next;
                p = p.next;
            } else if (l2!=null) {
                p.next = new ListNode();
                p.next.val=(l2.val + perenos) % 10;
                perenos = (l2.val + perenos) / 10;
                l2 = l2.next;
                p = p.next;
            }
        }
        if (perenos != 0) {
            p.next = new ListNode();
            p.next.val = perenos;
        }
        return res;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode res = new ListNode(head.val);
        ListNode p = res;
        int cur = head.val;
        head = head.next;
        while (head!=null){
            if(head.val==cur){
                head=head.next;
                continue;
            }
            cur = head.val;
            head = head.next;
            res.next = new ListNode(cur);
            res = res.next;
        }
        return p;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length-1; i>=0;i--){
            if(m*n<0)
                break;
            if(nums1[m-1]<nums2[n-1]){
                nums1[i]=nums2[n-1];
                n--;
            }else{
                while(m>-1 && nums1[m-1]>nums2[n-1]) {
                    m--;
                }
                for(int j = i-1; j>=m; j--)
                {
                    nums1[j+1]=nums1[j];
                }
                nums1[m-1]=nums2[n-1];
            }
        }
    }

    public static void main(String[] args) {

    }
}