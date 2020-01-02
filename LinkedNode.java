public class LinkedNode{
    private Word cur_node;
    private LinkedNode next = null;
    private LinkedNode previous =null;

    /**
     * set current node
     * @param word a word
     */
    public LinkedNode(Word word){
        cur_node = word;
    }

    /**
     *
     * @return return current node
     */

    public Word getCur_node() {
        return cur_node;
    }

    /**
     *
     * @return next node
     */

    public LinkedNode getNext() {
        return next;
    }

    /**
     * set current node
     * @param node is Word
     */

    public void setCur_node(Word node) {
        this.cur_node = node;
    }

    /**
     * set next node
     * @param next a linkednode
     */

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    /**
     *
     * @return previous node
     */

    public LinkedNode getPrevious() {
        return previous;
    }

    /**
     * set previous node
     * @param previous a linkednode
     */

    public void setPrevious(LinkedNode previous) {
        this.previous = previous;
    }
}
