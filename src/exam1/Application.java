package exam1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static exam1.AbonementTypes.*;
import static exam1.SectionTypes.*;

// Задача «Фитнес»
//        В фитнес клубе есть три типа абонементов:
//        Разовый. По разовому абонементу клиенты могут посещать бассейн и тренажерный зал с 8 до 22 часов.
//        Дневной. По данному абонементу клиенты могут посещать тренажерный зал и групповые занятия (но не бассейн) с 8 до 16 часов.
//        Полный. По данному абонементу клиенты могут посещать тренажерный зал, бассейн и групповые занятия с 8 до 22 часов.
//
//        Каждый абонемент хранит дату регистрации (текущая дата) и дату окончания регистрации.
//        Каждый абонемент хранит информацию о владельце. Данные о владельце: имя, фамилия, год рождения.
//
//        Фитнес содержит информацию об абонементах:
//        которые зарегистрированы в данный момент в тренажерном зале;
//        абонементах, которые зарегистрированы в бассейне;
//        абонементах, которые зарегистрированы на групповых занятиях.
//
//        В каждой зоне (бассейн, тренажерный зал, групповые занятия) одновременно может быть зарегистрировано 20 абонементов.
//
//        Когда фитнес клуб закрывается, клиенты покидают его.
//
//        Когда клиент приходит в фитнес клуб, он сообщает желаемую зону и показывает абонемент.
//        Необходимо проверить может ли данный посетитель пройти в желаемую зону и пропустить его,
//        если возможность существует; если посетитель не может пройти, необходимо сообщить ему причину.
//
//        Посетитель не может пройти, если абонемент просрочен,
//        если он пытается пройти в зону, которая не разрешена по его абонементу,
//        если в зоне нет свободных мест.
//
//        Абонемент не может быть зарегистрирован одновременно в нескольких зонах.
//
//        Реализовать возможность вывода информации о посетителях:
//        сначала посетителях тренажерного зала, потом бассейна, потом групповых занятий.
//
//        Реализовать возможность выводить информацию в консоль каждый раз, когда клиент посещает фитнес клуб.
//        Информация для вывода:
//        Фамилия
//        Имя
//        Посещаемаю зона (бассейн/тренажерный зал/групповые занятия)
//        Дата и время посещения
//
//        Методы вывода информации в консоль можно описать в отдельном классе Logger (методы можно сделать static)

public class Application {

    public static void main(String[] args) {

        Fitness fit = new Fitness(LocalDateTime.of(2020,10,19,15,00));

        Person per1  = new Person("AAA","aaa", 1995);
        per1.getInfoAboutPerson();
        Person per2 = new Person("BBB","bbb",1990);
        per2.getInfoAboutPerson();
        Person per3 = new Person("CCC","ccc",1985);
        per3.getInfoAboutPerson();
        Person per4 = new Person("DDD","ddd",1980);
        per4.getInfoAboutPerson();
        Person per5 = new Person("EEE","eee",1975);
        per5.getInfoAboutPerson();
        System.out.println("");

        Abonement abonPer1 = Abonement.abonementMaker(MORNING, per1);
        Abonement abonPer2 = Abonement.abonementMaker(MORNING, per2);
        Abonement abonPer3 = Abonement.abonementMaker(FULL, per3);
        Abonement abonPer4 = Abonement.abonementMaker(FULL, per4);
        Abonement abonPer5 = Abonement.abonementMaker(ONE_DAY, per5);


        fit.checkAboniment(abonPer1, SWIMMING_POOL);
        fit.checkAboniment(abonPer2, SWIMMING_POOL);
        fit.checkAboniment(abonPer3, SWIMMING_POOL);
        fit.checkAboniment(abonPer4, SWIMMING_POOL);
        fit.checkAboniment(abonPer5, SWIMMING_POOL);

        fit.checkAboniment(abonPer1, GYM);
        fit.checkAboniment(abonPer2, GYM);
        fit.checkAboniment(abonPer3, GYM);
        fit.checkAboniment(abonPer4, GYM);
        fit.checkAboniment(abonPer5, GYM);

        fit.checkAboniment(abonPer1, GROUP_LESSON);
        fit.checkAboniment(abonPer2, GROUP_LESSON);
        fit.checkAboniment(abonPer3, GROUP_LESSON);
        fit.checkAboniment(abonPer4, GROUP_LESSON);
        fit.checkAboniment(abonPer5, GROUP_LESSON);
        System.out.println("");
        System.out.println("");

        fit.showAllInfo();
        System.out.println("");
        System.out.println("");

        fit.setFitnessTime(LocalDateTime.of(2020,10,19,22,30));

        fit.fitnesClosed();
        System.out.println("");

        fit.showAllInfo();


        //fit.setFitnessTime(LocalDateTime.of(2020,10,19,6,30));


        //fit.setFitnessTime(LocalDateTime.of(2020,10,18,6,30));















    }

}
