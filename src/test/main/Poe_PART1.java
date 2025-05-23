/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_part2;

/**
 *
 * @author RC_Student_lab
 */
import javax.swing.*;
import java.util.regex.*;

public class Poe_PART2 {
    private String storedUsername;
    private String storedPassword;
    private String firstName;
    private String lastName;

    // Method 1: Validate Username
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method 2: Validate Password
    public boolean checkPasswordComplexity(String password) {
        boolean length = password.length() >= 8;
        boolean capital = Pattern.compile("[A-Z]").matcher(password).find();
        boolean number = Pattern.compile("[0-9]").matcher(password).find();
        boolean special = Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();

        return length && capital && number && special;
    }

    // Method 3: Validate South African Cell Phone Number
    public boolean checkCellPhoneNumber(String number) {
        return number.matches("^\\+27\\d{9}$");
    }

    // Method 4: Registration Logic
    public String registerUser() {
        this.firstName = JOptionPane.showInputDialog("Enter your first name:");
        this.lastName = JOptionPane.showInputDialog("Enter your last name:");
        storedUsername = JOptionPane.showInputDialog("Enter a username (must contain _ and be ≤ 5 characters):");

        if (!checkUserName(storedUsername)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        storedPassword = JOptionPane.showInputDialog("Enter a password (min 8 chars, capital letter, number, special char):");

        if (!checkPasswordComplexity(storedPassword)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        String cellNumber = JOptionPane.showInputDialog("Enter your cell phone number with country code (e.g., +27831234567):");

        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
    }

    // Method 5: Login
    public boolean loginUser() {
        String inputUsername = JOptionPane.showInputDialog("Enter your username:");
        String inputPassword = JOptionPane.showInputDialog("Enter your password:");

        return inputUsername.equals(storedUsername) && inputPassword.equals(storedPassword);
    }

    // Method 6: Login Status Message
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Poe_PART2 login = new Poe_PART2();

        String regMsg = login.registerUser();
        JOptionPane.showMessageDialog(null, regMsg);

        boolean success = login.loginUser();
        String loginMsg = login.returnLoginStatus(success);
        JOptionPane.showMessageDialog(null, loginMsg);
    }
}

