package homework.lesson3;

//1. Заполните массив на N элементов случайным целыми числами и выведете максимальное, минимальное и среднее значение

import java.util.Arrays;

public class TaskOne {
    public static void main(String[] args) {

        int[] arr1 = {10, 40, 6, 80, 74, 23, 15, 79, -30, -80, 0, -96, 50};
        System.out.println(Arrays.toString(arr1));

        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        System.out.println(arr1[0]);
        System.out.println(arr1[arr1.length - 1]);
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i];

        }
        System.out.println("среднее арифметическое :" + sum / arr1.length);

    }
}

