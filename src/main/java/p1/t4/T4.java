package p1.t4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {

        // нет возврата назад по стеку, и много разных недоделок
        // смысл в том чтобы в каждом городе нужно выбирать направление
        // близкое к направлению на конечный пункт
        // если дорога заканчивается вернутся на один шаг
        // назад и начать со следующего направления близкого к основному
        // эти данные дают правильный путь
        /**
        10
        2 3
        8 4
        4 -7
        -3 11
        11 -6
        -5 -8
        6 -2
        -4 6
        2 8
        -1 -4
        8
        2 3
        */

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
