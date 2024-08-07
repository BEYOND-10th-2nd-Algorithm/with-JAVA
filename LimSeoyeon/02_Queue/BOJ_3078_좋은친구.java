import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N,M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];
        Queue<Integer> [] q = new LinkedList[21];
        long res=0;
        for (int i = 0; i < 21; i++) {
            q[i] = new LinkedList<>();
        }
        for(int i=0; i<N; i++){
            String s = br.readLine();
            arr[i] = s.length();
        }

        for(int i=0; i<N; i++){
            int curQ = arr[i];
            while(!q[curQ].isEmpty()&& i-q[curQ].peek()>M){
                q[curQ].poll();
            }
            res+=q[curQ].size();
            q[curQ].add(i);
        }
        System.out.println(res);
    }
}
