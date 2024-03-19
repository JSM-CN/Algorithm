import util.SortUtil;

public class EightSorts {

    public static void main(String[] args) {
        //����
        int[] ints = SortUtil.genRandomArray(10000000, 10000);
        int[] clone = ints.clone();
        long startTime = System.currentTimeMillis();
        shellSortPro(ints);
        System.out.println("�����ʱΪ:" + (System.currentTimeMillis() - startTime));
        System.out.println(check(ints));

        startTime = System.currentTimeMillis();
        shellSort(clone);
        System.out.println("�����ʱΪ:" + (System.currentTimeMillis() - startTime));
        System.out.println(check(clone));


    }

    /**
     * ѡ������ ÿ�δ�δ�����������ѡ�����Ļ���С�ģ��������������е�ĩβ��ֱ��δ��������Ϊ��
     * ʱ�临�Ӷȣ� O(n^2)
     * �ռ临�Ӷȣ�O(1)
     * �ȶ��ԣ����ȶ�
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
     * ֱ�Ӳ�������
     * ʱ�临�Ӷȣ�O(n^2)
     * �ռ临�Ӷȣ�O(1)
     * �ȶ���: �ȶ�
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
     * ð������
     * ʱ�临�Ӷ�: O(n^2)
     * �ռ临�Ӷ�: O(1)
     * �ȶ���:�ȶ�
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
     * ������ nλ�õ��ӽڵ�����Ϊ2n+1,2n+2,������һ����Ҷ�ӽڵ������Ϊn/2 - 1
     * ʱ�临�Ӷȣ�O(nlogn)
     * �ռ临�Ӷ�:O(1)
     * �ȶ��ԣ����ȶ�
     *
     * @param arr
     */
    static void heapSort(int[] arr) {
        //����󶥶�
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
     * ϣ������:��ʵϣ��������Ƕ�ֱ�Ӳ���������Ż������Ƚ��з���Բ����������Ԥ����,���һ��gapΪ1ʱ������ֱ�Ӳ���������ʱ�ͺܿ���
     * ʱ�临�Ӷȣ�O(nlogn)
     * �ռ临�Ӷ�: O(1)
     * �ȶ���:���ȶ�
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
     * �鲢����
     * ʱ�临�Ӷȣ�O(nlogn)
     * �ռ临�Ӷ�: O(n)
     * �ȶ���: �ȶ�
     *
     * @param arr
     */
    static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * ��������
     * ʱ�临�Ӷȣ�O(nlogn)
     * �ռ临�Ӷȣ�O(n)
     * �ȶ��ԣ����ȶ�
     *
     * @param arr
     */
    static void quickSort(int[] arr) {
        sort2(arr, 0, arr.length - 1);
    }

    /**
     * ��������
     * ƽ��ʱ�临�Ӷȣ�O��n+k��
     * �ռ临�Ӷȣ�O(n+k)
     * �ȶ��ԣ�
     * �㷨���裺
     * 1.�ҳ������������������С��Ԫ��
     * 2.ͳ��������ÿ��ֵΪi��Ԫ�س��ֵĴ�������������C�ĵ�i��
     * 3.�����еļ����ۼӣ���C�еĵ�һ��Ԫ�ؿ�ʼ��ÿһ���ǰһ�����
     * 4.�������Ŀ�����飺��ÿ��Ԫ��i����������ĵ�C[i]�ÿ��һ��Ԫ��C[i]��ȥ1
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
     * ��������λ�ý���
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
