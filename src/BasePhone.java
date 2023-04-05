import java.util.*;

public abstract class BasePhone implements Call<BasePhone> {
    protected String brand;
    private int imei;
    private boolean state;
    private Random random = new Random();
    private ReadFile readFile = new ReadFile();
    private List<String> rndBrands = new ArrayList<>(Arrays.asList(readFile.readFile("brands.txt").split(", ")));

    public BasePhone(String brand) {
        if (brand.isEmpty()) {
            int position = random.nextInt(rndBrands.size());
            this.brand = String.format("%s", rndBrands.get(position));
        } else {
            this.brand = brand;
        }
        this.imei = random.nextInt(0, 100000);
        this.state = false;
    }

    public BasePhone() {
        this("");
    }

    public String getBrand() {
        return brand;
    }

    public int getImei() {
        return imei;
    }

    public boolean getState() {
        return state;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    protected void turnOn() {
        this.state = true;
    }

    public void turnOnOff() {
        if (this.state) {
            this.state = false;
            System.out.printf("Телефон %s выключен.\n", this.brand);
        } else {
            turnOn();
            System.out.printf("Телефон %s включен.\n", this.brand);
        }
    }

    public void callOut(BasePhone phone) {
        if (this.state) {
            System.out.printf("Телефон %s звонит на телефон %s\n", this.brand, phone.getBrand());
            phone.callIn(this);
        } else {
            System.out.printf("Нельзя совершить звонок: телефон %s выключен\n", this.brand);
        }
    }// Куда звонит - как аргумент.

    public void callIn(BasePhone phone) {
        if (this.state) {
            System.out.printf("Входящий звонок от %s на телефон %s\n", phone.getBrand(), this.brand);
        } else {
            System.out.printf("Вызов не проходит: телефон %s выключен\n", this.brand);
        }
    }//Кто звонит - как аргумент.


    @Override
    public String toString() {
        return "Устройство = " + this.getClass().getSimpleName() +
                ", бренд = " + this.brand +
                ", imei = " + this.imei +
                ", телефон включен = " + this.state;
    }

    @Override
    public int hashCode() {
        return this.imei + this.brand.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasePhone)) {
            return false;
        }
        BasePhone bPh = (BasePhone) obj;
        return bPh.imei == this.imei && this.brand.equals(bPh.brand);
    }
}
