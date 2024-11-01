import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    static ArrayList<String> users = new ArrayList<>();
    static ArrayList<String> mails = new ArrayList<>();
    static ArrayList<String> phnno = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();
    static ArrayList<Integer> accounts = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize the data
        users.add("sandhya");
        users.add("triveni");
        users.add("vasavi");
        users.add("supriya");

        mails.add("sandhya@gmail.com");
        mails.add("triveni@gmail.com");
        mails.add("vasavi@gmail.com");
        mails.add("supriya@gmail.com");

        phnno.add("9848485773");
        phnno.add("3859274644");
        phnno.add("2937593758");
        phnno.add("9346226370");

        passwords.add("123");
        passwords.add("456");
        passwords.add("789");
        passwords.add("101");

        accounts.add(1000);
        accounts.add(2000);
        accounts.add(3000);
        accounts.add(4000);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Do you want to login or signup: ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("login")) {
                System.out.println(users);
                System.out.print("Enter your name: ");
                String name = sc.nextLine();

                if (users.contains(name)) {
                    int index = users.indexOf(name);

                    System.out.print("Enter your password: ");
                    String password = sc.nextLine();

                    if (password.equals(passwords.get(index))) {
                        System.out.println("Login successful");

                        while (true) {
                            System.out.print("Enter your choice 1:withdraw 2:deposit 3:checkbalance 4:logout: ");
                            int ch = sc.nextInt();
                            sc.nextLine(); // Consume newline

                            switch (ch) {
                                case 1:
                                    System.out.println("Withdraw");
                                    System.out.print("Enter how much amount you want to withdraw: ");
                                    int withdrawAmount = sc.nextInt();
                                    if (withdrawAmount > accounts.get(index)) {
                                        System.out.println("You don't have enough balance in your account");
                                    } else {
                                        accounts.set(index, accounts.get(index) - withdrawAmount);
                                    }
                                    break;
                                case 2:
                                    System.out.println("Deposit");
                                    System.out.print("How much you want to deposit: ");
                                    int depositAmount = sc.nextInt();
                                    accounts.set(index, accounts.get(index) + depositAmount);
                                    break;
                                case 3:
                                    System.out.println("Check Balance");
                                    System.out.println("Your balance is: " + accounts.get(index));
                                    break;
                                case 4:
                                    System.out.println("Logout");
                                    break;
                                default:
                                    System.out.println("Choose the correct option");
                                    continue;
                            }

                            if (ch == 4) break;
                        }

                    } else {
                        System.out.println("Please enter a valid password");
                    }
                } else {
                    System.out.println("Not eligible");
                }
            } else if (choice.equalsIgnoreCase("signup")) {
                signup(sc);
            } else {
                System.out.println("Choose the correct option");
            }
        }
    }

    public static void signup(Scanner sc) {
        System.out.print("Enter username: ");
        String name = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        System.out.print("Confirm password: ");
        String confirmPassword = sc.nextLine();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Signup failed.");
            return;
        }

        System.out.print("Enter mail ID: ");
        String mail = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();

        System.out.print("Enter deposit amount: ");
        int amount = sc.nextInt();
        sc.nextLine(); // Consume newline

        users.add(name);
        mails.add(mail);
        passwords.add(password);
        phnno.add(phoneNumber);
        accounts.add(amount);

        System.out.println("Signup successful! You can now log in.");
    }
}
