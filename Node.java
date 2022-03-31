public class Node<Entity> {
    private Entity entity;
    private int speed;
    private Node<Entity> Next;
    private Node<Entity> Previous;
    

    public Node(Entity character, Node<Entity> Next){
        this.entity = character;
        this.Next=null;
        if(character instanceof Enemy){
            Enemy Mob= (Enemy)character;
            this.speed=Mob.getSpeed();
        }
        else{
            Hero hero = (Hero) entity;
            this.speed=hero.getSpeed();
        }
        this.Previous=null;
    }


    public Node<Entity> getNext(){
        return(this.Next);
    }
    public Entity getEntity(){
        return(this.entity);
    }
    public void setNext(Node<Entity> other){
        this.Next=other;
    }

    public Node<Entity> getPrevious(){
        return(this.Previous);
    }
    public void setPrevious(Node<Entity> other){
        this.Previous=other;
    }
    public int getSpeed(){
        return(this.speed);
    }
    /* Maybe I'll use this for dummy node but rn it's kinda useless
    public void setValue(Object value){
        this.value=value;
    }
    */
    public String toString(){
        String returnableString="";
        if(this.getEntity() instanceof Enemy){
            Enemy villain = (Enemy) this.getEntity();
            returnableString+=villain.name;
        }
        else{
            Hero hiro=(Hero) this.getEntity();
            returnableString+=hiro.name;
        }
        return(returnableString);
    }
    
    
}
