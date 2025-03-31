public class Account {

    static private String IFSC = "PNB";
    private User accountHolder;
    
    private int myAccountBalance = 0;
    

    Account(User accountHolder){
        this.accountHolder = accountHolder;
        this.myAccountBalance = 0;
    }

    public int getBalance(Account account){
        return account.myAccountBalance;
    }

    public void addBalance(Account account, int money){
        account.myAccountBalance += money;
    }

    public void withdrawBalance(Account account, int amount){
        System.out.println();
        System.out.println();

        if (amount > account.getBalance(account)) {
            System.out.println("Your account don't have enough money!!" );
        }
        else{
            account.myAccountBalance -= amount;
            System.out.println("Transaction successful!! Here is your money!!  ₹" + amount +"\nYour currect balance is:  ₹" + account.getBalance(account));
        }
        System.out.println();
        System.out.println();
    }
    
    public void transferMoney(Account myAccount, String transferUserAccountNumber, int amount){

        User transferToUser = LoginSignupOperations.searchUser(transferUserAccountNumber);

        if(transferToUser != null){

            if (amount > myAccount.getBalance(myAccount)) {
                System.out.println("Your account don't have enough money!!" );
            }
            else{
                System.out.println();
                myAccount.myAccountBalance -= amount;
                System.out.println();
                addBalance(transferToUser.account, amount);
                System.out.println();
                System.out.println("Amount " + amount + " transfered to account number: " + transferUserAccountNumber);
                System.out.println("Your current balance is: ₹" + myAccount.getBalance(myAccount));
            }
            System.out.println();
            System.out.println();
        }
        else{
            System.out.println();
            System.out.println("No user found with account number: " + transferUserAccountNumber);
            System.out.println();
        }

    }

}
