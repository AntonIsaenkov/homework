package homework.lesson3;

//2. Создайте массив из чётных чисел [2;20] и выведите элементы массива в консоль в обратном порядке (20 18 16 ... 4 2)

import java.util.Arrays;

public class TaskTwo {

    public static void main(String[] args) {

        int[] arr1;
        int countElements = 0;

        for (int i = 2; i <= 20; i += 2) {

            countElements++;
        }

        arr1 = new int[countElements];

        for (int i = 0, j = 2; i < arr1.length; i++, j+=2 ){

            arr1[i] = j;
        }

        System.out.println(Arrays.toString(arr1));

        for (int i = arr1.length-1; i >=0; i-- ){

            System.out.print(arr1[i]+" ");
        }

    }
}
