package com.hospital.system;

import java.util.ArrayList;
import java.util.Scanner;
abstract class Person {
    private String name;
    protected int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public abstract void showDetails();
}
class Patient extends Person {
    private String disease;
    private double bill;
    public Patient(String name, int age, String disease, double bill) {
        super(name, age);
        this.disease = disease;
        this.bill = bill;
    }
    @Override
    public void showDetails() {
        System.out.println("Patient Name: " + getName());
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
        System.out.println("Bill: $" + bill);
    }
}
class Doctor extends Person {
    private String specialization;

    public Doctor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }
    @Override
    public void showDetails() {
        System.out.println("Doctor Name: " + getName());
        System.out.println("Age: " + age);
        System.out.println("Specialization: " + specialization);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        try {
            System.out.print("Enter patient name: ");
            String name = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter disease: ");
            String disease = scanner.nextLine();
            System.out.print("Enter bill amount: ");
            double bill = scanner.nextDouble();
            Person patient = new Patient(name, age, disease, bill);
            people.add(patient);
            Person doctor = new Doctor("Dr. Smith", 45, "Cardiology");
            people.add(doctor);
            for (Person p : people) {
                p.showDetails();
                System.out.println("-------------------");
            }
        } catch (Exception e) {
            System.out.println("Invalid input!");
        } finally {
            scanner.close();
        }
    }
}