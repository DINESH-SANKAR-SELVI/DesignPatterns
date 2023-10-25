/* A Bridge Pattern says that just "decouple the functional 
 *abstraction from the implementation so that the two can vary independently".
 *
 *The Bridge Pattern is also known as Handle or Body. 
*/
package Structural.BridgePattern;

import java.util.ArrayList;  
import java.util.List;  

//          Bridge Pattern 

// Step 1: Create a Question interface that provides the navigation from one question to another or vice-versa.
interface Question {  
    public void nextQuestion();  
    public void previousQuestion();  
    public void newQuestion(String q);  
    public void deleteQuestion(String q);  
    public void displayQuestion();  
    public void displayAllQuestions();  
}  
// Step 2: Create a JavaQuestions implementation class that will implement Question interface.
class JavaQuestions implements Question {  
 private List <String> questions = new ArrayList<String>();  
 private int current = 0;  
 public JavaQuestions(){  
    questions.add("What is class? ");  
    questions.add("What is interface? ");  
    questions.add("What is abstraction? ");  
    questions.add("How multiple polymorphism is achieved in java? ");  
    questions.add("How many types of exception  handling are there in java? ");  
    questions.add("Define the keyword final for  variable, method, and class in java? ");  
    questions.add("What is abstract class? ");  
    questions.add("What is multi-threading? ");  
 }  
 public void nextQuestion() {  
    if( current <= questions.size()-1 )  
    current++;  
    System.out.print(current);  
 }  
  
 public void previousQuestion() {  
    if( current > 0 )  
    current--;  
 }  
  
 public void newQuestion(String quest) {  
    questions.add(quest);  
 }  
  
 public void deleteQuestion(String quest) {  
    questions.remove(quest);  
 }  
  
 public void displayQuestion() {  
    System.out.println( questions.get(current) );  
 }  
 public void displayAllQuestions() {  
    for (String quest : questions) {  
    System.out.println(quest);  
 }  
}  
}
// Step 3: Create a QuestionManager class that will use Question interface which will act as a bridge..
class QuestionManager  {  
    protected Question q;  
    public String catalog;  
    public QuestionManager(String catalog) {  
    this.catalog=catalog;  
    }  
    public void next() {  
    q.nextQuestion();  
    }  
    public void previous() {  
    q.previousQuestion();  
    }  
    public void newOne(String quest) {  
    q.newQuestion(quest);  
    }  
    public void delete(String quest) {  
    q.deleteQuestion(quest);  
    }  
    public void display() {  
    q.displayQuestion();  
    }  
    public void displayAll() {  
        System.out.println("Question Paper: " + catalog);  
    q.displayAllQuestions();  
    }  
}
// Step 4: Create a QuestionFormat class that will extend the QuestionManager class
class QuestionFormat extends QuestionManager {  
    public QuestionFormat(String catalog){  
        super(catalog);  
    }  
    public void displayAll() {  
        System.out.println("\n---------------------------------------------------------");  
        super.displayAll();  
        System.out.println("-----------------------------------------------------------");  
    }  
}
// Step 5: Create a BridgePatternDemo class.
public class BridgePattern {
    public static void main(String[] args) {  
        QuestionFormat questions = new QuestionFormat("Java Programming Language");  
        questions.q = new JavaQuestions();  
            questions.delete("what is class?");  
            questions.display();  
        questions.newOne("What is inheritance? ");  
        
        questions.newOne("How many types of inheritance are there in java?");  
        questions.displayAll();  
    }    
}
