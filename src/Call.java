public interface Call<T> {
    void callOut(T gadget);
    void callIn(T gadget);
}
