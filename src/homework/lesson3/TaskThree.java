package homework.lesson3;

//3. Создайте массив из 11 случайных целых чисел из отрезка [-1;1], выведите массив в консоль.
//   Определите какой элемент встречается в массиве чаще всего и выведите информацию об этом в консоль.
//   Если два каких-то элемента встречаются одинаковое количество раз, то не выводите ничего.

import java.util.Arrays;

public class TaskThree {

    public static void main(String[] args) {

        int[] arr = new int[11];

        int count1 = 0; //счетчие элемента (-1)
        int count2 = 0; //счетчие элемента (0)
        int count3 = 0; //счетчие элемента (1)

        for (int i = 0; i < arr.length; i++) {

            arr[i] = (int) ((Math.random() * 4) - 2);

            if (arr[i] == -1) {

                count1++;

            } else if (arr[i] == 0) {

                count2++;

            } else {

                count3++;
            }

        }
        System.out.println(Arrays.toString(arr));

        if (count1 > count2 && count1 > count3){
            System.out.println("элемент \"-1\" встречается чаще в кол-ве: "+ count1);
        }
        if (count2 > count1 && count2 > count3){
            System.out.println("элемент \"0\" встречается чаще в кол-ве: "+ count3);
        }
        if (count3 > count2 && count3 > count1){
            System.out.println("элемент \"1\" встречается чаще в кол-ве: "+ count3);
        }


    }
}
