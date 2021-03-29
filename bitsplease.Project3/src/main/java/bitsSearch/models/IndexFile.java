package bitsSearch.models;

import java.util.Date;

public class IndexFile {
    private String fileName;
    private Date indexTime;
    private Boolean exists;

    public Date getIndexTime() {
        return indexTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setIndexTime(Date indexTime) {
        this.indexTime = indexTime;
    }

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }
}
