import java.util.Arrays;

public class Java2_5 {
    public static void main(String[] args) {
        final int size = 100;

        first(size);
        System.out.println();
        second(size);

    }
// Для проверки на малых числах уменьшить size, раскомменитровать строки с sout
    static void first(int size){
        float[] firstArray = new float[size];
        long startTime;

        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = 1.0F;
        }

        startTime = System.currentTimeMillis();
//        System.out.println("[1]Массив на входе" + Arrays.toString(firstArray));
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] =
                    (float)
                    (firstArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

//        System.out.println("[1]Время на перезапись по формуле: " + Long.valueOf(System.currentTimeMillis() - startTime));
//        System.out.println("Массив после вычислений: " + Arrays.toString(firstArray));
    }

    static void second(int size){
        float[] baseArray = new float[size];
        int halfSize = size / 2;
        float[] firstArray = new float[halfSize];
        float[] secondArray = new float[halfSize];
        long startTime;

        for (int i = 0; i < baseArray.length; i++) {
            baseArray[i] = 1.0F;
        }

        startTime = System.currentTimeMillis();
//        System.out.println("[2]Массив на входе: " + Arrays.toString(baseArray));
        System.arraycopy(baseArray, 0, firstArray, 0, halfSize);
        System.arraycopy(baseArray, halfSize, secondArray, 0, halfSize);

//        System.out.println("[2]Массив (1) на входе: " + Arrays.toString(firstArray));
//        System.out.println("[2]Массив (2) на входе " + Arrays.toString(secondArray));

        Thread th1 = new Thread(new Calculable(firstArray));
        Thread th2 = new Thread(new Calculable(secondArray));
        th1.start();
        th2.start();

        while (th1.isAlive() && th2.isAlive()){
        }

        System.arraycopy(firstArray, 0, baseArray,0, halfSize);
        System.arraycopy(secondArray, 0, baseArray, halfSize, halfSize);

//        System.out.println("[2]Время на перезапись по формуле: " + Long.valueOf(System.currentTimeMillis() - startTime));
//        System.out.println("[2]Массив на выходе: " + Arrays.toString(baseArray));
    }
}
