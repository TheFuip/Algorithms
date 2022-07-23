import java.util.*;

public class fibMemorization {

    public static void main(String[] args) {
        /*Write a function fib(n) that takes in a number as an argument.
         * The function should return the n'th number of the Fibonacci sequence.
         * 
         * The 1'st and 2n'd number of the sequence is 1.
         * To generate the next number of the sequence, we sum the previous two.
         * 
         * EX: n = [1, 2, 3, 4, 5, 6, 7,  8,  9, ...]
         * fib(n)= [1, 1, 2, 3, 5, 8, 13, 21, 34, ...]
         * 
         * 2^(n) time complexitiy
         * essentially dynamic programming is having a large problem 
         * and breaking it up into smaller instances of the same problem
         */
        HashMap<Integer, Long> map = new HashMap<>();

    
        System.out.println(fib(50, map));
        //System.out.println(iterativeFibn(7));
    }
    //recursive solution: however will take a long time to run a large value of n
    /*
     *
     public static int fib(int n){
        //if n <= 2 just return 1 since thats always the answer, otherwise add up the previous of value of n
        return n <= 2 ? 1 : fib(n-1) + fib(n-2);
    } 
     */
    
    //memoization: used to store duplicate sub-problems
    //use hashmap: keys will be the argument to functions (aka n), and value will be return value

 
    public static Long fib(int n, HashMap<Integer, Long> memo){
        //first check if the map already contains n if it does, return the val for the key of n
        if(memo.containsKey(n)){
            return memo.get(n);
        }

        //if the value of n is less than or equal to 2, just return 1
        if(n <= 2){
            return (long) 1;
        }

        //store n as the key, and the recursive fib answer as the value
       memo.put(n, fib(n-1, memo) + fib(n-2, memo));

       //iterate through the previous values until n<=2 or the map(memo) contains the answer to n
       return fib(n - 1, memo) + fib(n-2, memo);
    }
}