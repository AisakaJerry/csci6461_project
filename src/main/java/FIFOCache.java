import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class FIFOCache {
    public Map<String, String> cache;
    public int size;
    public Deque<String> keyQueue;

    public FIFOCache()
    {
        cache = new ConcurrentHashMap<>(size);
        this.size = size;
        keyQueue = new LinkedList<>();
    }

    /*Update the queue, every time we add a new element*/
    private void cycleKeyQueue(String key)
    {
        keyQueue.addLast(key);
        if (keyQueue.size() > size) {
            String first = keyQueue.removeFirst();
            cache.remove(first);
        }
    }

    /*Get the list of key*/
    public String keyQueue()
    {
        return String.join(",", keyQueue);
    }

    /*Add new element*/
    public void addValue(String key, String value)
    {
        cycleKeyQueue(key);
        cache.putIfAbsent(key,value);
    }

    /*Delete element*/
    public void delValue(String key, String value)
    {
        cache.remove(key, value);
        keyQueue.remove(key);
    }

    /*Get the value of key*/
    public void getValue(String key)
    {
        cache.get(key);
    }
}
