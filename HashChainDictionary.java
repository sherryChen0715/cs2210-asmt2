import java.io.*;
public class HashChainDictionary implements DictionaryADT{
    private LinkedNode[] table;
    private int M;
    private int numWords;

    /**
     * create a new dictionary
     * @param size
     */

    public HashChainDictionary(int size){
        M = size;
        table = new LinkedNode[size];
        numWords = 0;

    }

    /**
     * create a hash function
     * @param word
     * @return val
     */
    private int hash(String word){
        int val = (int)word.charAt(word.length()-1);
        for(int i = word.length()-2;i>-1;i--){
            val = (val*33 +(int)word.charAt(i))%M;
        }
        return val;
    }


    /**
     * Inserts the given Word object
     * referenced by word into the dictionary. This method must throw a DictionaryException
     * if the String stored in the Word object (its key) is already in the dictionary.
     * @param word
     */
    public int put(Word word) throws DictionaryException{
        int pos = hash(word.getKey());
        LinkedNode new_node = new LinkedNode(word);
        LinkedNode p;
        p = table[pos];
        LinkedNode pre = new LinkedNode(null);
        if(table[pos] == null){
            table[pos] = new_node;
        }
        else {
            while (p != null) {
                if (p.getCur_node().getKey().equals(word.getKey())) {
                    throw new DictionaryException("error");

                }
                else {
                    pre = p;
                    p = p.getNext();
                }

            }
            p = new_node;
            p.setPrevious(pre);
            pre.setNext(p);

        }
        numWords++;
        return 0;

    }

    /**
     *A method which returns the Word object with String
     * inputWord as its key. It must return null if the word does not exist in the dictionary.
     * @param inputWord
     * @return null or current node
     */
    public Word get(String inputWord){
        int pos = hash(inputWord);
        LinkedNode p = table[pos];
        while(p!=null && !p.getCur_node().getKey().equals(inputWord)){
            p = p.getNext();
        }
        if(p == null){
            return null;
        }
        else{
            return p.getCur_node();
        }
    }
    /**
     * Removes the Word record
     * with String inputWord as its key from the dictionary, and returns it. This method must throw
     * the NoKeyException if the word is not in the dictionary.
     * @param inputWord - a word that has a string and score associated with it.
     * @return p.getCur_node()
     * @throws NoKeyException
     */
    public Word remove(String inputWord) throws NoKeyException {
        int pos = hash(inputWord);
        LinkedNode p = table[pos];
        LinkedNode pre = new LinkedNode(null);
        while(p!=null && !p.getCur_node().getKey().equals(inputWord)){
            pre = p;
            p = p.getNext();
        }
        if(p == null){
            throw new NoKeyException("error");
        }
        else{
            if(p.getNext()!=null) {
                p.getNext().setPrevious(pre);
                pre.setNext(p.getNext());
            }
            else{
                pre.setNext(null);
            }
        }
        numWords--;
        return p.getCur_node();

    }

    /**
     * Returns the number of records stored in the hash table (not the size of
     * the table).
     * @return
     */
    public int size(){
        return numWords;
    }


}
