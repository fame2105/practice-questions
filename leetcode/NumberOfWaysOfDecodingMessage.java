package leetcode;

/**
 * Created by fame.issrani on 1/18/19.
 */
/*
Suppose the encoding is done in this manner
a-1
b-2
3-c
.
.
.
.
z-26
And you have been given an encoded message, how many ways are there to decode the message.
for ex:  "1224" -> this message could { "abbd" , "lbd", "avd", "lx", "abx"} -> 5 ways*/

//Remaining Task is to optimize the solution using memoization(Dynamic Programming)
public class NumberOfWaysOfDecodingMessage {

    public int numWays(String s) {
//        int[] memo = new int[s.length() +1];
        int result = helper(s, s.length());
        return result;
    }

    private int helper(String s, int k) {

        if (k == 0) {
            return 1;
        }

        int current_char_index = s.length() - k;
        char current_char = s.charAt(current_char_index);

        if(current_char == '0'){
            return 0;
        }

        int result = helper(s, k-1);

        int range = Integer.valueOf(s.substring(current_char_index, current_char_index+1));
        if(k >= 2 && range <= 26){
            result += helper(s, k-2);
        }
        return result;

    }

    public static void main(String[] args) {
              NumberOfWaysOfDecodingMessage obj = new NumberOfWaysOfDecodingMessage();
//        System.out.println('a' == 97);
        System.out.println(obj.numWays("1224"));
    }
}
