public class Goblin extends Enemy {

    public Goblin(int level, String name, Status status, int Hpcap, int Hp, int Strength, int Defence, int Vitality,  int Speed, int Exp, int moneyget){
        super(level, name, status, Hpcap, Hp, Strength, Defence, Vitality, Speed, Exp, moneyget);
        
    }
    public Goblin(){
        this(1,"Goburin",Status.NORMAL,1,1,1,1,1,1,1,1);
    }

    public void action(Hero other){
        
    }
    
}
