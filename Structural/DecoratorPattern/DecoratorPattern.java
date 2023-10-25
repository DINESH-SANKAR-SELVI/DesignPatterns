/*
 *A Decorator Pattern says that just "attach a flexible additional responsibilities
 *to an object dynamically".
 *
 *In other words, The Decorator Pattern uses composition instead of inheritance to 
 *extend the functionality of an object at runtime.
 *
 *The Decorator Pattern is also known as Wrapper. 
*/
package Structural.DecoratorPattern;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;

// Step 1: Create a Food interface.
interface Food {  
    public String prepareFood();  
    public double foodPrice();  
}
// Step 2: Create a VegFood class that will implements the Food interface and override its all methods.
class VegFood implements Food {  
    public String prepareFood(){  
         return "Veg Food";  
    }    
    public double foodPrice(){  
        return 50.0;  
    }  
}  
// Step 3: Create a FoodDecorator abstract class that will implements the Food interface and override it's all methods and it has the ability to decorate some more foods.
abstract class FoodDecorator implements Food{  
    private Food newFood;  
    public FoodDecorator(Food newFood)  {  
        this.newFood=newFood;  
    }  
    @Override  
    public String prepareFood(){  
        return newFood.prepareFood();   
    }  
    public double foodPrice(){  
        return newFood.foodPrice();  
    }  
}  
// Step 4:Create a NonVegFood concrete class that will extend the FoodDecorator class and override it's all methods.
class NonVegFood extends FoodDecorator{    
    public NonVegFood(Food newFood) {  
        super(newFood);  
    }  
    public String prepareFood(){  
        return super.prepareFood() +" With Roasted Chiken and Chiken Curry  ";   
    }  
    public double foodPrice()   {  
        return super.foodPrice()+150.0;  
    }  
}  
// Step 5: Create a ChineeseFood concrete class that will extend the FoodDecorator class and override it's all methods.
class ChineeseFood extends FoodDecorator{  
  public ChineeseFood(Food newFood)    {  
        super(newFood);  
  }  
    public String prepareFood(){  
        return super.prepareFood() +" With Fried Rice and Manchurian  ";   
    }  
    public double foodPrice()   {  
        return super.foodPrice()+65.0;  
        }  
}  
// Step 6: Create a DecoratorPatternCustomer class that will use Food interface to use which type of food customer wants means (Decorates).
public class DecoratorPattern {
    private static int  choice;  
    public static void main(String args[]) throws NumberFormatException, IOException    {  
       do{        
        System.out.print("========= Food Menu ============ \n");  
        System.out.print("            1. Vegetarian Food.   \n");  
        System.out.print("            2. Non-Vegetarian Food.\n");  
        System.out.print("            3. Chineese Food.         \n");  
        System.out.print("            4. Exit                        \n");  
        System.out.print("Enter your choice: ");  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));   
        choice=Integer.parseInt(br.readLine());  
        switch (choice) {  
        case 1:{   
                 VegFood vf=new VegFood();  
              System.out.println(vf.prepareFood());  
              System.out.println( vf.foodPrice());  
            }  
            break;  
              
                case 2:{  
                Food f1=new NonVegFood((Food) new VegFood());  
                    System.out.println(f1.prepareFood());  
                System.out.println( f1.foodPrice());  
        }  
            break;    
     case 3:{  
             Food f2=new ChineeseFood((Food) new VegFood());  
                     System.out.println(f2.prepareFood());  
                    System.out.println( f2.foodPrice());  
              }  
            break;    
              
         default:{    
            System.out.println("Other than these no food available");  
        }         
    return;  
     }//end of switch  
          
}while(choice!=4);  
    }
}
