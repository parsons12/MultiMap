import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ListMultiMap<K, V> implements MultiMap<K, V> {
	private HashMap<K, List<V>> map = new HashMap<K, List<V>>();

	/**
	 * Check whether the map contains the value specified.
	 * @param value -- the value to search for
	 * @return true if the map contains the value, false otherwise
	 */
	@Override
	public boolean contains(V value) {
		for (Entry<K, List<V>> entry : map.entrySet()) {
		    if(entry.getValue().contains(value)) {
		    	return true;
		    }
		}
		return false;
	}
	/**
	 * Get the collection of values associated with the specified key
	 * @param key -- the key to retrieve
	 * @return the Collection of values
	 */
	@Override
	public Collection<V> get(K key) {
		return map.get(key);
	}
	/**
	 * Check if the map is empty
	 * @return true if it is empty, false if not empty
	 */
	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}
	/**
	 * Get the set of keys in the map
	 * @return set of keys in the map
	 */
	@Override
	public Set<K> keySet() {
		return map.keySet();
	}
	/**
	 * Add the value to the map associated with the specified key
	 * @param key -- the key to store against
	 * @param value -- the value to add to the map at the key
	 */
	@Override
	public void put(K key, V value) {
		if(map.get(key) == null) {
			map.put(key, new ArrayList<V>());
		}
		map.get(key).add(value);
	}
	/**
	 * Remove all values associated with the specified key
	 * @param key -- the key to remove values from
	 * @return the Collection of values removed
	 */
	@Override
	public Collection<V> remove(K key) {
		return map.remove(key);
	}
	/**
	 * Removes a specific value from map. 
	 * @param key -- the key to remove value from
	 * @param value -- the value to remove
	 * @return the value removed, null if nothing removed
	 */
	@Override
	public V remove(K key, V value) {
		map.get(key).remove(value);
		return value;
	}
	/**
	 * Number of objects in the map
	 * @return Number of objects in the map
	 */
	@Override
	public int size() {
		return map.size();
	}
	/**
	 * Get a collection containing all the values in the map
	 * @return a collection view of the values contained in this map
	 */
	@Override
	public Collection<V> values() {
		return (Collection<V>) map.values();
		}
		


}
