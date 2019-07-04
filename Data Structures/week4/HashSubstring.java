//Assignment3

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;
    private static int multiplier = 263;
    private static int prime = 1000000007;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static List<Integer> getOccurrences(Data input) {
        String p = input.pattern, t = input.text;
        int lengthP = p.length(), lengthT = t.length();
        List<Integer> occurrences = new ArrayList<Integer>();
        long patternHash = computeHash(p);
        long[] H = new long[lengthT - lengthP + 1];
        precomputeHash(H,t, lengthT, lengthP);
        for(int i=0;i<=lengthT-lengthP;i++) {
        	if(H[i]==patternHash) {
        		if(p.equals(t.substring(i, i+lengthP)))
        			occurrences.add(i);
        	}
        }
        return occurrences;
    }
    
    private static long computeHash(String str) {
    	long hash = 0;
        for (int i = str.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + str.charAt(i)) % prime;
        return hash;
    }

    private static long[] precomputeHash(long[] H,String text,int lengthT, int lengthP) {
    	H[lengthT-lengthP] = computeHash(text.substring(lengthT-lengthP));
    	long power = power(multiplier,lengthP);
    	for(int i=lengthT-lengthP-1;i>=0;i--) {
    		H[i] = (text.charAt(i) + (multiplier * H[i+1])%prime - (text.charAt(i+lengthP)*power)%prime + prime)%prime;
    	}
    	return H;
    }
    
    private static long power(int x,int p) {
    	long res=1;
    	for(int i=1;i<=p;i++)
    		res = (res *x)%prime;
    	return res%prime;
    }
    
    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

