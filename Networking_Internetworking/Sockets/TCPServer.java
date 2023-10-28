/*
 *  @author Elia Renzoni
 *  @date 13/10/2023
 *  @brief Server
 */

import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1280);
        Socket s = server.accept();
        OutputStream serverComm = s.getOutputStream();
        DataOutputStream socketDos = new DataOutputStream(serverComm);
        socketDos.writeUTF("Messaggio dal Server");
        
        socketDos.close();
        serverComm.close();
        s.close();
        server.close();
    }
}
