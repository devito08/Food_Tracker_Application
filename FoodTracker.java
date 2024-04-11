import java.util.Scanner;

enum UserRole {
    USER, ADMIN;
}

class FoodItems {
    private String dish;
    private float calories;
    private double servingSize;
    private int quantity;

    public FoodItems(String dish, float calories, double servingSize, int quantity) {
        this.dish = dish;
        this.calories = calories;
        this.servingSize = servingSize;
        this.quantity = quantity;
    }

    public String getDish() {
        return dish;
    }

    public float getCalories() {
        return calories;
    }

    public double getServingSize() {
        return servingSize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
            System.out.println("One " + dish + " has been selected. Remaining quantity: " + quantity);
        } else {
            System.out.println("Sorry, " + dish + " is out of stock.");
        }
    }
}

class User {
    private String username;
    private String password;
    private UserRole role;

    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }
}

class AuthService {
    public User login(String username, String password) {

        if (username.equals("admin") && password.equals("admin")) {
            return new User(username, password, UserRole.ADMIN);
        } else if (username.equals("user") && password.equals("user")) {
            return new User(username, password, UserRole.USER);
        } else {
            return null;
        }
    }
}

public class FoodTracker {
    private static FoodItems food1 = new FoodItems("Pizza", 300.5f, 150.0, 5);
    private static FoodItems food2 = new FoodItems("Salad", 150.2f, 100.0, 3);
    private static FoodItems food3 = new FoodItems("Burger", 500.0f, 200.0,5);
    private static FoodItems food4 = new FoodItems("Pasta", 400.8f, 180.0,4);
    private static FoodItems food5 = new FoodItems("Sushi", 250.3f, 120.0,6);
    private static FoodItems food6 = new FoodItems("Sandwich", 200.0f, 110.0,8);
    private static FoodItems food7 = new FoodItems("Steak", 600.7f, 250.0,8);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AuthService authService = new AuthService();
    

        System.out.print("Enter the user name:");
        String username = sc.nextLine();
        System.out.print("Enter the password:");
        String password = sc.nextLine();

        User user = authService.login(username, password);
        if (user != null) {
            if (user.getRole() == UserRole.USER) {
                System.out.println("Welcome, User!");

                
                displayFoodItemsForUser(sc);

                System.out.println("Enter the name of the food you want to select:");
                String selectedFood = sc.nextLine();
                processFoodSelection(selectedFood);
            } else if (user.getRole() == UserRole.ADMIN) {
                System.out.println("Welcome, Admin!");

                
            }
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void displayFoodItemsForUser(Scanner sc) {
        System.out.println("Food items for User:");
        System.out.println(food1.getDish() + ": Calories - " + food1.getCalories() + ", Serving Size - " + food1.getServingSize() + ", Quantity - " + food1.getQuantity());
        System.out.println(food2.getDish() + ": Calories - " + food2.getCalories() + ", Serving Size - " + food2.getServingSize() + ", Quantity - " + food2.getQuantity());
        System.out.println(food3.getDish() + ": Calories - " + food3.getCalories() + ", Serving Size - " + food3.getServingSize() + ", Quantity - " + food3.getQuantity());
        System.out.println(food4.getDish() + ": Calories - " + food4.getCalories() + ", Serving Size - " + food4.getServingSize() + ", Quantity - " + food4.getQuantity());
        System.out.println(food5.getDish() + ": Calories - " + food5.getCalories() + ", Serving Size - " + food5.getServingSize() + ", Quantity - " + food5.getQuantity());
        System.out.println(food6.getDish() + ": Calories - " + food6.getCalories() + ", Serving Size - " + food6.getServingSize() + ", Quantity - " + food6.getQuantity());
        System.out.println(food7.getDish() +": Calories - " + food7.getCalories() + ", Serving Size - " + food7.getServingSize() + ", Quantity - " + food7.getQuantity());
    }

    private static void processFoodSelection(String selectedFood) {
        switch (selectedFood.toLowerCase()) {
            case "pizza":
                decreaseQuantity("Pizza");
                break;
            case "salad":
                decreaseQuantity("Salad");
                break;
            case "burger":
                decreaseQuantity("Burger");
                break;
            case "pasta":
                decreaseQuantity("Pasta");
                break;
            case "sushi":
                decreaseQuantity("Sushi");
                break;
            case "sandwich":
                decreaseQuantity("Sandwich");
                break;
            case "steak":
                decreaseQuantity("Steak");
                break;            
            default:
                System.out.println("Invalid food selection.");
        }
    }
    

    private static void decreaseQuantity(String foodName) {
        if (foodName.equals("Pizza")) {
            food1.decreaseQuantity();
        } else if (foodName.equals("Salad")) {
            food2.decreaseQuantity();
        }
        else if (foodName.equals("burger")) {
            food3.decreaseQuantity();
        }
        else if (foodName.equals("pasta")) {
            food4.decreaseQuantity();
        }
        else if (foodName.equals("Sushi")) {
            food5.decreaseQuantity();
        }
        else if (foodName.equals("Sandwich")) {
            food6.decreaseQuantity();
        }
        else if (foodName.equals("Steak")) {
            food7.decreaseQuantity();
        }
    }
}
