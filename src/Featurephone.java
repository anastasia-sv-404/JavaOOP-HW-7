public class Featurephone extends PlanePhone implements Email<Featurephone> {
    protected String os;
    private boolean stateInternet;

    public Featurephone(String brand, String os) {
        super(brand);
        if (os.isEmpty()) {
            this.os = "native";
        } else {
            this.os = os;
        }
        this.stateInternet = false;
    }

    public Featurephone(String brand) {
        this(brand, "native");
    }

    public Featurephone() {
        this("");
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    private void turnOnInternet() {
        this.stateInternet = true;
    }

    @Override
    public void onOffInternet() {
        if(this.getState()) {
            if (this.stateInternet) {
                this.stateInternet = false;
                System.out.printf("Интернет на устройстве %s выключен.\n", this.brand);
            } else {
                turnOnInternet();
                System.out.printf("Выход в интернет с устройства %s произведен.\n", this.brand);
            }
        }
        else{
            System.out.printf("Интернет не может быть включен. Сначала включите устройство %s\n", this.brand);
        }
    }

    @Override
    public void sendEmail(Featurephone phone) {
        if (this.stateInternet) {
            System.out.printf("Email отправлен с телефона %s на телефон %s.\n", this.brand, phone.getBrand());
            phone.reciveEmail(this);
        } else {
            System.out.printf("Для отправки Email включите интернет на устройстве %s.\n", this.brand);
        }
    }// Куда шлет Email - как аргумент.

    @Override
    public void reciveEmail(Featurephone phone) {
        if (this.stateInternet) {
            System.out.printf("Входящий Email от %s на телефон %s получен\n", phone.getBrand(), this.brand);
        } else {
            System.out.printf("Письмо не получено: интернет на телефоне %s выключен\n", this.brand);
        }
    }//Кто шлет Email - как аргумент.


    @Override
    public String toString() {
        return "Устройство = " + this.getClass().getSimpleName() +
                ", бренд = " + this.brand +
                ", imei = " + this.getImei() +
                ", телефон включен = " + this.getState() +
                ", OS = " + this.os +
                ", интернет включен = " + this.stateInternet;
    }

    @Override
    public int hashCode() {
        return this.getImei() + this.brand.hashCode() + this.os.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Featurephone)) {
            return false;
        }
        Featurephone fPh = (Featurephone) obj;
        return fPh.getImei() == this.getImei() && this.brand.equals(fPh.brand) && fPh.os.equals(this.os);
    }
}
