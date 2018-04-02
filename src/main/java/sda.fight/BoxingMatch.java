package sda.fight;

import java.util.Random;

public class BoxingMatch implements IFightingMatch {

    private IFighter fighter1;
    private IFighter fighter2;

    public BoxingMatch(IFighter fighter1, IFighter fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }

    @Override
    public void fight() {
        Random random = new Random();

        IFighter first;
        IFighter second;

        int randomValue = random.nextInt();
        if (randomValue % 2 == 0) {
            first = fighter1;
            second = fighter2;
        } else {
            first = fighter2;
            second = fighter1;
        }

        IFighter winner;
        while (true) {
            FighterAttackActionType f1_attack = first.attack();
            FighterDefenceActionType f2_block = second.defend();
            if (fighterWasHit(f1_attack, f2_block)) {
                int punchPower = second.getHp();
                second.decreaseHp(first.getAttackPower());
                punchPower -= second.getHp();
                System.out.println(first.getName() + " zadaje cios " + f1_attack.toString() + " " + second.getName() + " za " + punchPower + " punktów życia");
                System.out.println(second.getName() + " ma " + second.getHp() + " punktów życia");
                System.out.println();
            }

            if (!second.isAlive()) {
                winner = first;
                break;
            }

            FighterAttackActionType f2_attack = second.attack();
            FighterDefenceActionType fi_block = first.defend();
            if (fighterWasHit(f2_attack, fi_block)) {
                int punchPower = first.getHp();
                first.decreaseHp(second.getAttackPower());
                punchPower -= first.getHp();
                System.out.println(second.getName() + " zadaje cios " + f2_attack.toString() + " " + first.getName() + " za " + punchPower + " punktów życia");
                System.out.println(first.getName() + " ma " + first.getHp() + " punktów życia");
                System.out.println();
            }
            if (!first.isAlive()) {
                winner = second;
                break;
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Walke wygrywa " + winner.getName());
    }

    private boolean fighterWasHit(FighterAttackActionType f1_attack, FighterDefenceActionType f2_block) {
        boolean hitSuccessful = false;

        if (f1_attack.equals(FighterAttackActionType.HIGH_PUNCH)
                && f2_block.equals(FighterDefenceActionType.LOW_BLOCK)) {
            hitSuccessful = true;
        }
        if (f1_attack.equals(FighterAttackActionType.LOW_PUNCH)
                && f2_block.equals(FighterDefenceActionType.HIGH_BLOCK)) {
            hitSuccessful = true;
        }
        return hitSuccessful;
    }
}
