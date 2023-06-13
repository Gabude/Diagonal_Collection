package Online_Space.Apt.Diagonal_Collection;

import Online_Space.Apt.TrappingRainWater_2;

public class Main {
    public static void main(String[] args)
    {
        int[][] heights = {{1,4,3,1,3,2},{3,2,1,3,2,4}, {2,3,3,2,3,1}};

        Solution obj = new Solution();
        System.out.print("The maximum amount of water that can be trapped is " +
                obj.trapRainWater(heights));
    }
}
