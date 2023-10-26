/*
 *A Strategy Pattern says that "defines a family of functionality,
 *encapsulate each one, and make them interchangeable".
 *
 *The Strategy Pattern is also known as Policy.
 */
package CoreDesignPatterns.Behavioural.StrategyPattern;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;

//          Strategy Pattern

// Step 1: Create a Strategy interface.
interface Strategy {  
      
    public float calculation(float a, float b);  
  
}
// Step 2: Create a Addition class that will implement Startegy interface.
class Addition implements Strategy{  
  
    @Override  
    public float calculation(float a, float b) {  
        return a+b;  
    }  
  
}
// Step 3: Create a Subtraction class that will implement Startegy interface.
class Subtraction  implements Strategy{  
  
    @Override  
    public float calculation(float a, float b) {  
        return a-b;  
    }  
  
}
// Step 4: Create a Multiplication class that will implement Startegy interface.
class Multiplication implements Strategy{  
  
    @Override  
    public float calculation(float a, float b){  
        return a*b;  
    }  
}
// Step 5: Create a Context class that will ask from Startegy interface to execute the type of strategy.
class Context {  
  
       private Strategy strategy;  
       
       public Context(Strategy strategy){  
          this.strategy = strategy;  
       }  
  
       public float executeStrategy(float num1, float num2){  
          return strategy.calculation(num1, num2);  
       }  
}
// Step 6: Create a StartegyPatternDemo class.
public class StrategyPattern {  
      
    public static void main(String[] args) throws NumberFormatException, IOException {  
          
          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
          System.out.print("Enter the first value: ");  
          float value1=Float.parseFloat(br.readLine());  
          System.out.print("Enter the second value: ");  
          float value2=Float.parseFloat(br.readLine());  
          Context context = new Context(new Addition());          
          System.out.println("Addition = " + context.executeStrategy(value1, value2));  
  
          context = new Context(new Subtraction());       
          System.out.println("Subtraction = " + context.executeStrategy(value1, value2));  
  
          context = new Context(new Multiplication());        
          System.out.println("Multiplication = " + context.executeStrategy(value1, value2));  
       }  
  
}