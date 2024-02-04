package basel;

public class Main {

    public static void main(String[] args) {

        Stack stack = new Stack(25);

        String exp = "sin(4)+5*!2.4-(5^2+1){}";
        System.out.println(stack.infixToPostfix(exp));

        stack.balancedParentheses(exp);

        /*
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("1. Size of stack after push operations: " +
                stack.size());
        System.out.print("2. Pop elements from stack :\n ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println("\n3. Size of stack after pop operations : " +
                stack.size());*/
    }
}
