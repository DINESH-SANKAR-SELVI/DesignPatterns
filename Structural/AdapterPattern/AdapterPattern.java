/*
 *An Adapter Pattern says that just "converts the interface of a class 
 *into another interface that a client wants".
 *
 *In other words, to provide the interface according to client 
 *requirement while using the services of a class with a different interface.
 *
 *The Adapter Pattern is also known as Wrapper. 
*/
package Structural.AdapterPattern;

import java.io.BufferedReader;  
import java.io.InputStreamReader;
//              CreditCard Purchase 

// Step 1: Create a CreditCard interface (Target interface).
interface CreditCard {  
    public void giveBankDetails();  
    public String getCreditCard();  
}
// Step 2: Create a BankDetails class (Adaptee class).
class BankDetails{  
    private String bankName;  
    private String accHolderName;  
    private long accNumber;  
      
    public String getBankName() {  
        return bankName;  
    }  
    public void setBankName(String bankName) {  
        this.bankName = bankName;  
    }  
    public String getAccHolderName() {  
        return accHolderName;  
    }  
    public void setAccHolderName(String accHolderName) {  
        this.accHolderName = accHolderName;  
    }  
    public long getAccNumber() {  
        return accNumber;  
    }  
    public void setAccNumber(long accNumber) {  
        this.accNumber = accNumber;  
    }  
}
// Step 3: Create a BankCustomer class (Adapter class).
class BankCustomer extends BankDetails implements CreditCard {  
 public void giveBankDetails(){  
  try{  
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
      
   System.out.print("Enter the account holder name :");  
   String customername=br.readLine();  
   System.out.print("\n");  
      
   System.out.print("Enter the account number:");  
   long accno=Long.parseLong(br.readLine());  
   System.out.print("\n");  
      
   System.out.print("Enter the bank name :");  
   String bankname=br.readLine();  
      
   setAccHolderName(customername);  
   setAccNumber(accno);  
   setBankName(bankname);  
   }catch(Exception e){  
        e.printStackTrace();  
   }  
  }  
  @Override  
  public String getCreditCard() {  
   long accno=getAccNumber();  
   String accholdername=getAccHolderName();  
   String bname=getBankName();  
          
   return ("The Account number "+accno+" of "+accholdername+" in "+bname+ " bank is valid and authenticated for issuing the credit card. ");  
  }  
}
// Step 4: Create a AdapterPatternDemo class (client class).
public class AdapterPattern {
    public static void main(String args[]){  
    
        CreditCard targetInterface=new BankCustomer();  
    
        targetInterface.giveBankDetails();  
        System.out.print(targetInterface.getCreditCard());  
 }       
}
