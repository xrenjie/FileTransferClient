package fileclient;

import java.io.*;
import java.net.*;

public class Server {
    Socket socket;
    InputStream is;
    FileOutputStream fos;
    int bufferSize;


    public static void main(String[] args) throws Exception{

        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        ServerSocket server = new ServerSocket(4333);
        ServerSocket server2 = new ServerSocket(4334);
        Socket s;
        while(true){
            try {
                s = server.accept();

                while (true) {
                    FileTransferProcessor ftp = new FileTransferProcessor(s);
                    String filename = receiveFilename(server2);

                    //Change filepath in quotations to set folder for received files
                    ftp.receiveFile("T:\\New folder\\" + filename);
                    System.out.println("Transferred 1 file");

                    if(s.isClosed()){
                        break;
                    }
                }
            }catch(Exception e){e.printStackTrace();}
        }

    }

    protected static String receiveFilename(ServerSocket server) throws Exception{

        Socket s = server.accept();

        FileTransferProcessor ftp = new FileTransferProcessor(s);
        String filename = ftp.receiveFilename();

        return filename;
    }
}
