/*
 *An Interpreter Pattern says that "to define a representation of 
 *grammar of a given language, along with an interpreter that uses this
 *representation to interpret sentences in the language".
 */
package CoreDesignPatterns.Behavioural.InterpreterPattern;

import java.util.Stack; 

//          Interpreter Pattern

// Step 1: Create a Pattern interface.
interface Pattern {  
    public String conversion(String exp);  
}  
// Step 2: Create a InfixToPostfixPattern class that will allow what kind of pattern you want to convert.
class InfixToPostfixPattern implements Pattern{
	
	@Override
	public String conversion(String exp) {
		
		int priority = 0;// for the priority of operators.
		
        String postfix = "";

        Stack<Character> s1 = new Stack<Character>();

        for (int i = 0; i < exp.length(); i++)
        {
           char ch = exp.charAt(i);
           if (ch == '+' || ch == '-' || ch == '*' || ch == '/'||ch=='%')
           {
              // check the precedence
              if (s1.size() <= 0)
                 s1.push(ch);
              else
              {
                 Character chTop = (Character) s1.peek();
                 if (chTop == '*' || chTop == '/')
                    priority = 1;
                 else
                    priority = 0;
                 if (priority == 1)
                 {
                    if (ch == '*' || ch == '/'||ch=='%')
                    {
                       postfix += s1.pop();
                       i--;
                    }
                    else
                    { // Same
                       postfix += s1.pop();
                       i--;
                    }
                 }
                 else
                 {
                    if (ch == '+' || ch == '-')
                    {
                       postfix += s1.pop();
                       s1.push(ch);
                    }
                    else
                       s1.push(ch);
                 }
              }
           }
           else
           {
              postfix += ch;
           }
        }
        int len = s1.size();
        for (int j = 0; j < len; j++)
           postfix += s1.pop();
        return postfix;	
	} 	
}
// Step 3: Create a InterpreterPatternClient class that will use InfixToPostfix Conversion.
public class InterpreterPattern{
    public static void main(String[] args) {  
            
        String infix = "a+b*c";  
              
        InfixToPostfixPattern ip=new InfixToPostfixPattern();  
              
        String postfix = ip.conversion(infix);  
        System.out.println("Infix:   " + infix);  
        System.out.println("Postfix: " + postfix);  
       }  
    
}