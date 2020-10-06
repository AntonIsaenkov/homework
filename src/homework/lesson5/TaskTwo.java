package homework.lesson5;

//2. Найти количество вхождений одной строки в другую. <br>
//Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза <br>

import java.util.Arrays;

public class TaskTwo {

    public static void main(String[] args) {

        String stroka = " дома одомашненный домовой дом доммод ";
        String userStr = "дом";
        int count = 0;
        int index = 0;

        while(true){

            index = stroka.indexOf(userStr, index);
            if (index < 0) {
                break;
            }

            ++index;

            System.out.println("Совпадения");
            count++;
        }

        System.out.println(count);
    }
}


