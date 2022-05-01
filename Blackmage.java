public class Blackmage extends Hero{
    private String Job;
    private int[] Growths;
    private int mana;
    private int maxmana;
    private String equipment[]; //I'm thinking weapon,armor and two accesories.
    public Blackmage(int level,String name, Status status, int Hpcap, int Hp,int Strength, int Defence, int Vitality, int Magic, int Speed, int Exp, int Expcap){
        super(level, name, status, Hpcap, Hp, Strength, Defence, Vitality, Magic, Speed, Exp, Expcap);
        this.Job="Blackmage";
        //this.Growths={3,2,5,7,0,9}; I'm so changing this
        this.mana=0; //It might be cool to make warriors stats scale with gauge. That way the player chooses between explosive dps or reliable damage?
        //this.equipment={} Start out unarmed;
        this.maxmana=100;

    }
    public Blackmage(){
        this(1,"Ried",Status.NORMAL,1,1,1,1,1,1,2,1,1);
    }
    public void action(String move,Object other,Entity[] targets){
        //have attack be calculated independently
        int actual_magic=this.Magic;
        Enemy opponent = (Enemy) other;
        if(move == "fire" ){
            int damage = 2*this.Magic+50;
            opponent.takeDamage(damage);

        }
        //Just an Idea for now. Probably not gonna do this
        else if(move == "fire" && this.getStatus()==Status.BERSERK ){
            Entity victim = this.random_attack(targets);
            Entity victim2 = this.random_attack(targets);
            this.Magic=this.Magic*3;
            int damage1=this.Magic;
            damage1=damage1-victim.getDefence();
            int damage2=this.Magic;
            damage2=damage2-victim2.getDefence();
            System.out.println(this.name+' '+"Used Flame torrent on "+victim.getName() +" and"+victim2.getName()+"!");
            victim.takeDamage(damage1);
            victim2.takeDamage(damage2);


            //Boosted fire that damages everyone
            // bassically budget meteor
        }
        
        
        this.Magic=actual_magic;
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
    public int find_original_Maxmana(){
        int original_Maxmana;
        original_Maxmana=(int)(this.maxmana-.5*this.Magic);
        return(original_Maxmana);
    }
    public void calculateHpcap(){
        this.maxmana=(int)(this.find_original_Maxmana()+.5*this.Magic);
    }
    public String toString(){
        String result="";
        result+="Name: "+this.name+"\n";
        result+="Job: "+this.Job+"\n";
        result+="level: "+this.level+"\n";
        result+="Status: "+this.status.name()+"\n";
        result+="Exp: "+Integer.toString(this.Exp)+"/"+Integer.toString(this.Expcap)+"\n";
        result+="Health "+Integer.toString(this.Hp)+"/"+Integer.toString(this.Hpcap)+"\n";
        result+="Mana: "+Integer.toString(this.mana)+"/"+Integer.toString(this.maxmana)+"\n";
        result+="Strength: "+Integer.toString(this.Strength)+"\n";
        result+="Defence: "+Integer.toString(this.Defence)+"\n";
        result+="Vitality: "+Integer.toString(this.Vitality)+"\n";
        result+="Magic: "+Integer.toString(this.Magic)+"\n";
        result+="Speed: "+Integer.toString(this.Speed)+"\n";
        
        return(result);
    }
    
    
}

