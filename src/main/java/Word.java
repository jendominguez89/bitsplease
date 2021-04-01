
/*
 * This class is a WIP prototype. I intend to capture all the information we
 * need for each word. I would like to try design patterns and a singleton
 * seems appropriate here, although I do wonder if it's needlessly
 * complicating things.
 */


public class Word {
    public String word; // the word itself, should probs be immutable
    public ArrayList<File> files; // list of files in which the word is found
    public ArrayList<Integer> places; // word count number of each occurence


    /*
     * The constructor should only be called if a record doesn't currently
     * exist for that specific word. As such, the constructor is private and
     * the getWord method should be called to check if the constructor should
     * be called or if a prexisting Word object should be returned.
     */
    private Word(String word){
        // There was a hole here, but it's gone now. Placeholders now included.
        self.word = word;
        self.files = fileSearch(word);
        self.places = placeSearch(word);
    }

    @Override
    public String toString(){
        return self.word;
    }

    public static Word getWord(String word){
        /*
         * Take a word as an argument, and compare it to the list of words
         * stored in our future database. If a match is found, return it so
         * that it may be displayed or altered. Otherwise, create a new Word
         * object and return that.
         */
        for(Word term : database){
            if(term.word == word) {
                return term;
            }
        }
        return new Word(word);
    }



}