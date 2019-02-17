/**
 * 归并排序
 */
public class MergeSort {
    private static int[] arr = {5, 4, 2, 81, 9, 3, 8, 7, 1, 345, 56, 41, 7, 1, 2, 85, 634, 8, 42, 46, 43, 1, 5, 6};

    public static void main(String[] args) {
        sort(arr);
        for (int i : arr) {
            System.out.print(i);
            System.out.print(",");
        }
    }

    /**
     * 归并排序
     * 从小到大
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        if (arr == null || arr.length == 0){
            return arr;
        }

        return sortDG(arr,0,arr.length-1);
    }

    /**
     * 递归排序数据
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int[] sortDG(int[] arr, int left, int right) {
        if (left == right){
            return arr;//递归终止点，即左右相等时
        }

        int middle = (left+right)/2;//相当于取中间数向下取整
        sortDG(arr,left,middle);
        sortDG(arr,middle+1,right);
        merge(arr,left,middle,right);
        return arr;
    }

    /**
     * 合并两个区间
     * @param arr
     * @param left
     * @param middle
     * @param right
     * @return
     */
    private static int[] merge(int[] arr, int left, int middle, int right) {

        int[] newArr = new int[right-left+1];

        int newArrIndex = 0;
        int leftMinIndex = left;//左区间最小数
        int rightMinIndex = middle + 1;//右区间最小数，middle在左区间是闭区间，在右区间是开区间
        while (leftMinIndex <= middle && rightMinIndex <= right){//分别将两遍小数插入新数组，直到有一侧取完
            if (arr[leftMinIndex] < arr[rightMinIndex]){
                newArr[newArrIndex++] = arr[leftMinIndex++];
            }else {
                newArr[newArrIndex++] = arr[rightMinIndex++];
            }
        }

        //以下两个while为将还未清空一侧加入新数组中
        while (leftMinIndex <= middle){
            newArr[newArrIndex++] = arr[leftMinIndex++];
        }

        while (rightMinIndex <= right){
            newArr[newArrIndex++] = arr[rightMinIndex++];
        }

        //更新arr中数据
        for (int value : newArr){
            arr[left++] = value;
        }

        return arr;
    }
}
