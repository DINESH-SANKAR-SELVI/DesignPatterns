/*
 *In chain of responsibility, sender sends a request to a chain of objects.
 *The request can be handled by any object in the chain.
 *
 *A Chain of Responsibility Pattern says that just "avoid coupling the
 *sender of a request to its receiver by giving multiple objects a chance
 *to handle the request". For example, an ATM uses the Chain of Responsibility
 *design pattern in money giving process.
 *
 *In other words, we can say that normally each receiver contains reference 
 *of another receiver. If one object cannot handle the request then it passes
 *the same to the next receiver and so on. 
*/
package CoreDesignPatterns.Behavioural.ChainOfResponsibilityPattern;

//              ChainOf Responsibility


// Step 1: Create a Logger abstract class.
abstract class Logger {  
    public static int OUTPUTINFO=1;  
    public static int ERRORINFO=2;  
    public static int DEBUGINFO=3;  
    protected int levels;  
    protected Logger nextLevelLogger;  
    public void setNextLevelLogger(Logger nextLevelLogger) {  
        this.nextLevelLogger = nextLevelLogger;  
    }  
        public void logMessage(int levels, String msg){  
        if(this.levels<=levels){  
            displayLogInfo(msg);  
        }  
        if (nextLevelLogger!=null) {  
            nextLevelLogger.logMessage(levels, msg);  
        }  
    }  
    protected abstract void displayLogInfo(String msg);  
}  
// Step 2: Create a ConsoleBasedLogger class.
class ConsoleBasedLogger extends Logger {  
    public ConsoleBasedLogger(int levels) {  
        this.levels=levels;  
    }  
    @Override  
    protected void displayLogInfo(String msg) {  
        System.out.println("CONSOLE LOGGER INFO: "+msg);  
    }  
}  
// Step 3: Create a DebugBasedLogger class.
class DebugBasedLogger extends Logger {  
    public DebugBasedLogger(int levels) {  
        this.levels=levels;  
    }  
    @Override  
    protected void displayLogInfo(String msg) {  
        System.out.println("DEBUG LOGGER INFO: "+msg);  
    }  
}
// Step 4: Create a ErrorBasedLogger class.
class ErrorBasedLogger extends Logger {  
    public ErrorBasedLogger(int levels) {  
        this.levels=levels;  
    }  
    @Override  
    protected void displayLogInfo(String msg) {  
        System.out.println("ERROR LOGGER INFO: "+msg);  
    }  
}
// Step 5: Create a ChainOfResponsibilityClient class.
public class ChainOfResponsibilityPattern{
    private static Logger doChaining(){  
          Logger consoleLogger = new ConsoleBasedLogger(Logger.OUTPUTINFO);  
            
          Logger errorLogger = new ErrorBasedLogger(Logger.ERRORINFO);  
          consoleLogger.setNextLevelLogger(errorLogger);  
            
          Logger debugLogger = new DebugBasedLogger(Logger.DEBUGINFO);  
          errorLogger.setNextLevelLogger(debugLogger);  
            
          return consoleLogger;   
          }  
          public static void main(String args[]){  
          Logger chainLogger= doChaining();  
  
              chainLogger.logMessage(Logger.OUTPUTINFO, "Enter the sequence of values ");  
              chainLogger.logMessage(Logger.ERRORINFO, "An error is occured now");  
              chainLogger.logMessage(Logger.DEBUGINFO, "This was the error now debugging is compeled");  
              }      
}