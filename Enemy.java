public abstract class Enemy {
    protected int level;
    protected String name;
    protected Status status;
    protected int Hpcap;
    protected int Hp;
    protected int Strength;
    protected int Defence;
    protected int Vitality;
    protected int Speed;
    protected int Exp;
    protected int moneyget;
    public Enemy(int level, String name, Status status, int Hpcap, int Hp, int Defence, int Vitality,  int Speed, int Exp, int moneyget){
        this.level = level;
        this.name = name;
        this.status = status;
        this.Hpcap = Hpcap;
        this.Hp = Hp;
        this.Defence = Defence;
        this.Vitality = Vitality;
        this.Speed = Speed;
        this.Exp = Exp;
        this.moneyget = moneyget;
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
    public int getSpeed(){
        return(this.Speed);
    }
    public int getExp(){
        return(this.Exp);
    }   
    public void attack(Hero other){
        
    }
    public abstract void action(Hero other);

}
