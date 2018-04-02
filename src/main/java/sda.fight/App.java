package sda.fight;


public class App 
{
    public static void main( String[] args ) {

        IFighter boxer1 = new AggressiveBoxer("Mike Tyson", 100, IFighterStyle.HIGH,1);
        IFighter boxer2 = new Boxer("Andrzej Gołota", 100,IFighterStyle.LOW,15);
        IFightingMatch match = new BoxingMatch(boxer1,boxer2);
        match.fight();
    }
}
