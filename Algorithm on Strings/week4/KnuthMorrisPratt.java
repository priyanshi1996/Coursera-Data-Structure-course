import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//Assignment1
public class KnuthMorrisPratt {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    // Find all the occurrences of the pattern in the text and return
    // a list of all positions in the text (starting from 0) where
    // the pattern starts in the text.
    public List<Integer> findPattern(String pattern, String text) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Implement this function yourself
        int patternLength= pattern.length();
        String str = pattern+"$"+text;
        int length = str.length();
        int[] arr = new int[length];
        computePrefix(str, arr);
        for(int i=0;i<length;i++) {
        	if(arr[i]==patternLength)
        		result.add(i-2*patternLength);
        }
        return result;
    }
    
    public void computePrefix(String pattern, int[] arr) {
    	int l = pattern.length();
    	int border = 0;
    	for(int i=1;i<l;i++) {
    		while(border>0 && pattern.charAt(border)!=pattern.charAt(i)) {
    			border = arr[border-1];
    		}
    		if(pattern.charAt(border)==pattern.charAt(i)) {
    			border++;
    		}
    		else
    			border = 0;
    		arr[i] = border;
    	}
    	
    }

    static public void main(String[] args) throws IOException {
        new KnuthMorrisPratt().run();
    }

    public void print(List<Integer> x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String pattern = scanner.next();
        String text = scanner.next();
        List<Integer> positions = findPattern(pattern, text);
        print(positions);
    }
}
