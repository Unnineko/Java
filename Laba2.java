public class laba2 {
    public static void main(String[] args) {
        int[] sequence = new int[10]; // Создаем массив для хранения последовательности
        
        // Заполняем последовательность неотрицательными целыми числами, не превышающими 10000
        for (int i = 0; i < 10; i++) {
            sequence[i] = (int) (Math.random() * 100);
        }
        
        int maxR = -1;
        
        // Проходим по всем элементам последовательности
        for (int i = 0; i < 10; i++) {
            for (int j = i+1; j < 10; j++) {
                int result = sequence[i] * sequence[j];
                
                if (result % 14 == 0 && result > maxR) {
                    maxR = result;
                }
            }
        }
        
        if (maxR == -1) {
            System.out.println("Число R не найдено.");
        } else {
            System.out.println("Максимальное число R, кратное 14 и произведение 2х различных элементов последовательности: " + maxR);
        }
    }
}
