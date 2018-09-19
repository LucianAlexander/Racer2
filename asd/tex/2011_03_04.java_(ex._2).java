// Esame del 4 marzo 2011, esercizio 2
// Ricordarsi di specificare sempre, nei commenti al codice, l'utilità di ogni metodo.

interface Map<K, V>
	{
	public static final int HORNER_Z = 33;
	public Entry<K, V> get(K key);
	public Entry<K, V> put(K key, V value);
	public Entry<K, V> remove(K key);
	public int size();
	public Collection<K> keys();
	public Collection<V> values();
	public Collection<Entry<K, V>> entries();
	public int hash(K key);
	}

interface Entry<K, V>
	{
	K key;
	V value;
	public Entry(K key, V value);
	public K getKey();
	public V getValue();
	}

public int hash(String key) // Costo computazionale non richiesto
	{
	int pos = 0;
	for(int i = 0; i < key.length(); i++)
		pos += key.charAt(i) * Math.pow(HORNER_Z, i);
	return pos;
	}

// Il metodo assume una variabile d'istanza private Entry<String, String>[] entries nella classe della mappa!
public Entry<String, String> put(String key, String value) throws Exception // Costo computazionale non richiesto
	{
	int pos = hash(key);
	if(pos > entries.length) pos = pos % entries.length;
	boolean done = false;
	for(int i = 0; i < size(); i++)
		{
		if(pos + i < entries.length)
			{
			if(entries[pos + i] == null)
				{
				entries[pos + i] = new Entry<String, String>(key, value);
				done = true;
				return entries[pos + i];
				}
			}
		else
			{
			if(entries[(pos + i) % entries.length] == null)
				{
				entries[(pos + i) % entries.length] = new Entry<String, String>(key, value);
				done = true;
				return entries[(pos + i) % entries.length];
				}
			}
		}
	if(!done) throw new Exception("Element insertion failed");
	}

public Entry<String, String> remove(K key) // Costo computazionale non richiesto
	{
	int pos = hash(key);
	if(pos > entries.length) pos = pos % entries.length;
	Entry<String, String> out = entries[pos];
	entries[pos] = null;
	return out;
	}