import java.util.Random;

public class game{
    public static void main(String[] args){
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



        //System.out.println(turns);
        

    }
}