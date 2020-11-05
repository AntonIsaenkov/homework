package com.ifmo.jjd.lesson15.hw.compare;


import com.ifmo.jjd.lesson15.collection.Student;

import java.util.*;

public class ComparingExample {

    public static void main(String[] args) {

        // сортировать по значениям свойств: price, color, brand
        Car blackOpel = new Car("black", "opel", 2000);
        Car redOpel = new Car("red", "opel", 2500);
        Car yellowMazda = new Car("yellow", "mazda", 3000);
        Car greenMazda = new Car("green", "mazda", 3000);

        Car whiteKia = new Car("white", "kia", 1000);
        Car blueHundai = new Car("blue", "hundai", 5000);


        Comparator<Car> carPriceComparator = new PriceComparator();

        Comparator<Car> carColorComparator = new ColorComparator();

        Comparator<Car> carBrandComparator = new BrandComparator();


        ArrayList<Car> carArrayList = new ArrayList();
        carArrayList.add(yellowMazda);
        carArrayList.add(greenMazda);
        carArrayList.add(blackOpel);
        carArrayList.add(redOpel);
        carArrayList.add(whiteKia);
        carArrayList.add(blueHundai);


        Collections.sort(carArrayList, carPriceComparator);
        System.out.println("Сортировка по цене:");

        for (Car car:carArrayList) System.out.println(car);
        System.out.println("");


        Collections.sort(carArrayList, carColorComparator);
        System.out.println("Сортировка по цвету:");

        for (Car car:carArrayList) System.out.println(car);
        System.out.println("");


        Collections.sort(carArrayList, carBrandComparator);
        System.out.println("Сортировка по бренду:");

        for (Car car:carArrayList) System.out.println(car);
        System.out.println("");

    }

}
