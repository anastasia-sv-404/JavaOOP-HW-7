public interface Message<T> {

    void sendSMS(T gadget);
    void reciveSMS(T gadget);

}
