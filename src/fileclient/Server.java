package fileclient;

import java.net.*;

public class Server implements Runnable {

    private static ServerSocket server;
    private static ServerSocket server2;
    private static Socket s;
    public String directory;


    protected static String receiveFilename(ServerSocket server) throws Exception{

        Socket s = server.accept();

        FileTransferProcessor ftp = new FileTransferProcessor(s);
        String filename = ftp.receiveFilename();

        return filename;
    }

    public void stop(){
        try {
            server.close();
            server2.close();
            s.close();
        }catch(Exception e){e.printStackTrace();}
    }

    @Override
    public void run() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);

            server = new ServerSocket(4333);
            server2 = new ServerSocket(4334);

            while (true) {
                try {
                    s = server.accept();

                    while (true) {
                        FileTransferProcessor ftp = new FileTransferProcessor(s);
                        String filename = receiveFilename(server2);

                        //Change filepath in quotations to set folder for received files
                        ftp.receiveFile(directory +"\\"+ filename);
                        System.out.println("Transferred 1 file");


                        if (s.isClosed()) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }catch(Exception e){e.printStackTrace();}
    }

    public void changeDirectory(String directory){
        this.directory=directory;
    }

}
