
//Assignment2
import java.io.*;
import java.util.StringTokenizer;


public class JobQueue {
    private int numWorkers;
    private int[] jobs;
    private Worker[] priorityQueue;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
        assignedWorker = new int[m];
        startTime = new long[m];
        priorityQueue = new Worker[numWorkers];
        for(int i=0;i<numWorkers;i++) {
        	Worker w = new Worker(i,0);
        	priorityQueue[i] = w;
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private void assignJobs() {
        buildHeap();
        int m = jobs.length;
    	for(int i=0;i<m;i++) {
    		assignedWorker[i] = priorityQueue[0].workerNo;
    		startTime[i] = priorityQueue[0].priority;
    		priorityQueue[0].priority += jobs[i]; 
    		shiftDown(0);
    	}
    }
    
    private void buildHeap() {
    	int x = numWorkers/2;
        for(int i=x-1;i>=0;i--)
            shiftDown(i);
    }
    
    public void shiftDown(int no){
        int l = 2*no + 1;
        int r = 2*no + 2;
        int len = numWorkers;
        int min = no;
        if(l<len && (priorityQueue[no].priority>priorityQueue[l].priority || (priorityQueue[no].priority == priorityQueue[l].priority && priorityQueue[no].workerNo > priorityQueue[l].workerNo)))
            min = l;
        if(r<len && (priorityQueue[min].priority>priorityQueue[r].priority || (priorityQueue[min].priority == priorityQueue[r].priority && priorityQueue[min].workerNo > priorityQueue[r].workerNo)))
            min = r;
        
        if(min == no)
            return;
        
        Worker tmp = priorityQueue[min];
        priorityQueue[min] = priorityQueue[no];
        priorityQueue[no] = tmp;
        shiftDown(min);
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
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
    static class Worker{
    	private int workerNo;
    	private long priority;
    	
    	Worker(int workerNo,long priority){
    		this.workerNo = workerNo;
    		this.priority = priority;
    	}
    }
}
