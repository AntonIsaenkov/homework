package homework.lesson5;

//3. Написать функцию, которая проверяет, является ли строка палиндромом. <br>
//Палиндром — это число, буквосочетание, слово или текст, которые одинаково
//читаются по буквам или по словам как слева направо, так и справа налево. <br>
//Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром <br>

public class Taskhree {

    public static void main(String[] args) {

        String str = "а, роза, упала на,,, лапу Азора";

        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',' || str.charAt(i) == ' ' || str.charAt(i) == ':') {
                continue;
            }

            stb = stb.append(str.charAt(i));

        }


        String str1 = stb.toString();
        System.out.println(str1);

        String str2 = stb.reverse().toString();
        System.out.println(str2);


        if (str1.equalsIgnoreCase(str2)) {

            System.out.println("Палиндром");
        } else {
            System.out.println("Не Палиндром");
        }

    }
}
