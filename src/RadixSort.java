import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序
 */
public class RadixSort {
    private static int[] arr = {5, 4, 2, 81, 9, 3, 8, 7, 1, 345, 56, 41, 7, 1, 2, 85, 634, 8, 42, 46, 43, 1, 5, 6};

    public static void main(String[] args) {
        sort(arr);
        for (int i : arr) {
            System.out.print(i);
            System.out.print(",");
        }
    }

    //最大数量级
    private static final int maxLevel = 100;
    /**
     * 从小到大
     * 基数排序
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {

        int level = 1;
        int index = 0;
        List<List<Integer>> bucket = new ArrayList<List<Integer>>(10);

        while (level <= maxLevel) {
            //初始化容器
            for (int i = 0; i < 10; i++) {
                bucket.add(new ArrayList<Integer>());
            }
            //按基数存入到容器内
            for (int value : arr){
                int num = (value/level)%10;//基数位置大小
                bucket.get(num).add(value);
            }

            //更新数组内数据
            for (List<Integer> content : bucket){
                for (Integer value : content) {
                    arr[index++] = value;
                }
            }
            level *= 10;
            index = 0;
            bucket.clear();
        }

        return arr;
    }
}
