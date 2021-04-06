import java.util.ArrayList;

public class Permutation_recursion {

	/* 
	 * 순열 재귀함수 
	 * 
	 * Run configuration 이용
	 * */
	public static void main(String[] people) {
		int input = 3;
//		boolean 배열 생성 시 false 값 으로 채워짐
		boolean[] isChecked = new boolean[people.length];
		String[] result = new String[input];
		ArrayList<String[]> totalList = new ArrayList<String[]>();

		permutation(people, isChecked, result, input, 0, totalList);

		for (String[] strings : totalList) {
			String temp = "";
			for (String text : strings) {
				temp += " " + text;
			}
			System.out.println(temp);
		}
		System.out.println("총 경우의 수zz : " + totalList.size());
		Stack st = new Stack();
	}

	private static void permutation(String[] people, boolean[] isChecked, String[] result, int endPoint, int dept,
			ArrayList<String[]> totalList) {
		if (endPoint == dept) {
			totalList.add(result.clone());
		} else {
			for (int i = 0; i < people.length; i++) {
				if (!isChecked[i]) {
					isChecked[i] = true; // 사용된 배열 위치
					result[dept] = people[i]; // 저장
					permutation(people, isChecked, result, endPoint, dept + 1, totalList);
					isChecked[i] = false; // 사용된 것 다시 제자리
					result[dept] = ""; // 저장된 것 제자리
				}
			}
		}
	}
}
