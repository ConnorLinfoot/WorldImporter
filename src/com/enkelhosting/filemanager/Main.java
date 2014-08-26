package com.enkelhosting.filemanager;

import java.io.*;

public class Main {

    public static void copyFolder(File src, File dest) throws IOException {
        if( src.isDirectory() ){
            if(!dest.exists()){
                dest.mkdir();
            }

            String files[] = src.list();

            for (String file : files) {
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                copyFolder(srcFile,destFile);
            }

        } else {
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0){
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
        }
    }

    public static void deleteFiles(File file) throws IOException{
        if( file.isDirectory() ){
            if( file.list().length==0 ){
                file.delete();
            } else {
                String files[] = file.list();
                for (String temp : files) {
                    File fileDelete = new File(file, temp);
                    deleteFiles(fileDelete);
                }
                if(file.list().length==0){
                    file.delete();
                }
            }
        } else {
            file.delete();
        }
    }

}
