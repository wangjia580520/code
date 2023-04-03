package com.forezp.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 文件流的区别的使用
 */
public class FileCase {
    public static void main(String[] args) throws Exception {
        FileCase fileCase = new FileCase();
        while(true){
            Scanner in =new Scanner(System.in);
            switch (in.nextInt()){
                case 1:fileCase.byteStreamRead();
                    break;
                case 2:fileCase.byteStreamWirte();
                    break;
                case 3:fileCase.charStreamRead();
                    break;
                case 4: fileCase.charStreamWirte();
                    break;
                case 5: fileCase.bufferRead();
                    break;
                case 6: fileCase.bufferWrite();
                    break;
                default:;
            }
        }
    }

    /**
     * 字节读取
     */
    public void byteStreamRead() throws Exception {
        InputStream in = this.getClass().getResourceAsStream("/file/fileCase.txt");
        byte[] bytes = new byte[100];
        int count = 0;
        // 中文及中文符号占用三个字节 一个英文占用一个字节 回出现中文乱码的情况
        while ((count = in.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, count, "utf-8"));
        }
        in.close();
    }

    /**
     * 字节写入,请到target下查看
     */
    public void byteStreamWirte() throws Exception {
        String file = this.getClass().getResource("/file/fileCase.txt").getFile();
        FileOutputStream fos = new FileOutputStream(file, true);
        String str = "时间刺客 time assassin" + getCurrentDateStr() + System.lineSeparator();
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        fos.write(bytes);
        fos.close();
    }


    /**
     * 字符读取
     */
    public void charStreamRead() throws Exception {
        String file = this.getClass().getResource("/file/fileCase.txt").getFile();
        FileReader fr = new FileReader(file);
        char[] bytes = new char[100];
        int count = 0;
        while ((count = fr.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, count));
        }
        fr.close();
    }

    /**
     * 字符读取
     */
    public void charStreamWirte() throws Exception {
        String file = this.getClass().getResource("/file/fileCase.txt").getFile();
        FileWriter fw = new FileWriter(file, true);
        String str = "时间刺客 time assassin" + getCurrentDateStr() + System.lineSeparator();
        fw.write(str);
        fw.close();
    }

    /**
     * buffRead
     *
     * @return
     */
    public void bufferRead() throws Exception {
        String file = this.getClass().getResource("/file/fileCase.txt").getFile();
        BufferedReader buf = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = buf.readLine()) != null) {
            System.out.println(line);
        }
        buf.close();
    }

    /**
     * buffRead
     *
     * @return
     */
    public void bufferWrite() throws Exception {
        String file = this.getClass().getResource("/file/fileCase.txt").getFile();
        BufferedWriter buf = new BufferedWriter(new FileWriter(file,true));
        String str = "时间刺客 time assassin" + getCurrentDateStr();
        buf.write(str);
        buf.newLine();
        buf.close();
    }

    public String getCurrentDateStr() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(new Date());
    }
}
