/*
 *A Composite Pattern says that just "allow clients to operate in generic manner on 
 *objects that may or may not represent a hierarchy of objects". 
*/
package CoreDesignPatterns.Structural.CompositePattern;

import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.List; 

// Step 1: Create an Employee interface that will be treated as a component.
interface Employee {  
    public  int getId();  
    public String getName();  
    public double getSalary();  
       public void print();  
    public void add(Employee employee);  
       public void remove(Employee employee);  
       public Employee getChild(int i);  
}
// Step 2: Create a BankManager class that will be treated as a Composite and implements Employee interface.
class BankManager implements Employee {  
     private int id;  
     private String name;  
     private double salary;  
  
     public BankManager(int id,String name,double salary) {  
      this.id=id;      
      this.name = name;  
      this.salary = salary;  
     }  
         List<Employee> employees = new ArrayList<Employee>();  
     @Override  
     public void add(Employee employee) {  
        employees.add(employee);  
     }  
        @Override  
     public Employee getChild(int i) {  
      return employees.get(i);  
     }  
     @Override  
     public void remove(Employee employee) {  
      employees.remove(employee);  
     }    
     @Override  
     public int getId()  {  
      return id;  
     }  
     @Override  
     public String getName() {  
      return name;  
     }  
    @Override  
     public double getSalary() {  
      return salary;  
     }  
     @Override  
     public void print() {  
      System.out.println("==========================");  
      System.out.println("Id ="+getId());  
      System.out.println("Name ="+getName());  
      System.out.println("Salary ="+getSalary());  
      System.out.println("==========================");  
        
      Iterator<Employee> it = employees.iterator();  
        
          while(it.hasNext())  {  
            Employee employee = it.next();  
            employee.print();  
         }  
     }  
}
// Step 3: Create a Cashier class that will be treated as a leaf and it will implement to the Employee interface.
class Cashier implements Employee{  
    /* 
         In this class,there are many methods which are not applicable to cashier because 
         it is a leaf node. 
     */  
        private int id;  
            private String name;  
        private double salary;  
        public Cashier(int id,String name,double salary)  {  
            this.id=id;  
            this.name = name;  
            this.salary = salary;  
        }  
        @Override  
        public void add(Employee employee) {  
            //this is leaf node so this method is not applicable to this class.  
        }  
        @Override  
        public Employee getChild(int i) {  
            //this is leaf node so this method is not applicable to this class.  
            return null;  
        }  
        @Override  
        public int getId() {  
            // TODO Auto-generated method stub  
            return id;  
        }  
        @Override  
        public String getName() {  
            return name;  
        }  
        @Override  
        public double getSalary() {  
            return salary;  
        }  
        @Override  
        public void print() {  
            System.out.println("==========================");  
            System.out.println("Id ="+getId());  
            System.out.println("Name ="+getName());  
            System.out.println("Salary ="+getSalary());  
            System.out.println("==========================");  
        }  
        @Override  
        public void remove(Employee employee) {  
            //this is leaf node so this method is not applicable to this class.  
        }  
}  
// Step 4: Create a Accountant class that will also be treated as a leaf and it will implement to the Employee interface.
class Accountant implements Employee{  
/* 
    In this class,there are many methods which are not applicable to cashier because 
    it is a leaf node. 
*/  
    private int id;  
    private String name;  
    private double salary;  
   public Accountant(int id,String name,double salary)  {  
       this.id=id;  
       this.name = name;  
       this.salary = salary;  
   }  
   @Override  
   public void add(Employee employee) {  
       //this is leaf node so this method is not applicable to this class.  
   }  
   @Override  
   public Employee getChild(int i) {  
       //this is leaf node so this method is not applicable to this class.  
       return null;  
   }  
   @Override  
    public int getId() {  
        // TODO Auto-generated method stub  
        return id;  
   }  
   @Override  
   public String getName() {  
       return name;  
   }  
   @Override  
   public double getSalary() {  
       return salary;  
   }  
   @Override  
   public void print() {  
       System.out.println("=========================");  
       System.out.println("Id ="+getId());  
       System.out.println("Name ="+getName());  
       System.out.println("Salary ="+getSalary());  
       System.out.println("=========================");  
   }  
  @Override  
   public void remove(Employee employee) {  
       //this is leaf node so this method is not applicable to this class.  
   }  
}  
// Step 5: Create a CompositePatternDemo class that will also be treated as a Client and ii will use the Employee interface.
public class CompositePattern {
    public static void main(String args[]){  
         Employee emp1=new Cashier(101,"Sohan Kumar", 20000.0);  
         Employee emp2=new Cashier(102,"Mohan Kumar", 25000.0);  
         Employee emp3=new Accountant(103,"Seema Mahiwal", 30000.0);   
         Employee manager1=new BankManager(100,"Ashwani Rajput",100000.0);  
            
          manager1.add(emp1);  
          manager1.add(emp2);  
          manager1.add(emp3);  
          manager1.print();  
        }
}
