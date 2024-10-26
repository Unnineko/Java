import java.io.*;
import java.util.*;

public class Laba15 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("1234.txt"))) {
            int totalOccupiedSeats = Integer.parseInt(reader.readLine()); //считывание количества занятых мест

            List<int[]> occupiedSeats = new ArrayList<>();

            for (int i = 0; i < totalOccupiedSeats; i++) {
                String[] line = reader.readLine().split(" "); //чтение номера ряда и места
                occupiedSeats.add(new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])});
            }

            //сортировка по номеру ряда по убыванию и по номеру места по возрастанию
            occupiedSeats.sort(Comparator.comparingInt((int[] seat) -> seat[0]).reversed()
                    .thenComparingInt(seat -> seat[1]));

            int bestRow = -1, bestSeat = -1;

            //проходим по всем занятым местам
            for (int index = 1; index < occupiedSeats.size(); index++) {
                //проверка если ряд совпадает с предыдущим
                if (occupiedSeats.get(index)[0] == occupiedSeats.get(index - 1)[0]) {
                    int currentRow = occupiedSeats.get(index)[0];
                    int currentSeat = occupiedSeats.get(index)[1];
                    int previousSeat = occupiedSeats.get(index - 1)[1];

                    //проверка, есть ли два соседних места с занятыми местами слева и справа
                    if (currentSeat - previousSeat == 1) {
                        //проверка на наличие занятых мест слева и справа
                        if (occupiedSeats.stream().anyMatch(seat -> seat[0] == currentRow && seat[1] == previousSeat - 1) &&
                            occupiedSeats.stream().anyMatch(seat -> seat[0] == currentRow && seat[1] == currentSeat + 1)) {
                            bestRow = currentRow;
                            bestSeat = previousSeat; //наименьший номер из пары
                            break; //выход тк нашли подходящий ряд
                        }
                    }
                }
            }

            System.out.println(bestRow + " " + bestSeat);

        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}
