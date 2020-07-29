import java.util.*; 

/*
$javac Homework1.java

$java -Xmx128M -Xms16M Homework1

test-0 PASSED.
test-1 PASSED.
test-2 PASSED.
test-3 PASSED.
test-4 PASSED.
test-5 PASSED.
test-6 PASSED.
test-7 PASSED.
test-8 PASSED.
test-9 PASSED.
test-10 PASSED.
*/
public class Homework1{

    public static void main(String []args){
        testSortColors();
    }
    
    // 75. Sort Colors
    // Use counting sort to sort colors
    public static void sortColors(int[] nums) {
        // Iterrate the array counting numbers of 0, 1, and 2
        int[] counts = new int[3]; 
        for (int color : nums) {
            counts[color]++;
        }
        
        // Overwrite array with total number of 0, 1, and 2
        int index = 0;
        for (int color = 0; color < counts.length; color++) {
            int count = counts[color];
            while (count > 0) {
                nums[index] = color;
                index++;
                count--;
            }
        }
    }
    
    // Test sorting colors
    public static void testSortColors() {
        int[][] inputs = {
                {},
                {0, 1, 2},
                {0, 2, 1},
                {1, 0, 2},
                {1, 2, 0},
                {2, 0, 1},
                {2, 1, 0},
                {2, 0, 2, 1, 1, 0},
                {1, 0, 1, 2, 2, 0},
                {0, 1, 0, 2, 2, 1},
                {1, 2, 1, 0, 0, 2},
        };
        int[][] answers = {
                {},
                {0, 1, 2},
                {0, 1, 2},
                {0, 1, 2},
                {0, 1, 2},
                {0, 1, 2},
                {0, 1, 2},
                {0, 0, 1, 1, 2, 2},
                {0, 0, 1, 1, 2, 2},
                {0, 0, 1, 1, 2, 2},
                {0, 0, 1, 1, 2, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            Homework1.sortColors(inputs[i]);
            int[] expected = answers[i];
            assertEquals(i, inputs[i], expected);
        }
     }    
    
    private static void assertEquals(int number, int[] actual, int[] expected) {
        if (Arrays.equals(actual, expected)) {
            System.out.println("test-" + number + " PASSED.");
        } else {
            System.out.println("test-" + number + " FAILED. actual: " + Arrays.toString(actual) + ", expected: " + Arrays.toString(expected));
        }
    }
}
