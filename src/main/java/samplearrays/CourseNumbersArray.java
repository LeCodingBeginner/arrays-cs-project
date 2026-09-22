package samplearrays;

public class CourseNumbersArray {
    // I need to create three methods - addCourseNumber & hasCourseNumber & display:
    // addCourseNumber:
    public static int[] addCourseNumber(int[] courseNumbers,int c){
        // let's check if c is already is courseNumbers:
        for (int e : courseNumbers){
            if (e == c){
                return courseNumbers;
            }
        }
        // if not let's create a new array that contains c:
        int[] updatedCourses = new int[courseNumbers.length+1];
        for (int i = 0; i< courseNumbers.length; i++){
            updatedCourses[i] = courseNumbers[i];
        }
        updatedCourses[courseNumbers.length] = c;

        return updatedCourses;
    }

    // hasCourseNumber:
    public static boolean hasCourseNumber(int[] courseNumbers ,int c){
        for(int e : courseNumbers){
            if (e==c){
                return true;
            }
        }
        return false;
    }

    public static void display(int [] table){
        System.out.println("The course numbers are: ");
        for (int e : table){
            System.out.println(" | " + e);
        }
    }

    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};

        // let's add a new course:
        int [] updatedCourses = addCourseNumber(registeredCourses,2240);

        // let's check if it has 2240:
        System.out.println(hasCourseNumber(updatedCourses,2240)); // should print true
        System.out.println(hasCourseNumber(registeredCourses,2240)); // should print flase

        // let's display :
        display(updatedCourses);
    }
}
