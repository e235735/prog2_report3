package jp.ac.uryukyu.ie.e235735;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**勇者の名前のセッター*/
    public void setName(String name) {
        this.name = name;
    }

    /**勇者の攻撃力のセッター*/
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**勇者のHPのセッター */
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    /**勇者の生死を確認するセッター */
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    /**勇者の攻撃力のゲッター */
    public int getAttack() {
        return this.attack;
    }

    /**勇者のHPのゲッター */
    public int getHitPoint() {
        return this.hitPoint;
    }

    /*勇者の生死を確認するゲッター */
    public boolean getDead() {
        return this.dead;
    }

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    public boolean isDead(){
        return getDead();
    }

    public String getName(){
        return this.name;
    }

    /**
     * 攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
     */
    public void attack(LivingThing opponent){
        if (dead == false) {
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        this.hitPoint -= damage;
        if( this.hitPoint < 0 ) {
            this.dead = true;
            System.out.printf("%sは倒れた。\n", this.name);
        }
    }
}