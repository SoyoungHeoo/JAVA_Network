public abstract class Character {
    protected int hp;
    protected int mp;
    // ...
    WeaponBehavior weapon; // Association (Aggregation) 상속 아님. 부품처럼 캐릭터클래스가 가져다 쓰는 것. loosely coupled. mess up 방지.

    abstract void attack();

    abstract void info();

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }

    // final 클래스, 메소드, 변수에 붙일 수 있다.
    // 클래스에 붙으면 : 상속불가
    // 메소드 : 자식클래스에서 고쳐쓰기 불가
    // 변수(필드): 상수취급. 고치기 불가.
    public final void performWeapon(){
        weapon.useWeapon();
    }

}
