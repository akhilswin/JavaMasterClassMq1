package yaksha;

import java.util.*;

public class MainClass {

	public static String highestScorer(StudentInformation studentInformation) throws InvalidMarkException {
		String name = "";
		int score = 0;
		String information[] = studentInformation.getInformation();
		for (int i = 0; i < information.length; i++) {
			StringTokenizer st = new StringTokenizer(information[i], "-");
			String tname = st.nextToken();
			int tscore = 0;
			for (int j = 0; j < 3; j++) {
				int cscore = Integer.parseInt(st.nextToken());
				if (cscore < 0 || cscore > 100) {
					throw new InvalidMarkException("Score in a subject must be between 0 to 100");
				} else {
					tscore = tscore + cscore;
				}
			}
			if (tscore > score) {
				score = tscore;
				name = tname;
			}
		}
		return name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter number of students");
		Scanner scanner = new Scanner(System.in);
		int size = Integer.parseInt(scanner.nextLine());
		String information[] = new String[size];
		System.out.println("Enter students details");
		for (int i = 0; i < size; i++)
			information[i] = scanner.nextLine();
		StudentInformation studentInformation = new StudentInformation(information);
		System.out.print("Highest scorer student is : ");
		try {
			System.out.println(highestScorer(studentInformation));
		} catch (InvalidMarkException m) {
			System.out.println("Exception occured: " + m);
		}
		scanner.close();
	}
}
