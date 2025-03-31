public class User {

    String name;
    int age;
    long phoneNo;
    String email;

    String accountNumber;
    String accountPassword;

    Account account;

    static boolean isLoggedin = false;

    User(String name, int age, long phoneNo, String email){
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
        this.email = email;

        this.accountNumber = null;
        this.accountPassword = null;
    }

    User(String name, int age, long phoneNo, String email, String accountNumber, String accountPassword, Account account){
        this(name, age, phoneNo, email);
        this.accountNumber = accountNumber;
        this.accountPassword = accountPassword;
        this.account = account;
    }

    
}
