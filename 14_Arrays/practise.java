public class practise {
    public static int trapped(int[] height){
        int n = height.length;
        //creating left max
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[0], height[i]);
        }
        //creating right max
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for(int j=n-2; j>=0; j--){
            rightMax[j] = Math.max(rightMax[j+1], height[j]);
        }

        //solving
        int trappedwater = 0;
        for(int k=0; k<n; k++){
            int waterlevel = Math.min(leftMax[k], rightMax[k]);
            trappedwater += waterlevel -  height[k];
        }

        return trappedwater;
    }
    public static void main(String args[]){
        int[] height = {4,2,0,6,3,2,5};
        System.out.println("Water level is "+ trapped(height));
    }
}