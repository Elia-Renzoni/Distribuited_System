/*
 *  @author Elia Renzoni
 *  @date 13/10/2023
 *  @brief Client
 */

import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 1280);
        InputStream sStream = client.getInputStream();
        DataInputStream socketComm = new DataInputStream(sStream);
        String serverMessagge = new String(socketComm.readUTF());
        System.out.println(serverMessagge);
        socketComm.close();
        sStream.close();
        client.close(); 
    }    
}
