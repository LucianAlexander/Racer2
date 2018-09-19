public class MaxGap {

    public static int maxGap(int[] array, int start, int end) {

        if (start < 0 || start > end || array == null)
            throw new RuntimeException("Invalid start, end, or array.");

        int size = end - start;

        if (size < 2)
            return -1;

        if (size == 2) {
            return array[start + 1] - array[start];
        }

        int pivot = start + (size / 2) + (size % 2 == 0 ? 0 : 1);

        int max_gap_right = maxGap(array, start, pivot);
        int max_gap_middle = array[pivot] - array[pivot - 1];
        int max_gap_left = maxGap(array, pivot, end);

        int max_gap = max_gap_right > max_gap_middle ? max_gap_right : max_gap_middle;
        max_gap = max_gap > max_gap_left ? max_gap : max_gap_left;

        return max_gap;
    }

}
---------------------------------------------------------
public class MaxGap {

    public static int maxGap(int[] array, int start, int end) {

        if (start < 0 || start > end || array == null)
            throw new RuntimeException("Invalid start, end, or array.");

        int size = end - start;

        if (size < 2)
            return -1;

        if (size == 2) {
            return array[start + 1] - array[start];
        }

        int pivot = start + (size / 2);

        int max_gap_left = maxGap(array, start, pivot+1);
        int max_gap_right = maxGap(array, pivot, end);


        return max_gap_right > max_gap_left ? max_gap_right : max_gap_left;

    }

}
