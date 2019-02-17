/**
 * 堆排序
 */
public class HeapSort {
    private static int[] arr = {5, 4, 2, 81, 9, 3, 8, 7, 1, 345, 56, 41, 7, 1, 2, 85, 634, 8, 42, 46, 43, 1, 5, 6};

    public static void main(String[] args) {
        sort(arr);
        for (int i : arr) {
            System.out.print(i);
            System.out.print(",");
        }
    }

    //记录已排序的最小索引，在构建最大堆时初始化
    private static int num = 0;
    /**
     * 堆排序
     * 从小到大
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        if (arr == null || arr.length == 0){
            return arr;
        }

        buildHeap(arr);//将无序数组构建成最大堆

        //只需要遍历完剩余两个节点时即可结束
        for (int i = num - 1; i > 0; i--){
            swap(arr,0,i);
            num--;//此时数组后面 下标是num开始的到最后 的均为已排好序的
            heapify(arr,0);//此时堆中只有根节点是错误的，调整即可
        }
        return arr;
    }

    /**
     * 构建最大堆
     * @return
     */
    private static int[] buildHeap(int[] arr) {
        num = arr.length;

        //最后一个元素的父节点为 num/2 向下取整，构建最大堆也就是从倒数第二层开始调整
        for (int i = num/2 ; i >= 0; i--){
            heapify(arr,i);
        }

        return arr;
    }


    /**
     * 调整堆
     * @param arr
     * @param index
     * @return
     */
    private static int[] heapify(int[] arr, int index){

        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;
        int parentIndex = index;

        //比较父节点和左子节点的值，大的改为父节点
        if (leftChildIndex < num && arr[leftChildIndex] > arr[parentIndex]){
            parentIndex = leftChildIndex;
        }

        //比较父节点和右子节点的值（此时父节点为原来的左节点和父节点中的最大值），大的改为父节点
        if (rightChildIndex < num && arr[rightChildIndex] > arr[parentIndex]){
            parentIndex = rightChildIndex;
        }

        //如果父节点改变了，那么开始交换位置，并向下继续调整（这个递归的逻辑是为了改变根节点时的调整,构建最大堆时这个递归代码是冗余的）
        if (parentIndex != index){
            swap(arr,parentIndex,index);
            heapify(arr,parentIndex);
        }

        return arr;
    }

    /**
     * 交换位置
     * @param arr
     * @param i
     * @param j
     * @return
     */
    private static int[] swap(int[] arr,int i,int j){
        int flag = arr[i];
        arr[i] = arr[j];
        arr[j] = flag;
        return arr;
    }
}
