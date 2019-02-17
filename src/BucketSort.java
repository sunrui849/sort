import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 */
public class BucketSort {
    private static int[] arr = {5, 4, 2, 81, 9, 3, 8, 7, 1, 345, 56, 41, 7, 1, 2, 85, 634, 8, 42, 46, 43, 1, 5, 6};

    public static void main(String[] args) {
        sort(arr);
        for (int i : arr) {
            System.out.print(i);
            System.out.print(",");
        }
    }

    //设置桶的大小
    private static final int BUCKET_SIZE = 5;

    /**
     * 从小到大
     * 桶排序
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        if (arr == null || arr.length == 0){
            return arr;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int value : arr) {
            max = Math.max(max,value);
            min = Math.min(min,value);
        }

        //桶的数量
        int bucketNum = (max - min)/BUCKET_SIZE + 1;
        //以ArrayList作为桶的容器，参数为设置桶的数量，即ArrayList默认的长度
        List<List<Integer>> bucket = new ArrayList<List<Integer>>(bucketNum);
        //初始化桶
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<Integer>());
        }

        //将数据放到桶里
        for (int value : arr){
            int num = (value - min)/BUCKET_SIZE;
            bucket.get(num).add(value);
        }

        //排序每一个桶内的数据
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucket.get(i));
        }

        //更新数组内数据
        int index = 0;
        for (List<Integer> content : bucket){
            for (Integer value : content) {
                arr[index++] = value;
            }
        }
        return arr;
    }

}

