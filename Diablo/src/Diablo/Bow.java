package Diablo;

import Diablo.WeaponBehavior;

public class Bow implements WeaponBehavior {
    @Override
    public void useWeapon(){
        System.out.println("활을 사용해 원거리 공격");
    }
}
