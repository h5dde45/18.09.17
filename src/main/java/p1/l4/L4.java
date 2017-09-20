package p1.l4;


public class L4 {
   public static void main(String[] args) {
/*

        Scanner scanner = new Scanner(System.in);

        //количество городов
        int counterCities = 0;
        counterCities = scanner.nextInt();

        List<City> cities = new ArrayList<>();//города

        //координаты городов
        for (int i = 0; i < counterCities; i++) {
            cities.add(new City(scanner.nextInt(), scanner.nextInt()));
        }

        //расстояние на одном баке
        int distance = 0;
        distance = scanner.nextInt();

        //пункт отправления - индекс города
        int indexCityOut = 0;
        indexCityOut = scanner.nextInt();

        //пунтк прибытия - индекс города
        int indexCityIn = 0;
        indexCityIn = scanner.nextInt();

        //коллекция всех существующих дорог
        List<Road> allRoads = new ArrayList<>();

        // добавление дорог
        roadCity(allRoads, counterCities, cities);

//        System.out.println(allRoads);

        //поиск кротчайшего пути
        System.out.println(new Navigator().findingWay(cities, allRoads, indexCityOut, indexCityIn, distance));
    }

    static void roadCity(List<Road> roads, int counterCities, List<City> cities) {
        Random random = new Random();
        int n = 0;
        for (int i = 0; i < counterCities; i++) {
            for (int j = 0; j < counterCities; j++) {
                n = random.nextInt(100);
                // расстояние между городов меньше 8
                if (n < 99 && i != j &&
                        (Math.sqrt(Math.pow(cities.get(j).getY() -
                                cities.get(i).getY(), 2)
                                + Math.pow(cities.get(j).getX() -
                                cities.get(i).getX(), 2))) < 8) {
                    roads.add(new Road(i, j));
                }
            }
        }
    }
}

class Navigator {

    //стек дорог для поиска нужного направления
    LinkedList<Road> stackRoads = new LinkedList<>();

    //все направления из текущего города отсортированные
    //в правильном порядке относительно направлени на заданный конечный город
    private TreeSet<Road> directionsFromCity = new TreeSet<>();

    //направлени из текущего города на заданный конечный город
    static double mainDirection;

    //текущий город
    private int indexCurrentCity;

    //поиск нужного пути
    int findingWay(List<City> cities, List<Road> allRoads,
                   int indexCityOut, int indexCityIn, int distance) {
        indexCurrentCity = indexCityOut;
        mainDirection = calculateDirection(cities, indexCurrentCity, indexCityIn);
//        System.out.println(mainDirection);

        //заполнение коллекции направлений из текущего города
        directionsFromCity.clear();
        addRoads(allRoads, cities,distance);

//        System.out.println(directionsFromCity);
//        for (Road road : directionsFromCity) {
//            System.out.println(road.getDirection()+" = "+road.getDistance());
//        }

        stackRoads.push(directionsFromCity.first());
        indexCurrentCity=stackRoads.element().getCityB();

        if(indexCurrentCity!=indexCityIn){
            findingWay(cities,allRoads,indexCurrentCity,indexCityIn,distance);
        }

//        System.out.println(stackRoads);
        return stackRoads.size();
    }

    private void addRoads(List<Road> roads, List<City> cities, double distance) {
        for (Road road : roads) {
            if (indexCurrentCity == road.getCityA()) {
                road.setDirection(calculateDirection(cities, indexCurrentCity, road.getCityB()));
                road.setDistance(calculateDistance(cities, indexCurrentCity, road.getCityB()));
                if (road.getDistance() <= distance) {
                    directionsFromCity.add(road);
                }
            }
        }
    }

    private double calculateDistance(List<City> cities, int indexCurrentCity, int indexCityIn) {
        return  Math.sqrt( Math.pow(cities.get(indexCityIn).getY() -
                cities.get(indexCurrentCity).getY(),2)
                + Math.pow(cities.get(indexCityIn).getX() -
                cities.get(indexCurrentCity).getX(),2));
    }

    private double calculateDirection(List<City> cities, int indexCurrentCity, int indexCityIn) {
        //определение направления из текущего города на следующий город
        double direction = Math.toDegrees(
                Math.atan((double) (cities.get(indexCityIn).getY() - cities.get(indexCurrentCity).getY())
                        / (cities.get(indexCityIn).getX() - cities.get(indexCurrentCity).getX())));

        if (direction < 0 && (cities.get(indexCurrentCity).getX() > cities.get(indexCityIn).getX())) {
            direction += 180;
        } else if (direction > 0 && (cities.get(indexCurrentCity).getX() > cities.get(indexCityIn).getX())) {
            direction -= 180;
        }
        return direction;
    }
}

class City {
    //координаты города
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

class Road implements Comparable<Road> {

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
        }*/
    }
}
