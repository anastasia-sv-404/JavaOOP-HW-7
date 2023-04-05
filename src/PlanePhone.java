public class PlanePhone extends BasePhone implements Message<PlanePhone> {

    public PlanePhone(String brand) {
        super(brand);
    }
    public PlanePhone() {
        this("");
    }

    @Override
    public void sendSMS(PlanePhone phone) {
        if (this.getState()) {
            System.out.printf("SMS отправлено с телефона %s на телефон %s\n", this.brand, phone.getBrand());
            phone.reciveSMS(this);
        } else {
            System.out.printf("Нельзя отправить SMS: телефон %s выключен\n", this.brand);
        }
    }// Куда шлет СМС - как аргумент.

    @Override
    public void reciveSMS(PlanePhone phone) {
        if (this.getState()) {
            System.out.printf("Входящее SMS от %s на телефон %s\n", phone.getBrand(), this.brand);
        } else {
            System.out.printf("Сообщение не получено: телефон %s выключен\n", this.brand);
        }
    }//Кто шлет СМС - как аргумент.

}
