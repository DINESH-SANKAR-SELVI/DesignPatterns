/*
 *A Memento Pattern says that "to restore the state of an object
 *to its previous state". But it must do this without violating 
 *Encapsulation. Such case is useful in case of error or failure.
 * 
 * The Memento pattern is also known as Token.
 */
package CoreDesignPatterns.Behavioural.MementoPattern;

import java.util.ArrayList;  
import java.util.List;  

//          Memento Pattern

// Step 1: Create an Originator class that will use Memento object to restore its previous state.
class Originator {  
      
       private String state;  
      
       public void setState(String state){  
          this.state = state;  
       }  
      
       public String getState(){  
          return state;  
       }  
      
       public Memento saveStateToMemento(){  
          return new Memento(state);  
       }  
      
       public void getStateFromMemento(Memento Memento){  
          state = Memento.getState();  
       }  
}
// Step 2: Create a Memento class that will Store internal state of the Originator object.
class Memento {  
      
    private String state;  
  
    public Memento(String state) {  
        this.state=state;  
    }  
    public String getState() {  
        return state;  
    }        
}
// Step 3: Create a Caretaker class that will responsible for keeping the Memento.
class Caretaker {  
      
    private List<Memento> mementoList = new ArrayList<Memento>();  
  
       public void add(Memento state){  
          mementoList.add(state);  
       }  
  
       public Memento get(int index){  
          return mementoList.get(index);  
       }  
  
}
// Step 4: Create a MementoPatternDemo class.
public class MementoPattern{
    public static void main(String[] args) {  
          
          Originator originator = new Originator();  
            
          Caretaker careTaker = new Caretaker();  
            
          originator.setState("State #1");  
          careTaker.add(originator.saveStateToMemento());  
          originator.setState("State #2");  
          careTaker.add(originator.saveStateToMemento());  
          originator.setState("State #3");  
          careTaker.add(originator.saveStateToMemento());  
          originator.setState("State #4");  
  
          System.out.println("Current State: " + originator.getState());          
          originator.getStateFromMemento(careTaker.get(0));  
          System.out.println("First saved State: " + originator.getState());  
          originator.getStateFromMemento(careTaker.get(1));  
          System.out.println("Second saved State: " + originator.getState());  
          originator.getStateFromMemento(careTaker.get(2));  
          System.out.println("Third saved State: " + originator.getState());  
       }  
      
}