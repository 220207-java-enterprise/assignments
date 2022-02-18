import java.util.Comparator;

public class ComparatorbyArea implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        //sorts in ascending order
        return o1.Area()-o2.Area();
    }
}
