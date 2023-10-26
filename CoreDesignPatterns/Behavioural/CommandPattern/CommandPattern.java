/*
 *A Command Pattern says that "encapsulate a request under an object
 *as a command and pass it to invoker object. Invoker object looks for the
 *appropriate object which can handle this command and pass the command to 
 *the corresponding object and that object executes the command".
 * 
 *It is also known as Action or Transaction.
*/
package CoreDesignPatterns.Behavioural.CommandPattern;

// Step 1: Create a ActionListernerCommand interface that will act as a Command.
interface ActionListenerCommand {  
    public void execute();  
}  
// Step 2: Create a Document class that will act as a Receiver.
class Document {  
          public void open(){  
           System.out.println("Document Opened");  
       }  
       public void save(){  
           System.out.println("Document Saved");  
       }  
}  
// Step 3: Create a ActionOpen class that will act as an ConcreteCommand.
class ActionOpen implements ActionListenerCommand{  
    private Document doc;  
    public ActionOpen(Document doc) {  
        this.doc = doc;  
    }  
    @Override  
    public void execute() {  
        doc.open();  
    }  
}  
// Step 4: Create a ActionSave class that will act as an ConcreteCommand.
class ActionSave implements ActionListenerCommand{  
   private Document doc;  
   public ActionSave(Document doc) {  
        this.doc = doc;  
    }  
    @Override  
    public void execute() {  
        doc.save();  
    }  
}  
// Step 5: Create a MenuOptions class that will act as an Invoker.
class MenuOptions {
	private ActionListenerCommand openCommand;
    private ActionListenerCommand saveCommand;
 
    public MenuOptions(ActionListenerCommand open, ActionListenerCommand save) {
        this.openCommand = open;
        this.saveCommand = save;
    }
    public void clickOpen(){
       openCommand.execute();
    }
    public void clickSave(){
      saveCommand.execute();
    }
}
// Step 6: Create a CommanPatternClient class that will act as a Client.
public class CommandPattern{
    public static void main(String[] args) {  
        Document doc = new Document();  
          
        ActionListenerCommand clickOpen = new ActionOpen(doc);  
        ActionListenerCommand clickSave = new ActionSave(doc);  
          
        MenuOptions menu = new MenuOptions(clickOpen, clickSave);  
          
        menu.clickOpen();  
        menu.clickSave();  
   }  
    
}