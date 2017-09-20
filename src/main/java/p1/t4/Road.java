package p1.t4;


public class Road implements Comparable<Road> {

    //индексы городов (cityA --> cityB)
    private int cityA;
    private int cityB;

    //направление (cityA --> cityB) в градусах
    private double direction;

    //расстояние (cityA --> cityB)
    private double distance;

    public Road(int cityA, int cityB) {
        this.cityA = cityA;
        this.cityB = cityB;
    }

    public int getCityA() {
        return cityA;
    }

    public int getCityB() {
        return cityB;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Road{" +
                "cityA=" + cityA +
                ", cityB=" + cityB +
                '}';
    }

    @Override
    public int compareTo(Road road) {

        //сортирует коллекцию всех направлений дорог идущих
        // из текущего города относительно направления на заданный конечный пункт
        if (Math.abs(Navigator.mainDirection - this.direction) >
                Math.abs(Navigator.mainDirection - road.direction)) {
            return 1;
        } else if (Math.abs(Navigator.mainDirection - this.direction) <
                Math.abs(Navigator.mainDirection - road.direction)) {
            return -1;
        } else {
            return 0;
        }
    }
}
