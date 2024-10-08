class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        
        res[0] = StartRange(nums,target);
        res[1] = EndRange(nums,target);
        return res;
    }
    private int StartRange(int[] nums,int target)
    {
        int low = 0;
        int high = nums.length-1;
        int index = -1;
        while(low <= high)
        {
        int mid = (low + high) / 2;
        if(nums[mid] == target)
        {
            // it would be some repeated numbers too
            // so fix high as a boundary and and search left....
            index = mid; // because in the nxt step itself we need mid...if mid is returned then the nxt stmt becomes unreachable
            high = mid - 1;
        }
        else if(nums[mid] < target)
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
        }
        return index;
    }
    private int EndRange(int[] nums,int target)
    {
        int low = 0;
        int high = nums.length-1;
        int index = -1;
        while(low <= high)
        {
        int mid = (low + high) / 2;
        if(nums[mid] == target)
        {
            //it would be the last range 
            //hence move the start value (low) to the right
            index =  mid;
            low = mid + 1;
        }
        else if(nums[mid] < target)
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
        }
        return index;  
       
    }
    
}

/*
        int res[] = new int[2];
        for(int i=0;i<2;i++)
        {
            res[i] = -1;
        }
         int k = target;
          for(int i =0;i<nums.length;i++)
       {
           if(nums[i] == k)
           {
               res[0] = i;
               break;
           }
       }
       for(int i =nums.length-1;i>=0;i--)
       {
           if(nums[i] == k)
           {
               res[1] = i;
               break;
           }
       }
        return res;
*/