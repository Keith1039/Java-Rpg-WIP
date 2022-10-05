

public interface Entity {
    public void attack(Object other);
    public Boolean canAct();
    public void takeDamage(int damage);
    public void setStatus(Status effect);
    
    //Getters
    public int getLevel();
    public String getName();
    public Status getStatus();
    public int getHpcap();
    public int getHp();
    public int getStrength();
    public int getDefence();
    public int getVitality();
    public int getMagic();
    public int getSpeed();
    public int getExp();
    public Boolean isDead();

}
