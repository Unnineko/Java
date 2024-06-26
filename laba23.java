interface Voltage220{
    public void volt220();
}

class V220device implements Voltage220{
    final public int voltage = 220;
    public void volt220(){
        System.out.println("Напряжение 220 вольт");
    }
}

interface Voltage380{
    public void volt380();
}

class V380device implements Voltage380{
    final public int voltage = 380;
    public void volt380(){
        System.out.println("Напряжение 380 вольт");
    }
}

class UsingDevice{
    private Voltage220 voltage220;

    public UsingDevice(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    public void using(){
        voltage220.volt220();
    }
}

class Adapter implements Voltage220{
    Voltage380 voltage380;

    public Adapter(Voltage380 voltage380) {
        this.voltage380 = voltage380;
    }

    public void volt220(){
        voltage380.volt380();
    }
}

public class laba23 {
    public static void main(String[] args) {

        Voltage220 v220 = new V220device();
        UsingDevice ud = new UsingDevice(v220);
        ud.using();

        Adapter v380 = new Adapter(new V380device());
        UsingDevice ud380 = new UsingDevice(v380);
        ud380.using();

    }
}