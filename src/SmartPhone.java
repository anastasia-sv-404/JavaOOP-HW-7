public class SmartPhone extends Featurephone implements Protection<SmartPhone> {
    public SmartPhone(String brand, String os) {
        super(brand);
        if (os.isEmpty()) {
            this.os = "Android";
        } else {
            this.os = os;
        }
    }

    public SmartPhone(String brand) {
        this(brand, "Android");
    }

    public SmartPhone() {
        this("");
    }

    @Override
    public void scanFingerPrint(SmartPhone phone) {
        System.out.printf("Отпечаток пальца отсканирован для разблокировки устройства %s.\n", phone.getBrand());
    }

    @Override
    protected void turnOn() {
        scanFingerPrint(this);
        super.turnOn();
    }
}
