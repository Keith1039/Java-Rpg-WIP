import java.lang.invoke.VolatileCallSite;
import java.util.Random;

public abstract class Hero implements Entity {
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
    protected int Exp;
    protected int Expcap;
    protected String[] Movelist;
    protected MoveLinkedList Moves;
    

        
    public Hero(int level, String name, Status status, int Hpcap, int Hp, int Strength, int Defence, int Vitality, int Magic, int Speed, int Exp, int Expcap){
        this.level = level;
        this.name = name;
        this.status = status;
        this.Hpcap = Hpcap;
        this.Hp = Hp;
        this.Strength=Strength;
        this.Defence = Defence;
        this.Vitality = Vitality;
        this.Magic = Magic;
        this.Speed = Speed;
        this.Exp = Exp;
        this.Expcap = Expcap;
        }
    public int getLevel(){
        return(this.level);
    }
    public String getName(){
        return(this.name);
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
    
    public int getExp(){
        return(this.Exp);
    }   

    public void takeDamage(int damage){
        
        if(damage < 0){
            damage=0;
        }
        this.Hp=this.Hp-damage;
        if(this.Hp<0){
            this.setStatus(Status.DEAD);
        }

        if(damage==((int)(.20*this.Hpcap)) && this.getStatus()==Status.CHARGED){
            this.setStatus(Status.STAGGERED);
            System.out.println(this.name+' '+"Was caught off guard!");
        }
        
        System.out.println(this.name+' '+"took "+Integer.toString(damage)+" damage!");

        this.correctHp();
        
        
    }

    public void getExperience(Enemy other){
        this.Exp=this.Exp+other.getExp();
        while(this.Exp > this.Expcap){
            this.levelup();
        }
    }

    public abstract void levelup();

    //This will check the status of the party member before they're allowed to act.
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
    public void checkStatus(){
        Status condition=this.status;
        if(condition==Status.POISONED){
            //take a certain amount of damage based on health
            int damage = (int) .10*this.Hp;
            this.takeDamage(damage);
            System.out.println(this.name+" is poisoned and took "+Integer.toString(damage));
        }
        else if(condition==Status.SILENCED){
            //Cannot use "Action" command

        }
        else if(condition==Status.BERSERK){
            //Fun things happen :)
        }
    }

    //Menu for the actual player characters. Honestly this might just become it's own class.
    public void menu(){

        
    }
    public Entity random_attack(Entity[] targets){
        Random random = new Random();
        Entity target= targets[random.nextInt(targets.length)];
        return(target);
        
    }
    public void attack(Object other){
        Enemy vilain=(Enemy) other;
        int result;

        result = this.Strength-vilain.Defence;
        vilain.takeDamage(result);

    }
    public abstract void action(String move,Object other, Entity[] targets);

    public void correctHp(){
        if(this.Hp > this.Hpcap){
            this.Hp=this.Hpcap;
        }
        else if(this.Hp<0){
            this.Hp=0;
        }
    }
    public void regen(int heal ){
        if(this.status!=Status.DEAD){
            this.Hp=this.Hp+heal;
            System.out.println(this.name+' '+"healed "+Integer.toString(heal)+" HP!");
            this.correctHp();
        }
        else if(this.status==Status.DEAD){
            System.out.println(this.name+' '+"is Dead and thus can't be healed!");
        }

    }

    public void useitem(){
        //might use a dictionary for this
    }
    public void defend(){

    }
    public void setStatus(Status effect){
        this.status=effect;
    }

    public boolean run(Enemy other){
        //make it impossible to run from boss.
        boolean result=false; 
        //I'll probably use random for this. I have to make it so that the higher the level the lower the odds of running.
        return(result);
    }
    public int find_original_hpcap(){
        int original_hpcap;
        original_hpcap=(int)(this.Hpcap-.5*this.Vitality);
        return(original_hpcap);
    }
    public void calculateHpcap(){
        this.Hpcap=(int)(this.find_original_hpcap()+.5*this.Vitality);
    }

    public String printMovelist(){
        String res=this.Movelist.toString();
        return(res);
    }


    
}
