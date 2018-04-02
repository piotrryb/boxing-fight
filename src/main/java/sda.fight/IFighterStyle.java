package sda.fight;

public enum IFighterStyle {
    LOW(75), HIGH(25), BALANCED(50);

    int lowPercentage;

    IFighterStyle(int lowPercentage) {
        this.lowPercentage = lowPercentage;
    }

    public int getLowPercentage() {
        return lowPercentage;
    }
}
