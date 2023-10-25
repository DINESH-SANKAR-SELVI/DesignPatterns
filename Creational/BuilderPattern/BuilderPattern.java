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

import java.io.IOException;
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  

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

/*********You Have a Two Main so Hide One***********/

// public class BuilderPattern {
//     public static void main(String args[]){  
//         CDBuilder cdBuilder=new CDBuilder();  
//         CDType cdType1=cdBuilder.buildSonyCD();  
//         cdType1.showItems();  
       
//         CDType cdType2=cdBuilder.buildSamsungCD();  
//         cdType2.showItems();  
//       }    
// }

/***********************************ANOTHER EXAMPLE*************************************/

/*
 *We are considering a business case of pizza-hut where we can get different
 *varieties of pizza and cold-drink.
 *
 *Pizza can be either a Veg pizza or Non-Veg pizza of several types 
 *(like cheese pizza, onion pizza, masala-pizza etc) and will be of 4 sizes i.e. small, medium, large, extra-large.
 *
 *Cold-drink can be of several types (like Pepsi, Coke, Dew, Sprite, Fanta, Maaza, Limca, Thums-up etc.)
 *and will be of 3 sizes small, medium, large.
*/

// Step 1: Create an interface Item that represents the Pizza and Cold-drink.
interface  Item   
{  
   public String name();  
    public String size();  
    public float price();  
}
// Step 2:Create an abstract class Pizza that will implement to the interface Item.
abstract class Pizza implements Item{  
        @Override  
        public abstract float price();  
}   
// Step 3:Create an abstract class ColdDrink that will implement to the interface Item.
abstract class ColdDrink implements Item{  
 @Override  
 public abstract float price();  
}
// Step 4:Create an abstract class VegPizza that will extend to the abstract class Pizza.
abstract class VegPizza extends Pizza{  
    @Override  
    public abstract float price();  
    @Override  
    public abstract  String name();  
    @Override  
    public abstract  String size();  
}
// Step 5:Create an abstract class NonVegPizza that will extend to the abstract class Pizza.
abstract class NonVegPizza extends Pizza{  
    @Override  
    public abstract float price();  
    @Override  
    public abstract String name();  
    @Override  
    public abstract String size();  
}
// Step 6:Now, create concrete sub-classes SmallCheezePizza, MediumCheezePizza, LargeCheezePizza, ExtraLargeCheezePizza that will extend to the abstract class VegPizza.
class SmallCheezePizza extends VegPizza{  
    @Override  
    public float price() {  
        return 170.0f;  
    }  
    @Override  
    public String name() {  
        return "Cheeze Pizza";  
    }  
    @Override  
    public String size() {  
       return "Small size";  
    }    
}
class MediumCheezePizza extends VegPizza{  
    @Override  
    public float price() {  
       return  220.f;  
    }  
    @Override  
    public String name() {  
        return "Cheeze Pizza";  
    }  
    @Override  
    public String size() {  
     return "Medium Size";  
 }  
}
class LargeCheezePizza extends VegPizza{  
    @Override  
    public float price() {  
        return 260.0f;  
    }  
    @Override  
    public String name() {  
        return "Cheeze Pizza";  
    }  
    @Override  
    public String size() {  
        return "Large Size";  
    }  
}
class ExtraLargeCheezePizza extends VegPizza{  
    @Override  
    public float price() {  
        return 300.f;  
    }  
    @Override  
    public String name() {  
        return  "Cheeze Pizza";  
    }  
    @Override  
    public String size() {  
        return "Extra-Large Size";  
    }  
}
// Step 7:Now, similarly create concrete sub-classes SmallOnionPizza, MediumOnionPizza, LargeOnionPizza, ExtraLargeOnionPizza that will extend to the abstract class VegPizza.
class SmallOnionPizza extends VegPizza {  
    @Override  
    public float price() {  
        return 120.0f;  
    }  
    @Override  
    public String name() {  
        return  "Onion Pizza";  
    }  
    @Override  
    public String size() {  
       return  "Small Size";  
    }    
}
class MediumOnionPizza extends VegPizza {  
    @Override  
    public float price() {  
        return 150.0f;  
    }  
   @Override  
    public String name() {  
        return  "Onion Pizza";  
    }  
   @Override  
    public String size() {  
       return  "Medium Size";  
    }    
}
class LargeOnionPizza extends  VegPizza{  
    @Override  
    public float price() {  
        return 180.0f;  
    }  
    @Override  
    public String name() {  
         return "Onion Pizza";  
    }  
    @Override  
    public String size() {  
       return  "Large size";  
    }  
}
class ExtraLargeOnionPizza extends VegPizza {  
    @Override  
    public float price() {  
        return 200.0f;  
    }  
    @Override  
    public String name() {  
         return  "Onion Pizza";  
    }  
    @Override  
    public String size() {  
       return  "Extra-Large Size";  
    }  
}
// Step 8:Now, similarly create concrete sub-classes SmallMasalaPizza, MediumMasalaPizza, LargeMasalaPizza, ExtraLargeMasalaPizza that will extend to the abstract class VegPizza.
class SmallMasalaPizza extends VegPizza{  
    @Override  
    public float price() {  
        return 100.0f;  
    }  
    @Override  
    public String name() {  
        return  "Masala Pizza";  
    }  
    @Override  
    public String size() {  
       return  "Samll Size";  
    }  
}
class MediumMasalaPizza extends VegPizza {  
      
