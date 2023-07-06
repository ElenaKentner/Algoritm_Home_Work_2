package HomeWork;

import java.util.Arrays;

/*




Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9. Incrementing by one gives 9 + 1 = 10. Thus, the result should be [1,0].
 */
public class HomeWork2 {
    public static void main(String[] args) {
//        Task 1. Написать самостоятельно сортировку слиянием.
//        Стереть все то, что написали во время классной работы и заново написать merge sort, опираясь на
//        текстовое описание и псевдокод.
        int[] arr = {5, 2, 9, 1, 7, 6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

//        Task 2*. Дано число, которое задано своими разрядами, расположенными в массиве. Прибавить к этому числу 1.
//        Example 1:
//        Input: digits = [1,2,3]
//        Output: [1,2,4]
//        Explanation: The array represents the integer 123. Incrementing by one gives 123 + 1 = 124. Thus, the result should be [1,2,4].
        int[] arr1 = {1,2,3};
        int[] res1 = plusOne(arr1);
        System.out.println(Arrays.toString(res1));

//        Example 2:
//        Input: digits = [4,3,2,1]
//        Output: [4,3,2,2]
//        Explanation: The array represents the integer 4321. Incrementing by one gives 4321 + 1 = 4322. Thus, the result should be [4,3,2,2].
        int[] arr2 = {4, 3, 2, 1};
        int[] res2 = plusOne(arr2);
        System.out.println(Arrays.toString(res2));

//        Example 3:
//        Input: digits = [9]
//        Output: [1,0]
//        Explanation: The array represents the integer 9. Incrementing by one gives 9 + 1 = 10. Thus, the result should be [1,0].
        int[] arr3 = {9};
        int[] res3 = plusOne(arr3);
        System.out.println(Arrays.toString(res3));

    }



    /**
     * метод принимает исходный массив и возвращает измененный м ассив(+1)
     * @param arr исходный массив
     * @return измененный массив
     */
    private static int[] plusOne(int[] arr) {
        int n = arr.length;//переменная для хранения длины массива
        for (int i = n - 1; i >= 0; i--) {//начинаем итерацию с конца массива и идем к голове
            if (arr[i] < 9) { //условие что число меньеш 9 - прибавляем один
                arr[i]++;
                return arr; //возвращаем массив
            } else { //если равно 9 то ставим значение ноль
                arr[i] = 0;
            }
        }
        int[] newArr = new int[n + 1];//если все девятки - новый массив с плюс 1 элемента
        newArr[0] = 1;
        return newArr;//возврат нового массива
    }
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {//базовая проверка
            return;
        }
        int n = arr.length;
        int[] temp = new int[n];
        mergeSort(arr, temp, 0, n - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;//делим на 2 половины и рекрусивно вызываем mergeSort для каждой половины
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {//слияние двух подмассивов
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {//копирование оставшихся элементов из левого подмассива
            temp[k++] = arr[i++];
        }
        while (j <= right) {//копирование оставшихся элементов из правого подмассива
            temp[k++] = arr[j++];
        }
        for (int m = left; m <= right; m++) {//копирование отсортированного массива из временного массива в исходный массив
            arr[m] = temp[m];
        }
    }








}
