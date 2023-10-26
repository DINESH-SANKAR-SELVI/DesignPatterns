/*
 * A Template Pattern says that "just define the skeleton 
 * of a function in an operation, deferring some steps to 
 * its subclasses".
 */
package CoreDesignPatterns.Behavioural.TemplatePattern;

//          Template Pattern

// Step 1: Create a Game abstract class.
abstract class Game {  
      
       abstract void initialize();  
       abstract void start();  
       abstract void end();  
      
       public final void play(){  
  
          //initialize the game  
          initialize();  
  
          //start game  
          start();  
            
          //end game  
          end();  
       }  
}
// Step 2: Create a Chess class that will extend Game abstract class for giving the definition to its method.
class Chess extends Game {  
     @Override  
       void initialize() {  
          System.out.println("Chess Game Initialized! Start playing.");  
       }  
     @Override  
       void start() {  
          System.out.println("Game Started. Welcome to in the chess game!");  
       }  
    @Override  
       void end() {  
          System.out.println("Game Finished!");  
       }  
}
// Step 3: Create a Soccer class that will extend Game abstract class for giving the definition to its method.
class Soccer extends Game {  
      
    @Override  
       void initialize() {  
          System.out.println("Soccer Game Initialized! Start playing.");  
       }  
  
    @Override  
       void start() {  
          System.out.println("Game Started. Welcome to in the Soccer game!");  
       }  
         
    @Override  
       void end() {  
          System.out.println("Game Finished!");  
       }  
}
// Step 4: Create a TemplatePatternDemo class.  
public class TemplatePattern{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {  
          
         Class c=Class.forName(args[0]);  
         Game game=(Game) c.newInstance();  
         game.play();     
    }    
}