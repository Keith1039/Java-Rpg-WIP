public class Linkedlist implements Stack {
    private Node<Entity> top;
    private Node<Entity> first;
    private int size=0;

    public Linkedlist(){
        first=null;
        top=first;
        size=0;
    }

    public Linkedlist(Hero[] heroes, Enemy[] enemies){
        super();
        for(int i=0; i<heroes.length;i++){
            this.push(heroes[i]);
        }
        for(int j=0;j<enemies.length;j++){
            this.push(enemies[j]);
        }
    }
    public void push(Entity other){
        Node<Entity> other2= new Node<Entity>(other, null);
        if(IsEmpty()==true){
            first= other2;
            top=first;
        }
        else{
        if(first.getSpeed()<=other2.getSpeed()){
            first.setPrevious(other2);
            other2.setNext(first);
            first=other2;
        }
        else{
            int j=0;
            Node<Entity> CurrentNode;
            Node<Entity> right_before;
            CurrentNode=first;
            right_before=CurrentNode;
            while(CurrentNode.getNext()!=null && CurrentNode.getSpeed()>other2.getSpeed()){
                right_before=CurrentNode;
                CurrentNode=CurrentNode.getNext();
                if(CurrentNode.getNext()==null){
                    j=1;
                }
            }
            if(j==1&&CurrentNode.getSpeed()>other2.getSpeed()){
                CurrentNode.setNext(other2);
                other2.setPrevious(CurrentNode);
            }
            else{
                other2.setNext(CurrentNode);
                other2.setPrevious(right_before);
                CurrentNode.setPrevious(other2);
                right_before.setNext(other2);
            }
        }
        size++;
        }
    }

    
    public boolean IsEmpty(){
        return(first==null);
    }
    
    public Entity peek(){
        return(top.getEntity());
    }

    
    public Entity pop(){
        Entity returnable;
        if(IsEmpty()==true){
            return(null);
        }else{
            if(first.getNext()==null){
                returnable=first.getEntity();
                first=null;
            }
            else{
            Node<Entity> ref = first.getNext();
            ref.setPrevious(null);
            returnable=first.getEntity();
            first=ref;
            }
        }
        size--;
        return(returnable);
        
    }
    public int getSize(){
        return(this.size);
    }
    /*
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
    */
    //I mean... this'll work for ints but not other stuff..... Shuffle stack here we gooo
    //Make an iterator fool
    public String toString(){
        String returnable="[ ";
        Node<Entity> CurrentNode=first;
        while(CurrentNode.getNext()!=null){
            returnable+=CurrentNode.toString()+", ";
            CurrentNode=CurrentNode.getNext();
        }
        returnable+=CurrentNode.toString();
        returnable+="]";
        return(returnable);
    }
    
}
