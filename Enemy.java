public abstract class Enemy implements Entity{
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
    public void attack(Object other){
        int result;
        Hero h = (Hero) other;
        result=this.Strength-h.Defence;
        h.takeDamage(result);
        
    }
    public abstract void action(Hero other);

    public Boolean canAct(){
        Status condition = this.status;
        Boolean result = true;
        if(condition==Status.DEAD){
            //Can't do anything since you're dead
            result=false;
            System.out.println(this.name+" is dead! They cannot act");
        }
        else if(condition==Status.STUNNED){
            //Can't do anything since you're stunned
            result=false;
            System.out.println(this.name+" is stunned! They cannot act");
        }
        else if(condition==Status.STAGGERED){
            //Chance to miss or just not do anything increased
            //Might mix this up later
            result=false;
            System.out.println(this.name+" has been staggered! They cannot act!");
        }
        return(result);
    }

    public void setStatus(Status effect){
        this.status=effect;
    }

    public void takeDamage(int damage){
        if (damage <0){
            damage=0;
        }
        this.Hp=this.Hp-damage;
    }
}
