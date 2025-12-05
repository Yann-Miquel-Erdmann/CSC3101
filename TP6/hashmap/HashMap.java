package TP6.hashmap;

public class HashMap<K, V> implements Map<K, V> {
    private Map<K, V>[] table;
    private int size = 0;

    public HashMap() {
        table = new Map[5];
        for (int i = 0; i < table.length; i++) {
            table[i] = new ListMap<K, V>(null, null);
        }
    }

    public HashMap(int tabSize) {
        table = new Map[tabSize];
        for (int i = 0; i < table.length; i++) {
            table[i] = new ListMap<K, V>(null, null);
        }
    }

    private Map<K, V> getList(K key) {
        return table[(key.hashCode() % table.length + table.length) % table.length];
    }

    private void resize() {
        HashMap<K, V> newHM = new HashMap<>(table.length * 2);

        for (int i = 0; i < table.length; i++) {
            table[i].allTo(newHM);
        }

        this.table = newHM.table;
    }

    public int getSize() {
        return size;
    }
    public int getTableLength() {
        return table.length;
    }

    @Override
    public boolean put(K key, V value) {
        if (getList(key).put(key, value)) {

            size += 1;
            if (size > table.length * 0.75) {
                resize();
            }

            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        return getList(key).get(key);
    }

    @Override
    public boolean remove(K key) {

        if (getList(key).remove(key)) {
            size -= 1;
            return true;
        }
        return false;
    }

    @Override
    public void display() {
        for (int i = 0; i < table.length; i++) {
            table[i].display();
        }
    }

    @Override
    public void allTo(Map<K, V> map) {
        for (int i = 0; i < table.length; i++){
            table[i].allTo(map);
        }
    }


}
