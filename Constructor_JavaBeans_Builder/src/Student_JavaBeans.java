
/**
 * 
 * @author Demon
 * @version 1.0.0
 * JavaBeans pattern
 */
public class Student_JavaBeans {
	
	// required
	private long id = -1; // required no default value
	private String name = "error";
	private Sex sex = Sex.Male;
	
	// optional
	private String telephone = "null";
	private String email = "null";
	private String QQ = "null";
	
	public Student_JavaBeans () {}

	// setters
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}
}
