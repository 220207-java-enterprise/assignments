public class PerimeterComparator {

    public boolean isLessThan(Rectangle a, Rectangle b){
        if(a.getPerimeter() < b.getPerimeter())
            return true;
        else
            return false;
    }

}
