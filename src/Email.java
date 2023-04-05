public interface Email<T> extends Internet{

    void sendEmail(T gadget);
    void reciveEmail(T gadget);
}
