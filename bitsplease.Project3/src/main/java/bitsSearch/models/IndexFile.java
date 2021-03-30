package bitsSearch.models;

import java.util.Date;
import java.sql.File;
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

    /* compareTo() is a common method in Java, and described by an
     * interface named 'Comaparable'. If the argument is greater than
     * the object calling it, compareTo() returns -1. Since this is
     * the only condition we care about, I only check to see if the
     * result is < 0. This is probably possible to do in one line
     * or with fewer cpu cycles. I'm avoiding that because I see enough
     * monstrous lambda functions when I look at javascript.
     */
    public boolean hasBeenModified() {
        int result = indexTime.compareTo(new Date(new File(fileName).lastModified()));
        return result < 0;
    }
}
