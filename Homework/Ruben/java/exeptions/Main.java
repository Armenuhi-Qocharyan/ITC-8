public class Main {
    public static void findName(String name) throws NameNotFound{
	if(name == ""){
	    throw new NameNotFound("Name not found");
	}
	System.out.println(name);
    }
    public static void main(String[] args){
	try {
	    findName("");
	} catch (NameNotFound ex) {
	    ex.printStackTrace();
	}
    }
}
