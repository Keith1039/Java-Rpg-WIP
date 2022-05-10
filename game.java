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

        int level;
        String name;
        Status status;
        int Hpcap;
        int Hp;
        int Strength;
        int Defence;
        int Vitality;
        int Magic;
        int Speed;
        int Exp;
        int Expcap;

        
        while(scanner.hasNext()==true){ //every 13 it switches to a new character, lines 2,7 don't matter
            tracker2++;
            System.out.println(tracker2);
            //System.out.println(scanner.nextLine());
            if(tracker2==1){
                name=scanner.nextLine();
                String actual_name="";
                char[] array=name.toCharArray();
                boolean condition =false;

                for(int i =0; i<array.length;i++){
                    

                if(condition == true){
                    actual_name+=array[i];
                }
                if(array[i]==' '){
                    condition=true;
                }
                }
            }
            if(tracker2==5){
                String returnable = digitstring(scanner.nextLine());
                level=Integer.parseInt(returnable);
                //level = Integer.valueOf(returnable);
                //System.out.println(level);

            }
        }
        scanner.close();


        return(objects);
    }

    public String digitstring(String string){
        char[] returnables = string.toCharArray();
        String digitstring ="";

        for(int i=0; i<returnables.length;i++){
            Character test = returnables[i];
            if(test.isDigit(returnables[i])==true){
                digitstring+=returnables[i];
            }
        }

        return(digitstring);
    }

}


