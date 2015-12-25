import java.util.Calendar;

/**
 * 
 * @author Demon
 *
 */
public class Main {

	private static final int MAX_TIMES = 10000;
	private static final int LOOPS = 1000000;

	public static void main(String[] args) {

		{
			int sum = 0;
			int i, j;
			for (j = 0; j < MAX_TIMES; j++) {
				Calendar c = Calendar.getInstance();

				long start = c.getTimeInMillis();
				for (i = 0; i < LOOPS; i++) {
					// Constructor
					Student_Constructor student_Constructor = new Student_Constructor(
							0, "Liao", Sex.Male, "12345678",
							"386654578@qq.com", "386654578");
				}

				c = Calendar.getInstance();
				long end = c.getTimeInMillis();
				sum += end - start;
			}

			System.out.println("Constructor:" + sum);
		}

		{
			int sum = 0;
			int i, j;
			for (j = 0; j < MAX_TIMES; j++) {

				Calendar c = Calendar.getInstance();
				long start = c.getTimeInMillis();

				for (i = 0; i < LOOPS; i++) {
					// JavaBeans
					Student_JavaBeans student_JavaBeans = new Student_JavaBeans();
					student_JavaBeans.setId(0);
					student_JavaBeans.setName("Liao");
					student_JavaBeans.setSex(Sex.Male);
					student_JavaBeans.setTelephone("12345678");
					student_JavaBeans.setEmail("386654578@qq.com");
					student_JavaBeans.setQQ("386654578");
				}

				c = Calendar.getInstance();
				long end = c.getTimeInMillis();
				sum += end - start;
			}

			System.out.println("JavaBeans:" + sum);
		}

		{
			int sum = 0;
			int i, j;
			for (j = 0; j < MAX_TIMES; j++) {

				Calendar c = Calendar.getInstance();
				long start = c.getTimeInMillis();

				for (i = 0; i < LOOPS; i++) {
					// Builder
					Student_Builder student_Builder = new Student_Builder.Builder(
							0, "Liao", Sex.Male).setEmail("386654578@qq.com")
							.setTele("12345678").setQQ("38854578").build();
				}

				c = Calendar.getInstance();
				long end = c.getTimeInMillis();
				sum += end - start;
			}

			System.out.println("Builder:" + sum);
		}

	}

}
