package fileclient;

import java.io.*;
import java.net.*;

public class Client {


    public String ipAddress;
    public Client(String ipAddress){
        this.ipAddress=ipAddress;
    }

    public int sendFile(File file) throws Exception{
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket s = new Socket(ipAddress, 4333);

            FileTransferProcessor ftp = new FileTransferProcessor(s);

            ftp.sendFile(file);
        }catch(Exception e){
            e.printStackTrace();
        }
            return 1;
    }

    public int sendFilename(File file) throws Exception{
        try {
            InetAddress address = InetAddress.getLocalHost();
            Socket s = new Socket(ipAddress, 4334);

            FileTransferProcessor ftp = new FileTransferProcessor(s);

            ftp.sendFilename(file);
        }catch(Exception e) {
            e.printStackTrace();
            return 0;
        }

        return 1;
    }



}
