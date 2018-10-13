/**
 * Class for symbol table.
 */
class SymbolTable {
    /**
     * keys array.
     */
    private String[] keys;
    /**
     * values array.
     */
    private Integer[] values;
    /**
     * no of elemnts inserted till.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    SymbolTable(final int n) {
        keys = new String[n];
        values = new Integer[n];
        size = 0;
    }
    /**
     * inserts a key-value pair.
     * Best case: O(1)
     * Worst case: O(N)
     * Average case: O(N)
     * @param      key    The key
     * @param      value  The value
     */
    void put(final String key, final Integer value) {
        if (value == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }
    /**
     * contains.
     * Best case: O(1)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    boolean contains(final String key) {
        return get(key) != null;
    }
    /**
     * gets function.
     * Best case: O(1)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    Integer get(final String key) {
        if (size == 0) {
            return null;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return null;
    }
    /**
     * rank.
     * Best case: O(1)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    int rank(final String key) {
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
    /**
     * max.
     * Best case: O(1)
     * Worst case: O(1)
     * Average case: O(1)
     * @return     { description_of_the_return_value }
     */
    String max() {
        return keys[size - 1];
    }
    /**
     * deletes.
     * Best case: O(1)
     * Worst case: O(N)
     * Average case: O(N)
     * @param      key   The key
     */
    void delete(final String key) {
        if (size == 0) {
            return;
        }
        int i = rank(key);
        if (i == size || keys[i].compareTo(key) != 0) {
            return;
        }
        int j;
        for (j = i; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        size--;
        keys[j] = null;
        values[j] = null;
    }
    /**
     * deletes min value.
     * Best case: O(1)
     * Worst case: O(N)
     * Average case: O(N)
     */
    void deleteMin() {
        delete(keys[0]);
    }
    /**
     * prints all values.
     * Best case: O(1)
     * Worst case: O(N)
     * Average case: O(N)
     *
     * @return     { description_of_the_return_value }
     */
    String[] keys() {
        String[] res = new String[size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (values[i] != null) {
                res[k++] = keys[i];
            }
        }
        return res;
    }
    /**
     * floor.
     * Best case: O(1)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    String floor(final String key) {
        int i = rank(key);
        if (i < size && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        }
        return keys[i - 1];
    }
    /**
     * prints.
     */
    void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(keys[i] + "         " + values[i]);
        }
    }
}