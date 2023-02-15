public class Sorceress extends Character{

    public Sorceress(){
        hp = 350;
        mp = 550;
    }
    @Override
    void attack() {

    }

    @Override
    void info(){
        System.out.println("체력 : " + hp + "\n지능 : "+ mp);
    }
}
