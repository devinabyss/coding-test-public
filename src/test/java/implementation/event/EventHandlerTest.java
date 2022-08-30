package implementation.event;

import org.junit.jupiter.api.Test;

class EventHandlerTest {


    private EventHandler eventHandler = EventHandler.getInstance();


    @Test
    public void test() {


        EventListener listener = new EventListener() {
            @Override
            public String getName() {
                return "AAA";
            }


            @Override
            public void onEvent(String event) {
                System.out.println("Caught On Event Listener " + getName() + ", Event : " + event);
            }
        };


        eventHandler.addListener(listener);

        for (int i = 0; i < 100; i++) {
            eventHandler.publishEvent("BBB", "AAA");
            eventHandler.publishEvent("AAA", "AAA");
            eventHandler.broadPublishEvent("CCC", "FFF");
        }


    }


}