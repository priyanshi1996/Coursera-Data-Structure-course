
import java.util.*;
import java.io.*;
import java.util.zip.CheckedInputStream;

public class SuffixArrayLong {
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

    

    // Build suffix array of the string text and
    // return an int[] result of the same length as the text
    // such that the value result[i] is the index (0-based)
    // in text where the i-th lexicographically smallest
    // suffix of text starts.
    public int[] computeSuffixArray(String text) {
        int[] order = sortCharacters(text);
        int[] classes = computeCharClasses(text, order);
        int L = 1;
        int length = text.length();
        while(L<length) {
        	order = sortDoubled(text, L, order, classes);
        	classes = updateNewClasses(order, classes, L);
        	L = 2*L;
        }
        return order;
    }
    
    public int[] sortCharacters(String S) {
    	int length = S.length();
    	int[] order = new int[length];
    	int[] count = new int[5];
    	for(int i=0;i<length;i++)
    		count[charToIndex(S.charAt(i))] ++;
    	for(int i=1;i<5;i++)
    		count[i] = count[i]+count[i-1];
    	for(int i=length-1;i>=0;i--) {
    		char c = S.charAt(i);
    		count[charToIndex(c)]--;
    		order[count[charToIndex(c)]]=i;
    	}
    	return order;
    }
    
    public int[] computeCharClasses(String S, int[] order) {
    	int length = S.length();
    	int[] classes = new int[length];
    	classes[order[0]]=0;
    	for(int i=1;i<length;i++) {
    		if(S.charAt(order[i]) != S.charAt(order[i-1]))
    			classes[order[i]] = classes[order[i-1]]+1;
    		else
    			classes[order[i]] = classes[order[i-1]];
    	}
    	return classes;
    }
    
    public int[] sortDoubled(String S,int L, int[] order, int[] classes) {
    	int length = S.length();
    	int[] count = new int[length];
    	int[] newOrder = new int[length];
    	for(int i=0;i<length;i++)
    		count[classes[i]]++;
    	for(int i=1;i<length;i++)
    		count[i] = count[i]+count[i-1];
    	
    	for(int i=length-1;i>=0;i--) {
    		int start = (order[i]-L+length)%length;
    		int cl = classes[start];
    		count[cl]--;
    		newOrder[count[cl]] = start;
    	}
    	return newOrder;
    }
    
    public int[] updateNewClasses(int[] newOrder, int[] classes,int L) {
    	int n = newOrder.length;
    	int[] newClass = new int[n];
    	newClass[newOrder[0]] = 0;
    	for(int i=1;i<n;i++) {
    		int cur = newOrder[i];
    		int prev = newOrder[i-1];
    		int midCur = (cur+L)%n;
    		int midPrev = (prev+L)%n;
    		if(classes[cur]!=classes[prev] || classes[midCur]!=classes[midPrev])
    			newClass[cur] = newClass[prev]+1;
    		else
    			newClass[cur] = newClass[prev];
    	}
    	return newClass;
    }
    
    
    public int charToIndex(char ch) {
    	if(ch == '$')
    		return 0;
    	if(ch == 'A')
    		return 1;
    	if(ch == 'C')
    		return 2;
    	if(ch == 'G')
    		return 3;
    	else
    		return 4;
    }


    static public void main(String[] args) throws IOException {
        new SuffixArrayLong().run();
    }

    public void print(int[] x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        int[] suffix_array = computeSuffixArray(text);
        print(suffix_array);
    }
}
