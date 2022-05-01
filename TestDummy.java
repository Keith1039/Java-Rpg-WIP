public class TestDummy extends Enemy{
    public TestDummy(int level, String name, Status status, int Hpcap, int Hp, int Strength, int Defence, int Vitality, int Magic,  int Speed, int Exp, int moneyget){
        super(level, name, status, Hpcap, Hp, Strength, Defence, Vitality, Magic, Speed, Exp, moneyget);
        
    }
    public TestDummy(){
        this(9999,"Goburin",Status.NORMAL,99999999,9999999,1,0,1,1,1,1,1);
    }

    public void action(Hero other){
        
    }
}
