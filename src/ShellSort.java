/**
 * 希尔排序
 */
public class ShellSort {
    private static int[] arr = {5, 4, 2, 81, 9, 3, 8, 7, 1, 345, 56, 41, 7, 1, 2, 85, 634, 8, 42, 46, 43, 1, 5, 6};

    public static void main(String[] args) {
        sort(arr);
        for (int i : arr) {
            System.out.print(i);
            System.out.print(",");
        }
    }

    /**
     * 从小到大
     * 希尔排序
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        if (arr == null || arr.length == 0){
            return arr;
        }

        int num = arr.length;

        int increment = num/3 + 1;//间隔

        //不断缩小间隔
        for(;increment > 0; increment = increment/3) {
            //从第二个序列开始，开始对于每组进行插入排序
            for (int i = increment; i < num; i++){
                //后面的值始终记录着这趟比较要比较的值， 如果比当前组内前一个元素小就交换位置
                for (int preIndex = i - increment; preIndex >= 0 && arr[preIndex + increment] < arr[preIndex]; preIndex = preIndex -increment) {
                    int currValue = arr[preIndex + increment];
                    arr[preIndex + increment] = arr[preIndex];
                    arr[preIndex] = currValue;
                }
            }
        }

        return arr;
    }
}
