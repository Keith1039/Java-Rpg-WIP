public class Whitemage extends Hero{
    private String Job;
    private int[] Growths;
    private int mana;
    private int maxmana;
    private String equipment[]; //I'm thinking weapon,armor and two accesories.
    public Whitemage(int level,String name, Status status, int Hpcap, int Hp, int Defence, int Vitality, int Magic, int Speed, int Exp, int Expcap,String Job){
        super(level, name, status, Hpcap, Hp, Defence, Vitality, Magic, Speed, Exp, Expcap);
        this.Job="Whitemage";
        //this.Growths={3,2,5,7,0,9}; I'm so changing this
        this.mana=0; //It might be cool to make warriors stats scale with gauge. That way the player chooses between explosive dps or reliable damage?
        //this.equipment={} Start out unarmed;
        this.maxmana=100;

    }
    public void action(String move,Object other){
        //have attack be calculated independently
        int actual_magic=this.Magic;
        Hero ally = (Hero) other;
        if(move == "Light heal" ){
            int heal = 2*this.Magic+50;
            ally.regen(heal);

        }
        //Just an Idea for now. Probably not gonna do this
        else if(move == "Light heal" && this.getStatus()==Status.BERSERK ){
            this.Magic=this.Magic*6;
            int heal=2*this.Magic+50;
            this.regen(heal);
            Entity victim;

            //does the opposite of healing and drains their hp. Problem is it can happen to anyone. Don't know who
        }
        
        
        this.Strength=actual_magic;
    }
    public void correctMag(){
        if(this.mana>this.maxmana){
            this.mana=this.maxmana;
        }
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
