# 类初始化代码的几种写法 #
主要比较Telescoping constructor pattern,JavaBeans pattern and Builder pattern。

## Telescoping constructor pattern（重叠构造器） ##
比较常见，这种情况下，提供第一个只有**必要**参数的构造器，第二个构造器有一个可选参数，第三个两个，以此类推，最后一个构造器包含所有可选参数。
示例：

	public class Student_Constructor {
	
	public enum Sex{
		Male,
		Female;
	}
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

缺点：
1. 当有许多参数时，代码很难编写
2. 代码很难阅读，读者必须仔细数着参数来探究各值的意思


## JavaBeans Patttern ##
在这种模式下，调用一个无参构造器来创建对象，然后调用setter方法设置每个必要的参数。

    public class Student_JavaBeans {
	
	public enum Sex{
		Male,
		Female;
	}
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

优点：弥补了重叠构造器模式的不足
缺点：
1. 初始化代码冗长
2. 构造过程被分到了几个调用中，在构造过程中JavaBean可能处于不一致的状态。(解决方案：程序员付出额外的努力来确保它的线程安全。)

## Builder模式 ##
既能保证像重叠构造器模式那样的安全性，也能保证像JavaBeans模式那么好的可读性。

示例：

    public interface Builders<T> {
		public T build();
	}

    public class Student_Builder {

	public enum Sex{
		Male,
		Female;
	}
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

优点：
1. Builder模式十分灵活，可以单个Builder构建多个对象。
2. 有多个可变的参数。
3. 方便代码重构和参数增加。

缺点：
1. 参数较少的时候代码冗余。
2. 在十分注重性能的情况下，开销明显。