public class Laba7 {
    public static void main(String[] args) {
        int dollars = 15; //объявление переменной, обозначающей сумму в долларах
        int chocolatePrice = 1; //стоимость одной шоколадки в долларах
        int wrappersForChocolate = 3; //количество фантиков, необходимое для получения одной дополнительной шоколадки
        
        int chocolates = dollars / chocolatePrice; //вычисление количества шоколадок, которые можно купить за имеющуюся сумму долларов
        
        //расчет количества дополнительных шоколадок за фантики
        int wrappers = chocolates;
        while (wrappers >= wrappersForChocolate) { //цикл для обмена фантиков на дополнительные шоколадки
            int exchangedChocolates = wrappers / wrappersForChocolate; //вычисление количества дополнительных шоколадок за обмен фантиков
            chocolates += exchangedChocolates;
            wrappers = wrappers % wrappersForChocolate + exchangedChocolates; //обновление количества фантиков после обмена и получения дополнительных шоколадок
        }
        System.out.println("Можно купить " + chocolates + " шоколадок на " + dollars + " долларов.");
    }
}
