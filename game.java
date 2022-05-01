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
        Random random = new Random();
        random.nextInt(10);
        for(int i=0;i<20;i++){

        
        System.out.println(random.nextInt(10));
        }
        /*
        Warrior mark= new Warrior();          //2nd
        Whitemage helena= new Whitemage();    // 4th
        Blackmage Ried = new Blackmage();     //3rd
        Assassin Des = new Assassin();        //first
        Linkedlist turns=new Linkedlist();

        turns.push(helena);
        turns.push(Des);
        turns.push(Ried);
        turns.push(mark);


        System.out.println(turns);
        */

    }
}