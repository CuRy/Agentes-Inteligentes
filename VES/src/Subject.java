import java.util.HashMap;
import java.util.Set;


public class Subject {
	private HashMap<String, String> properties;
	private String name;
	
	public Subject(String name) {
		setName(name);
		properties = new HashMap<String, String>();
	}
	
	public void setProperty(String prop, String value) {
		properties.put(prop, value);
	}
	
	public String getProperty(String prop) {
		return properties.get(prop);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String match(HashMap<String, String> subject) {
		Set<String> keys = properties.keySet();
		Set<String> keys2 = subject.keySet();
		
		for (String key: keys) {
			if (!keys2.contains(key))
				return null;
			else if (!getProperty(key).equals(subject.get(key)))
				return null;
		}
		
		return name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("The subject: ");
		sb.append(name)
		  .append(" has properties: ")
		  .append(properties.toString());
		
		return sb.toString();
	}
	
	
}
