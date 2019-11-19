/* QuickSort: 3 keys:
    1. while (left <= right) if we use left < right, it will appear some situations that will stack overflow, 
       because two partition parts will have some intersect part.
    2. A[left] < pivot not <= ; because if there is an array that 1, 1, 1, 1, 1 ... it will cause a partion that 
       only one part has elements which is a bad partition.
    3. Use pivot to represent value not the index.

    QuickSort Time Complexity is O(nlgn), that is an average time because in the worst situation, it will cost O(n2) Time complexity
              Space Complexity O(1) dont need extra space, but it is not a in-place sort.
    */


package Sort;

public class QuickSort {
    public void quickSort(int[] A, int start, int end) {
        if (start >= end) return;
        int left = start, right = end;
        int pivot = A[(start + end) / 2];

        while (left <= right) {

            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}
