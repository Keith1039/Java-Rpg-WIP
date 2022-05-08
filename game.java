import java.util.Random;
import java.io.*;
public class game{
    private int gamestate=0;
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

        for(int i=0; i<999;i++){
        mark.levelup();
        }
        
        //System.out.println(mark.printMovelist());
        nice.save(Des, helena, Ried, mark);
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
            for(int i=0;i<hirro.length;i++){
                printWriter.println(hirro[i].toString());
                printWriter.flush();
                
            }
            printWriter.close();
            
    
        }catch(IOException e){
            System.out.println("Error occured");
        }
    }

    public Object[] load(File saveFile){
        Object[] objects =new Object[5];

        return(objects);
    }
}

