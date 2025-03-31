public class Testing {

    static{
        System.out.println("========================================================");
        System.out.println("WELCOME TO PUNJAB NATIONAL BANK");
        System.out.println("========================================================");
        System.out.println();
    }

    public static void main(String[] args) {
        // User user = Database.users[0];

        // System.out.println(user.name);
        // System.out.println(user.age);
        // System.out.println(user.accountNumber);
        // System.out.println(user.accountPassword);


        LoginSignupOperations.signUp("Bablu", 21,  8009008009L, "bablu@gmail.com", "1234");

        for(User userss: Database.users){
            if(userss!=null)
                System.out.println(userss.accountNumber + "     " + userss.accountPassword + "      " + userss.account.getBalance(userss.account));
        }

        for(Account account: Database.accounts){
            if( account!=null)
                System.out.println(account.getBalance(account));
        }

        LoginSignupOperations.login("PNB002", "1234");
        LoginSignupOperations.login("12345", "54321");

  

        // System.out.println(Database.users[0]);
        // System.out.println(Database.accounts[0].getBalance(Database.accounts[0]));

        // System.out.println(Database.users[0].account);
        // System.out.println(Database.accounts[0]);

        Database.users[2].account.addBalance(Database.accounts[2], 100);
        System.out.println(Database.users[2].account.getBalance(Database.accounts[2]));
        System.out.println(Database.users[2].account.getBalance(Database.users[2].account));

    }
}