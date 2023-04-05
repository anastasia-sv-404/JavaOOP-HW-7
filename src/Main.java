public class Main {
    public static void main(String[] args) {

        PlanePhone plPh1 = new PlanePhone("Smth");
        PlanePhone plPh2 = new PlanePhone();

        System.out.println(plPh1);
        System.out.println(plPh2);
        System.out.println();

        plPh1.callOut(plPh2);
        plPh1.turnOnOff();
        plPh1.callOut(plPh2);
        plPh2.turnOnOff();
        plPh1.callOut(plPh2);
        System.out.println();



        Featurephone fPh1 = new Featurephone("Smth2", "iOS");
        Featurephone fPh2 = new Featurephone("Smth3");
        Featurephone fPh3 = new Featurephone();

        System.out.println(fPh1);
        System.out.println(fPh2);
        System.out.println(fPh3);
        System.out.println();

        fPh1.sendSMS(fPh2);
        fPh1.turnOnOff();
        fPh1.sendSMS(fPh2);
        fPh2.turnOnOff();
        fPh1.sendSMS(fPh2);
        System.out.println();

        fPh1.onOffInternet();
        System.out.println(fPh1);
        fPh1.onOffInternet();
        System.out.println(fPh1);
        System.out.println();



        SmartPhone smPh1 = new SmartPhone("Smth4", "iOS");
        SmartPhone smPh2 = new SmartPhone("Smth5");
        SmartPhone smPh3 = new SmartPhone();

        System.out.println(smPh1);
        System.out.println(smPh2);
        System.out.println(smPh3);
        System.out.println();

        smPh1.sendEmail(smPh2);
        smPh1.turnOnOff();
        smPh1.onOffInternet();
        smPh1.sendEmail(smPh2);
        System.out.println();

        smPh2.turnOnOff();
        smPh2.onOffInternet();
        smPh1.sendEmail(smPh2);
        System.out.println();

    }
}