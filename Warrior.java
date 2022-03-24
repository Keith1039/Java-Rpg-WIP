public class Warrior extends Hero {
    private String Job;
    private int[] Growths;
    private int gauge;
    private String equipment[]; //I'm thinking weapon,armor and two accesories.

    public Warrior(int level,String name, Status status, int Hpcap, int Hp, int Defence, int Vitality, int Magic, int Speed, int Exp, int Expcap,String Job){
        super(level, name, status, Hpcap, Hp, Defence, Vitality, Magic, Speed, Exp, Expcap);
        this.Job="Warrior";
        //this.Growths={3,2,5,7,0,9}; I'm so changing this
        this.gauge=0; //It might be cool to make warriors stats scale with gauge. That way the player chooses between explosive dps or reliable damage?
        //this.equipment={} Start out unarmed;
    }

    //find a way to get dictionaries.
    //Warrior will have martial arts that use gauge. Don't make it too op me
    //Might add "cost" to action. Dunno yet
    //Make a function that doesn't let player choose a move that they don't have the resources(gauge, mana, etc) to use.
    public void action(String move,Enemy other){
        //have attack be calculated independently
        int actual_attack=this.Strength;
        if(move == "Heavy Slash" ){
            this.Strength=this.Strength*2;
            this.attack(other);
            this.gauge=this.gauge-20; 
        }
        //Just an Idea for now. Probably not gonna do this
        else if(move == "Heavy Slash" && this.getStatus()==Status.BERSERK ){
            this.Strength=this.Strength*6;
            //Make it so that this can literally hit. ANYONE, You either one shot the boss or one shot an ally. ROll the dice my friend
        }
        
        
        this.Strength=actual_attack;
    }

    public void correctGauge(){
        if(this.gauge>100){
            this.gauge=100;
        }
    }
    
    
}
