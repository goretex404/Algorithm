
public class Permutation_forloop {

	/* 순열 중첩for문 */
	public static void main(String[] args) {
	    int count = 0;
	    int[] people = {1,2,3};
	    
	    for( int firstIndex = 0; firstIndex < people.length; firstIndex++ ) {
	        for( int secondIndex = 0; secondIndex < people.length; secondIndex++ ) {
	            
	            if( firstIndex == secondIndex ) continue;
	            
	            for( int thirdIndex = 0; thirdIndex < people.length; thirdIndex++ ) {
	                if( thirdIndex == secondIndex || thirdIndex == firstIndex ) continue;
	                
	                int first = people[firstIndex];
	                int second= people[secondIndex];
	                int third = people[thirdIndex];
	                count++;
	                System.out.println("( "+first +" " + second + " " + third +" )");
	            }
	        }
	    }
	    System.out.println("총 경우의 수 : " + count);
	}
}
