import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


public class Utils {
	private static ArrayList<Subject> subjects;
	
	static {
		subjects = new ArrayList<Subject>();
	}
	
	public static boolean loadRules() {
		try {
			FileReader fr = new FileReader("rules.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			String name = "";
			
			while (line != null) {
				String[] def = line.split("IF");
				name = def[0].trim();
				name = name.substring(0, name.length() - 1);
				
				String conditions[] = def[1].trim().split("AND"); // Should be a list of attributes separated by "AND"s
				
				// Read subject properties
				Subject subject = new Subject(name);
				
				for (String cond: conditions) {
					String parts[] = cond.split("=|<|>|<=|>=|!=");
					subject.setProperty(parts[0], parts[1]);
				}
				System.out.println(subject);
				subjects.add(subject);
				
				line = br.readLine();
			}
			
			br.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static void classifySubjects() {
		try {
			FileReader fr = new FileReader("subjects.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			int index = 0;
			boolean notFound = true;
			
			while (line != null) {				
				String properties[] = line.split("AND"); // Should be a list of properties separated by "AND"s
				HashMap<String, String> unknown = new HashMap<String, String>();
				
				for (String prop: properties) {
					String parts[] = prop.split("=|<|>|<=|>=|!=");
					unknown.put(parts[0], parts[1]);
				}
				
				for (Subject subject: subjects) {					
					String name = subject.match(unknown);
					if (name != null) {
						System.out.printf("The subject at line: %d, is of type: %s\n", index, name);
						notFound = false;
						break;
					}
				}
				
				if (notFound)
					System.out.printf("The subject at line: %d, is unknown\n", index);
				
				line = br.readLine();
				index++;
			}
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
