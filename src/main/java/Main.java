import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Unit marine = new Marine("Marine", 20, 6,4,"Terran Unit");
        Unit zealot = new Marine("Zealot", 30, 8,2,"Protoss Unit");
        Unit zergling = new Marine("Zergling", 15, 5,5,"Zerg Unit");

        String[] leftRight = {"왼쪽", "오른쪽"};



        List<Unit> units=new ArrayList<>();
        units.add(marine);
        units.add(zealot);
        units.add(zergling);
        for (Unit unit : units) {
            unit.printInfo();
        }
        Random random = new Random();
        int unitIdx = random.nextInt(units.size());
        Unit unit = units.get(unitIdx);
        units.remove(unitIdx);
        int targetIdx = random.nextInt(units.size());
        Unit target = units.get(targetIdx);
        while (true) {
            int distance = random.nextInt(20) + 1;
            for (int i = 0; i < distance; i++) {
                unit.move(leftRight[random.nextInt(leftRight.length)]);
            }
            unit.getCurrentPostion();
            try {
                unit.attack(target);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("프로그램을 종료합니다.");
                return;
            }
        }

    }
}
