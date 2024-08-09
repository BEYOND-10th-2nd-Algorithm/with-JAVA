import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    public static void recursion(int st, int ext, int dest, int n, BufferedWriter bw) throws IOException {
        if(n==1){
            bw.write(st+" "+dest+'\n');
            return;
        }
        recursion(st,dest,ext,n-1, bw);
        bw.write(st+" "+dest+'\n');
        recursion(ext,st,dest,n-1,bw);
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int cnt = 1;
        for(int i=2; i<=N; i++){
            cnt = cnt*2+1;
        }
        System.out.println(cnt);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        recursion(1,2,3,N , bw);
        bw.flush();
        bw.close();
    }

}
