package fileclient;

import java.io.*;
import java.net.Socket;

public class FileTransferProcessor {
    Socket socket;
    InputStream is;
    FileOutputStream fos;
    BufferedOutputStream bos;
    int bufferSize;


    FileTransferProcessor(Socket client) {
        socket = client;
        is = null;
        fos = null;
        bos = null;
        bufferSize = 0;

    }

    void receiveFile(String fileName) {
        try {
            is = socket.getInputStream();
            bufferSize = socket.getReceiveBufferSize();
            System.out.println("Buffer size: " + bufferSize);
            fos = new FileOutputStream(fileName);
            bos = new BufferedOutputStream(fos);
            byte[] bytes = new byte[bufferSize];
            int count;
            while ((count = is.read(bytes)) >= 0) {
                bos.write(bytes, 0, count);
            }
            bos.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void sendFile(File file) {

        FileInputStream fis;
        BufferedInputStream bis;
        BufferedOutputStream out;
        byte[] buffer = new byte[8192];
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            out = new BufferedOutputStream(socket.getOutputStream());
            int count;
            while ((count = bis.read(buffer)) > 0) {
                out.write(buffer, 0, count);

            }
            out.close();
            fis.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String receiveFilename() throws Exception{
        BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
        try (DataInputStream d = new DataInputStream(in)) {
            String filename = d.readUTF();
            //Files.copy(d, Paths.get(filename));
            return filename;
        }catch(Exception e){e.printStackTrace();}
        return "";
    }


    public void sendFilename(File file) throws Exception{
        //File file = infile;
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
        try (DataOutputStream d = new DataOutputStream(out)) {
            d.writeUTF(file.getName());
            //Files.copy(file.toPath(), d);
        } catch (Exception e){e.printStackTrace();}


    }
}