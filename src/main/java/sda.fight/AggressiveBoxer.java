package sda.fight;

public class AggressiveBoxer extends Boxer {

    private int baseHp;
    public AggressiveBoxer(String name, int hp, IFighterStyle style, int attackPower) {
        super(name, hp, style, attackPower);
        this.baseHp = hp;
    }

    @Override
    public int getAttackPower(){
        int strengthToReturn = attackPower;
        if (getHp() < baseHp /2) {
            strengthToReturn += 3;
        }
        return strengthToReturn;
    }
}
