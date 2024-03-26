interface Product {
    String getProductName();
    double getProductPrice();
    int getProductRating();
}

class Tea implements Product {
    private String productName;
    private double productPrice;
    private int productRating;
  
    public Tea(String name, double price, int rating) {
        productName = name;
        productPrice = price;
        productRating = rating;
    }
  
    public String getProductName() {
        return productName;
    }
  
    public double getProductPrice() {
        return productPrice;
    }
  
    public int getProductRating() {
        return productRating;
    }
}

class Yogurt implements Product {
    private String productName;
    private double productPrice;
    private int productRating;
  
    public Yogurt(String name, double price, int rating) {
        productName = name;
        productPrice = price;
        productRating = rating;
    }
  
    public String getProductName() {
        return productName;
    }
  
    public double getProductPrice() {
        return productPrice;
    }
  
    public int getProductRating() {
        return productRating;
    }
}

class Chocolate implements Product {
    private String productName;
    private double productPrice;
    private int productRating;
  
    public Chocolate(String name, double price, int rating) {
        productName = name;
        productPrice = price;
        productRating = rating;
    }
  
    public String getProductName() {
        return productName;
    }
  
    public double getProductPrice() {
        return productPrice;
    }
  
    public int getProductRating() {
        return productRating;
    }
}

interface User {
    String getUsername();
    String getPassword();
}

class UserOne implements User {
    private String username;
    private String password;
  
    public UserOne(String name, String pass) {
        username = name;
        password = pass;
    }
  
    public String getUsername() {
        return username;
    }
  
    public String getPassword() {
        return password;
    }
}

class UserTwo implements User {
    private String username;
    private String password;
  
    public UserTwo(String name, String pass) {
        username = name;
        password = pass;
    }
  
    public String getUsername() {
        return username;
    }
  
    public String getPassword() {
        return password;
    }
}

class UserThree implements User {
    private String username;
    private String password;
  
    public UserThree(String name, String pass) {
        username = name;
        password = pass;
    }
  
    public String getUsername() {
        return username;
    }
  
    public String getPassword() {
        return password;
    }
}

class ProductUser implements Product, User {
    private String productName;
    private double productPrice;
    private int productRating;
    private String username;
    private String password;
  
    public ProductUser(String name, double price, int rating, String user, String pass) {
        productName = name;
        productPrice = price;
        productRating = rating;
        username = user;
        password = pass;
    }
  
    public String getProductName() {
        return productName;
    }
  
    public double getProductPrice() {
        return productPrice;
    }
  
    public int getProductRating() {
        return productRating;
    }
  
    public String getUsername() {
        return username;
    }
  
    public String getPassword() {
        return password;
    }
  
    public void UserBoughtTheProduct() {
        System.out.println(getUsername() + " купил " + getProductName());
    }
}

public class Laba13 {
    public static void main(String[] args) {
        Product tea = new Tea("Чай Липтон", 150.0, 4);
        Product yogurt = new Yogurt("Йогурт Данон", 60.0, 5);
        Product chocolate = new Chocolate("Милка", 120.0, 5);

        User userOne = new UserOne("UserName1", "123456");
        User userTwo = new UserTwo("UserName2", "666666");
        User userThree = new UserThree("UserName3", "123456789");

        ProductUser productUser = new ProductUser("Капучино Nescafe", 250.0, 5, "UserCoffeeLover", "SecurePassword123");

        productUser.UserBoughtTheProduct();
    }
}
