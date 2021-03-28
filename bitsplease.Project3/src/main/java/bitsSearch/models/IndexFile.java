package bitsSearch.models;

import java.util.Date;

public class IndexFile {
    private String fileName;
    private Date added ;

    public Date getAdded() {
        return added;
    }

    public String getFileName() {
        return fileName;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
