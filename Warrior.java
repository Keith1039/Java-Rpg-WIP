public class Warrior extends Hero {
    private String Job;
    private int[] Growths;
    private int gauge;
    private String equipment[]; //I'm thinking weapon,armor and two accesories.

    public Warrior(int level,String name, Status status, int Hpcap, int Hp, int Defence, int Vitality, int Magic, int Speed, int Balance, int Exp, int Expcap,String Job){
        super(level, name, status, Hpcap, Hp, Defence, Vitality, Magic, Speed, Balance, Exp, Expcap);
        this.Job="Warrior";
        //this.Growths={3,2,5,7,0,9}; I'm so changing this
        this.gauge=0;
        //this.equipment={} Start out unarmed;
    }

    //find a way to get dictionaries.
    //Warrior will have martial arts that use gauge. Don't make it too op me
    public void action(Enemy other){
        //have attack be calculated independently
        
    
    }

    public void correctGauge(){
        if(this.gauge>100){
            this.gauge=100;
        }
    }
    
    
}
