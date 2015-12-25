
/**
 * 
 * @author Demon
 * @version 1.0,0
 * Builder pattern
 */
public class Student_Builder {

	
	// required
	private final long id;
	private final String name;
	private final Sex sex;
	
	// optional
	private final String telephone;
	private final String email;
	private final String QQ;
	
	public static class Builder implements Builders<Student_Builder>{
		// required
		private final long id;
		private final String name;
		private final Sex sex;
		
		// optional
		private String telephone = "null";
		private String email = "null";
		private String QQ = "null";
		
		public Builder(long id ,String name,Sex sex){
			this.id = id;
			this.name = name;
			this.sex = sex;
		}
		
		public Builder setTele(String tele){
			this.telephone = tele;
			return this;
		}
		
		public Builder setEmail(String email){
			this.email = email;
			return this;
		}
		
		public Builder setQQ(String qq){
			this.QQ = qq;
			return this;
		}
		
		@Override
		public Student_Builder build(){
			return new Student_Builder(this);
		}
		
	}
	private Student_Builder(Builder builder){
		this.id = builder.id;
		this.name = builder.name;
		this.sex  = builder.sex;
		this.telephone = builder.telephone;
		this.email = builder.email;
		this.QQ = builder.QQ;
	}

}
