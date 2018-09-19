public class Permutation {

    public static void permute(int[] array, int i, int len) {

        if (len == i){
            printArray(array, len);
            return;
        }

        for (int j = i; j < len; j++) {
            swap(array, i, j);
            permute(array, i + 1, len);
            swap(array, i, j);
        }
    }

    public static void permute(int[] array, int len) {
        permute(array, 0, len);
    }

    public static void printArray(int[] array, int len) {
        System.out.print("[ ");
        for (int i = 0; i < len; i++)
            System.out.print(array[i] + ", ");
        System.out.println("]");
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
