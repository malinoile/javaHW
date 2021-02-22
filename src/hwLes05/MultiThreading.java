package hwLes05;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading {

    private static final int size = 10000000;
    private static final int h = size / 2;

    public static void main(String args[]) {
        workArray();
        workArrayWithTwoThread();
    }

    public static void workArray() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for(int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Первый метод справляется за " + (System.currentTimeMillis() - a) + " мс");
    }

    public static void workArrayWithTwoThread() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        float[] arrayPartOne = new float[h];
        float[] arrayPartTwo = new float[h];
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arrayPartOne, 0, h);
        System.arraycopy(arr, h, arrayPartTwo, 0, h);

        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < h; i++) {
                arrayPartOne[i] = (float)( arrayPartOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < h; i++) {
                arrayPartTwo[i] = (float)( arrayPartTwo[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        thread1.start();
        thread2.start();

        System.arraycopy(arrayPartOne, 0, arr, 0, h);
        System.arraycopy(arrayPartTwo, 0, arr, h, h);

        System.out.println("Второй метод справляется за " + (System.currentTimeMillis() - a) + " мс");
    }

}
