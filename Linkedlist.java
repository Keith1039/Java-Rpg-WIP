public class Linkedlist implements Stack {
    private Node top;
    private Node first;

    public Linkedlist(){
        first=new Node();
        top=first;
    }
    public void push(Object other){
        if(IsEmpty()==true){
            first.setValue(other);
        }
        else{
        Node nextnode=new Node(other,null);
        top.setNext(nextnode);
        top=nextnode;
        }
    }

    
    public boolean IsEmpty(){
        return(top==first);
    }
    
    public Object peek(){
        return(top.getValue());
    }

    
    public Object pop(){
        Object returnable;
        if(IsEmpty()==true){
            return(null);
        }else{
            if(top==first){
                returnable=first.getValue();
                first.setNext(null);
                first.setValue(null);
            }
            else{
            returnable=top;
            top=newTop();
            top.setNext(null);
            }
        }
        return(returnable);
    }
    
    public Node newTop(){
        Node CurrentNode;
        Node right_before;
        CurrentNode=first;
        right_before=CurrentNode;
        while(CurrentNode.getNext()!=null){
            right_before=CurrentNode;
            CurrentNode=CurrentNode.getNext();
        }
        return(right_before);
    }
    //I mean... this'll work for ints but not other stuff..... Shuffle stack here we gooo
    public String toString(){
        String returnable="[ ";
        Node CurrentNode=first;
        while(CurrentNode.getNext()!=null){

        }

        return(returnable);
    }
    

    

    
}
