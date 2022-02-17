public class AreaComparator {
    public boolean isLessThan(Rectangle a, Rectangle b){
        if(a.getArea() < b.getArea())
            return true;
        else
            return false;
    }
}
