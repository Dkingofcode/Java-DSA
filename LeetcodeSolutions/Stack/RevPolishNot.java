package LeetcodeSolutions.Stack;

import java.util.Stack;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class RevPolishNot {
    
    private static final Set<String> OPERATORS = new HashSet<>(Arrays.asList("+", "-", "*", "/"));


    public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(OPERATORS.contains(token)){
                int y = stack.pop();
                int x = stack.pop();
                stack.push(eval(x, y, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }


    private int eval(int x, int y, String operator) {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'eval'");
         switch(operator){
            case "+" : return x + y;
            case "-" : return x - y;
            case "*" : return x * y;
            default: return x / y;
         }
    }


    // For clean code purpose, you can create an interface called Operator and map each operator string to the interface
    interface Operator{
        int eval(int x, int y);
    }


    private static final Map<String, Operator> OPERATORSS = new HashMap<String, Operator>(){{
        put("+", new Operator(){
            public int eval(int x, int y){
                return x + y;
            };
        });

        put("-", new Operator(){
            public int eval(int x, int y){
                return x - y;
            };
        });

        put("*", new Operator(){
            public int eval(int x, int y){
                return x * y;
            };
        });

        put("/", new Operator(){
            public int eval(int x, int y){
                return x / y;
            };
        });
    }};



    public int evalsRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(OPERATORSS.containsKey(token)){
                int y = stack.pop();
                int x = stack.pop();
                stack.push(OPERATORSS.get(token).eval(x, y));
            }else{
               stack.push(Integer.parseInt(token)); 
            }
        }
        return stack.pop();
    }

}
