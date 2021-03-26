

package bitsSearch;
import com.google.gson.Gson;
import java.io.*;
import java.util.Date;

public class IndexFile {
        //Hard coded for testing purposes.
        public static File file = new File("D:\\InteliJ\\bitsplease\\bitsplease.Project3\\src\\test\\java\\bitsSearch\\PathTest.java");
        private String name;
        private String modifyDate;
        private boolean modified;

        public IndexFile(File Name) {
            this.name = Name.toString();
        }

        public String getName() {
            return this.name;
        }

        public void setName(String filePath) {
            this.name = filePath;
        }

        public String getModifyDate() {
            return modifyDate;
        }

        public void setModifyDate(String modifyDate) {
            this.modifyDate = modifyDate;
        }

        public boolean ismodified() {
            return modified;
        }

        public void setmodified(boolean modified) {
            this.modified = modified;

        }
        //Function will accept a file and write information to a Json file.
        public static void writeToJson(File fileName) throws IOException, FileNotFoundException {
            bitsSearch.IndexFile IndexFile = new bitsSearch.IndexFile(file);
            Writer writer = new FileWriter("SearchIndexTesting");
            new Gson().toJson(IndexFile, writer);
            writer.close();

        }
    }

