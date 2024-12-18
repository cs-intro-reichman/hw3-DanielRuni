/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		int sw = 0;
		str1 = preProcess(str1);
		for (int k=0; k<str1.length(); k++) {
			if (str1.charAt(k) == 32) {
				if (k == 0) {
					str1 = (str1.substring(1));
				} else {
					str1 = (str1.substring(0,k)) + (str1.substring(k+1));	
				}
			}
		}
		str2 = preProcess(str2);
		for (int m=0; m<str2.length(); m++) {
			if (str2.charAt(m) == 32) {
				if (m == 0) {
					str2 = (str2.substring(1));
				} else {
					str2 = (str2.substring(0,m)) + (str2.substring(m+1));	
				}
			}
		}
		if (str1.length() != str2.length()) {
			return false;
		}
		for (int i=0; i<str1.length(); i++) {
			sw = 0;
			for (int j=0; j<str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					sw = 1;
					if (j == 0) {
						str2 = str2.substring( 1);
					} else if (j == (str2.length()-1)) {
						str2 = str2.substring(0 , (j));
					} else {
						str2 = (str2.substring( 0 , (j) )) + (str2.substring(j+1));
					}
					break;
				}
			}
			if (sw == 0) {
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String fixedWord = "";
		for (int i=0; i<str.length(); i++) {
			if (((str.charAt(i) >= 65) && (str.charAt(i) <= 90)) || ((str.charAt(i) >= 97) && (str.charAt(i) <= 122)) || (str.charAt(i) == 32)) {
				fixedWord = fixedWord + str.charAt(i);
			}
		}
		fixedWord = fixedWord.toLowerCase();
		return fixedWord;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String randomized = "";
		while (str.length() > 0) {
			int i = (int) (Math.random() * (str.length()));
			randomized += str.charAt(i);
			if (i == 0) {
				str = str.substring( 1);
			} else if (i == (str.length()-1)) {
				str = str.substring(0 , (i));
			} else {
				str = (str.substring( 0 , (i) )) + (str.substring(i+1));
			}
		}
		return randomized;
	}
}
