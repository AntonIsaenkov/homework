package homework.lesson2;

//Программа загадывает число в диапазоне [1;9] <br>
//Пользователь вводит число с клавиатуры  <br>
//Программа в зависимости от введенного числа выводит в консоль следующее: <br>
// "загаданное число больше" <br>
// "загаданное число меньше" <br>
// "Вы угадали" (программа завершает работу) <br>
// если введен 0, выводит "выход из программы" (программа завершает работу) <br>

import java.util.Scanner;

public class Test6 {

    public static void main(String[] args) {

        int min = 1;
        int max = 9;
        int chislo = min + (int) (Math.random() * (max - min) + 1);


        Scanner scan = new Scanner(System.in);
        int i = 0;
        boolean gameAgain = true;


        while (gameAgain) {

            System.out.println("Программа загадала число от 1 до 9\n" +
                    "Попробуйте отгадать!");

            System.out.println("Введите число: ");
            int ugadai = scan.nextInt();
            i++;

            if (ugadai==0){ break;

            }
            if (ugadai < chislo) {

                System.out.println("Теплее");

            } else if (ugadai > chislo) {

                System.out.println("Холднее");

            } else {

                System.out.println("Угадано");
                System.out.println("число: " + chislo + " угадано с " + i + " попыток");
                System.out.println("Сыграть снова: 1 - Да, остальные цифры: Нет");
                int again = scan.nextInt();
                if (again !=1 ){
                gameAgain = false;
                }
            }

        }

    }

}



