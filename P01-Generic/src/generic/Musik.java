package generic;

public class Musik {
    private String path;
    private String fileName;
    private String fileSize;
    private String extension;

    public Musik(String path, String fileName, String fileSize, String extension) {
        this.path = path;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return fileName + " (" + fileSize + ")";
    }
}
