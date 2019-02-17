/**
 * 冒泡排序
 */
public class MPSort {
    private static int[] arr = {5,4,2,81,9,3,8,7,1,345,56,41,7,1,2,85,634,8,42,46,43,1,5,6};

    public static void main(String[] args) {
        sortMp(arr);
        for (int i : arr){
            System.out.print( i );
            System.out.print(",");
        }
    }

    /**
     * 冒泡排序
     * 从小到大
     * @param arr
     * @return
     */
    public static int[] sortMp(int[] arr){
        if (arr == null || arr.length == 0){
            return arr;
        }

        int num = arr.length;
        for (int i = 0; i < num-1; i++) { //共比较n-1次圈 ，排完多少圈在最后就有几个是已排好序的
            for (int j = 0; j < num-i-1; j++){ //每一圈需要比较每两个相近的，排除最后已排好的
                if (arr[j+1] < arr[j]) {
                    int flag = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = flag;
                }
            }
        }

        return arr;
    }

    /**
     * 冒泡排序
     * 从小到大
     * 增加提前结束标志位
     * @param arr
     * @return
     */
    public static int[] sortMp2(int[] arr){
        if (arr == null || arr.length == 0){
            return arr;
        }

        int num = arr.length;
        for (int i = 0; i < num-1; i++) { //共比较n-1次圈 ，排完多少圈在最后就有几个是已排好序的
            boolean end = true;
            for (int j = 0; j < num-i-1; j++){ //每一圈需要比较每两个相近的，排除最后已排好的
                if (arr[j+1] < arr[j]) {
                    int flag = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = flag;
                    end = false;
                }
            }
            if (end){
                break;
            }
        }

        return arr;
    }



}
