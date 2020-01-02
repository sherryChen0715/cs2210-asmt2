import java.io.*;
import java.util.ArrayList;

public class WordSearchOperations {
    private int dict_size;
    private HashChainDictionary dict;
    private HashChainDictionary foundWords;
    private int gridSize;
    private int maxScore;
    private String[][] letters;

    /**
     * A constructor
     * @param fileName
     * @param wordTextFile
     * @throws IOException
     * @throws DictionaryException
     */
    public WordSearchOperations(String fileName, String wordTextFile) throws IOException,
            DictionaryException {

        dict = new HashChainDictionary(74051);
        File file = new File(wordTextFile);
        FileReader fr = new FileReader(file);
        BufferedReader in = new BufferedReader(fr); //read input file
        String line;
        while ((line = in.readLine()) != null) {
            String[] readed = line.split(",");
            int i = Integer.parseInt(readed[1]);
            Word word = new Word(readed[0], i);
            dict.put(word);  //put the new words into dictionary
        }
        in.close();
        fr.close();
        this.foundWords = new HashChainDictionary(97);

        File new_file = new File(fileName); //read input file
        FileReader new_fr = new FileReader(new_file);
        BufferedReader new_in = new BufferedReader(new_fr);

        String number = new_in.readLine();
        gridSize = Integer.parseInt(number); //get the grid size from the first line

        letters = new String[gridSize][gridSize]; //creat a 2d array
        String line2;
        char[] letter ;



        for (int i = 0; i < gridSize; i++) {
            line2 = new_in.readLine();
            letter = line2.toCharArray(); // letter contains all the chars on the same line
            for (int j = 0; j < letters.length; j++) {
                letters[i][j] = Character.toString(letter[j]);
            }
        }

            String line3;
            while ((line3 = new_in.readLine()) != null) {
                //process the line
                if (dict.get(line3) != null) {
                    maxScore = maxScore + dict.get(line3).getValue(); //calculate the Maximum score
                }
            }
            new_in.close();
            new_fr.close();
            //read from game word txt and construct 2-d array

    }


    /**
     * Return the number of words found so far during playtime.
     * @return size
     */
    public int getNumWordsFound(){
        return foundWords.size();
    }

    /**
     * Return the grid size (dimension) of the letter grid
     * @return grid size
     */
    public int getSize(){
        return gridSize;
    }

    /**
     * Returns the maximum score for the game being played. This
     * is used by the WordSearch class to determine if the game should finish or not.
     * @return maximum score
     */
    public int getMaxScore(){
        return maxScore;
    }

    /**
     * Returns the letter on row i and column j in the
     * grid, the String letters[i][j]
     * @param i
     * @param j
     * @return specific letter in 2d array
     */
    public String getLetter(int i, int j){
        return this.letters[i][j];
    }

    /**
     *Given a String string, you will return an
     * ArrayList containing Word objects (in no particular order), each corresponding to valid words
     * in the dictionary that are substrings of string.
     * @param string
     * @return stringlist
     */
    ArrayList<Word> checkWords(String string){
        ArrayList<Word> stringList = new ArrayList<Word>();
        for(int i =0; i+3<string.length();i++){
            if(dict.get(string.substring(i,i+4))!=null){
                stringList.add(dict.get(string.substring(i,i+4)));
            }
        }
        for(int i =0; i+4<string.length();i++){
            if(dict.get(string.substring(i,i+5))!=null){
                stringList.add(dict.get(string.substring(i,i+5)));
            }
        }
        for(int i =0; i+5<string.length();i++){
            if(dict.get(string.substring(i,i+6))!=null){
                stringList.add(dict.get(string.substring(i,i+6)));
            }
        }
        for(int i =0; i+6<string.length();i++){
            if(dict.get(string.substring(i,i+7))!=null){
                stringList.add(dict.get(string.substring(i,i+7)));
            }
        }
        return stringList;

    }

    /**
     * Given a String line corresponding to a line of
     * actively selected or currently used letters in the game grid, return the ArrayList of containing
     * all words found within line (in no particular order).
     * @param line
     * @return string list
     */
    ArrayList<Word> findWords(String line){

        ArrayList<Word> stringList2 = new ArrayList<Word>();
        ArrayList<Word> stringList3 = new ArrayList<Word>();
        String[] wordStrings = line.split("\\s+");
        for(int i = 0; i<wordStrings.length;i++){
            stringList2 = checkWords(wordStrings[i]);
            for(int j =0; j<stringList2.size();j++){
                stringList3.add(stringList2.get(j));
            }
        }
        return stringList3;
    }

    /**
     * Given an ArrayList of words, put all the newly found words (i.e. words not existing yet in the
     * found words dictionary) from words into the found word dictionary, and return an ArrayList
     * containing the Word objects for all the newly found words (in no particular order)
     * @param words
     * @return array list
     * @throws DictionaryException
     */
    ArrayList<Word> updateWordList(ArrayList<Word> words) throws DictionaryException {
        ArrayList<Word> newFound = new ArrayList<Word>();
        Word tempWord ;
        for (int i = 0; i < words.size(); i++) {
            Word w = words.get(i);
            if (foundWords.get(w.getKey()) == null) {
                foundWords.put(w);
                newFound.add(w);
            }

        }
        return newFound;
    }




}
