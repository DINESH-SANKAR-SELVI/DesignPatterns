/*
 *Builder Pattern says that "construct a complex object from simple objects 
  *using step-by-step approach"
 *
 *It is mostly used when object can't be created in single step 
 *like in the de-serialization of a complex object.
*/
package Creational.BuilderPattern;

import java.util.ArrayList;
import java.util.List;

//                        simple example of builder design pattern

// Step 1: Create Packing interface
interface Packing {  
    public String pack();  
    public int price();  
}  
//  Step 2: Create 2 abstract classes CD and Company
abstract class CD implements Packing{  
    public abstract String pack();  
}
abstract class Company extends CD{  
   public abstract int price();  
}  
// Step 3: Create 2 implementation classes of Company: Sony and Samsung
 class Sony extends Company{  
    @Override  
        public int price(){   
                        return 20;  
      }  
    @Override  
    public String pack(){  
             return "Sony CD";  
        }         
}
class Samsung extends Company {  
    @Override  
        public int price(){   
                        return 15;  
    }  
    @Override  
    public String pack(){  
             return "Samsung CD";  
        }         
}
// Step 4: Create the CDType class
class CDType {  
             private List<Packing> items=new ArrayList<Packing>();  
             public void addItem(Packing packs) {    
                    items.add(packs);  
             }  
             public void getCost(){  
              for (Packing packs : items) {  
                        packs.price();  
              }   
             }  
             public void showItems(){  
              for (Packing packing : items){  
             System.out.print("CD name : "+packing.pack());  
             System.out.println(", Price : "+packing.price());  
          }       
            }     
}
// Step 5: Create the CDBuilder class
class CDBuilder {  
    public CDType buildSonyCD(){   
       CDType cds=new CDType();  
       cds.addItem(new Sony());  
       return cds;  
}  
public CDType buildSamsungCD(){  
CDType cds=new CDType();  
cds.addItem(new Samsung());  
return cds;  
}  
}


public class BuilderPattern {
    public static void main(String args[]){  
        CDBuilder cdBuilder=new CDBuilder();  
        CDType cdType1=cdBuilder.buildSonyCD();  
        cdType1.showItems();  
       
        CDType cdType2=cdBuilder.buildSamsungCD();  
        cdType2.showItems();  
      }    
}
