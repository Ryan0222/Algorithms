/* MergeSort Time Complexity is O(nlgn) which is differnet from quickSort because every partion it will partition two part. So 
   it is not an average Time Complexity.

   MergeSort needs O(n) extra space to merge the results.
   and it is an in-place sort.
*/


package Sort;

public class MergeSort {

    public void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) return;

        mergeSort(A, start, (start + end) / 2, temp);
        mergeSort(A, (start + end) / 2 + 1, end, temp);
        merge(A, start, end, temp);
    }

    public void merge(int[] A, int start, int end, int[] temp) {
        int middle = (start + end) / 2;
        int leftIndex = start;
        int rightIndex = middle + 1;
        int index = leftIndex;

        while (leftIndex <= middle && rightIndex <= end) {
            if (A[leftIndex] < A[rightIndex]) {
                temp[index++] = A[leftIndex++];
            } else {
                temp[index++] = A[rightIndex++];
            }
        }

        while (leftIndex <= middle) {
            temp[index++] = A[leftIndex++];
        }

        while (rightIndex <= end) {
            temp[index++] = A[rightIndex++];
        }

        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
    }
}