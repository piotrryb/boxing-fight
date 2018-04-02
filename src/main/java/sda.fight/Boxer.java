package sda.fight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Boxer implements IFighter {

    private String name;
    private int hp;
    private IFighterStyle style;
    protected int attackPower;

    protected Map<FighterAttackActionType, Integer> attackStatistics = new HashMap<>();

    public Boxer(String name, int hp, IFighterStyle style, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.style = style;
        this.attackPower = attackPower;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public FighterAttackActionType attack() {
        Random random = new Random();
        int hitProbability = random.nextInt(100);

        FighterAttackActionType attack = hitProbability < style.getLowPercentage() ?
                FighterAttackActionType.LOW_PUNCH : FighterAttackActionType.HIGH_PUNCH;

        logAttackStatistics(attack);
        return attack;
    }

    private void logAttackStatistics(FighterAttackActionType attack) {
        if (!attackStatistics.containsKey(attack)) {
            attackStatistics.put(attack, 1);
        } else {
            Integer tempCounter = attackStatistics.get(attack);
            tempCounter++;
            attackStatistics.put(attack, tempCounter);
        }
    }

    @Override
    public FighterDefenceActionType defend() {
        Random random = new Random();
        int blockProbability = random.nextInt(100);

        FighterDefenceActionType block = blockProbability < style.getLowPercentage() ?
                FighterDefenceActionType.LOW_BLOCK : FighterDefenceActionType.HIGH_BLOCK;
        return block;
    }

    @Override
    public void decreaseHp(int attackPower) {
        Random random = new Random();
        hp -= random.nextInt(attackPower);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getAttackPower() {
        return attackPower;
    }

}
