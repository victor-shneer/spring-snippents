package com.carmel.advancedIO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * Probably you don't need read buffers anymore
 * see ThrowableSuppliersTest with Files::ReadAllLines
 *
 */
public class ReadWriteTest {
    /**
     *
     * Bad performance because we read byte by byte
     *
     * @param from
     * @param to
     * @throws IOException
     */
    public void readWrite(String from, String to) throws IOException {
        InputStream in = null;
        OutputStream out = null;

        try{
            in = new FileInputStream(from);
            out = new FileOutputStream(to);

            while(true){
                int bytedata = in.read();
                if(bytedata == -1)
                    break;
                out.write(bytedata);
            }
        } finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
    }

    /**
     * Better performance using buffers
     * @param from
     * @param to
     * @throws IOException
     */
    public void readWriteBuffer(String from, String to) throws IOException {
        InputStream inBuffer = null; //500 bytes by default
        OutputStream outBuffer = null;

        try{
            InputStream in = new FileInputStream(from);
            inBuffer = new BufferedInputStream(in);

            OutputStream out = new FileOutputStream(to);
            outBuffer = new BufferedOutputStream(out);

            while(true){
                int bytedata = inBuffer.read();
                if(bytedata == -1)
                    break;
                out.write(bytedata);
            }
        } finally {
            if (inBuffer != null)
                inBuffer.close();
            if (outBuffer != null)
                outBuffer.close();
        }
    }

    public void readWriteArray(String from, String to) throws IOException {
        InputStream in = null;
        OutputStream out = null;

        try{
            in = new FileInputStream(from);
            out = new FileOutputStream(to);

            int availableLength = in.available();
            byte[] totalBytes = new byte[availableLength];
            in.read(totalBytes);

            out.write(totalBytes);
        } finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
    }

    @Test
    void readWriteTest() {
        String from = System.getProperty("user.dir") + "/read.png";
        String to = System.getProperty("user.dir") + "/write.png";
        try {
            long startTime = System.currentTimeMillis();
            readWrite(from, to);
            long endTime = System.currentTimeMillis();
            System.out.println("Default " + (endTime - startTime));

            long startTime1 = System.currentTimeMillis();
            readWriteBuffer(from, to);
            long endTime1 = System.currentTimeMillis();
            System.out.println("Default " + (endTime1 - startTime1));

            long startTime2 = System.currentTimeMillis();
            readWriteArray(from, to);
            long endTime2 = System.currentTimeMillis();
            System.out.println("Default " + (endTime2 - startTime2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