    @Override  
    public float price() {  
        return 120.0f;  
    }  
  
    @Override  
    public String name() {  
      
        return  "Masala Pizza";  
      
    }  
  
    @Override  
    public String size() {  
       return  "Medium Size";  
    }
}  
class LargeMasalaPizza extends  VegPizza{  
    @Override  
    public float price() {  
        return 150.0f;  
    }  
  
    @Override  
    public String name() {  
      
        return  "Masala Pizza";  
      
    }  
  
    @Override  
    public String size() {  
       return  "Large Size";  
    }  
} 
class ExtraLargeMasalaPizza extends VegPizza {  
    @Override  
    public float price() {  
        return 180.0f;  
    }  
  
    @Override  
    public String name() {  
      
        return  "Masala Pizza";  
      
    }  
  
    @Override  
    public String size() {  
       return  "Extra-Large Size";  
    }  
}

// Step 9:Now, create concrete sub-classes SmallNonVegPizza, MediumNonVegPizza, LargeNonVegPizza, ExtraLargeNonVegPizza that will extend to the abstract class NonVegPizza.
class SmallNonVegPizza extends NonVegPizza {  
  
    @Override  
    public float price() {  
        return 180.0f;  
    }  
  
    @Override  
    public String name() {  
       return "Non-Veg Pizza";  
    }  
  
    @Override  
    public String size() {  
        return "Samll Size";  
    }  
      
}
class MediumNonVegPizza extends NonVegPizza{  
      
    @Override  
    public float price() {  
        return 200.0f;  
    }  
  
    @Override  
    public String name() {  
       return "Non-Veg Pizza";  
    }  
  
    @Override  
    public String size() {  
        return "Medium Size";  
    }  
}
class LargeNonVegPizza extends NonVegPizza{  
      
    @Override  
    public float price() {  
        return 220.0f;  
    }  
  
    @Override  
    public String name() {  
       return "Non-Veg Pizza";  
    }  
  
    @Override  
    public String size() {  
        return "Large Size";  
    }  
      
}
class ExtraLargeNonVegPizza extends NonVegPizza {  
    @Override  
    public float price() {  
        return 250.0f;  
    }  
  
    @Override  
    public String name() {  
       return "Non-Veg Pizza";  
    }  
  
    @Override  
    public String size() {  
        return "Extra-Large Size";  
    }  
      
} 
// Step 10: Now, create two abstract classes Pepsi and Coke that will extend abstract class ColdDrink.
abstract class Pepsi extends ColdDrink {  
  
    @Override  
    public abstract  String name();  
  
    @Override  
    public abstract  String size();  
      
    @Override  
    public abstract  float price();   
      
}
abstract class Coke  extends ColdDrink {  
  
    @Override  
    public abstract  String name();  
  
