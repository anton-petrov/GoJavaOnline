package edu.petrov.gojavaonline.module03.filesystem;

import java.util.regex.Pattern;

/**
 * Created by anton on 06/03/16.
 */
public class File implements FileSystemObject, Comparable {
    String name;
    String path;
    byte[] data;

    File() {
    }

    public File(String name) {
        this.name = name;
    }

    File(String path, String name) {
        this.name = name;
        this.path = path;
    }

    public String name() {
        return name;
    }

    public String getExtension() {
        String[] filename = name.split(Pattern.quote("."));
        if (filename.length > 1) {
            return filename[filename.length - 1];
        }
        return "";
    }

    public String getPath() {
        return path;
    }

    void setPath(String path) {
        this.path = path;
    }

    byte[] getData() {
        return data;
    }

    byte[] setData(byte[] data) {
        return (this.data = data);
    }

    public long size() {
        if (data != null) {
            return data.length;
        }
        return 0;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    public String getFullPath() {
        return path + "/" + name;
    }

    @Override
    public String toString() {
        return String.format("name=%-32s\tpath=%-32s\tsize=%-6d\textension=%s", name(), getPath(), size(), getExtension());
    }

    @Override
    public int compareTo(Object o) {
        return name.compareTo(((FileSystemObject) o).name());
    }

}
