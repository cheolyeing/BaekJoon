import java.io.*;
import java.util.Stack;

public class N1918 {
	static String s;
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(inf2postf(s));
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
	}
	
	private static String inf2postf(String infix) {

        String postfix = "";
        Stack<Character> operator = new Stack<Character>();
        char popped;

        for (int i = 0; i < infix.length(); i++) {

            char get = infix.charAt(i);

            if (!isOperator(get))
                postfix += get;

            else if (get == ')')
                while ((popped = operator.pop()) != '(')
                    postfix += popped;

            else {
                while (!operator.isEmpty() && get != '(' && precedence(operator.peek()) >= precedence(get))
                    postfix += operator.pop();

                operator.push(get);
            }
        }
        // pop any remaining operator
        while (!operator.isEmpty())
            postfix += operator.pop();

        return postfix;
    }

    private static boolean isOperator(char i) {
        return precedence(i) > 0;
    }

    private static int precedence(char i) {

        if (i == '(' || i == ')') return 1;
        else if (i == '-' || i == '+') return 2;
        else if (i == '*' || i == '/') return 3;
        else return 0;
    }
	/*static String postfix(String s) {

		int open = 0;
		int close = 0;
		
		for (int i=1; i<s.length()-1; i++) {
			if(s.charAt(i)=='(') open++;
			else if(s.charAt(i)==')') {
				close++;
			}
			else if(isOperator(s.charAt(i)) && open==close) {
				return postfix(postfix(s.substring(1, i)), s.charAt(i), postfix(s.substring(i+1, s.length()-1)));
			}
		}
		return s;
	}
	
	static String postfix(String operand1, char operator, String operand2) {
		return operand1+operand2+operator;
	}
	
	static String binding(String s) {
		for (int i=0; i<s.length(); i++) {
			
		}
	}
	
	static boolean binded(String s, int idx) {
		int bef = idx-1, aft = idx+1;
		while(true) {
			if(aft==s.length()) return false;
			if(s.charAt(aft)==')') break;
			if(isOperator(s.charAt(aft++))) return false;
		}
		
		while(true) {
			if(bef<0) return false;
			if(s.charAt(bef--)=='(') break;
			if(isOperator(s.charAt(bef--))) return false;
		}
		
		return true;
	}
	
	
	static boolean isOpen(char c) {
		return c =='(';
	}
	
	static boolean isClose(char c) {
		return c == ')';
	}
	
	static boolean isOperator(char c) {
		return 41<(int)c && (int)c<48;
	}
	
	static boolean isAlpha(char c) {
		return 64<(int)c && (int)c<91;
	}*/
}