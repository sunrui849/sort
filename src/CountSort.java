/**
 * 计数排序
 */
public class CountSort {

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
     * 计数排序
     * 假设知道最大值，最小值为0（如果不知道的话，通过计算需要比较 2*n 次，在计算时间复杂度的时候可以忽略常数）
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

        int num = max - min +1;
        int[] newArr = new int[num];

        //开始计数
        for (int value : arr){
            newArr[value - min]++; //value - min 是将最小数放到数组0位置，以此类推
        }

        int index = 0;
        //更新arr的值
        for (int i = 0;i < num; i++) {
            while (newArr[i] > 0){
                arr[index++] = i + min;// i + min 还原真实数据
                newArr[i]--;
            }
        }

        return arr;
    }
}
