
//Assignment2
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HashChains {

    private FastScanner in;
    private PrintWriter out;
    // store all strings in one list
//    private List<String> elems;
    // for hash function
    private int bucketCount;
    private long prime = 1000000007l;
    private long multiplier = 263;
    ArrayList<String>[] arr;

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void writeSearchResult(boolean wasFound) {
        out.println(wasFound ? "yes" : "no");
        // Uncomment the following if you want to play with the program interactively.
        // out.flush();
    }

    private void processQuery(Query query) {
    	int hash = 0;
    	ArrayList<String> list;
        switch (query.type) {
            case "add":
            	hash = computeHash(query.s);
//            	System.out.println("hash "+hash);
            	list = arr[hash];
            	if(list == null) {
            		list = new ArrayList<String>();
            		arr[hash] = list;
            	}
                if (!list.contains(query.s))
                    list.add(0, query.s);
                
                break;
            case "del":
            	hash = computeHash(query.s);
            	list= arr[hash];
            	if(list == null) {
            		list = new ArrayList<String>();
            		arr[hash] = list;
            	}
                if (list.contains(query.s))
                    list.remove(query.s);
                break;
            case "find":
            	hash = computeHash(query.s);
            	list= arr[hash];
            	if(list == null) {
            		list = new ArrayList<String>();
            		arr[hash] = list;
            	}
                writeSearchResult(list.contains(query.s));
                break;
            case "check":
            	list= arr[query.ind];
            	if(list == null) {
            		out.println();
            		break;
            	}
                for (String cur : list)
                    out.print(cur + " ");
                out.println();
                // Uncomment the following if you want to play with the program interactively.
                // out.flush();
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }
    
    private int computeHash(String str) {
    	long hash = 0;
        for (int i = str.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + str.charAt(i)) % prime;
        return (int)hash % bucketCount;
    }

    public void processQueries() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        bucketCount = in.nextInt();
        int queryCount = in.nextInt();
        arr = new ArrayList[bucketCount];
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
        out.close();
    }

    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
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
