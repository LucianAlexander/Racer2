public class Queen {

    public static void solve(int n) {
        int[] q = new int[n];
        enumerate(q, q.length, 0);
    }

    public static boolean is_consistent(int[] q, int k) {

        for (int i = 0; i < k; i++) {
            if (q[i] == q[k])             return false;   // stessa colonna
            if ((q[i] - q[k]) == (k - i)) return false;   // stessa diagonale principale
            if ((q[k] - q[i]) == (k - i)) return false;   // stessa diagonale secondaria
        }

        return true;
    }

    public static void printQueens(int[] q, int N) {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                if (q[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");
    }

    public static void enumerate(int[] q, int N, int k) {

        if (k == N)
            printQueens(q, N);

        else {

            for (int i = 0; i < N; i++) {

                q[k] = i;
                if (is_consistent(q, k))
                    enumerate(q, N, k + 1);

            }
        }
    }

}
