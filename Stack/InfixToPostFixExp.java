import java.util.Stack;

public class InfixToPostFixExp {

    private static int priority(char ch){
        if(ch == '^'){
            return 3;
        }else if(ch == '*' || ch == '/'){
            return 2;
        }else{
            return 1;
        }
    }

    private static String infixToPostfix(String s){
        String res = "";
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (Character.isDigit(ch))){
                res += ch;
            }

            else if(ch == '('){
                st.push('(');
            }
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    res += st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && priority(ch) < priority(st.peek())){
                    res += st.pop();
                }

                st.push(ch);
            }

        }

        while (!st.isEmpty()) {
            res += st.pop();
        }

        return res;
    }
   
    public static void main(String[] args) {
        String s = "a+b*(c^d-e)";

        System.out.println(infixToPostfix(s));
    }
}
