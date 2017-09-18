package p1;

import java.util.*;

public class T4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int counterCities = 0;
        counterCities = scanner.nextInt();

        List<City> cities = new ArrayList<>();

        for (int i = 0; i < counterCities; i++) {
            cities.add(new City(scanner.nextInt(), scanner.nextInt()));
        }

        int distance = 0;
        distance = scanner.nextInt();

        int indexCityOut = 0;
        indexCityOut = scanner.nextInt() - 1;

        int indexCityIn = 0;
        indexCityIn = scanner.nextInt() - 1;

        for (City c : cities) {
            System.out.println(c.getX() + " " + c.getY());
        }

        System.out.println(distance);
        System.out.println(indexCityOut);
        System.out.println(indexCityIn);

        List<Road> roads = new ArrayList<>();
        roadCity(roads, counterCities);
        System.out.println(roads);

        double mainDirection = Math.atan
                ((double) (cities.get(indexCityIn).getY() - cities.get(indexCityOut).getY())
                        / (cities.get(indexCityIn).getX() - cities.get(indexCityOut).getX()));

        System.out.println(mainDirection);
        System.out.println(new Navigator().findingWays(roads,mainDirection,distance));
    }

    static void roadCity(List<Road> roads, int counterCities) {
        Random random = new Random();
        int n = 0;
        for (int i = 1; i <= counterCities; i++) {
            for (int j = 1; j <= counterCities; j++) {
                n = random.nextInt(30);
                if (n < 20 && i != j) {
                    roads.add(new Road(i, j));
                }
            }
        }
    }
}

class Navigator {
    LinkedList<Road> roadList = new LinkedList<>();
    double currentDirection;

    int findingWays(List<Road> roads, double mainDirection, int distance) {
//        currentDirection=Math.atan
//                ((double) (roads.get(indexCityIn).getY() - cities.get(indexCityOut).getY())
//                        / (cities.get(indexCityIn).getX() - cities.get(indexCityOut).getX()));

        roadList.push(roads.get(0));
        roadList.push(roads.get(1));
        roadList.push(roads.get(2));
        System.out.println(roadList);
        roadList.pop();
        System.out.println(roadList);
        return roadList.size();
    }

}

class City {
    private int x;
    private int y;

    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Road {
    int cityA;
    int cityB;

    public Road(int cityA, int cityB) {
        this.cityA = cityA;
        this.cityB = cityB;
    }

    @Override
    public String toString() {
        return "Road{" +
                "cityA=" + cityA +
                ", cityB=" + cityB +
                '}';
    }
}

