import java.util.Comparator;

public class ComparatorbyPerimeter implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        //sorts in ascending order
        return o1.Perimeter()-o2.Perimeter();
    }
}
