public class Assassin extends Hero{
    //Aka status effect hell
    //lowest stats of all but with concentration
    private String Job;
    private int[] Growths;
    private int concentration;
    private String equipment[]; //I'm thinking weapon,armor and two accesories.
    private int original_strength;
    private int original_defence;
    private int original_speed;
    public Assassin(int level,String name, Status status, int Hpcap, int Hp, int Strength, int Defence, int Vitality, int Magic, int Speed, int Exp, int Expcap){
        super(level, name, status, Hpcap, Hp, Strength, Defence, Vitality, Magic, Speed, Exp, Expcap);
        this.Job="Assassin";
        //this.Growths={3,2,5,7,0,9}; I'm so changing this
        //concentration boosts stats
        this.concentration=0; 
        //this.equipment={} Start out unarmed;
        this.setOriginal_stats();

    }
    public Assassin(){
        this(1,"Mark",Status.NORMAL,1,1000,1000,1,1,1,1,1,1);
    }
    public void action(String move,Object other){
        
        //have attack be calculated independently
        int actual_strength=this.Strength;
        
        Enemy opponent = (Enemy) other;
        if(move == "Poison blade" && this.concentration>20){
            int damage = (int) (this.concentration*.7+this.Strength);
            opponent.takeDamage(damage);
            opponent.setStatus(Status.POISONED);
            

        }
        
        else if(move == "Poison blade" && this.getStatus()==Status.BERSERK && this.concentration>20 ){
            int damage = (int) (this.concentration*.95+this.Strength);
            //make it able to hit anyone
            /*
            opponent.takeDamage(damage);
            opponent.setStatus(Status.POISONED);
            */
            
        }
        
        
        
        
    }
    public void Applybuff(){
        //The more concentration, the higher the stat boosts. The lower the concentration, the lower the stat boosts
        this.Strength=(int)(this.original_strength+.5*this.concentration);
        this.Defence=(int)(this.original_defence+.5*this.concentration);
        this.Speed=(int)(this.original_speed+.5*this.concentration);
    }
    public void Nullbuff(){
        this.Strength=(int)(this.original_strength-.5*this.concentration);
        this.Defence=(int)(this.original_defence-.5*this.concentration);
        this.Speed=(int)(this.original_speed-.5*this.concentration);
    }
    public void setOriginal_stats(){
        this.original_strength=this.Strength;
        this.original_defence=this.Defence;
        this.original_speed=this.Speed;
    }
    public void setConcentration(){
        //meant to be used at the start of the fight
        this.concentration=0;
    }
    public void attack(Object other){
        this.Applybuff();
        Enemy vilain=(Enemy) other;
        int result;
        result = this.Strength-vilain.Defence;
        vilain.takeDamage(result);
        this.Nullbuff();
        this.gain_concentration(result);
        this.correct_concentration();
        
    }
    public void correct_concentration(){
        if(this.concentration>100){
            this.concentration=100;
        }
        else if(this.concentration<0){
            this.concentration=0;
        }
    }
    public void gain_concentration(int damage){
        this.concentration=(int)(this.concentration+.5*damage);
        this.correct_concentration();
    }
    public void takeDamage(int damage){
        this.Nullbuff();
        if(damage < 0){
            damage=0;
        }
        else if(damage > this.Hp){
            this.Hp=0;
            this.setStatus(Status.DEAD);
            damage=0;
        }
        this.Hp=this.Hp-damage;
        this.lose_concentration(damage);
        this.Applybuff();
    
        
    }
    public void lose_concentration(int damage){
        this.concentration=(int)(this.concentration-.5*damage);
        this.correct_concentration();
    }
    public void levelup(){
        this.level++;
        //deal with growths later
        this.Strength=this.Strength+Growths[0];
        this.Defence=this.Defence+Growths[1];
        this.Exp=this.Exp-this.Expcap;
        this.Expcap=this.Expcap+50*this.level;
        this.setOriginal_stats();
        
    }

    public String toString(){
        String result="";
        result+="Name: "+this.name+"\n";
        result+="Job: "+this.Job+"\n";
        result+="level: "+this.level+"\n";
        result+="Status: "+this.status.name()+"\n";
        result+="Exp: "+Integer.toString(this.Exp)+"/"+Integer.toString(this.Expcap)+"\n";
        result+="Health "+Integer.toString(this.Hp)+"/"+Integer.toString(this.Hpcap)+"\n";
        result+="Concentration: "+Integer.toString(this.concentration)+"/"+Integer.toString(100)+"\n";
        result+="Strength: "+Integer.toString(this.Strength)+"(+"+Integer.toString((int)(.5*this.concentration))+")"+"\n";
        result+="Defence: "+Integer.toString(this.Defence)+"(+"+Integer.toString((int)(.5*this.concentration))+")"+"\n";
        result+="Vitality: "+Integer.toString(this.Vitality)+"\n";
        result+="Magic: "+Integer.toString(this.Magic)+"\n";
        result+="Speed: "+Integer.toString(this.Speed)+"(+"+Integer.toString((int)(.5*this.concentration))+")"+"\n";
        
        return(result);
    }
    
    
}

