/* 
 *Prototype Pattern says that cloning of an existing object instead of 
 *creating new one and can also be customized as per the requirement.
 *
 *This pattern should be followed, if the cost of creating a 
 *new object is expensive and resource intensive.
*/
package CoreDesignPatterns.Creational.PrototypePattern;

import java.io.BufferedReader;  
import java.io.InputStreamReader;
import java.io.IOException;  

//  prototype design pattern

//Step 1: create blueprint for the class
interface Prototype {  
    public Prototype getClone();
}
//Step 2: make record data to copy and return new obj
class EmployeeRecord implements Prototype{  
      
    private int id;  
    private String name, designation;  
    private double salary;  
    private String address;  
      
    public EmployeeRecord(){  
        System.out.println("   Employee Records of Oracle Corporation ");  
        System.out.println("---------------------------------------------");  
        System.out.println("Eid"+"\t"+"Ename"+"\t"+"Edesignation"+"\t"+"Esalary"+"\t\t"+"Eaddress");  
      
    }  
    public  EmployeeRecord(int id, String name, String designation, double salary, String address) {        
        this();  
        this.id = id;  
        this.name = name;  
        this.designation = designation;  
        this.salary = salary;  
        this.address = address;  
    }  
      
    public void showRecord(){        
        System.out.println(id+"\t"+name+"\t"+designation+"\t"+salary+"\t"+address);  
    }  
  
    @Override  
    public Prototype getClone() {        
        return new EmployeeRecord(id,name,designation,salary,address);  
    }  
}

public class PrototypePattern {
    public static void main(String[] args) throws IOException {  
          
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));  
        System.out.print("Enter Employee Id: ");  
        int eid=Integer.parseInt(br.readLine());  
        System.out.print("\n");  
          
        System.out.print("Enter Employee Name: ");  
        String ename=br.readLine();  
        System.out.print("\n");  
          
        System.out.print("Enter Employee Designation: ");  
        String edesignation=br.readLine();  
        System.out.print("\n");  
          
        System.out.print("Enter Employee Address: ");  
        String eaddress=br.readLine();  
        System.out.print("\n");  
          
        System.out.print("Enter Employee Salary: ");  
        double esalary= Double.parseDouble(br.readLine());  
        System.out.print("\n");  
           
        EmployeeRecord e1=new EmployeeRecord(eid,ename,edesignation,esalary,eaddress);  
          
        e1.showRecord();  
        System.out.println("\n");  
        EmployeeRecord e2=(EmployeeRecord) e1.getClone();  
        e2.showRecord();  
    }
}
