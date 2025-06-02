package main.java;

import main.java.AccountServices.UserServices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AtmInterface {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            UserServices services = new UserServices();
            String[] credentials = new String[2];
            int choose = -1;
            boolean notLongedIn = true;
            List<String> options;
            try {
                options = Files.readAllLines(Path.of("files/options.txt"));
            }catch (IOException e){
                System.out.println("Options file not found");
                return;
            }
            double balanceChange;


            System.out.println("Welcome to ATM: ");
        do {
            System.out.println("Press 1 to login");
            System.out.println("Press 2 to sign up");
            System.out.println("Press 3 to exit");
            System.out.println("Option: ");
            try {
                choose = scanner.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
            switch (choose) {
                case (1):
                    System.out.println("Logging in:");
                    System.out.println("Login: ");
                    credentials[0] = scanner.next();
                    System.out.println("Password: ");
                    credentials[1] = scanner.next();
                    credentials = Arrays.stream(credentials).map(String::trim).toArray(String[]::new);
                    notLongedIn  = !services.loggingIn(credentials);
                    credentials[0] = credentials[1] = null;
                    break;
                case (2):
                    boolean passwordMach = true;
                    do {
                        System.out.println("Sign up:");
                        System.out.println("Type Login:");
                        credentials[0] = scanner.next();
                        System.out.println("Type password:");
                        credentials[1] = scanner.next();
                        System.out.println("Confirm password");
                        String confirmPassword = scanner.next();

                        if (credentials[1].equals(confirmPassword)) passwordMach = false;
                        credentials = Arrays.stream(credentials).map(String::trim).toArray(String[]::new);

                        System.out.println(services.addUser(credentials));
                    } while (passwordMach);
                    break;
                case (3):
                    return;
                case (-1):
                    break;
                default:
                    System.out.println("Wrong option!");
                    break;
            }

        } while (notLongedIn);

        System.out.println("Balance:");
        System.out.println(services.getBalance());

        while (true){
            options.forEach(System.out::println);

            try{
                choose = scanner.nextInt();
                }
            catch (InputMismatchException e){
                System.out.println("Invalid input.");
                scanner.nextLine();
                }

                System.out.println("Balance:");
            switch (choose){
                case(1):
                    System.out.println("Amount to withdraw:");
                    balanceChange = scanner.nextDouble();
                    System.out.println("Operation succeed: " + services.userWithdraw(balanceChange));
                    break;
                case(2):
                    System.out.println("Amount to remittance:");
                    balanceChange = scanner.nextDouble();
                    System.out.println("Operation succeed: " + services.userRemittance(balanceChange));
                    break;
                case(3):
                    System.out.println("See you again");
                    return;
                default:
                    System.out.println("Wrong option!");
                    break;
            }
        }
    }
}
