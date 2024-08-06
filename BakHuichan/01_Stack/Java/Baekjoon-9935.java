import java.util.Scanner;

public class Main {
    public static String string_cut(String string, int start, int end) {
        String tmp = new String();

        for (int i = start; i < end; i++) {
            tmp += string.charAt(i);
        }
        return tmp;
    }

    public static void main(String[] args) throws Exception {
        String line = new String();
        String bomb = new String();
        Scanner sc = new Scanner(System.in);

        line = sc.nextLine();
        int lineSize = line.length();
        bomb = sc.nextLine();
        int bombSize = bomb.length();

        int tmpPoint = 0;
        int linePoint = 0;
        String tmp = new String();
        
        while (true) {
            if (tmp.length() < bombSize) {
                if (linePoint < lineSize) tmp += line.charAt(linePoint);
            } else {
                if (tmp.charAt(tmpPoint - bombSize) == bomb.charAt(0)) {
                    if (bomb.equals(string_cut(tmp, tmpPoint - bombSize, tmpPoint))) {
                        tmp = tmp.substring(0, tmpPoint - bombSize);
                        tmpPoint -= bombSize;
                    }
                }
                if (linePoint < lineSize) tmp += line.charAt(linePoint);
            }
            tmpPoint++;
            linePoint++;

            if (linePoint > line.length()) {
                break;
            }
        }
        if (tmp.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(tmp);
        }
    }
}
