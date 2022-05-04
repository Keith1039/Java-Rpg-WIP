
public class MoveLinkedList {
    //pop method isn't required
    private Node2 first;
    private Node2 rear;
    private int size;

    public static class Node2 {
        private String Move;
        private Node2 Next;
    
    
        public Node2(String Move){
            this.Move=Move;
            this.Next=null;
            
        }
    
        public String getMove(){
            return(this.Move);
        }
        
        public Node2 getnext(){
            return(this.Next);
        }
        public void setNext(Node2 Next){
            this.Next=Next;
        }
        public void setMove(String Move){
            this.Move=Move;
        }

    
    }

    public MoveLinkedList(){
        this.first=null;
        this.rear=null;
        this.size=0;
    }
    public void append(String value){
        Node2 appendable = new Node2(value);
        if(this.first==null){
            first=appendable;
            rear=first;
        }
        else{
            rear.Next= appendable;
            rear=rear.Next;
        }
        this.size++;
    }

    public int getSize(){
        return(this.size);
    }

    public String toString(){
        String res="";
        Node2 traversenode=first;
        for(int i=0; i<this.size;i++){
            res+=Integer.toString(i+1)+": "+traversenode.Move+"\n";
            traversenode=traversenode.Next;
        }
        return(res);
    }
}
