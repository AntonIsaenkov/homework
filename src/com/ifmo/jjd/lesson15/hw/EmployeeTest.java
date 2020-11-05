package com.ifmo.jjd.lesson15.hw;
// Создать список объетов List<Employee> (использовать метод employeeGenerator)
// и сортировать по:
// имени
// имени и зарплате
// имени, зарплате, возрасту и компании

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeTest {

    public static void main(String[] args) {

        List<Employee> empList = Employee.employeeGenerator(10);


        Comparator<Employee> empNameComparator = new NameComparator();
        Comparator<Employee> empSalaryComparator = new SalaryComparator();

        Comparator<Employee> empNameAndSalaryComparator = new NameComparator().thenComparing(new SalaryComparator());

        Comparator<Employee> empNameAndSalaryAndAgeAndCompanyComparator = new NameComparator().
                thenComparing(new SalaryComparator()).
                thenComparing(new AgeComparator()).
                thenComparing(new CompanyComparator());

        Collections.sort(empList, empNameComparator);
        System.out.println("Сортировка работников по имени");
        for (Employee emp : empList)
            System.out.println(emp);
        System.out.println("");

        Collections.sort(empList, empSalaryComparator);
        System.out.println("Сортировка работников по зп");
        for (Employee emp : empList)
            System.out.println(emp);
        System.out.println("");

        Collections.sort(empList, empNameAndSalaryComparator);
        System.out.println("Сортировка работников по имени и зарплате");
        for (Employee emp : empList)
            System.out.println(emp);
        System.out.println("");

        Collections.sort(empList, empNameAndSalaryAndAgeAndCompanyComparator);
        System.out.println("Сортировка работников по имени и зарплате, и возрасту, и компании");
        for (Employee emp : empList)
            System.out.println(emp);

    }
}
