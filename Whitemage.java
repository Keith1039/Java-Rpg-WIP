public class Whitemage extends Hero{
    private String Job;
    private int[] Growths;
    private int mana;
    private int maxmana;
    //private String equipment[]; //I'm thinking weapon,armor and two accesories.

    public Whitemage(int level,String name, Status status, int Hpcap, int Hp, int Strength, int Defence, int Vitality, int Magic, int Speed, int Exp, int Expcap){
        super(level, name, status, Hpcap, Hp,Strength, Defence, Vitality, Magic, Speed, Exp, Expcap);
        this.Job="Whitemage";
        //this.Growths={3,2,5,7,0,9}; I'm so changing this
        this.mana=0; //It might be cool to make warriors stats scale with gauge. That way the player chooses between explosive dps or reliable damage?
        //this.equipment={} Start out unarmed;
        this.maxmana=100;
        this.Movelist= new String[]{"Light Heal","Calming Prayer","Blessing Of Light"};
        this.Moves=new MoveLinkedList();
        this.Moves.append(this.Movelist[0]);

    }
    public Whitemage(){
        this(1,"helena",Status.NORMAL,1,1,1,1,1,1,1,1,1);
    }
    public void action(String move,Object other,Entity[] targets){
        //have attack be calculated independently
        int actual_magic=this.Magic;
        Hero ally = (Hero) other;
        if(move == "Light Heal"&&this.getStatus()!=Status.BERSERK ){
            
            System.out.println(this.name+' '+"used Light Heal on "+ally.name);
            int heal = 2*this.Magic+50;
            ally.regen(heal);

        }
        //Just an Idea for now. Probably not gonna do this
        else if(move == "Light Heal" && this.getStatus()==Status.BERSERK ){
            Entity victim = this.random_attack(targets);
            System.out.println(this.name+' '+"used Inverse Heal on "+victim.getName());
            this.Magic=this.Magic*6;
            int heal=2*this.Magic+50;
            heal=heal-victim.getDefence();
            victim.takeDamage(heal);
            this.regen((int)(.5*heal));
            System.out.println(victim.getHp());
            //victim.takeDamage(heal);
            
            

            //does the opposite of healing and drains their hp. Problem is it can happen to anyone. Don't know who
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
        if(this.level==5){
            this.Moves.append(this.Movelist[1]);
            System.out.println(this.name+' '+"has learned "+"'"+this.Movelist[1]+"'!");
        }
        if(this.level==10){
            this.Moves.append(this.Movelist[2]);
            System.out.println(this.name+' '+"has learned "+"'"+this.Movelist[2]+"'!");
        }
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
