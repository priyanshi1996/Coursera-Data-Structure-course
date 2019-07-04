import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Assignment2
public class InverseBWT {
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

    static int countA=0,countC=0,countG=0,countT=0;
    
    String inverseBWT(String bwt) {
        StringBuilder result = new StringBuilder();
        String lastCol = bwt;
        int len = lastCol.length();
        int i=0;
        int [] occurancesFirstCol = new int[len];
        int [] occurancesLastCol = new int[len];
        
        String firstCol = markLastOccurances(occurancesLastCol, lastCol, len);
        markFirstOccurances(occurancesFirstCol, firstCol, len);
//        System.out.println(countA+ " "+countC+" "+countG+" "+countT);
//        System.out.println(firstCol);
        while(true) {
        	char firstColSymbol = firstCol.charAt(i);
        	result.append(firstColSymbol);
        	char lastColSymbol = lastCol.charAt(i);
        	int lastColPos = occurancesLastCol[i];
        	if(lastColSymbol == '$')
        		break;
        	if(lastColSymbol == 'A') {
        		int start = 0;
        		i = start + lastColPos;
        	}
        	else if(lastColSymbol == 'C') {
        		int start = countA;
        		i = start + lastColPos ;
        	}
        	else if(lastColSymbol == 'G') {
        		int start = countA+countC;
        		i = start + lastColPos;
        	}
        	else if(lastColSymbol == 'T') {
        		int start = countA+countC+countG;
        		i = start + lastColPos;
        	}
        		
        }
        result.reverse();
        return result.toString();
    }
    
    public static void markFirstOccurances(int[] arr,String text,int len) {
    	int posA=0,posC=0,posG=0,posT=0;
    	for(int i=0;i<len;i++) {
    		if(text.charAt(i)=='A')
    			arr[i] = ++posA;
    		if(text.charAt(i)=='C')
    			arr[i] = ++posC;
    		if(text.charAt(i)=='G')
    			arr[i] = ++posG;
    		if(text.charAt(i)=='T')
    			arr[i] = ++posT;
    	}
    	
    }
    public static String markLastOccurances(int[] arr,String text,int len) {
    	
    	for(int i=0;i<len;i++) {
    		if(text.charAt(i)=='A')
    			arr[i] = ++countA;
    		if(text.charAt(i)=='C')
    			arr[i] = ++countC;
    		if(text.charAt(i)=='G')
    			arr[i] = ++countG;
    		if(text.charAt(i)=='T')
    			arr[i] = ++countT;
    	}
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append('$');
	    	for(int i=0;i<countA;i++)
	    		sb.append('A');
	    	for(int i=0;i<countC;i++)
	    		sb.append('C');
	    	for(int i=0;i<countG;i++)
	    		sb.append('G');
	    	for(int i=0;i<countT;i++)
	    		sb.append('T');
    	
    	return sb.toString();
    }
    
    static public void main(String[] args) throws IOException {
        new InverseBWT().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String bwt = scanner.next();
        System.out.println(inverseBWT(bwt));
    }
}
