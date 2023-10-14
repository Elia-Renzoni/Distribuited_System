/*
 *  @author Elia Renzoni
 *  @date 14/10/2023
 *  @brief Socket Client
 */

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket server = new Socket("localhost", 1234);
        InputStream in = server.getInputStream();
        DataInputStream data = new DataInputStream(in);
        int fibonacciValue = data.readInt();
        System.out.println("Fibonacci Number : " + fibonacciValue);

        server.close();
        in.close();
        data.close();
    }
}
