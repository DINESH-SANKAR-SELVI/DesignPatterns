/*
 * An Observer Pattern says that "just define a one-to-one dependency 
 * so that when one object changes state, all its dependents are notified
 *  and updated automatically".
 * 
 * The observer pattern is also known as Dependents or Publish-Subscribe.
 */
package CoreDesignPatterns.Behavioural.ObserverPattern;

  
// import java.util.Observable;  
// import java.util.Observer;  
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.*;  
      
//              Observer Pattern

// Step 1: Create a ResponseHandler1 class the will implement the java.util.Observer interface.
class ResponseHandler1 implements Observer {  
    private String resp;  
    public void update(Observable obj, Object arg) {  
        if (arg instanceof String) {  
            resp = (String) arg;  
            System.out.println("\nReceived Response: " + resp );  
        }  
    }  
}
// Step 2: Create a ResponseHandler2 class the will implement the java.util.Observer interface.
class ResponseHandler2 implements Observer {  
    private String resp;  
    public void update(Observable obj, Object arg) {  
        if (arg instanceof String) {  
            resp = (String) arg;  
            System.out.println("\nReceived Response: " + resp );  
        }  
    }  
}
// Step 3: Create an EventSource class that will extend the java.util.Observable class .
class ObserverPattern extends Observable implements Runnable {  
    @Override  
    public void run() {  
        try {  
            final InputStreamReader isr = new InputStreamReader(System.in);  
            final BufferedReader br = new BufferedReader(isr);  
            while (true) {  
                String response = br.readLine();  
                setChanged();  
                notifyObservers(response);  
            }  
        }  
        catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}