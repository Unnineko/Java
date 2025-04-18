import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoordinatePoints {

    //класс для представления координат точки на плоскости
    static class Coordinates {
        private final int x; //координата по оси X
        private final int y; //координата по оси Y

        //конструктор для инициализации координат
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        //метод для вычисления минимального расстояния до осей координат
        public int calculateDistanceToAxes() {
            return Math.min(Math.abs(x), Math.abs(y));
        }
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Введите количество точек: ");
        int numberOfPoints = inputScanner.nextInt(); //считываем количество точек
        List<Coordinates> coordinateList = new ArrayList<>(); //список для хранения считаемых точек

        //считывание координат точек
        System.out.println("Введите координаты точек (x y):");
        for (int i = 0; i < numberOfPoints; i++) {
            int x = inputScanner.nextInt(); //считываем координату X
            int y = inputScanner.nextInt(); //считываем координату Y
            //добавление точки, только если она не лежит на осях
            if (x != 0 && y != 0) {
                coordinateList.add(new Coordinates(x, y)); //добавление в список
            }
        }

        //массив для подсчета количества точек в каждой четверти
        int[] quadrantCounts = new int[4];
        //массив для хранения точек в каждой четверти
        List<Coordinates>[] pointsInQuadrants = new List[4];

        //инициализация списков для каждой из четырех четвертей
        for (int i = 0; i < 4; i++) {
            pointsInQuadrants[i] = new ArrayList<>();
        }

        //разделяем точки по четвертям и считаем их количество
        for (Coordinates point : coordinateList) {
            int quadrantIndex = determineQuadrant(point); //определяем принадлежность точки к четверти
            quadrantCounts[quadrantIndex]++; //увеличиваем счетчик для данной четверти
            pointsInQuadrants[quadrantIndex].add(point); //добавляем точку в соответствующий список
        }

        //переменные для хранения наилучшей четверти и соответствующих метрик
        int bestQuadrant = -1;
        int highestCount = 0;
        int smallestDistance = Integer.MAX_VALUE;
        Coordinates nearestPoint = null; //ближайшая точка

        //поиск лучшей четверти по количеству точек и минимальному расстоянию
        for (int i = 0; i < 4; i++) {
            if (quadrantCounts[i] > highestCount) {
                //если текущая четверть имеет больше точек
                highestCount = quadrantCounts[i];
                bestQuadrant = i;
                smallestDistance = Integer.MAX_VALUE; //сбрасываем расстояние
                nearestPoint = getNearestPoint(pointsInQuadrants[i]); //находим ближайшую точку
            } else if (quadrantCounts[i] == highestCount && highestCount > 0) {
                //если количество точек такое же, но больше нуля
                int currentMinDistance = getMinimumDistance(pointsInQuadrants[i]); //получаем минимальное расстояние для этой четверти
                if (currentMinDistance < smallestDistance) {
                    //если текущее расстояние меньше
                    smallestDistance = currentMinDistance;
                    bestQuadrant = i;
                    nearestPoint = getNearestPoint(pointsInQuadrants[i]); //находим ближайшую точку
                } else if (currentMinDistance == smallestDistance) {
                    //если расстояния одинаковы, выбираем четверть с меньшим номером
                    if (bestQuadrant == -1 || (i < bestQuadrant)) {
                        bestQuadrant = i;
                        nearestPoint = getNearestPoint(pointsInQuadrants[i]); //находим ближайшую точку
                    }
                }
            }
        }

        if (bestQuadrant != -1) {
            System.out.println("Координатная четверть K = " + (bestQuadrant + 1));
            System.out.println("Количество точек M = " + highestCount);
            System.out.println("Наименее удаленная точка A = (" + nearestPoint.x + ", " + nearestPoint.y + ")");
            System.out.println("Минимальное расстояние R = " + nearestPoint.calculateDistanceToAxes());
        } else {
            //если ни одна точка не введена
            System.out.println("Необходимо ввести хотя бы одну точку в каждой четверти.");
        }
    }

    //метод для определения четверти, к которой принадлежит точка
    private static int determineQuadrant(Coordinates point) {
        if (point.x > 0 && point.y > 0) return 0; //первая четверть
        if (point.x < 0 && point.y > 0) return 1; //вторая четверть
        if (point.x < 0 && point.y < 0) return 2; //третья четверть
        return 3; //четвертая четверть
    }

    //метод для нахождения ближайшей точки к осям координат
    private static Coordinates getNearestPoint(List<Coordinates> points) {
        if (points.isEmpty()) return null; //если список пуст

        Coordinates closest = points.get(0); //предполагаем, что первая точка ближайшая
        for (Coordinates point : points) {
            //сравниваем каждую точку
            if (point.calculateDistanceToAxes() < closest.calculateDistanceToAxes()) {
                closest = point; //обновляем ближайшую точку
            }
        }
        return closest; //возвращаем ближайшую точку
    }

    //метод для нахождения минимального расстояния до осей из заданного списка точек
    private static int getMinimumDistance(List<Coordinates> points) {
        int minDistanceValue = Integer.MAX_VALUE; //начальное значение
        for (Coordinates point : points) {
            //находим минимальное расстояние среди всех точек
            minDistanceValue = Math.min(minDistanceValue, point.calculateDistanceToAxes());
        }
        return minDistanceValue; //возвращаем минимальное расстояние
    }
}