package com.zelenkov.net.helper;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

public class ImageHelper {

    public static String makeFile(Part part) throws IOException {
        InputStream content = part.getInputStream();
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        String path = "/Users/artemkalugin/IdeaProjects/Semester Work/src/main/webapp/tmp/" + fileName;

        try(FileOutputStream fos = new FileOutputStream(path)) {
            byte[] buffer = new byte[content.available()];
            content.read(buffer, 0, buffer.length);
            fos.write(buffer, 0, buffer.length);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return fileName;
    }

    public static String makeFile(Part part, String path) throws IOException {
        InputStream content = part.getInputStream();
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

        File file = new File(path + File.separator + fileName);
        System.out.println(file.getAbsolutePath());

        try(FileOutputStream fos = new FileOutputStream(path + File.separator + fileName)) {
            byte[] buffer = new byte[content.available()];
            content.read(buffer, 0, buffer.length);
            fos.write(buffer, 0, buffer.length);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return fileName;
    }


}
