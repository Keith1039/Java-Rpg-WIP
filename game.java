import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class game{
    private int gamestate=0;
    private int money=0;
    //private String[] items = null; probably make a list function for items
    public static void main(String[] args) throws IOException{
        game nice= new game();
        
        /*
        JFrame frame = new JFrame("Rpg");
        frame.setVisible(true);
        Assassin test_assassin=new Assassin();
        Goblin test_Goblin=new Goblin();
        test_assassin.attack(test_Goblin);
        System.out.println(test_assassin);
        */
        
        Warrior mark= new Warrior();          //2nd
        Whitemage helena= new Whitemage();    // 4th
        Blackmage Ried = new Blackmage();     //3rd
        Assassin Des = new Assassin();        //first
        TestDummy dummy = new TestDummy();
        Linkedlist turns=new Linkedlist();

        /*
        for(int i=0; i<999;i++){
        mark.levelup();
        }
        */
        
        //System.out.println(mark.printMovelist());
        nice.save(Des, helena, Ried, mark);

        nice.load(new File("Save"));
        //mark.levelup();
        //nice.save(Des, helena, Ried, mark);
        /*
        turns.push(helena);
        turns.push(Des);
        turns.push(Ried);
        turns.push(mark);
        Entity[] list= new Entity[]{(Entity)mark,(Entity)helena,(Entity)Ried,(Entity)Des,(Entity)dummy};
        helena.setStatus(Status.BERSERK);
        helena.action("Light Heal", Ried, list);
        //System.out.println(mark.getStatus().toString());
        //System.out.println(helena.getStatus().toString());
        //System.out.println(Des.getStatus().toString());
        //System.out.println(dummy.getStatus().toString());
        */



        //System.out.println(turns);
        

    }

    public void save(Assassin assassin,Whitemage whitemage,Blackmage blackmage, Warrior warrior) throws IOException{
        Hero[] hirro = new Hero[]{assassin,whitemage,blackmage,warrior};
        
        try{
            File f= new File("Save");
            if(f.exists()==false){
                f.createNewFile();
            }
            FileWriter writer = new FileWriter(f);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(Integer.toString(this.gamestate));
            printWriter.println(Integer.toString(this.money));
            for(int i=0;i<hirro.length;i++){
                printWriter.println(hirro[i].toString());
                printWriter.flush();
                
            }
            printWriter.close();
            
    
        }catch(IOException e){
            System.out.println("Error occured");
        }

        
    }

    //right now I'm pretty sure this works but right now I'm missing an items list
    public Object[] load(File saveFile) throws IOException{ // only shows up if save file exists
        Assassin assassin=null;
        Blackmage blackmage=null;
        Whitemage whitemage=null;
        Warrior warrior=null;
        Hero[] hirros=new Hero[]{assassin,whitemage,blackmage,warrior};
        Object[] objects =new Object[6]; //first 2 are ints, the others are gonna be the hero objects
        Scanner scanner= new Scanner(saveFile);
        
        int tracker=0;
        int tracker2=0;
        objects[0]=Integer.parseInt(scanner.nextLine());
        objects[1]=Integer.parseInt(scanner.nextLine());

        int current_mana=0;
        int level=0;
        String name="";
        Status status=Status.NORMAL;
        int Hpcap=0;
        int Hp=0;
        int Strength=0;
        int Defence=0;
        int Vitality=0;
        int Magic=0;
        int Speed=0;
        int Exp=0;
        int Expcap=0;

        
        while(scanner.hasNext()==true){ //every 13 it switches to a new character, lines 2,7 don't matter
            tracker2++;
            //System.out.println(tracker2);
            //System.out.println(scanner.nextLine());
            String x = scanner.nextLine();
         
            if(tracker2==1){
                String actual_name="";
                char[] array=x.toCharArray();
                boolean condition =false;

                for(int i =0; i<array.length;i++){
                    

                if(condition == true){
                    actual_name+=array[i];
                }
                if(array[i]==' '){
                    condition=true;
                }
                }
                name=actual_name;
            }
            if(tracker2==3){
                String returnable = digitstring(x);
                level=Integer.parseInt(returnable);
            }
            
            if(tracker2==4){
                boolean flag1 = false;
                String STATUS ="";
                char[] array = x.toCharArray();
                for(int i=0;i<array.length;i++){
                    if(flag1==true){
                        STATUS+=array[i];
                    }
                    if(array[i]==' '){
                        flag1=true;
                    }
                }
                System.out.println(STATUS);
                status=(Status.valueOf(STATUS));
            }
            
            if(tracker2==5){
                String[] value_valuecap=digitstringmod(x);
                Exp=Integer.parseInt(value_valuecap[0]);
                Expcap = Integer.parseInt(value_valuecap[1]);
            }

            if(tracker2==6){

                String[] value_valuecap=digitstringmod(x);
                Hp=Integer.parseInt(value_valuecap[0]);
                Hpcap= Integer.parseInt(value_valuecap[1]);
            }
            //make sure to add a way for the mages mana to be recorded
            if(tracker2==7 && tracker==1 || tracker2==7 && tracker==2){
                String[] Manavalues=digitstringmod(x);
                current_mana=Integer.parseInt(Manavalues[0]);
            }
            if(tracker2>7&&tracker2!=13){
                String stat_val=digitstring(x);
                int stat_num_val = Integer.parseInt(stat_val);
                if(tracker2==8){
                    Strength=stat_num_val;
                }
                if(tracker2==9){
                    Defence=stat_num_val;
                }
                if(tracker2==10){
                    Vitality=stat_num_val;
                }
                if(tracker2==11){
                    Magic=stat_num_val;
                }
                if(tracker2==12){
                    Speed=stat_num_val;
                }
            }

            if(tracker2==13){
                tracker2=0;
                Hero target=hirros[tracker];
                if(tracker==0){
                    target=new Assassin(level, name, status, Hpcap, Hp, Strength, Defence, Vitality, Magic, Speed, Exp, Expcap);
                }
                if(tracker==1){
                    target= new Whitemage(level, name, status, Hpcap, Hp, Strength, Defence, Vitality, Magic, Speed, Exp, Expcap);
                    Whitemage target2 = (Whitemage) target;
                    target2.setMana(current_mana);
                }
                if(tracker==2){
                    target= new Blackmage(level, name, status, Hpcap, Hp, Strength, Defence, Vitality, Magic, Speed, Exp, Expcap);
                    Blackmage target2 = (Blackmage) target;
                    target2.setMana(current_mana);
                }
                if(tracker==3){
                    target= new Warrior(level, name, status, Hpcap, Hp, Strength, Defence, Vitality, Magic, Speed, Exp, Expcap);
                }
                objects[2+tracker]=target;
                tracker++;
            }
        }
        scanner.close();


        return(objects);
    }

    public String digitstring(String string){
        char[] returnables = string.toCharArray();
        String digitstring =" ";

        for(int i=0; i<returnables.length;i++){
            Character test = returnables[i];
            if(test.isDigit(returnables[i])==true){
                digitstring+=returnables[i];
            }
        }
        digitstring=digitstring.trim();
        return(digitstring);
    }

    public String[] digitstringmod(String string){
        char[] returnables = string.toCharArray();
        String[]digitstringmod=new String[2];
        boolean flip=false;
        String value ="";
        String valuecap="";
        for(int i=0; i<returnables.length;i++){
            Character test = returnables[i];
            if(test.isDigit(returnables[i])==true && flip==false){
                value+=returnables[i];
            }
            else if(test.isDigit(returnables[i])==true && flip==true){
                valuecap+=returnables[i];
            }

            if(returnables[i]=='/'){
                flip=true;
            }

        }
        digitstringmod[0]=value;
        digitstringmod[1]=valuecap;
        return(digitstringmod);
    }
}


