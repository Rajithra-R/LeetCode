class Solution {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int arr[] = {-1,-1,-1};  // initiallizing indices for a,b,c
        for(int i=0;i<s.length();i++)
        {
            // if u encounter a char update its value in arr to its respective index
            // if b encounters then 'b' - '0' = 2 => arr[2] = 0 (0 - index)
            arr[s.charAt(i) - 'a'] = i; // a-a = 0; b-a = 1; c-a = 2
            // check for validity ...
            // it is valid if all the num in the arr are not equal to -1 
            if(arr[0] != -1 && arr[1] != -1 && arr[2] != -1) // valid and hence update res
            {
                // res is res + minimal value of 3 indices
                res +=(1+ Math.min(Math.min(arr[0],arr[1]),arr[2]));
            }
        }
        return res;
    }
}