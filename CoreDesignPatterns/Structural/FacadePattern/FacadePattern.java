/*A Facade Pattern says that just "just provide a unified and simplified interface
 *to a set of interfaces in a subsystem, therefore it hides the complexities of the 
 *subsystem from the client".
 *
 *In other words, Facade Pattern describes a higher-level interface that makes the 
 *sub-system easier to use.
 *
 *Practically, every Abstract Factory is a type of Facade. 
*/
package CoreDesignPatterns.Structural.FacadePattern;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  

// Step 1: Create a MobileShop interface.
interface MobileShop {  
    public void modelNo();  
    public void price();  
}  
// Step 2: Create a Iphone implementation class that will implement Mobileshop interface.
class Iphone implements MobileShop {  
    @Override  
    public void modelNo() {  
        System.out.println(" Iphone 6 ");  
    }  
    @Override  
    public void price() {  
    System.out.println(" Rs 65000.00 ");  
    }  
}  
// Step 3: Create a Samsung implementation class that will implement Mobileshop interface.
class Samsung implements MobileShop {  
    @Override  
    public void modelNo() {  
    System.out.println(" Samsung galaxy tab 3 ");  
    }  
    @Override  
    public void price() {  
        System.out.println(" Rs 45000.00 ");  
    }  
}  
// Step 4: Create a Blackberry implementation class that will implement Mobileshop interface .
class Blackberry implements MobileShop {  
    @Override  
    public void modelNo() {  
    System.out.println(" Blackberry Z10 ");  
    }  
    @Override  
    public void price() {  
        System.out.println(" Rs 55000.00 ");  
    }  
}  
// Step 5: Create a ShopKeeper concrete class that will use MobileShop interface.
class ShopKeeper {  
    private MobileShop iphone;  
    private MobileShop samsung;  
    private MobileShop blackberry;  
      
    public ShopKeeper(){  
        iphone= new Iphone();  
        samsung=new Samsung();  
        blackberry=new Blackberry();  
    }  
    public void iphoneSale(){  
        iphone.modelNo();  
        iphone.price();  
    }  
        public void samsungSale(){  
        samsung.modelNo();  
        samsung.price();  
    }  
   public void blackberrySale(){  
    blackberry.modelNo();  
    blackberry.price();  
        }  
}  
// Step 6: Now, Creating a client that can purchase the mobiles from MobileShop through ShopKeeper.
public class FacadePattern {
    private static int  choice;  
    public static void main(String args[]) throws NumberFormatException, IOException{  
        do{       
            System.out.print("========= Mobile Shop ============ \n");  
            System.out.print("            1. IPHONE.              \n");  
            System.out.print("            2. SAMSUNG.              \n");  
            System.out.print("            3. BLACKBERRY.            \n");  
            System.out.print("            4. Exit.                     \n");  
            System.out.print("Enter your choice: ");  
              
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
            choice=Integer.parseInt(br.readLine());  
            ShopKeeper sk=new ShopKeeper();  
              
            switch (choice) {  
            case 1:  
                {   
                  sk.iphoneSale();  
                    }  
                break;  
       case 2:  
                {  
                  sk.samsungSale();        
                    }  
                break;    
       case 3:  
                           {  
                           sk.blackberrySale();       
                           }  
                   break;     
            default:  
            {    
                System.out.println("Nothing You purchased");  
            }         
                return;  
            }  
              
      }while(choice!=4);  
   }  
}
