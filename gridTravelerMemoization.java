import java.util.HashMap;

public class gridTravelerMemoization {
    public static void main(String[] args) {
        /*
         * Say that you're a traveler on a 2D grid. You begin in the top-left corner and your goal is to
         * travel to the bottom-right corner. You may only move down or right.
         * 
         * In how many ways can you travel to the goal on a grid with dimensions m * n
         * 
         * Write a function 'gridTraveler(m, n)' to calculate this.
         * 
         * EX: gridTraveler(2,3) -> 3 | 3 rows and 2 columns
         * m = rows
         * n = columns
         * 
         * [s][][]
         * [][][e] = 3 (when n = 2 columns, m = 3 rows )
         * right, right, down = 3
         * right, down, right = 3
         * down, right, right = 3
         * 
         * 18x18 = 2333606220
         */
        HashMap<String, Long> memo = new HashMap<>();

        System.out.println(gridTraveler(18, 18, memo));
    }
    public static Long gridTraveler(int m, int n, HashMap<String, Long> memo){
        //Include a , for easier readability to identify the exact m, n argument
        String key = m + "," + n;

        //check if m, n parameters are stored in the map, if they are return the recursive value related to the key
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        //return 0 if grid is 1x1 or one grid dimension is less than 1 i.e, 0
        if(m == 1 || n == 1){
            return (long) 1;
        }

        //just return 0 if m or n is 0
        if(m <= 0 || n <= 0){
            return (long) 0;
        }
        
        //put the string key inside as the key for the map(memo), and the recursion of m-1 and n-1 as the value
        memo.put(key, gridTraveler(m-1, n, memo) + gridTraveler(m, n-1, memo));

        //recurse until the values of m or n meet the conditional criteria above
        return gridTraveler(m-1, n, memo) + gridTraveler(m, n-1, memo);
    }
}
