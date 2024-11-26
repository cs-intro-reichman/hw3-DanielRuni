// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3 V
	    System.out.println(minus(7,2));  // 7 - 2 V
   		System.out.println(minus(2,7));  // 2 - 7 V
 		System.out.println(times(3,4));  // 3 * 4 V
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2 V
   		System.out.println(pow(5,3));      // 5^3 V
   		System.out.println(pow(3,5));      // 3^5 V
   		System.out.println(div(12,3));   // 12 / 3 V
   		System.out.println(div(5,5));    // 5 / 5  V
   		System.out.println(div(25,7));   // 25 / 7 
   		System.out.println(mod(25,7));   // 25 % 7 V
   		System.out.println(mod(120,6));  // 120 % 6 V   
   		System.out.println(sqrt(36)); // V
		System.out.println(sqrt(263169)); // V
   		System.out.println(sqrt(76123)); // V
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 > 0) {
			for (int i=0; i<x2; i++) {
				x1 ++ ;
			}
		} else {
			for (int j=x2; j<0; j++) {
				x1 -- ;
			}	
		}
		
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 > 0) {
			for (int i=0; i<x2; i++) {
				x1 -- ;
			}
		} else {
			for (int j=x2; j<0; j++) {
				x1 ++ ;
			}
		}

		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 == 0 || x2 == 0) {
			return 0; }
		int sum = x1;
		if (x1 > 0 && x2 > 0) {
			for (int i=0; i<x2-1; i++) {
				sum = plus(sum, x1);
			}
		} else {
			if (x1 < 0 && x2 > 0) {
				for (int j=0; j<x2-1; j++) {
					sum = plus(sum, x1);
				}
			} else if (x1 < 0 && x2 < 0) {
				for (int k=x2; k<=0; k++) {
					sum = minus(sum, x1);
				}
			} else if (x1 < 0 && x2 >0) {
					for (int n=x2; n<=0; n++) {
						sum = plus(sum, x1);
					}
				}
			}
			return sum;
		}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int sum = x;
		for (int i=0; i<n-1; i++) { 
			sum = times(sum, x);
		}
		return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x1 == 0 || x2 == 0) {
			return 0;
		}
		int sum = x1, counter = 0;
		if (x1 > 0 && x2 > 0) {
			while (sum > 0) {
				sum = minus(sum, x2);
				counter ++;
			}
		} else if (x1 > 0 && x2 < 0) {
			while (sum > 0) {
				sum = minus(sum, x2);
				counter -- ;
			}
		} else if (x1 < 0 && x2 > 0) {
			while (sum < 0) {
				sum = plus(sum, x2);
				counter -- ;
			}
		} else {
			while (sum < 0) {
				sum = minus(sum, x2);
				counter ++ ;
			}
		}
		if (sum == 0) {
			return counter;
		} else {
			counter -- ;
			return counter;
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int remainder = x1;
		while (remainder >= x2) {
			remainder = minus(remainder, x2);
		}
		return remainder;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int count = 1 , number = pow(count, 2);
		while (number < x) {
			count ++ ;
			number = pow(count, 2);
		}
		if (number == x) {
			return count;
		} else {
			count --;
			return count;
		}
	}	  	  
}