import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Assignment1
public class BurrowsWheelerTransform {
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

    int n;
    String BWT(String text) {
        StringBuilder result = new StringBuilder();

        // write your code here
        n = text.length();
        
        char[][] arr = new char[n][n];
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		int pos = (i+j)%n;
        		arr[i][j] = text.charAt(pos);
        	}
        }
        Arrays.sort(arr, new Comparator<char[]>() {

			@Override
			public int compare(char[] o1, char[] o2) {
				int i=0;
				while(i<n) {
					if(o1[i]<o2[i])
						return -1;
					else if(o1[i]>o2[i])
						return 1;
					i++;
				}
				return 1;
			}
		});
        for(int i=0;i<n;i++) {
        	result.append(arr[i][n-1]);
        }
        return result.toString();
    }

    static public void main(String[] args) throws IOException {
        new BurrowsWheelerTransform().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        System.out.println(BWT(text));
    }
}
