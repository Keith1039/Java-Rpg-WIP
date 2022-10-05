public class Goblin extends Enemy {

    public Goblin(int level,Mobtype mobtype, String name, Status status, int Hpcap, int Hp, int Strength, int Defence, int Vitality, int Magic,  int Speed, int Exp, int moneyget){
        super(level, mobtype, name, status, Hpcap, Hp, Strength, Defence, Vitality, Magic, Speed, Exp, moneyget);
        
    }
    public Goblin(){
        this(1,Mobtype.MOB,"Goburin",Status.NORMAL,1,1,1,1,1,1,1,1,1);
    }

    public void action(Hero other){
        
    }
    
}
