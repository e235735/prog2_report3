package jp.ac.uryukyu.ie.e235735;

public class Warrior extends LivingThing {
    public Warrior (String name, int maximumHP, int attackW) {
        super(name, maximumHP, attackW);
    }

    public void attackWithWeaponSkill(LivingThing e) {
        if (isDead() == false) {
            int attackW = (int)(getAttack() * 1.5);
            System.out.printf("%sの攻撃！ウェポンスキルを発動！%sに%dのダメージを与えた！！", getName(), e.getName(), attackW);
            e.wounded(attackW);
        }
    }
}
