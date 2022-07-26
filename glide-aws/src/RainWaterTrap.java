//TC: O(n)
//Sc: O(n) space  where n is teh length of teh input arary.
public class RainWaterTrap {
//	
//	Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//
//	The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
//
//	Example:
//
//	Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//	Output: 6
	
	 //kep ierating take teh height of 2 pilalrs and get min height 
    //and substract it with current pillar
    //caklculate left max in seperate array
    //calculate right max in seperate array
    //create another array and get min height of both pillars and see if given hight in actual array is less than minheight then w = minHeight
   // 1.calcualte left max--> [0,0,1,1,1,2,2,2,2,2,3,3,3]
    //    2.calculate right max -->[3,3,3,3,3,3,3,2,2,2,1,0]
  //  tehn check min height of both ararys and also that index what is actual height if height is less tahn min height then water trapped is minHeight - pillarheightat that index else water trapped is zero.
    public int trap(int[] heights) {
        //calculate the left max
        
       int[] maxes = new int[heights.length];
        int leftMax=0;
        for(int i=0; i <heights.length; i++){
            
            int height = heights[i];
            maxes[i] = leftMax;
            leftMax= Math.max(leftMax , height);
        }
        
        int rightMax=0;
        int total=0;
        for(int i=heights.length-1; i >=0; i--){
            
            int height = heights[i];
            int minHeight = Math.min(rightMax , maxes[i]);
            
            if(height < minHeight){
                maxes[i] = minHeight - height;
                total+=maxes[i];
            }
            else{
                maxes[i]=0;
            }
          
            rightMax= Math.max(rightMax , height);
        }
        
         return total;
    }
    
    
 public int trapOptimal(int[] height) {
        
        if(height.length == 0)
            return 0;
        
        int left = 0;
        int right = height.length-1;
        int leftMax = height[left];
        int rightMax = height[right];
        int total=0;
        
        while(left < right){
           leftMax = Math.max(leftMax , height[left]);
            rightMax = Math.max(rightMax , height[right]);
              int res = Math.min(leftMax, rightMax);
            
            if(leftMax < rightMax){
                
              if(height[left] < res)
                  total+=res-height[left];
                left++;
            }
            else{
                if(height[right] < res)
                    total+=res-height[right];
                right--;
            }
        }
        
        return total;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
