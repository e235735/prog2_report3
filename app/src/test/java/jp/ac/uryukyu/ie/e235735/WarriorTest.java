package jp.ac.uryukyu.ie.e235735;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class WarriorTest {
    /**
     * 倒れたはずの敵は攻撃できないことを検証。
     * 検証手順
     *  (1) ウォーリアーと敵を準備。ウォーリアーの攻撃力は敵を一撃で倒せるほど強い状態とする。
     *  (2) ウォーリアーが殴り、敵も殴る。敵は一撃で倒されていることを期待。
     *  (3) 敵が死んだ状態ならば攻撃できないはず。
     * 　　つまり攻撃実行してもウォーリアーのHPは減っていないことを期待。これを検証する。
     */
    @Test
    void attackWithWeaponSkillTest() {
        int defaultWarriorHp = 200;
        Warrior demoWarrior = new Warrior("デモ戦士", defaultWarriorHp, 100);
        Enemy sandbag1 = new Enemy("サンドバッグ1", 150, 100);
        Enemy sandbag2 = new Enemy("サンドバッグ2", 150, 100);
        Enemy sandbag3 = new Enemy("サンドバッグ3", 150, 100);
        ArrayList<Enemy> enemyList = new ArrayList<>();
        enemyList.add(sandbag1);
        enemyList.add(sandbag2);
        enemyList.add(sandbag3);

        for (Enemy e:enemyList) {
            demoWarrior.attackWithWeaponSkill(e);
            int nowSandbagHitPoint = e.getHitPoint();
            assertEquals(0, nowSandbagHitPoint);
        }
    }
}