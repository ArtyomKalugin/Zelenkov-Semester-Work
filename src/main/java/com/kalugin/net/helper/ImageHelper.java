package com.kalugin.net.helper;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

public class ImageHelper {

    private static final int DIRECTORIES_COUNT = 100;
    private static final String FILE_PATH_PREFIX = "/tmp";

    public static File makeFile(Part part) throws IOException {
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        InputStream content = part.getInputStream();
        int partNumber = Math.abs(fileName.hashCode() % DIRECTORIES_COUNT);
        File file = new File(FILE_PATH_PREFIX + File.separator + partNumber + File.separator + fileName);
        file.getParentFile().mkdirs();
        file.createNewFile();

        return file;
    }

}
