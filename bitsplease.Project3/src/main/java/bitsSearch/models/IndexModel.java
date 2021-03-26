package bitsSearch.models;

import java.util.HashMap;
import java.util.Set;

public class IndexModel {
    private HashMap<String, Set<String>> index;
    public HashMap<String, Set<String>>getIndex(){
        return index;
    }

    public void setIndex(HashMap<String, Set<String>> index) {
        this.index = index;
    }

}
