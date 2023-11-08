package 인규.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 나머지 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    br.close();
    String[] ABC = input.split(" ");
    int A = Integer.parseInt(ABC[0]);
    int B = Integer.parseInt(ABC[1]);
    int C = Integer.parseInt(ABC[2]);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write((A + B) % C + "\n");
    bw.write((((A % C) + (B % C)) % C) + "\n");
    bw.write((A * B) % C + "\n");
    bw.write((((A % C) * (B % C)) % C) + "\n");
    bw.flush();
    bw.close();
  }

}