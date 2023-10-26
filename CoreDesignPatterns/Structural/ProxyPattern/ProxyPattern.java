/*Simply, proxy means an object representing another object.
 *
 *According to GoF, a Proxy Pattern "provides the control for accessing the original object".
 *
 *So, we can perform many operations like hiding the information of 
 *original object, on demand loading etc.
 *
 *Proxy pattern is also known as Surrogate or Placeholder. 
*/
package CoreDesignPatterns.Structural.ProxyPattern;


// Step 1: Create an OfficeInternetAccess interface.
interface OfficeInternetAccess {  
    public void grantInternetAccess();  
}  
// Step 2: Create a RealInternetAccess class that will implement OfficeInternetAccess interface for granting the permission to the specific employee.
class RealInternetAccess implements OfficeInternetAccess {  
    private String employeeName;  
    public RealInternetAccess(String empName) {  
        this.employeeName = empName;  
    }  
    @Override  
    public void grantInternetAccess() {  
        System.out.println("Internet Access granted for employee: "+ employeeName);  
    }  
}  
// Step 3: Create a ProxyInternetAccess class that will implement OfficeInternetAccess interface for providing the object of RealInternetAccess class.
class ProxyInternetAccess implements OfficeInternetAccess {  
           private String employeeName;  
           private RealInternetAccess  realaccess;  
               public ProxyInternetAccess(String employeeName) {  
            this.employeeName = employeeName;  
        }  
        @Override  
        public void grantInternetAccess()   
        {  
            if (getRole(employeeName) > 4)   
            {  
                realaccess = new RealInternetAccess(employeeName);  
                realaccess.grantInternetAccess();  
            }   
            else   
            {  
                System.out.println("No Internet access granted. Your job level is below 5");  
            }  
        }  
        public int getRole(String emplName) {  
            // Check role from the database based on Name and designation  
            // return job level or job designation.  
            return 9;  
        }  
}  
// Step 4: Now, Create a ProxyPatternClient class that can access the internet actually.
public class ProxyPattern {
    public static void main(String[] args)   
    {  
        OfficeInternetAccess access = new ProxyInternetAccess("Ashwani Rajput");  
        access.grantInternetAccess();  
    }      
}
