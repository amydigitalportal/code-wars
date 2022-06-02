/**File: DigitalRoot.java
 * @author Amy Novun
 * @since June 02, 2022
 * Description: 
 *   Practice programming challenge: Digital root.
 */
public class DigitalRoot {

	/** Original method for digital root. */
	static int digitalRoot(int sum) {
		// Simple check for zero or negatives
		if (sum <= 0) {
			return 0;
		}

		// When sum has one digit
		if (sum < 10) {
			return sum;
		// When sum has multiple digits
		} else {
			int newSum = 0;
			
			// Go through each last-digit and add to new sum
			for (int i = sum; i > 0; i = i/10) {
				// Get the value of last-digit
				int lastDigit = i % 10;
				System.out.print(" *--> " + newSum + " + " + lastDigit);
				
				// Add last-digit to new sum
				newSum += lastDigit;
				System.out.println(" = " + newSum);
			}
			System.out.println(" *Sum of current iteration: " + newSum);
			return digitalRoot(newSum);
		}		
	}
	
	/** Version 2 of digital root operation. */
	static int digitalRootB(int sum) {
		if (sum < 10) {
			return sum;
		} else {
			System.out.print("  -->  ");
			int newSum = 0;				// = Running total of current iteration.
			int operand = sum;			// = Used for trimming digits.
			int operandDecimals = 0;	// = Used for tracking decimal places.
			
			for (int i = sum; i > 0; i = i / 10) {
				// Get first digit
				operandDecimals = (int) (Math.log10(operand)+1); // Get number of decimal places
				double fd = (operand / Math.pow(10, operandDecimals)) * 10; // = Determine first digit
				int firstDigit = (int) fd; 		// = Cast to integer
				newSum += firstDigit; 			// Add digit to running sum
				System.out.print(firstDigit); 	// Print out current digit
				int subtractor = firstDigit * (int) Math.pow(10, --operandDecimals);
				operand -= subtractor;	// Trim/eliminate first digit from operand
				if (operand > 0)				// When operand still has digits
					System.out.print(" + "); 	// Convey addition operator
			}
			System.out.print(" = " + newSum);
			return digitalRootB(newSum);
		}
	}
	
	/** Main entry point for program execution. */
	public static void main(String[] args) {
		
		// Execution
		int[] inputSums = { 16, 942, 132189, 493193 };
		for (int i : inputSums) {
			System.out.print(i);
			digitalRootB(i);
			System.out.println();
		}	
	}	
}//end DigitalRoot
