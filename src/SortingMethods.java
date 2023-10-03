import java.util.*;

public class SortingMethods {

    protected Integer[] createArray(Integer n){
        Integer[] res = new Integer[n];
        Random random = new Random();
        for (int i = 0; i <n; i++) {
            res[i] = random.nextInt(0,20);
        }
        return res;
    }

    public void bubbleSort(int[] array, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n-i-1 ; j++) {
                if(array[j]>array[j+1]){
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
    }

    public List<Integer> quickSort(List<Integer> array){
        if(array.size()<2){
            return array;
        }
        int anchor = array.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < array.size(); i++) {
            if(array.get(i) < anchor){
                left.add(array.get(i));
            }else{
                right.add(array.get(i));
            }
        }

        List<Integer> res = quickSort(left);
        res.add(anchor);
        res.addAll(quickSort(right));

        return res;
    }

    public void insertionSort(Integer[] array, int n){
        for (int i = 1; i < n; i++) {
            if(array[i] < array[i-1]){
                int j = i;
                while (array[j] < array[j-1]){
                    Integer t = array[j];
                    array[j] = array[j-1];
                    array[j-1] = t;
                    j--;
                    if(j==0)
                        break;
                }
            }
        }
    }

    private int min(Integer[] array, int i, int n){
        int min = array[i];
        int res = i;
        for (int j = i+1; j <n; j++) {
            if(array[j] < min){
                res = j;
                min = array[j];
            }
        }
        return res;
    }

    public void choiceSort(Integer[] array, int n){
        for (int i = 0; i < n; i++) {
            int j = min(array, i, n);
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    }

    protected static void testingSort(int n, SortingMethods methods){
        Integer[] array = methods.createArray(n);

        for (int it:
                array) {
            System.out.print(it+" ");
        }
        System.out.println();

        //List<Integer> res = methods.quickSort(Arrays.asList(array));
        //System.out.println(res.toString());

        methods.choiceSort(array,n);

        for (int it:
                array) {
            System.out.print(it+" ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        testingSort(n,new SortingMethods());
    }

}
