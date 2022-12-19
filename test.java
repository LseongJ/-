import java.io.*;
import java.util.*;

public class test{
    public static void main(String[] args) {
        String filepath = "C:/Users/dltjd/OneDrive/바탕 화면/test1.csv";
        File file = null;
        BufferedWriter bw = null;
        String newline = System.lineSeparator(); //줄바꿈(\n)
        Scanner sc = new Scanner(System.in);

        try{
            file = new File(filepath);
            bw = new BufferedWriter((new FileWriter(file)));

            bw.write("ID, PW, score");
            bw.write(newline);

            String id = sc.nextLine();
            bw.write(id);
            bw.write(newline);
            
            bw.flush();
            bw.close();


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}