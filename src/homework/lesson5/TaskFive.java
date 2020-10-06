package homework.lesson5;

//5. Найдите самое длинное слово в предложении, при условии, что в предложении все слова разной длины <br>
//Например, в "в предложении все слова разной длины" самое длинное слово "предложении" <br>

import java.util.Arrays;

public class TaskFive {

    public static void main(String[] args) {

        String str = "в предложении, Aэтосамоедлинноеслово, Все::: слова :разной, длины,,,  ";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == ',' || str.charAt(i) == ':') {
                continue;
            }

            sb = sb.append(str.charAt(i));

        }
        String strNew = sb.toString();
        System.out.println(strNew);

        String[] strMass = strNew.split(" ");
        System.out.println(Arrays.toString(strMass));

            for (int i = 0; i < strMass.length-1; i++) {

                if (strMass[i].length() > strMass[i+1].length()){

                    String vremennoSlovo = strMass[i+1];
                    strMass[i+1] = strMass[i];
                    strMass[i] = vremennoSlovo;
                }

            }
        System.out.println(Arrays.toString(strMass));

        System.out.println(strMass[strMass.length-1]);
        System.out.println(strMass[strMass.length-1].length());

    }

}
