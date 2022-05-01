import javax.swing.text.StyledEditorKit.BoldAction;

public interface Entity {
    public void attack(Object other);
    public Boolean canAct();
    public void takeDamage(int damage);
    public void setStatus(Status effect);

}
