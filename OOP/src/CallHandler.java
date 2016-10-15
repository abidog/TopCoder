public class CallHandler {

    private static CallHandler instance;

    private CallHandler() {
        if (instance == null) {
            instance = new CallHandler();
        }
    }
    public CallHandler getCallHandler() {
        return instance;
    }


}
