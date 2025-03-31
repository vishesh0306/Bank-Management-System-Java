import java.util.Scanner;
public class App {

    static boolean start = true;
    static User currentUser;
    
    static{
        System.out.println("==================================================================");
        System.out.println("\t\tWELCOME TO PUNJAB NATIONAL BANK");
        System.out.println("==================================================================");
        System.out.println();
    }

    public static void main(String[] args) {
        int choice;

        Scanner scanner = new Scanner(System.in);

        while (start) {
            
            System.out.println("Press 1: Current user? => Signin \nPress 2: Open Account? => Signup \nPress 3: Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
            case 1:{

                System.out.println("==================================================================");
                System.out.println("\t\t\tSign-in");
                System.out.println("==================================================================");
                System.out.println();
                System.out.print("Enter Account Number: ");
                scanner.nextLine();
                String accNo = scanner.nextLine();
                // System.out.println();

                System.out.print("Enter Account Password: ");
                String accPass = scanner.nextLine();
                System.out.println();

                currentUser = LoginSignupOperations.login(accNo, accPass);

                break;
            }
           
            case 2:{
                System.out.println("==================================================================");
                System.out.println("\t\t\tSign-Up");
                System.out.println("==================================================================");
                System.out.println();
                System.out.print("Enter your name: ");
                scanner.nextLine();
                String name = scanner.nextLine();
             
                System.out.print("Enter your age: ");
                int age = scanner.nextInt();

                System.out.print("Enter your Phone Number: ");
                long phoneNo = scanner.nextLong();

                System.out.print("Enter your Email Address: ");
                scanner.nextLine();
                String email = scanner.nextLine();

                System.out.print("Set your account password \nEnter password: ");
                String password = scanner.nextLine();


                LoginSignupOperations.signUp(name, age, phoneNo, email, password);

                break;

            }
            
            
            case 3:{
                System.out.println();
                System.out.println("Thanks for visiting Punjab National Bank");
                System.out.println();
                start = false;

                break;
            }
            
            default:
                System.out.println();
                System.out.println("Invalid choice!!");
                System.out.println();
                break;
        }


            while(User.isLoggedin && currentUser != null){
                
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println();
                System.out.println("What do you wanna do? \nPress 1: Check Balance \nPress 2: Withdraw money \nPress 3: Deposit money \nPress 4: Transfer money \nPress 5: Logout Account");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                switch (choice) {
                    case 1:{
                        System.out.println();
                        System.out.println();
                        System.out.print("Your current balance is: ₹");
                        System.out.println( currentUser.account.getBalance(currentUser.account));
                        System.out.println();
                        System.out.println();
                        break;
                    }       

                    case 2:{
                        System.out.print("Enter the amount to withdraw from your account: ₹");
                        int money = scanner.nextInt();
                        currentUser.account.withdrawBalance(currentUser.account, money);
                        System.out.println();
                        System.out.println();
                        break;
                        
                    }

                    case 3:{
                        System.out.print("Enter the amount to deposit in your account: ₹");
                        int money = scanner.nextInt();
                        currentUser.account.addBalance(currentUser.account, money);
                        System.out.println("Money added successfully!! Your currect balance is: ₹" + currentUser.account.getBalance(currentUser.account));
                        System.out.println();
                        System.out.println();
                        break;
                    }

                    case 4:{
                        System.out.print("Enter account number to whom you wanna transfer funds: ");
                        String accNo = scanner.next();
                        System.out.print("Enter amount to transfer: ₹");
                        int money = scanner.nextInt();

                        currentUser.account.transferMoney(currentUser.account, accNo, money);

                        break;
                    }

                    case 5:{
                        System.out.println("Logging off... Visit again!!");
                        System.out.println();
                        User.isLoggedin = false;
                        break;
                    }
                
                    default:
                        System.out.println();
                        System.out.println("Invalid option, choose again!!");
                        System.out.println();
                }


            }
        }

        scanner.close();
    }



}
