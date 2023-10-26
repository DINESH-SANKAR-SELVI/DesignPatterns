/*
 *According to GoF, Iterator Pattern is used "to access the elements
 *of an aggregate object sequentially without exposing its underlying 
 *implementation".
 *
 *The Iterator pattern is also known as Cursor.
*/
package CoreDesignPatterns.Behavioural.IteratorPattern;

// Step 1: Create a Iterartor interface.
interface Iterator {  
    public boolean hasNext();  
    public Object next();  
}  
// Step 2: Create a Container interface.
interface Container {  
    public Iterator getIterator();  
}
// Step 3: Create a CollectionofNames class that will implement Container interface.
class CollectionofNames implements Container {  
    public String name[]={"Ashwani Rajput", "Soono Jaiswal","Rishi Kumar","Rahul Mehta","Hemant Mishra"};   
        
    @Override  
    public Iterator getIterator() {  
        return new CollectionofNamesIterate() ;  
    }  
    private class CollectionofNamesIterate implements Iterator{  
        int i;  
        @Override  
        public boolean hasNext() {  
            if (i<name.length){  
                return true;  
            }  
            return false;  
        }  
        @Override  
        public Object next() {  
            if(this.hasNext()){  
                return name[i++];  
            }  
            return null;      
        }  
    }  
}  
// Step 4: Create a IteratorPatternDemo class.
public class IteratorPattern{
        public static void main(String[] args) {  
          CollectionofNames cmpnyRepository = new CollectionofNames();  
            
          for(Iterator iter = cmpnyRepository.getIterator(); iter.hasNext();){  
              String name = (String)iter.next();  
              System.out.println("Name : " + name);  
           }      
    }      
}