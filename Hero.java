import javax.naming.spi.DirStateFactory.Result;

public abstract class Hero {
    protected int level;
    protected String name;
    protected Status status;
    protected int Hpcap;
    protected int Hp;
    protected int Strength;
    protected int Defence;
    protected int Vitality;
    protected int Magic;
    protected int Speed;
    protected static int Balance; //probably a better way to do this. I should ask Wilt
    protected int Exp;
    protected int Expcap;
    protected int[] items_list; //probably a better way to do this. I should ask Wilt
        
    public Hero(int level, String name, Status status, int Hpcap, int Hp, int Defence, int Vitality, int Magic, int Speed, int Balance, int Exp, int Expcap){
        this.level = level;
        this.name = name;
        this.status = status;
        this.Hpcap = Hpcap;
        this.Hp = Hp;
        this.Defence = Defence;
        this.Vitality = Vitality;
        this.Magic = Magic;
        this.Speed = Speed;
        this.Balance = Balance;
        this.Exp = Exp;
        this.Expcap = Expcap;
        }
    public int getLevel(){
        return(this.level);
    }
    public Status getStatus(){
        return(this.status);
    }
    public int getHpcap(){
        return(this.Hpcap);
    }
    public int getHp(){
        return(this.Hp);
    }    
    public int getStrength(){
        return(this.Strength);
    }    
    public int getDefence(){
        return(this.Defence);
    }   
     public int getVitality(){
        return(this.Vitality);
    }   
     public int getMagic(){
        return(this.Magic);
    }    
    public int getSpeed(){
        return(this.Speed);
    }
    public int getBalance(){
        return(this.Balance);
    }
    
    public int getExp(){
        return(this.Exp);
    }   

    public void takeDamage(int damage){
        if(damage < 0){
            damage=0;
        }
        this.Hp=this.Hp-damage;
    }

    public void getExperience(Enemy other){
        this.Exp=this.Exp+other.getExp();
        while(this.Exp > this.Expcap){
            this.levelup();
        }
    }

    public void levelup(){
        this.level++;
        this.Exp=this.Exp-this.Expcap;
        this.Expcap=this.Expcap+50*this.level;
    }

    public void menu(){

    }
    public void attack(Enemy other){
        int result;
        result = this.Strength-other.Defence;
        other.takeDamage(result);

    }
    public abstract void action(Enemy other);

    public void useitem(){

    }
    public void defend(){

    }

    public boolean run(Enemy other){
        //make it impossible to run from boss.
        boolean result=false; 
        //I'll probably use random for this. I have to make it so that the higher the level the lower the odds of running.
        return(result);
    }

}
