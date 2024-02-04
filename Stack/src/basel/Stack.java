package basel;

public class Stack {

    private int maxSize;
    private Object[] stackArray;// Holds the elements
    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new Object[maxSize];
        top = -1; //Empty stack
    }

    public void push(Object element){
    // Adds a new element to the top of the stack
        stackArray[++top] = element;
    }

    public Object pop(){
    // Removes and returns the stack's top element
        if (!isEmpty())
            return stackArray[top--];
        return null; //Empty stack
    }

    /*public Object peek(){
    // Return the top element without changing the stack
        if (!isEmpty())
            return stackArray[top];
        return null; //Empty stack
    }*/

    public int prec(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    public Object peek(){
    // Return the top element without changing the stack
        if (!isEmpty())
            return stackArray[top];
        return null; //Empty stack
    }

    public boolean isEmpty() {
        return (top == -1); // Returns true if stack is empty
    }

    public boolean isFull() {
        return (top == maxSize-1); // Returns true if stack is full
    }

    public int size() {
        return top + 1; // returns number of elements inside stack
    }

    public String infixToPostfix(String exp) {

        // initializing empty String for result
        StringBuilder result = new StringBuilder();

        // initializing empty stack
        Stack stack = new Stack(exp.length());

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result.append(c);

                // If the scanned character is an '(',
                // push it to the stack.
            else if (c == '(')
                stack.push(c);

                //  If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && !stack.peek().equals('('))
                    result.append(stack.pop());

                stack.pop();
            } else // an operator is encountered
            {
                while (!stack.isEmpty() && prec(c) <= prec((char) stack.peek())) {

                    result.append(stack.pop());
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek().equals('('))
                return "Invalid Expression";
            result.append(stack.pop());
        }
        return result.toString();

    }

    public String convert2Postfix(String infixExpr) {

        infixExpr=infixExpr.replace("cos","#");
        infixExpr=infixExpr.replace("sin","$");
        infixExpr=infixExpr.replace("tan","&");
        infixExpr=infixExpr.replace("LOG","L");
        infixExpr=infixExpr.replace("LN","N");


        Stack<Character> stack = new Stack<>();
        StringBuilder out = new StringBuilder(infixExpr.length());

        for (char c : chars)
        {
            if (isOperator(c)) {
                while (!stack.isEmpty() && !stack.peek().equals('(') )
                    if (operatorGreaterOrEqual((Character) stack.peek(), c))
                        out.append(stack.pop());
                    else
                        break;
                stack.push(c);
            }
            else if (c == '(')
                stack.push(c);

            else if (c == ')') {
                while (!stack.isEmpty() && !stack.peek().equals('('))
                    out.append(stack.pop());
                if (!stack.isEmpty())
                    stack.pop();
            }

            else if (isOperand(c))
                out.append(c);
        }

        while (!stack.isEmpty())
            out.append(stack.pop());

        String result=out.toString();
        result=result.replace("#","cos");
        result=result.replace("$","sin");
        result=result.replace("&","tan");
        result=result.replace("L","LOG");
        result=result.replace("N","LN");

        return result;
    }


    public double evaluatePostfix(String postfixExpr) {
        char[] chars = postfixExpr.toCharArray();
        Stack<Double> stack = new Stack<Double>();
        for (char c : chars) {
            if (isOperand(c))
                stack.push((double) (c - '0')); // convert char to int val
            else if (isOperator(c)) {
                double op1 = stack.pop();
                double op2 = stack.pop();
                double result;
                switch (c) {
                    case '*':
                        result = op1 * op2;
                        stack.push(result);
                        break;
                    case '/':
                        result = op2 / op1;
                        stack.push(result);
                        break;
                    case '+':
                        result = op1 + op2;
                        stack.push(result);
                        break;
                    case '-':
                        result = op2 - op1;
                        stack.push(result);
                        break;
                    case '^':
                        result = Math.pow(op2, op1);
                        stack.push(result);
                        break;
                    case '#':
                        result = Math.cos(op1);
                        stack.push(result);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public void balancedParentheses (String exp){

        Stack stack = new Stack(exp.length());

        for (int i = 0 ; i < exp.length();i++){
            if (exp.charAt(i) == '(' || exp.charAt(i) == '{'|| exp.charAt(i) == '['){
                char c = exp.charAt(i);
                stack.push(c);
            }
            else {
                if (exp.charAt(i) == ')' || exp.charAt(i) == '}' || exp.charAt(i) == ']'){
                    char ch = (char) stack.pop();
                    if(ch != '('){
                        System.out.println("Error");
                        break;
                    }
                }
            }
        }
        if (!stack.isEmpty()){
            System.out.println("invalid expression");
        }
        else {
            System.out.println("valid expression");
        }
    }
}
