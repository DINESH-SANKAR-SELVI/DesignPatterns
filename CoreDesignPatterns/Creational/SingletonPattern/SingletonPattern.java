/*Singleton Pattern says that just"define a class that has only one instance 
 *and provides a global point of access to it".
 *
 *In other words, a class must ensure that only single instance should be created and single object can be used by all other classes.
 *
 *There are two forms of singleton design pattern
 *
 *Early Instantiation: creation of instance at load time.
 *Lazy Instantiation: creation of instance when required.
*/
package CoreDesignPatterns.Creational.SingletonPattern;


import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;

//                    singleton design pattern using early instantiation.
class B{  
 private static B obj=new B();//Early, instance will be created at load time  
 private B(){}  
   
 public static B getB(){  
  return obj;  
 }  
  
 public void doSomething(){  
 //write your code  
 }  
}  
//                   singleton design pattern using lazy instantiation.

/*class A{  
    private static A obj;  
    private A(){}  
      
    public static A getA(){  
      if (obj == null){  
         synchronized(Singleton.class){  
           if (obj == null){  
               obj = new Singleton();//instance will be created at request time  
           }  
       }              
       }  
     return obj;  
    }  
     
    public void doSomething(){  
    //write your code  
    }  
   }*/  

/*
 *If singleton class is Serializable, you can serialize the singleton instance. Once it is serialized, you can deserialize it but it will not return the singleton object.
 *
 *To resolve this issue, you need to override the readResolve() method that enforces the singleton. It is called just after the object is deserialized. It returns the singleton object.
*/
   /*public class A implements Serializable {  
        //your code of singleton  
        protected Object readResolve() {  
            return getA();  
        }  
  
    }*/  
   
// Assumption: you have created a table userdata that has three fields uid, uname and upassword in mysql database. Database name is ashwinirajput, username is root, password is ashwini.

class JDBCSingleton {  
     //Step 1  
      // create a JDBCSingleton class.  
     //static member holds only one instance of the JDBCSingleton class.  
             
         private static JDBCSingleton jdbc;  
           
     //JDBCSingleton prevents the instantiation from any other class.  
       private JDBCSingleton() {  }  
        
    //Now we are providing gloabal point of access.  
         public static JDBCSingleton getInstance() {    
                                     if (jdbc==null)  
                                   {  
                                            jdbc=new  JDBCSingleton();  
                                   }  
                         return jdbc;  
             }  
            
   // to get the connection from methods like insert, view etc.   
          private static Connection getConnection()throws ClassNotFoundException, SQLException  
          {  
                
              Connection con=null;  
              Class.forName("com.mysql.jdbc.Driver");  
              con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ashwanirajput", "root", "ashwani");  
              return con;  
                
          }  
            
 //to insert the record into the database   
          public int insert(String name, String pass) throws SQLException  
          {  
              Connection c=null;  
                
              PreparedStatement ps=null;  
                
              int recordCounter=0;  
                
              try {  
                    
                      c=this.getConnection();  
                      ps=c.prepareStatement("insert into userdata(uname,upassword)values(?,?)");  
                      ps.setString(1, name);  
                      ps.setString(2, pass);  
                      recordCounter=ps.executeUpdate();  
                        
              } catch (Exception e) { e.printStackTrace(); } finally{  
                    if (ps!=null){  
                      ps.close();  
                  }if(c!=null){  
                      c.close();  
                  }   
              }  
             return recordCounter;  
          }  
  
//to view the data from the database        
      public  void view(String name) throws SQLException  
      {  
                Connection con = null;  
        PreparedStatement ps = null;  
        ResultSet rs = null;  
                  
                try {  
                      
                        con=this.getConnection();  
                        ps=con.prepareStatement("select * from userdata where uname=?");  
                        ps.setString(1, name);  
                        rs=ps.executeQuery();  
                        while (rs.next()) {  
                                  System.out.println("Name= "+rs.getString(2)+"\t"+"Paasword= "+rs.getString(3));      
                         
                        }  
                
          } catch (Exception e) { System.out.println(e);}  
          finally{  
                    if(rs!=null){  
                        rs.close();  
                    }if (ps!=null){  
                      ps.close();  
                  }if(con!=null){  
                      con.close();  
                  }   
                }  
      }  
        
