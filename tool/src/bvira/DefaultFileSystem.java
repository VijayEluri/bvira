package bvira;

import java.io.File;

public class DefaultFileSystem implements FileSystem {
    public void mkdir(String directoryName) {
        new File(directoryName).mkdir();
    }

    public void copy(String from, String to) {
        
    }
}
