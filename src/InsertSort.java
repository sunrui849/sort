/**
 * 插入排序
 */
public class InsertSort {
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
     * 插入排序
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        if (arr == null || arr.length == 0){
            return arr;
        }

        int num = arr.length;
        for (int i = 1; i < num; i++){//需要比较的数，第一个不需要比较
            int sortIndex = i-1;//排序好的结束位
            int currValue = arr[i];//当前需要比较的值
            while (sortIndex >= 0 && arr[sortIndex] > currValue) {//当前值比前一个小，
                arr[sortIndex + 1] = arr[sortIndex];//后移一位
                sortIndex--;
            }
            arr[sortIndex+1] = currValue;//插入
        }

        return arr;
    }
}

