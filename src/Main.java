import java.util.Random;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        FileWriter writer = new FileWriter("res.txt", false);
        int[] ch = new int[100];
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            ch[i] = rand.nextInt(100);
            writer.append(ch[i] + ",");

            writer.flush();
        }
        writer.append("\n");
        for (int i = 0; i < 100; i++) {

            System.out.print(ch[i] + "\t");


        }
        writer.append("---------------------------------------------------------------------------------------------" +
                "-------------------------------------------------------------------------------------------------------" +
                "---------------------------");
        writer.append("\n");
        writer.flush();
        for (int y = 0; y < 99; y++) {
            for (int x = 0; x < 99 - y; x++) {
                if (ch[x] > ch[x + 1]) {
                    int poplavok = ch[x + 1];
                    ch[x + 1] = ch[x];
                    ch[x] = poplavok;
                }

            }

        }
        System.out.print("---------------------------------------------------------------------------------------------" +
                "-------------------------------------------------------------------------------------------------------" +
                "---------------------------");
        for (int i = 0; i < 100; i++) {
            writer.append(ch[i] + ",");

            writer.flush();
          
        }
        writer.append("\n");
        System.out.println("ok");

        try (FileReader reader = new FileReader("res.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {

                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
            }

        }
    }
}