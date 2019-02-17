/**
 * 快速排序
 */
public class QuickSort {
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
     * 快速排序
     * 初始化
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        if (arr == null || arr.length == 0){
            return arr;
        }
        return quickSort(arr,0,arr.length-1);
    }

    /**
     * 递归排序两段数组
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int[] quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }

        int middleIndex = sortMiddle(arr,left,right);//找个基准值并使基准值左侧小右侧大，返回基准值索引
        quickSort(arr,left,middleIndex-1);//排序左区间
        quickSort(arr,middleIndex+1,right);//排序右区间

        return arr;

    }

    /**
     * 排序区间数据，使选定值两侧分别为大或小
     * 左右闭区间
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int sortMiddle(int[] arr,int left, int right){
        int sureValue = arr[left];//基准值
        int index = left +1;//这个标记右边为比选定值大的，左边为比选定值小的，相当于左区间上限+1
        for (int i = index; i <= right; i++){
            if (arr[i] < sureValue){//比基准值小则交换到左区间
                swap(arr,index,i);
                index++;//左区间上限+1
            }
        }
        swap(arr,left,index-1);//使基准值与左区间上限替换
        return index-1;
    }

    /**
     * 交换位置
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr,int i,int j) {
        int flag = arr[i];
        arr[i] = arr[j];
        arr[j] = flag;
    }
}

