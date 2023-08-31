import java.util.ArrayList;
import java.util.List;

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
    public static void main(String[] args) {
        LeetCodeTasks leetCodeTasks = new LeetCodeTasks();

    }
}
