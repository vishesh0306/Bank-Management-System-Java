public class Database {
    
    public static User[] users = new User[10];
    public static int userCount = 2;
    
    public static Account[] accounts = new Account[10];
    public static int accountCount = 2;

    static{
        accounts[0] = new Account(users[0]);
        accounts[1] = new Account(users[1]);
    }

    static{
        users[0] = new User("Vishesh", 21, 1234567890L, "vishesh@gmail.com", "PNB001", "11111", accounts[0]);
        users[1] = new User("Shivam", 19, 9876543211L, "Shivam@gmail.com", "PNB002", "22222", accounts[1]);
    }

    


}
