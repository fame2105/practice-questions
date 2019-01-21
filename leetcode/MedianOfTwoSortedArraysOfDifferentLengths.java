package leetcode;
/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Solution
 * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
 * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
 * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
 * <p>
 * Time complexity is O(log(min(x,y))
 * Space complexity is O(1)
 * <p>
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/4
 */

/**
 * Created by fame.issrani on 1/16/19.
 */
public class MedianOfTwoSortedArraysOfDifferentLengths {

    public double medianOfTwoSortedArrays(int[] ar1, int[] ar2) {
        //this step is so that we apply binary search on the smaller array.
        if (ar1.length > ar2.length) {
            medianOfTwoSortedArrays(ar2, ar1);
        }
        int length1 = ar1.length; // this is the array of shorter length
        int length2 = ar2.length;
        int low = 0, high = length1;
        while (low <= high) {
            int partX = (low + high) / 2;
            int partY = (length1 + length2 + 1) / 2 - partX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partX == 0) ? Integer.MIN_VALUE : ar1[partX - 1];
            int maxLeftY = (partY == 0) ? Integer.MIN_VALUE : ar2[partY - 1];

            int minRightX = (partX == 0) ? Integer.MAX_VALUE : ar1[partX];
            int minRightY = (partY == 0) ? Integer.MAX_VALUE : ar2[partY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((length1 + length2) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            }
            if (maxLeftX > minRightY) {  //we are too far on right side for partitionX. Go on left side.
                high = partX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partX + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};

        MedianOfTwoSortedArraysOfDifferentLengths mm = new MedianOfTwoSortedArraysOfDifferentLengths();

        System.out.println(mm.medianOfTwoSortedArrays(x, y));
    }
}
