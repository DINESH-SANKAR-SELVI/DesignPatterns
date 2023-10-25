/*
 *A Factory Pattern or Factory Method Pattern says that just define an interface or abstract class 
 *for creating an object but let the subclasses decide which class to instantiate. 
 *In other words, subclasses are responsible to create the instance of the class.
 *
 *The Factory Method Pattern is also known as Virtual Constructor.
*/
package Creational.FactoryPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//                              Calculate Electricity Bill

// Step 1: Create a Plan abstract class.
abstract class Plan{  
    protected double rate;  
    abstract void getRate();  

    public void calculateBill(int units){  
         System.out.println(units*rate);  
     }  
}
// Step 2: Create the concrete classes that extends Plan abstract class.
class  DomesticPlan extends Plan{  
    
    // @override  
     public void getRate(){  
         rate=3.50;              
    }  
}
class  CommercialPlan extends Plan{  
   //@override   
    public void getRate(){   
        rate=7.50;  
   }  
}
class  InstitutionalPlan extends Plan{  
   //@override  
    public void getRate(){   
        rate=5.50;  
   }   
}
// Step 3: Create a GetPlanFactory to generate object of concrete classes based on given information..
class GetPlanFactory{  
      
   //use getPlan method to get object of type Plan   
       public Plan getPlan(String planType){  
            if(planType == null){  
             return null;  
            }  
          if(planType.equalsIgnoreCase("DOMESTICPLAN")) {  
                 return new DomesticPlan();  
               }   
           else if(planType.equalsIgnoreCase("COMMERCIALPLAN")){  
                return new CommercialPlan();  
            }   
          else if(planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {  
                return new InstitutionalPlan();  
          }  
      return null;  
   }  
}
// Step 4: Generate Bill by using the GetPlanFactory to get the object of concrete classes by passing an information such as type of plan DOMESTICPLAN or COMMERCIALPLAN or INSTITUTIONALPLAN.
  
public class FactoryPattern {
    public static void main(String args[])throws IOException{  

        GetPlanFactory planFactory = new GetPlanFactory();  
        
        System.out.print("Enter the name of plan for which the bill will be generated: ");  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
        String planName=br.readLine();  
        System.out.print("Enter the number of units for bill will be calculated: ");  
        int units=Integer.parseInt(br.readLine());  
  
        Plan p = planFactory.getPlan(planName);  
        //call getRate() method and calculateBill()method of DomesticPaln.  
  
        System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");  
           p.getRate();  
           p.calculateBill(units);  
    }
}