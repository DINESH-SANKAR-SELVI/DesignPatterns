/*
 *A State Pattern says that "the class behavior changes based on its state".
 *In State Pattern, we create objects which represent various states and a 
 *context object whose behavior varies as its state object changes.
 * 
 * The State Pattern is also known as Objects for States.
 */
package CoreDesignPatterns.Behavioural.StatePattern;

// Step 1: Create a Connection interface that will provide the connection to the Controller class.
interface Connection {  
  
       public void open();  
       public void close();  
       public void log();  
       public void update();  
}
// Step 2: Create an Accounting class that will implement to the Connection interface.
class Accounting implements Connection {  
      
       @Override  
       public void open() {  
          System.out.println("open database for accounting");  
       }  
       @Override  
       public void close() {  
          System.out.println("close the database");  
       }  
         
       @Override  
       public void log() {  
          System.out.println("log activities");  
       }  
         
       @Override  
       public void update() {  
           System.out.println("Accounting has been updated");  
       }  
}
// Step 3: Create a Sales class that will implement to the Connection interface.
class Sales implements Connection {  
      
      @Override  
       public void open() {  
          System.out.println("open database for sales");  
       }  
       @Override  
       public void close() {  
          System.out.println("close the database");  
       }  
         
       @Override  
       public void log() {  
          System.out.println("log activities");  
       }  
         
       @Override  
       public void update() {  
           System.out.println("Sales has been updated");  
       }  
  
}
// Step 4: Create a Sales class that will implement to the Connection interface.
class Management implements Connection {  
      
      @Override  
       public void open() {  
          System.out.println("open database for Management");  
       }  
       @Override  
       public void close() {  
          System.out.println("close the database");  
       }  
         
       @Override  
       public void log() {  
          System.out.println("log activities");  
       }  
         
       @Override  
       public void update() {  
           System.out.println("Management has been updated");  
       }  
  
}  
// Step 5: Create a Controller class that will use the Connection interface for connecting with different types of connection.
class Controller {  
      
       public static Accounting acct;  
       public static Sales sales;  
       public static Management management;  
         
       private static Connection con;  
         
       Controller() {  
           acct = new Accounting();  
           sales = new Sales();  
           management = new Management();  
       }  
      
       public void setAccountingConnection() {  
           con = acct;  
       }  
       public void setSalesConnection() {  
           con  = sales;  
       }  
       public void setManagementConnection() {  
           con  = management;  
       }  
       public void open() {  
           con .open();  
       }  
       public void close() {  
           con .close();  
       }  
       public void log() {  
           con .log();  
       }  
       public void update() {  
           con .update();  
       }    
}
// Step 6: Create a StatePatternDemo class.
public class StatePattern {  
  
       Controller controller;  
       StatePattern(String con) {  
          controller = new Controller();  
          //the following trigger should be made by the user  
          if(con.equalsIgnoreCase("management"))  
             controller.setManagementConnection();  
          if(con.equalsIgnoreCase("sales"))  
             controller.setSalesConnection();  
          if(con.equalsIgnoreCase("accounting"))  
                 controller.setAccountingConnection();  
          controller.open();  
          controller.log();  
          controller.close();  
          controller.update();  
       }  
         
       public static void main(String args[]) {  
           new StatePattern(args[0]);     
       }  
}