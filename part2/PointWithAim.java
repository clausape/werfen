package part2;

public class PointWithAim {
    private int horizontal;
    private int vertical;

    private int aim;

    public PointWithAim(int horizontal, int vertical, int aim) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.aim = aim;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public int getAim() { return aim; }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    public void setAim(int aim) { this.aim = aim; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointWithAim pointWithAim = (PointWithAim) o;
        return horizontal == pointWithAim.horizontal &&
                vertical == pointWithAim.vertical &&
                aim == pointWithAim.aim;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(horizontal);
        result = 31 * result + Integer.hashCode(vertical);
        result = 31 * result + Integer.hashCode(aim);
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "horizontal=" + horizontal +
                ", vertical=" + vertical +
                ", aim=" + aim +
                '}';
    }
}
