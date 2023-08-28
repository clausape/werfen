package part1;

public class Point {
    private int horizontal;
    private int vertical;

    public Point(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return horizontal == point.horizontal &&
                vertical == point.vertical;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(horizontal);
        result = 31 * result + Integer.hashCode(vertical);
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "horizontal=" + horizontal +
                ", vertical=" + vertical +
                '}';
    }
}
