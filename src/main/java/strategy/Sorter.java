package strategy;

/**
 * 排序算法
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/8 16:16
 * @descrption
 */
public class Sorter<T> {
    //选择排序
//    public static void sort(Comparable[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minPos = i;
//
//            for (int j = i + 1; j < arr.length; j++) {
//                minPos = arr[j].compareTo(arr[minPos]) == -1 ? j : minPos;
//            }
//
//            swap(arr, i, minPos);
//        }
//
//    }
//
//    static void swap(Comparable[] arr, int i, int j) {
//        Comparable temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
    //比较器方法
    public  void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                minPos = comparator.compare(arr[j],arr[minPos])== -1 ? j : minPos;
            }

            swap(arr, i, minPos);
        }

    }

    void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
