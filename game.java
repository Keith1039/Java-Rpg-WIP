import javax.swing.JFrame;
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
        Warrior mark= new Warrior();
        Whitemage helena= new Whitemage();
        Blackmage Ried = new Blackmage();
        Assassin Des = new Assassin();
        Linkedlist turns=new Linkedlist();

        turns.push(helena);
        System.out.println(turns);
        turns.push(Des);
        System.out.println(turns);
        turns.push(Ried);
        System.out.println(turns);
        turns.push(mark);
        System.out.println(turns);

    }
}