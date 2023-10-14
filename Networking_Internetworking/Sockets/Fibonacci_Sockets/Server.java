/*
 *  @author Elia Renzoni
 *  @date 14/10/2023
 *  @brief Socket Server
 */

import java.net.*;
import java.io.*;

public class Server {
   public static void main(String[] args) throws IOException {
        Fibonacci fib = new Fibonacci(300);

        ServerSocket server = new ServerSocket(1234);
        Socket client = server.accept();
        OutputStream com = client.getOutputStream();
        DataOutputStream data = new DataOutputStream(com);
        fib.fibonacci(1, 1);
        int numeroFibo = fib.getFibonacciNum();
        data.writeInt(numeroFibo);

        server.close();
        client.close();
        com.close();
        data.close();

   } 
}
