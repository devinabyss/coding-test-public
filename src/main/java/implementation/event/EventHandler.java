package implementation.event;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 참조
 * https://blog.silentsoft.org/archives/10
 */
@Slf4j
public class EventHandler {
    private static final int MAX_THREAD_POOL = 5;
    private static final ReentrantLock lock = new ReentrantLock();
    //private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    // why copy on write? = multithreaded env
    //private static final List<EventListener> listeners = new CopyOnWriteArrayList<>();
    private static final Map<String, EventListener> listeners = new Hashtable<>();

    private static final ExecutorService publishExecutor = Executors.newFixedThreadPool(MAX_THREAD_POOL);

    private EventHandler() {
    }

    private static EventHandler self = null;

    public static EventHandler getInstance() {
        self = Optional.ofNullable(self).orElseGet(() -> {
            try {
                boolean isLocked = lock.tryLock(100, TimeUnit.MILLISECONDS);
                if (isLocked) return self = new EventHandler();
                else throw new RuntimeException("EventHandler Creating Failed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        });
        return self;
    }


    //
    private EventListener getListener(String key) {
        return listeners.get(key);
    }


    public void addListener(EventListener eventListener) {
//        try {
//            boolean locked = lock.tryLock(100, TimeUnit.MILLISECONDS);
//            if (locked) {
                listeners.put(eventListener.getName(), eventListener);
//            } else {
//                throw new RuntimeException("EventListener Register Failed.");
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } finally {
//            lock.unlock();
//        }
    }

    public void publishEvent(String eventType, String message) {
        publishExecutor.submit(() -> {
            EventListener listener = getListener(eventType);
            if (Objects.nonNull(listener)) {
                listener.onEvent(message);
            } else {
                log.info("## No Suitable Listener : {}, Message : {}", eventType, message);
            }
        });
    }

    public void broadPublishEvent(String eventType, String message) {
        log.info("## Broadcast Event Publish : {} - {}", eventType, message);
        listeners.forEach((key, value) -> publishExecutor.submit(() -> {
            value.onEvent(message);
        }));

    }

}
