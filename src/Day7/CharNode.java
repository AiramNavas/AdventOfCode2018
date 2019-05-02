package Day7;

import java.util.ArrayList;

public class CharNode {

    private Character value;
    private ArrayList<CharNode> nextNodes;
    private ArrayList<CharNode> prevNodes;

    public CharNode(){
        setNextNodes(new ArrayList<>());
        setPrevNodes(new ArrayList<>());
    }

    public CharNode(Character v){
        setValue(v);
        setNextNodes(new ArrayList<>());
        setPrevNodes(new ArrayList<>());
    }

    public CharNode(CharNode n){
        setValue(n.getValue());
        setNextNodes(n.getNextNodes());
        setPrevNodes(n.getPrevNodes());
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public void addNext(CharNode ch) {
        getNextNodes().add(ch);
        ch.getPrevNodes().add(this);
    }

    public CharNode getNext(int i) {
        return getNextNodes().get(i);
    }

    public CharNode getPrev(int i) {
        return getPrevNodes().get(i);
    }

    public ArrayList<CharNode> getNextNodes() {
        return nextNodes;
    }

    public void setNextNodes(ArrayList<CharNode> nextNodes) {
        this.nextNodes = nextNodes;
    }

    public ArrayList<CharNode> getPrevNodes() {
        return prevNodes;
    }

    public void setPrevNodes(ArrayList<CharNode> prevNodes) {
        this.prevNodes = prevNodes;
    }
}
