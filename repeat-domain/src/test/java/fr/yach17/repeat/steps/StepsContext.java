package fr.yach17.repeat.steps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SaYaQuenGa on 21/07/2014.
 */
public class StepsContext{
    private Map<Key, Object> context = new HashMap<>();


    public <T> T put(String key, T value){
        return (T) context.put(Key.from(key, value), value);
    }

    public <T> T get(String key, Class<T> clazz){
        return (T) context.get(Key.from(key, clazz));
    }

    private static class Key<V> {
        private String key;
        private Class<V> type;

        private Key( String key, Class<V> valueType) {
            this.key = key;
            this.type = valueType;
        }

        private static <U> Key<U> from(String key, U value) {
            return new Key<U>(key, (Class<U>) value.getClass());
        }
        private static <U> Key<U> from(String key, Class<U> clazz) {
            return new Key<U>(key, clazz);
        }
    }
}
