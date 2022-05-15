public class Fight {
    private Hero[] allies;
    private Enemy[] enemies;
    private Linkedlist slinky1;
    private Linkedlist slinky2;
    private Linkedlist deceased_heroes;
    private Linkedlist deceased_enemies;

    public Fight(Hero[] allies, Enemy[] enemies){
        this.allies=allies;
        this.enemies=enemies;
        slinky1= new Linkedlist(this.allies, this.enemies);
        slinky2=new Linkedlist();
        deceased_heroes=new Linkedlist();
    }


    public Boolean fight_over(){
        Boolean check=false;
        if(deceased_heroes.getSize()==allies.length||deceased_enemies.getSize()==enemies.length){
            check=true;
        }
        return(check);
    }

    //I'll include all the options but for now I'll just do basic attacks
    public boolean fight(){
        Boolean winner=false;
        Boolean fight_over;
        while((fight_over=fight_over())==false && slinky1.IsEmpty()==false){
            slinky2.push(slinky1.pop());
        }

        return(winner);
    }



    
    
    
    
}