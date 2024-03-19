import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4,1);
        Iterator<Integer> iterator = list.iterator();
        list.addAll(new ArrayList<>());
    }

}
