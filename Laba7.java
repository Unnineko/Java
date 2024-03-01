public class Laba7 {
    public static class Bus {
        private String driverName;
        private int busNumber;
        private int routeNumber;
        private String brand;
        private int yearOfOperation;
        private int mileage;
    
        public Bus(String driverName, int busNumber, int routeNumber, String brand, int yearOfOperation, int mileage) {
            this.driverName = driverName;
            this.busNumber = busNumber;
            this.routeNumber = routeNumber;
            this.brand = brand;
            this.yearOfOperation = yearOfOperation;
            this.mileage = mileage;
        }
    
        public int getRouteNumber() {
            return routeNumber;
        }
    
        public int getMileage() {
            return mileage;
        }
    
        public static void main(String[] args) {
            Bus[] buses = {
                new Bus("Петрушкина Валентина Викторовна", 123, 1, "Mercedes", 2010, 150000),
                new Bus("Кирпичева Карина Семёновна", 456, 2, "Volvo", 2012, 120000),
                new Bus("Смирнов Олег Михайлович", 789, 1, "MAN", 2008, 180000)
            };
    
            int searchRouteNumber = 1;
            System.out.println("Автобусы на маршруте " + searchRouteNumber + ":");
            for (Bus bus : buses) {
                if (bus.getRouteNumber() == searchRouteNumber) {
                    System.out.println(bus.driverName + " - Номер автобуса: " + bus.busNumber);
                }
            }
    
            int searchMileage = 160000;
            System.out.println("\nАвтобусы с пробегом более " + searchMileage + " км:");
            for (Bus bus : buses) {
                if (bus.getMileage() > searchMileage) {
                    System.out.println(bus.driverName + " - Номер автобуса: " + bus.busNumber);
                }
            }
        }
    }
}
