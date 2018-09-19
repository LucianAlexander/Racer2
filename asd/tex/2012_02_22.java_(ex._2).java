// Esame del 22 febbraio 2012, esercizio 2
// Ricordarsi di specificare sempre, nei commenti al codice, l'utilità di ogni metodo.

class FSInstance
	{
	String name;
	public FSInstance(String name);
	public String getName();
	}

class Folder extends FSInstance
	{
	LinkedList<FSInstance> content;
	int children;
	public Folder(String name);
	public List<FSInstance> getChildren();
	public void add(FSI child);
	public void remove(String name);
	}

class File extends FSInstance
	{
	long size;
	public File(String name, long size);
	public long getSize();
	}

class Link extends FSInstance
	{
	String path;
	public Link(String name, String path);
	public String getPath();
	}

class FileSystem
	{
	FSInstance root;
	public FSInstance getRoot();
	}

public List<String> search(String name)
	{
	List<String> out = new LinkedList<String>();
	String route = "";
	search(name, root, out, route);
	return out;
	}

public void search(String name, FSInstance elem, List<String> out, String route)
	{
	if(elem == null || elem instanceof Link) return;
	route.concat(elem.getName());
	if(elem instanceof File)
		{
		if(elem.getName().equals(name)) out.add(route);
		return;
		}
	else if(elem instanceof Folder)
		{
		for(FSInstance child : elem.getChildren())
			search(name, child, out, route);
		}
	}

public long getSize(FSInstance elem)
	{
	long totalLength = 0;
	getSize(elem, totalLength);
	return totalLength;
	}

public void getSize(FSInstance elem, long totalSize)
	{
	if(elem == null || elem instanceof Link) return;
	else if(elem instanceof File) totalSize += elem.getSize();
	else if(elem instanceof Folder)
		{
		for(FSInstance child : elem.getChildren())
			getSize(elem, totalSize);
		}
	}