import util.SortUtil;

public class EightSorts {

    public static void main(String[] args) {
        //测试
        int[] ints = SortUtil.genRandomArray(10000000, 10000);
        int[] clone = ints.clone();
        long startTime = System.currentTimeMillis();
        shellSortPro(ints);
        System.out.println("排序耗时为:" + (System.currentTimeMillis() - startTime));
        System.out.println(check(ints));

        startTime = System.currentTimeMillis();
        shellSort(clone);
        System.out.println("排序耗时为:" + (System.currentTimeMillis() - startTime));
        System.out.println(check(clone));


    }

    /**
     * 选择排序 每次从未排序的序列中选出最大的或最小的，放入已排序序列的末尾，直到未排序序列为空
     * 时间复杂度： O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param arr
     */
    static void selectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = arr[i];

            for (int j = i; j < len; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                }
            }
            arr[i] = min;
        }
    }

    /**
     * 直接插入排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性: 稳定
     *
     * @param arr
     */

    static void insertSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(j, j - 1, arr);
                j--;
            }

        }
    }

    /**
     * 冒泡排序
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     * 稳定性:稳定
     *
     * @param arr
     */
    static void bubbleSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (arr[j] < arr[j - 1])
                    swap(j, j - 1, arr);
            }
        }
    }

    /**
     * 堆排序 n位置的子节点索引为2n+1,2n+2,因此最后一个非叶子节点的索引为n/2 - 1
     * 时间复杂度：O(nlogn)
     * 空间复杂度:O(1)
     * 稳定性：不稳定
     *
     * @param arr
     */
    static void heapSort(int[] arr) {
        //构造大顶堆
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            getMaxHeap(i, len - 1, arr);
        }

        for (int i = len - 1; i > 0; i--) {
            swap(0, i, arr);
            getMaxHeap(0, i - 1, arr);
        }
    }

    /**
     * 希尔排序:其实希尔排序就是对直接插入排序的优化，首先进行分组对插入排序进行预排序,最后一次gap为1时，就是直接插入排序，这时就很快了
     * 时间复杂度：O(nlogn)
     * 空间复杂度: O(1)
     * 稳定性:不稳定
     *
     * @param arr
     */
    static void shellSort(int[] arr) {
        int len = arr.length;
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    swap(j, j - gap, arr);
                    j -= gap;
                }
            }
            gap /= 2;
        }
    }

    static void shellSortPro(int[] arr) {
        int len = arr.length;

        int gap = 1;

        while (gap < len / 3) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                for (int j = i; j - gap >= 0 && arr[j] < arr[j - gap]; j -= gap)
                    swap(j - gap, j, arr);
            }
            gap /= 3;
        }
    }


    /**
     * 归并排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度: O(n)
     * 稳定性: 稳定
     *
     * @param arr
     */
    static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     * 稳定性：不稳定
     *
     * @param arr
     */
    static void quickSort(int[] arr) {
        sort2(arr, 0, arr.length - 1);
    }

    /**
     * 计数排序
     * 平均时间复杂度：O（n+k）
     * 空间复杂度：O(n+k)
     * 稳定性：
     * 算法步骤：
     * 1.找出排序的数组中最大和最小的元素
     * 2.统计数组中每个值为i的元素出现的次数，存入数组C的第i项
     * 3.对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加
     * 4.反向填充目标数组：将每个元素i放在新数组的第C[i]项，每放一个元素C[i]减去1
     */


    static void sort2(int[] arr, int left, int right) {
        if (left >= right) return;
        int flag = arr[left];
        int low = left;
        int high = right;

        while (low < high) {
            while (low < high && arr[high] >= flag)
                high--;
            while (low < high && arr[low] <= flag)
                low++;
            if (low < high)
                swap(low, high, arr);
        }
        arr[left] = arr[low];
        arr[low] = flag;

        sort2(arr, left, high - 1);
        sort2(arr, high + 1, right);


    }

    private static void sort(int[] arr, int left, int right) {
        if (left == right)
            return;
        int mid = left + (right - left >> 1);

        sort(arr, left, mid);

        sort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;

        int cur1 = left;
        int cur2 = mid + 1;
        while (cur1 <= mid && cur2 <= right) {
            if (arr[cur1] < arr[cur2])
                temp[index++] = arr[cur1++];
            else temp[index++] = arr[cur2++];
        }
        while (cur1 <= mid)
            temp[index++] = arr[cur1++];
        while (cur2 <= right)
            temp[index++] = arr[cur2++];

        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }

    private static void getMaxHeap(int start, int end, int[] arr) {
        int curVal = arr[start];
        int left = start * 2 + 1;
        for (; left <= end; start = left, left = left * 2 + 1) {
            if (left < end && arr[left] < arr[left + 1])
                left++;
            if (arr[left] > curVal)
                swap(left, start, arr);
            else break;

        }

    }

    /**
     * 数组两数位置交换
     *
     * @param a
     * @param b
     * @param arr
     */
    static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static boolean check(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }
}
