package code;

public class FileandCount {
    public String file;
    public int count;

    public FileandCount(String file) {
        this(file, 1);
    }

    public FileandCount(String file, int count) {
        this.file = file;
        this.count = count;
    }
}
