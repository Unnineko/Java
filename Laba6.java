class Reader{
    public String FIO;
    public int TicketNum;
    public String Faculty;
    public String DateOfBirth;
    public String PhoneNumber;
    Reader(String FIO, int TicketNum, String Faculty, String DateOfBirth, String PhoneNumber){
        this.FIO = FIO;
        this.TicketNum = TicketNum;
        this.Faculty = Faculty;
        this.DateOfBirth = DateOfBirth;
        this.PhoneNumber = PhoneNumber;
    }
    public void TakeBook(int numberOfBook){
        System.out.println(FIO + " взял(а) " + numberOfBook + " книг(и)");
    }
    public void TakeBook(String... BookNames){
        System.out.println(FIO + " взял(a) книг(и): ");
        for (String Book : BookNames){
            System.out.println(Book + " ");
        }
    }
    public void ReturnBook(String... BookNames){
        System.out.println(FIO + " вернул(a) книг(и): ");
        for (String Book : BookNames){
            System.out.println(Book + " ");
        }
    }
    public void ReturnBook(int numberOfBook){
        System.out.println(FIO + " вернул(а) " + numberOfBook + " книг(и)");
    }
}
public class Laba6 {
    public static void main(String[] args) {
     Reader r1 = new Reader("Манушина Полина Викторовна", 012345, "Химический", "01.01.2002", "79659227129");
     Reader r2 = new Reader("Чередова Екатерина Михайловна", 001234, "Биология", "03.04.1995", "79547110375");
     Reader r3 = new Reader("Караванова Евгения Дмитриевна", 003455, "История", "05.06.1988", "79820116387");
     Reader r4 = new Reader("Смирнова Надежда Алексеевна", 000124, "Математика", "07.08.1992", "79365888153");
     Reader r5 = new Reader("Макеев Дмитрий Петрович",  506789, "Физика", "09.10.1985", "79875268165");
     Reader[] Readers = {r1, r2, r3, r4,r5};
     Readers[0].TakeBook(4);
        System.out.println();
     Readers [1].TakeBook("Приключения,", "Словарь,", "Энциклопедия" );
        System.out.println();
        Readers[2].ReturnBook("Мцыри,", "Химия 6 класс");
        System.out.println();
        Readers[3].ReturnBook(5);
    }
}
