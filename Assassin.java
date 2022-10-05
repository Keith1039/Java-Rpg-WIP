
import java.util.Random;





public class Assassin extends Hero{
    //Aka status effect hell
    //lowest stats of all but with concentration
    private String Job;
    private int[] Growths;
    private int concentration;
    //private String equipment[]; //I'm thinking weapon,armor and two accesories.
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
        this.Movelist=new String[]{"Poison Blade","Knife Volley","Dies Eres"};
        this.Moves=new MoveLinkedList();
        this.Moves.append(this.Movelist[0]);

    }
    public Assassin(){
        this(1,"Des",Status.NORMAL,1,1000,1000,1,1,1,6,1,1);
    }
    public void action(String move,Object other,Entity[] targets){
        
        //have attack be calculated independently
        //int actual_strength=this.Strength;
        int damage=0;
        
        Enemy opponent = (Enemy) other;
        if(move == "Poison Blade" && this.concentration>=20){
            damage = (int) (this.concentration*.7+this.Strength);
            opponent.takeDamage(damage);
            opponent.setStatus(Status.POISONED);
            this.concentration=this.concentration-20;
        }
        
        else if(move == "Poisoned Blade" && this.getStatus()==Status.BERSERK && this.concentration>=20 ){
            damage = (int) (this.concentration*.95+this.Strength);
            Entity victim = this.random_attack(targets);
            damage=damage-victim.getDefence();
            System.out.println(this.name+" "+"Used Venom Edge on "+victim.getName()+"!");
            victim.takeDamage(damage);
            victim.setStatus(Status.POISONED);
            this.gain_concentration(damage);
            this.concentration=this.concentration-20;
            
            //make it able to hit anyone, maybe not themselves tho?
            /*
            opponent.takeDamage(damage);
            opponent.setStatus(Status.POISONED);
            */
        }

        else if(move =="Knife Volley"){
            damage = (int)(this.concentration*.60+this.Strength);
            Entity victim = (Entity) other;
            damage = damage-victim.getDefence();
            Random genRandom = new Random();
            int count =0;
            for(int i=0;i<5;i++){
                System.out.println(this.name+" throws a barrage of knives!");
                if(genRandom.nextInt(100)<=60){
                    victim.takeDamage(damage);
                    count++;
                    gain_concentration(damage);
                }
                else{
                    System.out.println("The barrage missed!");
                }
            }
            if(count >=3){
                victim.setStatus(Status.STUNNED);
            }

        }
        else if(move == "Knife Volley" && this.status== Status.BERSERK){
            Random genRandom = new Random();
            
            for(int i=0; i<10;i++){
                Entity victim = targets[genRandom.nextInt(targets.length)];
                System.out.println(this.name+" throws a storm of knives!");
                if(genRandom.nextInt(100)<=65){
                    damage = (int)(concentration*80+this.Strength);
                    victim.takeDamage(damage);
                    gain_concentration(damage);
                    
                }
                else{
                    System.out.println("The attack missed!");
                }

            }
        }
        else if(move == "Dies Eres" && status != Status.CHARGED && status != Status.BERSERK){
            System.out.println(this.name+' '+"is charging up!");
            this.setStatus(Status.CHARGED);
        }
        else if(move == "Dies Eres" && status == Status.CHARGED){
            Random genRandom = new Random();
            Enemy victim = (Enemy) other;
            if(victim.getMobtype()==Mobtype.MOB){
                if(genRandom.nextInt(100)<=80){
                    victim.setStatus(Status.DEAD);
                    System.out.println(victim.getName()+' '+"Took 99999999999999999999999999999999999999 damage!");
                }

                else{
                    victim.takeDamage(damage);
                    damage=(int)(concentration*.9+this.Strength*1.15);

                }
            }
            else{
                if(genRandom.nextInt(100)<=5){
                    victim.setStatus(Status.DEAD);
                    System.out.println(victim.getName()+' '+"Took 999999999999999999999999999999999999999 damage!");
                }
                else{
                    victim.takeDamage(damage);
                    damage=(int)(concentration*.9+this.Strength*1.15);
                }
            }
        }
        else if(move=="Dies Eres"&& status==Status.BERSERK){
            Random randomgen =  new Random();
            damage=(int)(concentration*.7+this.Strength*1.15);
            for(int i=0; i<3;i++){
                Entity victim = targets[randomgen.nextInt(targets.length)];
                if(i==1){//instance of hero1
                    if(randomgen.nextInt(100)<=10){
                        victim.setStatus(Status.DEAD);
                        System.out.println(victim.getName()+' '+"Took 999999999999999999999999999999999999999 damage!");
                    }
                    else{
                        victim.takeDamage(damage);
                    }
                }
                if(i==2){ //Instance of villain
                    //mobtype blah blah blah 100% on regular mobs, 20% on bosses

                }
            }
            this.ResetConcentration();
        }

        
        if(move!="Knife Volley"){
            gain_concentration(damage);
        }
        

        this.Nullbuff();
        this.Applybuff();
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
    public void ResetConcentration(){
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
        this.Hp=this.Hp-damage;
        if(this.Hp<0){
            this.setStatus(Status.DEAD);
            this.ResetConcentration();
        }
        if(damage>=((int)(.20*this.Hpcap)) && this.getStatus()==Status.CHARGED){
            this.setStatus(Status.STAGGERED);
            System.out.println(this.name+' '+"Was caught off guard!");
            this.ResetConcentration();
        }
        this.lose_concentration(damage);
        this.Applybuff();
        this.correctHp();
    }
    public void lose_concentration(int damage){
        this.concentration=(int)(this.concentration-.5*damage);
        this.correct_concentration();
    }
    public void levelup(){
        this.level++;
        //deal with growths later
        
        //this.Strength=this.Strength+Growths[0];
        //this.Defence=this.Defence+Growths[1];
        this.Exp=this.Exp-this.Expcap;
        this.Expcap=this.Expcap+50*this.level;
        this.setOriginal_stats();
        if(this.level==5){
            this.Moves.append(this.Movelist[1]);
            System.out.println(this.name+' '+"has learned "+"'"+this.Movelist[1]+"'!");
        }
        if(this.level==10){
            this.Moves.append(this.Movelist[2]);
            System.out.println(this.name+' '+"has learned "+"'"+this.Movelist[2]+"'!");
        }
        
    }

    public String toString(){
        String result="";
        result+="Name: "+this.name+"\n";
        result+="Job: "+this.Job+"\n";
        result+="level: "+this.level+"\n";
        result+="Status: "+this.status.name()+"\n";
        result+="Exp: "+Integer.toString(this.Exp)+"/"+Integer.toString(this.Expcap)+"\n";
        result+="Health: "+Integer.toString(this.Hp)+"/"+Integer.toString(this.Hpcap)+"\n";
        result+="Concentration: "+Integer.toString(this.concentration)+"/"+Integer.toString(100)+"\n";
        result+="Strength: "+Integer.toString(this.Strength)+"(+"+Integer.toString((int)(.5*this.concentration))+")"+"\n";
        result+="Defence: "+Integer.toString(this.Defence)+"(+"+Integer.toString((int)(.5*this.concentration))+")"+"\n";
        result+="Vitality: "+Integer.toString(this.Vitality)+"\n";
        result+="Magic: "+Integer.toString(this.Magic)+"\n";
        result+="Speed: "+Integer.toString(this.Speed)+"(+"+Integer.toString((int)(.5*this.concentration))+")"+"\n";
        
        return(result);
    }
    
    
}

