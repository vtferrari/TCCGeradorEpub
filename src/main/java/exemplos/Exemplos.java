package exemplos;

public class Exemplos {

    public static class Figura1 {

        public static long fibo(int n) {
            int F = 0; // atual 
            int ant = 0; // anterior 
            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    F = 1;
                    ant = 0;
                } else {
                    F += ant;
                    ant = F - ant;
                }
            }
            return F;
        }

    }

    public static class Figura3 {

        static long fibo(int n) {
            if (n < 2) {
                return n;
            } else {
                return fibo(n - 1) + fibo(n - 2);
            }
        }

    }

    public static class Figura5 {

        static void maior(int n) {
            int a = 1, b = 0;

            // uma comparacao
            if (a > b) {
                a++;
                System.out.println("ok");
            }

        }

    }

    public static class Figura6 {

        void media(int n) {
            int array1[] = new int[4];
            int array2[] = new int[4];

            int sum1 = 0;
            int sum2 = 0;
            int average1 = 0;
            int average2 = 0;

            for (int i = 0; i < 4; i++) {
                sum1 += array1[i];
            }
            average1 = sum1 / 4;

            for (int i = 0; i < 4; i++) {
                sum2 += array2[i];
            }
            average2 = sum2 / 4;

        }

    }

    public static class Figura7 {

        public static int media(int[] Array_of_4) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += Array_of_4[i];
            }
            return sum / 4;
        }

        public static void main(String[] args) {
            int array1[] = new int[4];
            int array2[] = new int[4];

            int average1 = media(array1);
            int average2 = media(array2);
        }

    }
    


}
