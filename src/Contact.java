import java.util.List;
import java.lang.NullPointerException;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
public class Contact{
	private String attributes;
	/* A list of Attributes to be used
	 * n : name
	 * a : address
	 * p : phone
	 * f : fax
	 * e : email
	 * b : birthdate
	 * o : organization
	 * r : relationship
	 * c : nickname
	 * w : website
	 * g : gender
	 * s : notes
	 * h : phonetic name
	 */
	private List<String> fields;
	private static Dictionary<String, String> d = new Hashtable<String,String>();
	private static boolean initted = false;
	public Contact(String attrib, List<String> f){
		if(attrib == null || f == null)throw new NullPointerException();
		this.attributes = attrib;
		this.fields = f;
		if(!initted) init();
	}
	public static void init(){
		d.put("name", "n");
		d.put("address", "a");
		d.put("phone", "p");
		d.put("fax", "f");
		d.put("email", "e");
		d.put("birthdate", "b");
		d.put("organization", "o");
		d.put("relationship", "r");
		d.put("nickname","c");
		d.put("website", "w");
		d.put("gender", "g");
		d.put("notes", "s");
		d.put("phonetic","h");
		initted = !initted;
	}
	public String get(String attrib) throws Exception{
		String nameChar = "\\";
		if(attrib.length() == 1) nameChar = attrib;
		else nameChar = d.get(attrib);
		int queryNum = attributes.indexOf(nameChar);
		if(queryNum<0)throw new Exception("The attribute is not listed for the requested contact");
		return fields.get(queryNum);
	}
	public static void main(String[] args)throws Exception{
		List<String> info = new ArrayList<String>();
		String attributes = "npes";
		info.add("Pridhvi Myneni");
		info.add("6094974557");
		info.add("bluerat33@gmail.com");
		info.add("This dingus forgot his header!");
		Contact c = new Contact(attributes, info);
		System.out.println(c.get("phone"));
	}
}
