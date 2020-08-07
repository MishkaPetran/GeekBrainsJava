import sun.awt.windows.ThemeReader;

import java.util.Arrays;

public class CalculateArray {
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    public CalculateArray() {
        Arrays.fill(arr, 1);
    }

    public void executeSync() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Выполнение [1]: " + endTime);
    }

    public void executeAsync() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        float[] array1 = new float[h];
        float[] array2 = new float[h];

        System.arraycopy(arr, 0, array1, 0, h);
        System.arraycopy(arr, h, array2, 0, h);

        Thread t1 =  new Thread(new java.lang.Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < array1.length; i++) {
                    array1[i] = (float)(array1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread t2 = new Thread(new java.lang.Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < array2.length; i++) {
                    array2[i] = (float)(array2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        System.arraycopy(array1, 0, arr, 0, h);
        System.arraycopy(array2, 0, arr, h, h);

        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Выполнение [2]: " + endTime);
    }
}
