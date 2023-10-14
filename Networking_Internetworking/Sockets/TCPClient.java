/*
 *  @author Elia Renzoni
 *  @date 13/10/2023
 *  @brief Client
 */

import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket server = new Socket("localhost", 1280);
        InputStream sStream = server.getInputStream();
        DataInputStream socketComm = new DataInputStream(sStream);
        String serverMessagge = new String(socketComm.readUTF());
        System.out.println(serverMessagge);
        socketComm.close();
        sStream.close();
        server.close(); 
    }    
}
