

//ChangeDP
//Assignment1
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class Check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        String ans = "Success";
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
            	opening_brackets_stack.push(new Bracket(next,position+1));
            }

            if (next == ')' || next == ']' || next == '}') {
            	try {
            		Bracket b = opening_brackets_stack.pop();
            		if(!b.Match(next)) {
            			ans = position +1 + "";
            			break;
            		}
            	}
                catch(EmptyStackException e) {
                		ans = position+1+"";
                		break;
                }
            }
        }
        if(ans.equals("Success")) {
	        while(!opening_brackets_stack.isEmpty()) {
	        	Bracket b = opening_brackets_stack.pop();
	        	ans = b.position+"";
	        }
        }
        System.out.println(ans);
        // Printing answer, write your code here
    }
}

