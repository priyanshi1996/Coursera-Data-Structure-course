import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BWMatching {
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

    // Preprocess the Burrows-Wheeler Transform bwt of some text
    // and compute as a result:
    //   * starts - for each character C in bwt, starts[C] is the first position
    //       of this character in the sorted array of
    //       all characters of the text.
    //   * occ_count_before - for each character C in bwt and each position P in bwt,
    //       occ_count_before[C][P] is the number of occurrences of character C in bwt
    //       from position 0 to position P inclusive.
    private void PreprocessBWT(String bwt, Map<Character, Integer> starts, Map<Character, int[]> occ_counts_before) {
        // Implement this function yourself
    	int len = bwt.length();
    	int countA = 0, countC =0, countG = 0,countT=0;
//    	
    	occ_counts_before.put('A',new int[len+1]);
    	occ_counts_before.put('C', new int[len+1]);
    	occ_counts_before.put('G',new int[len+1]);
    	occ_counts_before.put('T', new int[len+1]);
    	for(int i=0;i<=len;i++) {
    		int[] arr = occ_counts_before.get('A');
			arr[i] = countA;
			occ_counts_before.put('A', arr);
			
			arr = occ_counts_before.get('C');
			arr[i] = countC;
			occ_counts_before.put('C', arr);
			
			arr = occ_counts_before.get('G');
			arr[i] = countG;
			occ_counts_before.put('G', arr);
			
			arr = occ_counts_before.get('T');
			arr[i] = countT;
			occ_counts_before.put('T', arr);
			
    		if(i<len && bwt.charAt(i)=='A') {
    			countA++;
    		}
    		else if(i<len && bwt.charAt(i)=='C') {
    			countC++;
    		}
    		else if(i<len && bwt.charAt(i)=='G') {
    			countG++;
    		}
    		else if(i<len && bwt.charAt(i)=='T') {
    			countT++;
    		}
    	}
    	
    	
    	if(countA>0)
    		starts.put('A', 1);
    	if(countC>0)
    		starts.put('C',1+countA);
    	if(countG>0)
    		starts.put('G',1+countA+countC);
    	if(countT>0)
    		starts.put('T', 1+countA+countC+countG);
    	
//    	for(int i=0;i<=len;i++)
//    		System.out.print(occ_counts_before.get('A')[i]);
    }

    // Compute the number of occurrences of string pattern in the text
    // given only Burrows-Wheeler Transform bwt of the text and additional
    // information we get from the preprocessing stage - starts and occ_counts_before.
    int CountOccurrences(String pattern, String bwt, Map<Character, Integer> starts, Map<Character, int[]> occ_counts_before) {
        // Implement this function yourself
    	int top =0;
    	int bottom = bwt.length()-1;
    	StringBuilder sbPattern = new StringBuilder(pattern);
    	while(top<=bottom) {
    		int length = sbPattern.length();
    		if(length>0) {
    			char symbol = sbPattern.charAt(length-1);
    			sbPattern.deleteCharAt(length-1);
    			if(occ_counts_before.get(symbol)[bottom+1] - occ_counts_before.get(symbol)[top]>0) {
    				 top = starts.get(symbol)+occ_counts_before.get(symbol)[top];
    				 bottom = starts.get(symbol)+occ_counts_before.get(symbol)[bottom+1]-1;
    			}	
    			else
    				return 0;
    		}
    		else
    			return bottom - top +1;
    	}
    	return 0;
    }

    static public void main(String[] args) throws IOException {
        new BWMatching().run();
    }

    public void print(int[] x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String bwt = scanner.next();
        // Start of each character in the sorted list of characters of bwt,
        // see the description in the comment about function PreprocessBWT
        Map<Character, Integer> starts = new HashMap<Character, Integer>();
        // Occurrence counts for each character and each position in bwt,
        // see the description in the comment about function PreprocessBWT
        Map<Character, int[]> occ_counts_before = new HashMap<Character, int[]>();
        // Preprocess the BWT once to get starts and occ_count_before.
        // For each pattern, we will then use these precomputed values and
        // spend only O(|pattern|) to find all occurrences of the pattern
        // in the text instead of O(|pattern| + |text|).
        PreprocessBWT(bwt, starts, occ_counts_before);
        int patternCount = scanner.nextInt();
        String[] patterns = new String[patternCount];
        int[] result = new int[patternCount];
        for (int i = 0; i < patternCount; ++i) {
            patterns[i] = scanner.next();
            result[i] = CountOccurrences(patterns[i], bwt, starts, occ_counts_before);
        }
        print(result);
    }
}
