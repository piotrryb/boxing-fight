package sda.fight;

public interface IFighter {

    boolean isAlive();

    FighterAttackActionType attack();

    FighterDefenceActionType defend();

    void decreaseHp(int attackPower);

    String getName();

    int getHp();

    int getAttackPower();

}
