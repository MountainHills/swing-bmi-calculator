package com.antonbondoc.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {

    public Calculator() {
        boolean isMetric = selectMeasurement();
        float weight = enterWeight(isMetric);
        float height = enterHeight(isMetric);
        float bmi = calculateBMI(weight, height, isMetric);

        // Rounding BMI to 2 Decimal Places
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Your BMI is: " + df.format(bmi));
        System.out.println("You are " + getBMICategory(bmi));
    }

    public boolean selectMeasurement() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your system of measurement: ");
            System.out.println("1. Metric");
            System.out.println("2. Imperial");
            System.out.println("===================================");

            if (scanner.hasNextInt()) {
                int temp = scanner.nextInt();
                if (temp == 1 || temp == 2) {
                    return temp == 1;
                } else {
                    System.out.println("Invalid input, try again. Sadge.");
                }
            } else {
                System.out.println("Invalid input, try again.");
                scanner.next();
            }
        }
    }

    public float enterWeight(boolean isMetric) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String measurement = isMetric ? "kilograms" : "pounds";
            System.out.println("Enter your weight in " + measurement + ": ");
            System.out.println("===================================");

            if (scanner.hasNextFloat()) {
                return scanner.nextFloat();
            } else {
                System.out.println("Invalid input, try again.");
                scanner.next();
            }
        }
    }

    private float enterHeight(boolean isMetric) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String measurement = isMetric ? "centimeters" : "feet and inches";
            System.out.println("Enter your height in " + measurement + ": ");
            System.out.println("===================================");

            if (isMetric) {
                if (scanner.hasNextFloat()) {
                    return scanner.nextFloat() / 100;
                } else {
                    System.out.println("Invalid input, try again.");
                    scanner.next();
                }
            } else {
                System.out.println("Enter your height feet: ");
                if (scanner.hasNextFloat()) {
                    float feet = scanner.nextFloat() * 12;

                    while (true) {
                        System.out.println("Enter your height inches: ");
                        if (scanner.hasNextFloat()) {
                            float inch = scanner.nextFloat();
                            return feet + inch;
                        } else {
                            System.out.println("Invalid input, try again.");
                            scanner.next();
                        }
                    }
                } else {
                    System.out.println("Invalid input, try again.");
                    scanner.next();
                }
            }
        }
    }

    public float calculateBMI(float weight, float height, boolean metric) {
        if (metric) {
            return (float) (weight / Math.pow(height, 2));
        } else {
            return (float) ((weight * 703) / Math.pow(height, 2));
        }
    }

    public String getBMICategory(float bmi) {
        if (bmi >= 30) {
            return "Obese";
        } else if (bmi <= 29.9 && bmi >= 25) {
            return "Overweight";
        } else if (bmi <= 24.9 && bmi >= 18.5) {
            return "Normal Weight";
        } else {
            return "Underweight";
        }
    }
}