package geeksForGeeksInterviewPrep;

import java.util.Scanner;

/**
 * Created by fame.issrani on 1/2/19.
 */
public class ClosestPalindrome {

    private static boolean isPalindrome(String s){
        int i = 0;
        int len = s.length();
        while(i < len / 2){
            if(s.charAt(i) != s.charAt(len-i-1)){
                return false;
            }
            i++;
        }
        return true;
    }

    private static int closestPalindrome(String s){
        if(isPalindrome(s)){
            return Integer.valueOf(s);
        }

        int minPalindrome = Integer.valueOf(s) - 1;
        int greaterPalindrome = Integer.valueOf(s) - 1;

        while(!isPalindrome(String.valueOf(minPalindrome))){
            minPalindrome--;
        }

        while(!isPalindrome(String.valueOf(greaterPalindrome))){
            greaterPalindrome++;
        }

        if(Math.abs(Integer.valueOf(s) - minPalindrome) < Math.abs(Integer.valueOf(s) - greaterPalindrome)){
            return minPalindrome;
        } else if(Math.abs(Integer.valueOf(s) - minPalindrome) > Math.abs(Integer.valueOf(s) - greaterPalindrome)){
            return greaterPalindrome;
        }
        return minPalindrome;
    }

    private static void displayArray(Integer[] array){
        for (int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        String ar[] = new String[testCases];
        int i=0;
        while(testCases>0){
            ar[i] = String.valueOf(scanner.nextInt());
            testCases-- ;
        }

        Integer[] output = new Integer[ar.length];
        for(i=0; i<output.length; i++){
            output[i] = closestPalindrome(ar[i]);
        }
         displayArray(output);
    }
}
