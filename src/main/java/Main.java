import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Unit marine = new Marine("Marine", 20, 6,4,"Terran Unit");
        Unit zealot = new Marine("Zealot", 30, 8,2,"Protoss Unit");
        Unit zergling = new Marine("Zergling", 15, 5,5,"Zerg Unit");


        List<Unit> units=new ArrayList<>();
        units.add(marine);
        units.add(zealot);
        units.add(zergling);
        Random random = new Random();
        int unitIdx = random.nextInt(units.size());
        Unit unit = units.get(unitIdx);
        units.remove(unitIdx);
        int targetIdx = random.nextInt(units.size());
        Unit target = units.get(targetIdx);
        while (true) {
            unit.move();
            unit.getCurrentPostion();
            unit.attack(target);
        }

    }
}
