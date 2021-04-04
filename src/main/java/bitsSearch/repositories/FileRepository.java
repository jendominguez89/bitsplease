package bitsSearch.repositories;

import bitsSearch.models.IndexFile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileRepository {

    private Gson gson = new Gson();

    public void save(List<IndexFile> files) throws IOException {
        File f = new File("files.json");
        try (FileWriter bw = new FileWriter(f)) {
            String raw = gson.toJson(files);
            bw.write(raw);
        }
    }

    public List<IndexFile> load() throws IOException {
        File f = new File("files.json");
        if (!f.exists()) {
            return new ArrayList<>();
        }
        StringBuilder sb = new StringBuilder();
        try (FileReader bw = new FileReader(f)) {
            try(BufferedReader reader = new BufferedReader(bw)){
                String line;
                while((line = reader.readLine()) != null){
                    sb.append(line);
                }
            }
        }
        Type collectionType = new TypeToken<ArrayList<IndexFile>>(){}.getType();
        return markFiles(gson.fromJson(sb.toString(), collectionType));
    }

    private List<IndexFile> markFiles(List<IndexFile> files){
        for(IndexFile file: files) {
            File f = new File(file.getFileName());
            file.setExists(f.exists());
        }
        return files;
    }

    public void remove(List<IndexFile> files) {
    }
}
