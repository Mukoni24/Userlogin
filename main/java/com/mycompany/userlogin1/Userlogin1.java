/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.userlogin1;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class Userlogin1 {

    // Method for Username Checking System
    public static boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method for Password Checking System
    public static boolean checkPasswordComplexity(String password) {

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        if (password.length() >= 8) {

            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);

                if (c >= 'A' && c <= 'Z') {
                    hasCapital = true;
                }

                if (c >= '0' && c <= '9') {
                    hasNumber = true;
                }

                if (!(c >= 'A' && c <= 'Z') &&
                    !(c >= 'a' && c <= 'z') &&
                    !(c >= '0' && c <= '9')) {
                    hasSpecial = true;
                }
            }

            return hasCapital && hasNumber && hasSpecial;
        }

        return false;
    }

    // Method for Cellphone Checking System
    public static boolean checkCellphoneNumber(String cellphone) {
        return cellphone.startsWith("+27") && cellphone.length() == 12;
    }

    // Method for Register User
    public static String registerUser(String username, String password) {

        if (!checkUsername(username)) {
            return "Username is not correctly formatted; please ensure that username contains an underscore and is no more than five characters in length.";
        } 
        else if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and a special character.";
        } 
        else {
            return "User has registered successfully.";
        }
    }

    // Method for Login Check
    public static boolean loginUser(String username, String password, String usernamelogin, String passwordlogin) {
        return username.equals(usernamelogin) &&
               password.equals(passwordlogin);
    }

    // Login Message
    public static String returnLoginStatus(boolean loginStatus, String firstName, String lastName) {

        if (loginStatus) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Main Method
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String username = "";
        String password = "";
        String cellphone = "";

        int choice;

        do {
            System.out.println("\n-----LOGIN SYSTEM-----");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Choose option: ");
            choice = input.nextInt();
            input.nextLine(); // clear buffer

            if (choice == 1) {

                // REGISTER
                System.out.println("\n--REGISTRATION---");
                System.out.print("Enter Username: ");
                username = input.nextLine();

                System.out.print("Enter Password: ");
                password = input.nextLine();

                System.out.print("Enter Cellphone (+27): ");
                cellphone = input.nextLine();

                System.out.println("\n----- REGISTRATION -----");

                // Username validation
                if (checkUsername(username)) {
                    System.out.println("Username successfully captured.");
                } else {
                    System.out.println("Username is not correctly formatted;please ensure that your username contains an underscore and is no more than five characters in length.");
                }

                // Password validation
                if (checkPasswordComplexity(password)) {
                    System.out.println("Password successfully captured.");
                } else {
                    System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter , a number , and a special character.");
                }

                // Cellphone validation
                if (checkCellphoneNumber(cellphone)) {
                    System.out.println("Cellphone number successfully added.");
                } else {
                    System.out.println("Cellphone number incorrectly formatted or does not contain international code.");
                }

                // Registration message
                System.out.println(registerUser(username, password));

            } else if (choice == 2) {

                // LOGIN
                System.out.println("\n----- LOGIN -----");

                System.out.print("Enter Username: ");
                String usernameLogin = input.nextLine();

                System.out.print("Enter Password: ");
                String passwordLogin = input.nextLine();

                System.out.print("Enter First Name: ");
                String firstName = input.nextLine();

                System.out.print("Enter Last Name: ");
                String lastName = input.nextLine();

                boolean loginStatus = loginUser(username, password, usernameLogin, passwordLogin);

                System.out.println(returnLoginStatus(loginStatus, firstName, lastName));

            } else if (choice == 3) {
                System.out.println("Goodbye!");

            } else {
                System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        input.close();
    }
}