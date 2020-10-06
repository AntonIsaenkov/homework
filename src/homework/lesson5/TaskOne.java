package homework.lesson5;

//1. Заполнить массив <br>
//Задать массив на N слов. <br>
//В цикле считывать с консоли слова (scanner.nextLine()), и добавлять их в массив
//(добавлять новое слово в массив можно только, если в нем его еще нет). <br>
//В итоге в массиве будут только уникальные слова. <br>
//Выход их программы по слову exit (его в массив не добавлять) или если массив заполнен <br>
//Перед завершением программы, вывести получившийся массив в консоль <br>

import java.util.Arrays;
import java.util.Scanner;

public class TaskOne {

    public static void main(String[] args) {

        String[] arrOfRandomWords;
        int arrSize;
        String userWord;
        Scanner scan = new Scanner(System.in);

        System.out.println("Kоличество элементов в массиве:");

        arrSize = scan.nextInt();
        scan.nextLine(); //убираем 1ый пустой елемент

        arrOfRandomWords = new String[arrSize];

        System.out.println("Задан массив на " + arrSize + " элементов\n" +
                "Заполните массив случайными словами\n" +
                "Для выхода из программы наберите \"exit\"");


        for (int i = 0; i < arrOfRandomWords.length; ) {

            userWord = scan.nextLine();

            if (userWord.equalsIgnoreCase("Exit")) {
                break;
            }

            for (int j = 0; j < arrOfRandomWords.length; j++) {

                if (userWord.equals(arrOfRandomWords[j]) || userWord.equals("")) {

                    System.out.println("Такое слово уже есть");
                    break;

                } else {

                    arrOfRandomWords[i] = userWord;
                    i++;
                    break;
                }
            }

        }

        System.out.println(Arrays.toString(arrOfRandomWords));
    }
}
