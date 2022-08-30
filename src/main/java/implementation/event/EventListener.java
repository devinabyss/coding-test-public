package implementation.event;

public interface EventListener {

    String getName();

    void onEvent(String event);
}
