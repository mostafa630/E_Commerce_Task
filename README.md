# 💰 E-Commerce Task Application

A Java-based e-commerce application demonstrating the use of Strategy Pattern for handling different product behaviors (expiration, shipping) dynamically.

## 📋 Prerequisites

Before running the application, ensure you have the following installed:

- **[JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)** or higher
- Code editor:
  - [Visual Studio Code](https://code.visualstudio.com/) with Java extensions, or
  - IDE such as [IntelliJ IDEA](https://www.jetbrains.com/idea/), or
  - Any other Java-compatible development environment

## 🚀 Running the Application
   ```bash
   git clone https://github.com/mostafa630/E_Commerce_Task.git
   cd E_Commerce_Task
   cd src
   javac App.java
   java App
   ```
## 🧪 Code Sample
  ```java
 Product cheese = new Product("Cheese" , 10.0 , 5 ,
            new Expired(LocalDate.of(2026, 7, 8)), // expired product
            new Shipped(2.0) // needs to be shipped
         );

        Product biscuits = new Product("Biscuits" , 5.0 , 20 ,
            new Expired(LocalDate.of(2028, 10, 1)), 
            new NonShipped() 
        );

        Product tv = new Product("TV" , 5000.0 , 10 ,
            new NonExpired(), 
            new Shipped(20.0) 
        );

        // Create user and add products to the cart
        User user = new models.User("Mostafa Younis", 6000.0);
        user.addToCart(cheese, 2); 
        user.addToCart(biscuits, 3);
        user.addToCart(tv, 1); // this product will be shipped

        // Checkout and handle exceptions
        try {
            CheckoutServices.checkout(user);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

```
## ✅ Sample Output 
```bash
                     #  Net Price Info  #
Product Name: Cheese
Unit Price: 10.0 $
Required Quantity: 2
Total Price for this Item: 20.0 $
------------------------------------------------------------------------------
Product Name: Biscuits
Unit Price: 5.0 $
Required Quantity: 3
Total Price for this Item: 15.0 $
------------------------------------------------------------------------------
Product Name: TV
Unit Price: 5000.0 $
Required Quantity: 1
Total Price for this Item: 5000.0 $
------------------------------------------------------------------------------
                   #   Shipping Item Info #
Product Name: Cheese
Unit Weight: 2.0 kg
shipped Price for each 1 KG:  3.5 $
Required Quantity: 2
Total Weight: 4.0 kg
Shipping Cost: 14.0 $
------------------------------------------------------------------------------
Product Name: TV
Unit Weight: 20.0 kg
shipped Price for each 1 KG:  3.5 $
Required Quantity: 1
Total Weight: 20.0 kg
Shipping Cost: 70.0 $
------------------------------------------------------------------------------
                   #  User Name : Mostafa Younis  #
- Net Cart Price : 5035.0
- shipping price: 84.0
- Total Price : 5119.0

Balance Before Shopping : 6000.0
Balance After Shopping : 881.0
```
## 🧠 Approach
  * I choose to use the  **[Strategy Pattern](w)** pattern  due its great use in situations when we need to 
    add behaviour in the run time and in our case the behaviour of the product in real life 
    will be determined in the run time by the Manager of the store
  
  * I use Strategy Patter and I prefer in this case using **[Composition over Inheritance ](w)**
    because I want to add the behaviour of the product in the run time and I don't want to create a class
    for each product type I want to create a class for each behaviour and then inject it into the product
    so that will give me the chance to add new options rather than Expireable or Shippable or both of them
    without the need to create a new class for each product type , just create a new strategy class
    and inject it into the product. (For Scalability and Flexibility)
  
  
  * To Add item to the Stock I can make it purely happen in the Runtime by using the Factory pattern
    and based on choices the Manager of the store will make, the product will be created with the
    required strategies.

  * but for the sake of simplicity I will just create the products in the code and assume that some of them
    are expired and some of them need to be shipped and some of them are not.  (imagine that Manager choose that)



