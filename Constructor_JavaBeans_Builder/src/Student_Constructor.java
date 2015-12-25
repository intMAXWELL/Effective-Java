
/**
 * 
 * @author Demon
 * @version 1.0.0
 * Telescoping constructor pattern
 */
public class Student_Constructor {
	
	// required
	private final long id;
	private final String name;
	private final Sex sex;
	
	// optional
	private final String telephone;
	private final String email;
	private final String QQ;
	
	public Student_Constructor (long id,String name,Sex sex,String telephone,String email,String QQ) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.telephone = telephone;
		this.email = email;
		this.QQ = QQ;
	}
	
	public Student_Constructor(long id,String name ,Sex sex){
		this(id, name, sex, "null", "null", "null");
	}
	
	public Student_Constructor(long id,String name,Sex sex,String telePhone){
		this(id, name, sex, telePhone, "null", "null");
	}
	
	public Student_Constructor(long id,String name,Sex sex,String telephone,String email){
		this(id, name, sex, telephone, email, "null");
	}
	
}
