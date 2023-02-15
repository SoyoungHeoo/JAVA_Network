import Diablo.Axe;
import Diablo.Babarian;
import Diablo.Bow;
import Diablo.Sorceress;

public class Day23 {
    // Diablo v0.5
    public static void main(String[] args){
        Babarian b1 = new Babarian();
        Sorceress s1 = new Sorceress();
        Bow windForce = new Bow();
        Axe berserkerAxe = new Axe();
        b1.setWeapon(berserkerAxe);
        b1.performWeapon();

        s1.setWeapon(windForce);
        s1.performWeapon();
        s1.setWeapon(new Axe());
        s1.performWeapon();

        s1.info();
        b1.setWeapon(() -> System.out.println("신오브로 아이스볼을 발사"));
        b1.performWeapon();
    }
}