    @Override  
    public abstract  String size();  
      
    @Override  
    public abstract  float price();   
      
}
//Step 11: Create concrete sub-classes SmallPepsi, MediumPepsi, LargePepsi that will extend to the abstract class Pepsi.
class SmallPepsi  extends Pepsi{  
  
    @Override  
    public String name() {  
       return "300 ml Pepsi";  
    }  
  
    @Override  
    public float price() {  
        return 25.0f;  
    }  
  
    @Override  
    public String size() {  
        return "Small Size";  
    }     
}
class MediumPepsi extends Pepsi {  
      
    @Override  
    public String name() {  
       return "500 ml Pepsi";  
    }  
  
    @Override  
    public String size() {  
        return "Medium Size";  
    }  
  
    @Override  
    public float price() {  
        return 35.0f;  
    }      
}
class LargePepsi extends Pepsi{  
    @Override  
    public String name() {  
       return "750 ml Pepsi";  
    }  
  
    @Override  
    public String size() {  
        return "Large Size";  
    }  
  
    @Override  
    public float price() {  
        return 50.0f;  
    }  
}

// Step 12:Now, create concrete sub-classes SmallCoke, MediumCoke, LargeCoke that will extend to the abstract class Coke.
class SmallCoke extends Coke{  
     
    @Override  
    public String name() {  
         return "300 ml Coke";    
    }  
  
    @Override  
    public String size() {  
         
        return "Small Size";  
    }  
  
    @Override  
    public float price() {  
      
        return  25.0f;  
    }  
 }
 class MediumCoke extends Coke{  
      
    @Override  
    public String name() {  
         return "500 ml Coke";    
    }  
  
    @Override  
    public String size() {  
         
        return "Medium Size";  
    }  
  
    @Override  
    public float price() {  
      
        return  35.0f;  
   }  
}
class LargeCoke extends Coke {  
     @Override  
    public String name() {  
         return "750 ml Coke";    
    }  
  
    @Override  
    public String size() {  
         
        return "Large Size";  
    }  
  
    @Override  
    public float price() {  
      
        return  50.0f;  
    }      
}
// Step 13:Create an OrderedItems class that are having Item objects defined above.
class OrderedItems {  
     
    List<Item> items=new ArrayList<Item>();  
      
