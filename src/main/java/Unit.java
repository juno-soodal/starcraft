import java.util.Random;

public abstract class Unit {
    private final String name;
    private final int attackPower;
    private final int speed;
    private final String description;
    private int health;
    private int position;


    public Unit(String name, int health, int attackPower, int speed, String description) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.speed = speed;
        this.description = description;
    }

    public void printInfo() {
        System.out.println(name+"| 체력: "+health+" | 공격력: "+attackPower+" | 설명: "+description);
    }

    public void move(String direction) {
        System.out.println(name+"이(가) "+direction+"으로 이동했습니다.");
        setPosition(direction);
    }

    private void setPosition(String direction) {
        position += "왼쪽".equals(direction) ? -1 : 1;
    }

    public void attack(Unit target) {
        if (target.health == 0) {
            throw new IllegalArgumentException("공격 대상이 이미 사망했습니다.");
        }
        System.out.println(name+"이가 "+target.name+"이를 공격합니다!");
        target.takeDamage(attackPower);
        if (target.health == 0) {
            System.out.println(target.name+"이(가) 사망했습니다.");
            return;
        }
        System.out.println(target.name + "의 남은 체력 " + target.health);


    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }

    public void getCurrentPostion() {
        System.out.println(name+ "의 위치는 현재 " + position+"입니다.");
    }

}
