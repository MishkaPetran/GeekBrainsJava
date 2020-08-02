import java.util.Arrays;

public class Calculable implements java.lang.Runnable {
    private float[] array;

    public Calculable(float[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i] =
                    (float)
                            (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Массив после вычислений " + Arrays.toString(array));
    }
}
