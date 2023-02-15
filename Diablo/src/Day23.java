public class Day23 {
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

    }
}
