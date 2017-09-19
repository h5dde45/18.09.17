package p1.t4;


import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;


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
        System.out.println(mainDirection);

        //заполнение коллекции направлений из текущего города
        addRoads(allRoads, cities,distance);

        System.out.println(directionsFromCity);
        for (Road road : directionsFromCity) {
            System.out.println(road.getDirection()+" = "+road.getDistance());
        }

        stackRoads.push(directionsFromCity.first());
        System.out.println(stackRoads);



        return 0;//findingWays(cities,allRoads,indexCurrentCity,indexCityIn,distance);
    }

    private void addRoads(List<Road> roads, List<City> cities,double distance) {
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