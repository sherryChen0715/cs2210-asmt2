public class Word{
    private String word;
    private int score;

    /**
     *
     * @param word a string
     * @param score an integer
     * A constructor which returns a new Word object
     * with the specified word and its associated score. The String word will be used as the key
     * attribute for every Word object, and integer value score is the value attribute.
     */
    public Word(String word, int score){
        this.word = word;
        this.score = score;

    }

    /**
     *
     * @return word
     * Returns the word String stored in a Word object.
     */
    public String getKey(){
        return this.word;

    }

    /**
     *  Returns the score stored in a Word object.
     * @return socre
     */
    public int getValue(){
        return this.score;
    }


}
