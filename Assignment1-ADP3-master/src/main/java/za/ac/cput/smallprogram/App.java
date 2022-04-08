package za.ac.cput.smallprogram;

import java.util.Scanner;

// Rename this class to your appropriate program name and delete this comment
public class App {

    public static void main(String[] args) {
        char operator;
        double num1, num2;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter operator (+, -, *, /");
        operator = input.next().charAt(0);

        System.out.println("Enter the two numbers one at a time");
        num1 = input.nextDouble();
        num2 = input.nextDouble();

        input.close();


    }

}
