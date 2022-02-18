public class Rectangle {
    public String name;
    private int area;
    private int perimeter;

    public void setArea(int area) {
        this.area = area;
    }

    public void setPerimeter(int perimeter) {
        this.perimeter = perimeter;
    }

    public int getArea() {
        return this.area;
    }

    public int getPerimeter() {
        return this.perimeter;
    }

    Rectangle (String name, int area, int perimeter) {
        this.name = name;
        this.area = area;
        this.perimeter = perimeter;
    }
}
