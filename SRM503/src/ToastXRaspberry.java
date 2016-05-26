public class ToastXRaspberry {
    public int apply(int upper_limit, int layer_count) {
        return (int)Math.ceil(layer_count/upper_limit);
    }
}
