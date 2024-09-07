/* 
#Algorithm
1. Reverse the infix
2. Infix to postfix
3. Reverse that answer
*/

import java.util.Stack;

public class InfixToPrefixExp {
    private static StringBuilder convertBracket(StringBuilder s){

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                s.setCharAt(i, '(');
            }else if(s.charAt(i) == '('){
                s.setCharAt(i, ')');
            }
        }
        return s;
    }

    private static int priority(char ch){
        if(ch == '^'){
            return 3;
        }else if(ch == '*' || ch =='/'){
            return 2;
        }else if(ch == '+' || ch == '-'){
            return 1;
        }else{
            return -1;
        }
    }

    private static String infixToPrefix(String s){
        StringBuilder str = new StringBuilder(s);
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();

        str.reverse();

        str = convertBracket(str);

        // System.out.println(str.toString());

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                res.append(ch);
            }

            else if(ch == '('){
                st.push(ch);
            }            
            else if(ch == ')'){
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop();
            }

            else{
                if(ch == '^'){
                    while (!st.isEmpty() && priority(ch) <= priority(st.peek())) {
                        res.append(st.pop());    
                    }
                }else{
                    while(!st.isEmpty() && priority(ch) < priority(st.peek())){
                        res.append(st.pop());
                    }
                }  
                
                st.push(ch);
            }
        }

        while(!st.isEmpty()){
            res.append(st.pop());
        }

        res.reverse();

        return res.toString();

    }
    public static void main(String[] args) {
        String infix = "(a+b)*c-d+f";

        System.out.println(infixToPrefix(infix));
    }
}