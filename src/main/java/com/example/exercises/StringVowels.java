package com.example.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class StringVowels {
	
	public static String findVowelInString2(String str, int position) {
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < str.length(); i += position) {
			if (isVowel(str.charAt(i))) {
				//System.out.println(ArrChar[i] + " at index" + i);
				sb.append(str.charAt(i));
			}
		    
		}
		return sb.toString();

	}
	public static void findVowelInString(String str, int position) {
		char[] ArrChar = str.toCharArray();
		//position = position - 1;
		System.out.println("Original: " + str + "\nPosition every: " + position + "\n");
		// System.out.println();
		for (int i = position; i < ArrChar.length; i+=position) {
			//System.out.println(i+"\n");
			if (isVowel(ArrChar[i])) {
				System.out.println(ArrChar[i] + " at index" + i);
			}
		}
	}
	public static boolean isVowel(char c) {
		return "AEIOUaeiou".indexOf(c) != -1;
	}
	
	public static String reverseStringJava8(String cadena) {
		String reversed = cadena.chars()
			    .mapToObj(c -> (char)c)
			    .reduce("", (s,c) -> c+s, (s1,s2) -> s2+s1);
		return reversed;
	}
	
	public static String reverseString(String cadena) {
		String newcadena = "";
		int count =cadena.length() - 1;
		
		while (count >= 0) {
			
			//System.out.println(cadena.charAt(count));
			newcadena += cadena.charAt(count);
			count--;
		}
		
		return newcadena;
	}
	
	public static String reverseString2(String cadena) {
		
		String reversed = new StringBuilder(cadena).reverse().toString();
		
		return reversed;
	}
	
    public static String leftrotate(String str, int d)
    {
            String ans = str.substring(d) + str.substring(0, d);
            return ans;
    }
 
    public static String rightrotate(String str, int d)
    {
            return leftrotate(str, str.length() - d);
    }
    
    public static boolean palindromeFunction(String str) {
    	
        StringBuilder plain = new StringBuilder(str);
        StringBuilder reverse = plain.reverse();
        return (reverse.toString()).equals(str);
    }
	
    public static int soldiers(int n, int k) {
    	if (n == 1) {
    		return 1;
    	} else {
    		return (soldiers(n - 1, k) + k - 1) % n + 1;
    	}
    }
    public static int soldiers2(int persons,int kskip){
        int safe=0;
        // Finding the Last survival person after completion of the loop.
        for(int i=1;i<=persons;i++){
            safe=(safe+kskip)%i;
        }
        return  safe+1;
    }
    private static List<String> intStreamMethodSoldier(final List<String> soldiersList) {
    	Predicate<Integer> isEven = i -> i % 2 == 0;
    	//This line is java 11...
    	Predicate<Integer> isOdd = Predicate.not(isEven);

    	Predicate<String> isEvenIndex = str -> (soldiersList.indexOf(str)+1)%2 == 0;
    	List<String> soldiersList1 = new ArrayList<>();

    	if(soldiersList.size() == 2) return soldiersList;

    	if(soldiersList.size() > 2) {
    		soldiersList1 = soldiersList.stream().filter(Predicate.not(isEvenIndex)).collect(Collectors.toList());
    	}
    	if(soldiersList.size()%2 != 0)
    		Collections.rotate(soldiersList1, 1);

    	soldiersList1 = intStreamMethodSoldier(soldiersList1);

    	return soldiersList1;
    }
    public static String stringListCombination(String[] str) {
    	String combinedString = String.join(", ", str);
    	return combinedString;
    }
	public static void main(String[] args) {
		//findVowelInString("esquinca bonilla jose antonio", 3);
		System.out.println(findVowelInString2("hhohhehhi", 3));
		//System.out.println(reverseString("aloha"));
		//System.out.println(reverseString2("esquinca"));
		System.out.println(reverseStringJava8("esquinca"));
		
		System.out.println(leftrotate("esquinca", 2));
		System.out.println(rightrotate("esquinca", 2));
		
		
		//String name = "esquinca";
		//String something = name.substring(2) + name.substring(0, 2);
		//String something2 = name.substring(name.length() - 2) + name.substring(0, name.length() - 2);
		
		String palindrome1 = "tenet";
		String palindrome2 = "madam";
		String notpalindrome = "hello";
		System.out.println(palindromeFunction(palindrome1));
		//String clean = text.replaceAll("\\s+", "").toLowerCase();
		
		int n = 14, k = 2;
		System.out.println(soldiers2(n, k));
		//System.out.println(soldiers(7, 2));
		
		
		String[] planets = {"Mercury", "Venus", "Mars"};
		System.out.println("Planets: " + stringListCombination(planets));
		//System.out.println(name);
		//System.out.println(something);
		//System.out.println(something2);
		
		
		
	}
	
}
