public class Node {
    private Object value;
    private Node Next;

    public Node(Object value, Node Next){
        this.value = value;
        this.Next=Next;
    }

    public Node getNext(){
        return(this.Next);
    }
    public Object getValue(){
        return(this.value);
    }
    public void setNext(Node other){
        this.Next=other;
    }
    
    
}
