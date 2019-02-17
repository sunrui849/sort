/**
 * 选择排序
 */
public class SelectSort {
    private static int[] arr = {5,4,2,81,9,3,8,7,1,345,56,41,7,1,2,85,634,8,42,46,43,1,5,6};

    public static void main(String[] args) {
        sort(arr);
        for (int i : arr){
            System.out.print( i );
            System.out.print(",");
        }
    }

    /**
     * 从小到大
     * 选择排序
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr){
        if (arr == null || arr.length == 0){
            return arr;
        }
        int num = arr.length;
        for (int i = 0; i< num - 1;i++){//选出来n-1个最小的数排序完成
            int minIndex = i;//最小的数的索引
            for (int j = i + 1; j < num; j++){//从剩余的数（除了已选出来的）中找到最小的索引
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int flag = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = flag;
        }

        return arr;
    }



}