    public void addItems(Item item){  
          
        items.add(item);  
    }  
    public float getCost(){  
          
        float cost=0.0f;  
            for (Item item : items) {  
                cost+=item.price();  
             }  
        return cost;  
    }  
    public void showItems(){  
          
        for (Item item : items) {  
            System.out.println("Item is:" +item.name());  
            System.out.println("Size is:" +item.size());  
            System.out.println("Price is: " +item.price());  
              
        }  
    }      
}
// Step 14:Create an OrderBuilder class that will be responsible to create the objects of OrderedItems class.
class OrderBuilder {  
    public OrderedItems preparePizza() throws IOException{  
          
        OrderedItems itemsOrder=new OrderedItems();  
         BufferedReader br =new BufferedReader(new InputStreamReader(System.in));  
          
        System.out.println(" Enter the choice of Pizza ");  
        System.out.println("============================");  
        System.out.println("        1. Veg-Pizza       ");  
        System.out.println("        2. Non-Veg Pizza   ");  
        System.out.println("        3. Exit            ");  
        System.out.println("============================");  
          
        int pizzaandcolddrinkchoice=Integer.parseInt(br.readLine());  
        switch(pizzaandcolddrinkchoice)  
        {  
           case 1:{  
                       
                     System.out.println("You ordered Veg Pizza");  
                     System.out.println("\n\n");  
                     System.out.println(" Enter the types of Veg-Pizza ");  
                     System.out.println("------------------------------");  
                     System.out.println("        1.Cheeze Pizza        ");  
                     System.out.println("        2.Onion Pizza        ");  
                     System.out.println("        3.Masala Pizza        ");  
                     System.out.println("        4.Exit            ");  
                     System.out.println("------------------------------");  
                                  int vegpizzachoice=Integer.parseInt(br.readLine());  
                     switch(vegpizzachoice)  
                     {  
                          case 1:  
                                {  
                                    System.out.println("You ordered Cheeze Pizza");  
                                      
                                    System.out.println("Enter the cheeze pizza size");  
                                    System.out.println("------------------------------------");  
                                    System.out.println("    1. Small Cheeze Pizza ");  
                                    System.out.println("    2. Medium Cheeze Pizza ");  
                                    System.out.println("    3. Large Cheeze Pizza ");  
                                    System.out.println("    4. Extra-Large Cheeze Pizza ");  
                                    System.out.println("------------------------------------");  
                                    int cheezepizzasize=Integer.parseInt(br.readLine());  
                                    switch(cheezepizzasize)  
                                        {  
                                              case 1:  
                                                   itemsOrder.addItems(new SmallCheezePizza());  
                                                   break;  
                                             case 2:  
                                                   itemsOrder.addItems(new MediumCheezePizza());  
                                                   break;    
                                             case 3:  
                                                   itemsOrder.addItems(new LargeCheezePizza());  
                                                   break;    
                                             case 4:  
                                                   itemsOrder.addItems(new ExtraLargeCheezePizza());  
                                                   break;
                                            default: 
                                                    break;
                                        }      
                                }
                                break;
                          case 2:  
                                {  
                                    System.out.println("You ordered Onion Pizza");  
                                    System.out.println("Enter the Onion pizza size");  
                                    System.out.println("----------------------------------");  
                                    System.out.println("    1. Small Onion Pizza ");  
                                    System.out.println("    2. Medium Onion Pizza ");  
                                    System.out.println("    3. Large Onion Pizza ");  
                                    System.out.println("    4. Extra-Large Onion Pizza ");  
                                    System.out.println("----------------------------------");  
                                    int onionpizzasize=Integer.parseInt(br.readLine());  
                                    switch(onionpizzasize)  
                                              {  
                                                  case 1:  
                                                   itemsOrder.addItems(new SmallOnionPizza());  
                                                   break;  
                                                      
                                                  case 2:  
                                                   itemsOrder.addItems(new MediumOnionPizza());  
                                                   break;    
                                                     
                                                  case 3:  
                                                   itemsOrder.addItems(new LargeOnionPizza());  
                                                   break;    
                                                        
                                                  case 4:  
                                                   itemsOrder.addItems(new ExtraLargeOnionPizza());  
                                                   break;        
                                                        
                                              }       
                                   }  
                                break;  
                          case 3:  
                                {  
                                    System.out.println("You ordered Masala Pizza");  
                                    System.out.println("Enter the Masala pizza size");  
                                    System.out.println("------------------------------------");  
                                    System.out.println("    1. Small Masala Pizza ");  
                                    System.out.println("    2. Medium Masala Pizza ");   
                                    System.out.println("    3. Large Masala Pizza ");  
                                    System.out.println("    4. Extra-Large Masala Pizza ");  
                                    System.out.println("------------------------------------");  
                                                  int masalapizzasize=Integer.parseInt(br.readLine());  
                                        switch(masalapizzasize)  
                                              {  
                                                  case 1:  
                                                   itemsOrder.addItems(new SmallMasalaPizza());  
                                                   break;  
                                                      
                                                  case 2:  
                                                   itemsOrder.addItems(new MediumMasalaPizza());  
                                                   break;    
                                                     
                                                  case 3:  
                                                   itemsOrder.addItems(new LargeMasalaPizza());  
                                                   break;    
                                                        
                                                  case 4:  
                                                   itemsOrder.addItems(new ExtraLargeMasalaPizza());  
                                                   break;        
                                                        
                                              }       
                                   
                                }  
                                break;      
                           
                     }      
                  
                   }  
                   break;// Veg- pizza choice completed.  
                  
            case 2:  
                   {  
                       System.out.println("You ordered Non-Veg Pizza");  
                       System.out.println("\n\n");  
                         
                                    System.out.println("Enter the Non-Veg pizza size");  
                                    System.out.println("------------------------------------");  
                                    System.out.println("    1. Small Non-Veg  Pizza ");  
                                    System.out.println("    2. Medium Non-Veg  Pizza ");  
                                    System.out.println("    3. Large Non-Veg  Pizza ");  
                                    System.out.println("    4. Extra-Large Non-Veg  Pizza ");  
                                    System.out.println("------------------------------------");  
                                      
                         
                       int nonvegpizzasize=Integer.parseInt(br.readLine());   
                        
                        switch(nonvegpizzasize)  
                             {  
                                 
                                  case 1:  
                                      itemsOrder.addItems(new SmallNonVegPizza());  
                                      break;  
                                                      
                                  case 2:  
                                      itemsOrder.addItems(new MediumNonVegPizza());  
                                      break;    
                                                     
                                  case 3:  
                                      itemsOrder.addItems(new LargeNonVegPizza());  
                                      break;    
                                                        
                                  case 4:  
                                      itemsOrder.addItems(new ExtraLargeNonVegPizza());  
                                      break;        
                              }  
                                      
                       }    
                        break;  
            default:  
            {  
                  break;  
                  
            }  
                  
 }//end of main Switch  
  
                    //continued?..  
        System.out.println(" Enter the choice of ColdDrink ");  
        System.out.println("============================");  
        System.out.println("        1. Pepsi            ");  
        System.out.println("        2. Coke             ");  
        System.out.println("        3. Exit             ");  
        System.out.println("============================");    
                    int coldDrink=Integer.parseInt(br.readLine());  
        switch (coldDrink)   
            {  
               case 1:  
                                {  
                                    System.out.println("You ordered Pepsi ");  
                                    System.out.println("Enter the  Pepsi Size ");  
                                    System.out.println("------------------------");  
                                    System.out.println("    1. Small Pepsi ");  
                                    System.out.println("    2. Medium Pepsi ");  
                                    System.out.println("    3. Large Pepsi ");  
                                    System.out.println("------------------------");  
                                              int pepsisize=Integer.parseInt(br.readLine());  
                                    switch(pepsisize)  
                                              {  
                                                  case 1:  
                                                   itemsOrder.addItems(new SmallPepsi());  
                                                   break;  
                                                      
                                                  case 2:  
                                                   itemsOrder.addItems(new MediumPepsi());  
                                                   break;    
                                                     
                                                  case 3:  
                                                   itemsOrder.addItems(new LargePepsi());  
                                                   break;    
                                                        
                                                }  
                                 }    
                                break;  
                         case 2:  
                                {  
                                    System.out.println("You ordered Coke");  
                                    System.out.println("Enter the Coke Size");  
                                    System.out.println("------------------------");  
                                    System.out.println("    1. Small Coke ");  
                                    System.out.println("    2. Medium Coke  ");  
                                    System.out.println("    3. Large Coke  ");  
                                    System.out.println("    4. Extra-Large Coke ");  
                                    System.out.println("------------------------");  
                                      
                                    int cokesize=Integer.parseInt(br.readLine());  
                                    switch(cokesize)  
                                              {  
                                                  case 1:  
                                                   itemsOrder.addItems(new SmallCoke());  
                                                   break;  
                                                      
                                                  case 2:  
                                                   itemsOrder.addItems(new MediumCoke());  
                                                   break;    
                                                     
                                                  case 3:  
                                                   itemsOrder.addItems(new LargeCoke());  
                                                   break;    
                                                        
                                                    
                                              }       
                                   
                                }  
                                break;  
                     default:  
                                      {  
                                                   break;  
                  
                                      }          
                           
                               }//End of the Cold-Drink switch  
                  return itemsOrder;  
  
          }
        }
// Step 15:Create a BuilderDemo class that will use the OrderBuilder class.
public class BuilderPattern {  
  
    public static void main(String[] args) throws IOException {  
        // TODO code application logic here  
          
        OrderBuilder builder=new OrderBuilder();  
          
        OrderedItems orderedItems=builder.preparePizza();  
          
        orderedItems.showItems();  
          
        System.out.println("\n");  
        System.out.println("Total Cost : "+ orderedItems.getCost());  
          
    }  
}// End of the BuilderDemo class  
