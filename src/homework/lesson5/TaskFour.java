package homework.lesson5;

//4. Заменить все буквы в слове на строчные, а первую букву на заглавную <br>
//Например, дано hello, получаем Hello / дано HeLLO, получаем Hello <br>

import java.util.Scanner;

public class TaskFour {

    public static void main(String[] args) {

        String userString;
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите слово в любом регистре:");

        userString = scan.nextLine();
        System.out.println("Дано: " + userString);

        String userStringOne = userString.substring(0, 1).toUpperCase();
        //System.out.println(userStringOne);

        String userStringTwo = userString.substring(1, userString.length()).toLowerCase();
        //System.out.println(userStringTwo);

        String endString = userStringOne.concat(userStringTwo);
        System.out.println(endString);
    }
}
