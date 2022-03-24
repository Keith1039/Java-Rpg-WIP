public class Assassin extends Hero{
    //Aka status effect hell
    //lowest stats of all but with concentration
    private String Job;
    private int[] Growths;
    private int concentration;
    private String equipment[]; //I'm thinking weapon,armor and two accesories.
    public Assassin(int level,String name, Status status, int Hpcap, int Hp, int Defence, int Vitality, int Magic, int Speed, int Exp, int Expcap,String Job){
        super(level, name, status, Hpcap, Hp, Defence, Vitality, Magic, Speed, Exp, Expcap);
        this.Job="Assassin";
        //this.Growths={3,2,5,7,0,9}; I'm so changing this
        //concentration boosts stats
        this.concentration=0; 
        //this.equipment={} Start out unarmed;

    }
    public void action(String move,Object other){
        /*
        //have attack be calculated independently
        int actual_magic=this.Magic;
        Enemy opponent = (Enemy) other;
        if(move == "fire" ){
            int damage = 2*this.Magic+50;
            opponent.takeDamage(damage);

        }
        //Just an Idea for now. Probably not gonna do this
        else if(move == "fire" && this.getStatus()==Status.BERSERK ){
            this.Magic=this.Magic*6;
            int heal=2*this.Magic+50;

            //Boosted fire that damages everyone
        }
        
        
        this.Magic=actual_magic;
        */
    }
    public void correctMag(){

        /*
        if(this.mana>this.maxmana){
            this.mana=this.maxmana;
        */
    }
    public void levelup(){
        this.level++;
        //deal with growths later
        this.Strength=this.Strength+Growths[0];
        this.Defence=this.Defence+Growths[1];
        this.Exp=this.Exp-this.Expcap;
        this.Expcap=this.Expcap+50*this.level;
    }
    
    
}

