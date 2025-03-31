public class LoginSignupOperations {

    public static User login(String accountNumber, String password){

        User user = searchUser(accountNumber);

        if(searchUser(accountNumber) != null){
            if(user.accountPassword.equals(password)){
                User.isLoggedin = true;
                System.out.println();

                System.out.println("\t\t\tLogin Successful!! \n\t\t\tWelcome " + user.name);

                System.out.println();

                return user;
            }
            else{
                System.out.println();
         
                System.out.println("\t\t\tLogin Failed!! \n\t\t\tIncorrect Password");
       
                System.out.println();
                return null;
 
            }
        }
        
        else{
            System.out.println();
            System.out.println("User Not Found");
            System.out.println();
        }
        return null;
    }


    public static void signUp(String name, int age, long phoneNo, String email, String password){
        
        User user = new User(name, age, phoneNo, email);    // Creating user without account 

        Account account = new Account(user);    //creating user account

        user.accountNumber = "PNB00" + Database.userCount;      //generating account number
        user.accountPassword = password;                        //setting accountpassword
        user.account = account;                                 //setting user account

        Database.accounts[Database.accountCount] = account;     //appending new user's account into account database
        Database.users[Database.userCount] = user;              //appending new user into user database

        Database.accountCount++;                                //increasing account count
        Database.userCount++;                                   //increasing user count

        
        System.out.println("\t\t\tAccount registered successfully!!");
        System.out.println("\t\t\tYour account number is: " + user.accountNumber);
        System.out.println();
       
        

    }

    public static User searchUser(String accountNumber){

        for(int i = 0; i < Database.users.length; i++){
            if(Database.users[i] != null && Database.users[i].accountNumber != null && Database.users[i].accountNumber.equals(accountNumber)){
                return Database.users[i];
            }
        }
        return null;
    }


}