     // to update the password for the given username  
      public int update(String name, String password) throws SQLException  {  
              Connection c=null;  
              PreparedStatement ps=null;  
                
              int recordCounter=0;  
              try {  
                      c=this.getConnection();  
                      ps=c.prepareStatement(" update userdata set upassword=? where uname='"+name+"' ");  
                      ps.setString(1, password);  
                      recordCounter=ps.executeUpdate();  
              } catch (Exception e) {  e.printStackTrace(); } finally{  
                      
                  if (ps!=null){  
                      ps.close();  
                  }if(c!=null){  
                      c.close();  
                  }   
               }  
             return recordCounter;  
          }  
            
// to delete the data from the database   
         public int delete(int userid) throws SQLException{  
              Connection c=null;  
              PreparedStatement ps=null;  
              int recordCounter=0;  
              try {  
                       c=this.getConnection();  
                      ps=c.prepareStatement(" delete from userdata where uid='"+userid+"' ");  
                      recordCounter=ps.executeUpdate();  
              } catch (Exception e) { e.printStackTrace(); }   
              finally{  
              if (ps!=null){  
                      ps.close();  
             }if(c!=null){  
                      c.close();  
              }   
           }  
             return recordCounter;  
          }  
 }
 //Singleton RealWorld Example 
public class SingletonPattern {
        static int count=1;  
    static int  choice;  
    public static void main(String[] args) throws IOException {  
          
        JDBCSingleton jdbc= JDBCSingleton.getInstance();  
          
          
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
   do{   
        System.out.println("DATABASE OPERATIONS");  
        System.out.println(" --------------------- ");  
        System.out.println(" 1. Insertion ");  
        System.out.println(" 2. View      ");  
        System.out.println(" 3. Delete    ");  
        System.out.println(" 4. Update    ");  
        System.out.println(" 5. Exit      ");  
          
        System.out.print("\n");  
        System.out.print("Please enter the choice what you want to perform in the database: ");  
          
        choice=Integer.parseInt(br.readLine());  
        switch(choice) {  
              
           case 1:{  
                    System.out.print("Enter the username you want to insert data into the database: ");  
                    String username=br.readLine();  
                    System.out.print("Enter the password you want to insert data into the database: ");  
                    String password=br.readLine();  
                      
                    try {  
                            int i= jdbc.insert(username, password);  
                            if (i>0) {  
                            System.out.println((count++) + " Data has been inserted successfully");  
                            }else{  
                                System.out.println("Data has not been inserted ");      
                            }  
                          
                        } catch (Exception e) {  
                          System.out.println(e);  
                        }  
                      
                     System.out.println("Press Enter key to continue...");  
                     System.in.read();  
                       
                   }//End of case 1  
                   break;  
            case 2:{  
                    System.out.print("Enter the username : ");  
                    String username=br.readLine();  
               
                    try  {  
                            jdbc.view(username);  
                         } catch (Exception e) {  
                          System.out.println(e);  
                        }  
                     System.out.println("Press Enter key to continue...");  
                     System.in.read();  
                       
                   }//End of case 2  
                  break;  
             case 3:{  
                     System.out.print("Enter the userid,  you want to delete: ");  
                     int userid=Integer.parseInt(br.readLine());  
             
                     try {  
                            int i= jdbc.delete(userid);  
                            if (i>0) {  
                            System.out.println((count++) + " Data has been deleted successfully");  
                            }else{  
                                System.out.println("Data has not been deleted");      
                            }  
                          
                         } catch (Exception e) {  
                          System.out.println(e);  
                         }  
                     System.out.println("Press Enter key to continue...");  
                     System.in.read();  
                       
                    }//End of case 3  
                   break;  
             case 4:{  
                    System.out.print("Enter the username,  you want to update: ");  
                    String username=br.readLine();  
                    System.out.print("Enter the new password ");  
                    String password=br.readLine();  
                      
                    try {  
                            int i= jdbc.update(username, password);  
                            if (i>0) {  
                            System.out.println((count++) + " Data has been updated successfully");  
                            }  
                          
                        } catch (Exception e) {  
                          System.out.println(e);  
                        }  
                     System.out.println("Press Enter key to continue...");  
                     System.in.read();  
                      
                   }// end of case 4  
                 break;  
                   
             default:  
                     return;  
        }  
          
       } while (choice!=4);   
   }      
}
