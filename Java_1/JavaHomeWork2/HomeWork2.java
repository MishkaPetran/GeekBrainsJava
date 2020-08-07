import java.util.Arrays;

public class HomeWork2 {

    public static void main(String[] args) {
//        1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//        С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("Задание №1");
        int[] array = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.println("Массив на входе:");
        printArray(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1){
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        System.out.println("Массив на выходе:");
        printArray(array);
        System.out.println("-----------------------------------");


//        2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("Задание №2");
        int[] array2 = new int[8];
        int j = 0;
        for (int i = 0; i < array2.length; i++) {

            array2[i] = j;
            j += 3;
        }

        System.out.println("Массив на выходе:");
        printArray(array2);
        System.out.println("-----------------------------------");


//        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("Задание №3");
        int[] array3 = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Массив на входе:");
        printArray(array3);

        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6){
                array3[i] *= 2;
            }
        }

        System.out.println("Массив на выходе:");
        printArray(array3);
        System.out.println("-----------------------------------");


//        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с
//        помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("Задание №4");
        int[][] array4 = new int[3][3];

        for (int i = 0; i < array4.length; i++) {
            for (int k = 0; k < array4.length; k++) {
                if (i == k){
                    array4[i][k] = 1;
                } else if (i + k == array4.length - 1){
                    array4[i][k] = 1;
                } else {
                    array4[i][k] = 0;
                }
            }
        }

        System.out.println("Массив на выходе:");
        for (int i = 0; i < array4.length; i++) {
            for (int k = 0; k < array4.length; k++) {
                System.out.print(" " + array4[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");

//        5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);

        System.out.println("Задание №5");
        int[] min_max_array = new int[] {-1, 0, 1, 2, 3, 4, 5};
        int minValue = min_max_array[0];
        int maxValue = min_max_array[0];

        System.out.print("Входящий массив ");
        printArray(min_max_array);

        for (int i = 1; i < min_max_array.length; i++) {
            if (minValue > min_max_array[i]) {
                minValue = min_max_array[i];
            }
        }

        for (int i = 0; i < min_max_array.length; i++) {
            if (maxValue < min_max_array[i]){
                maxValue = min_max_array[i];
            }
        }


        System.out.println("Минимальное значение = " + minValue);
        System.out.println("Максимальное значение = " + maxValue);
        System.out.println("-----------------------------------");

//        6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
//        если в массиве есть место, в котором сумма левой и правой части массива равны.
//        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
//        граница показана символами ||, эти символы в массив не входят.

        System.out.println("Задание №6");
        int[] balance_array = new int[] {2, 2, 2, 1, 2, 2, 10, 1};

        System.out.println("Входящий массив: ");
        printArray(balance_array);

        System.out.println(checkBalance(balance_array));
        System.out.println("-----------------------------------");


//        7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
//        или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
//        Для усложнения задачи нельзя пользоваться вспомогательными массивами.

        System.out.println("Задание №7");

        int n = 10;
        int native_n = n;
        int[] slide_array = new int[] {-5, -4, -3, -2, -1, 1, 2, 3, 4, 5};
        int tempValue = 0;

        if (Math.abs(n) < slide_array.length){ // Для того чтобы не крутить лишний раз элементы массива, отсекаем "целые" круги
            if (n >= 0){
                System.out.println("Сдвиг вправо на " + n);
                for (int i = 0; i < n; i++) {
                    tempValue = slide_array[slide_array.length - 1];
                    for (int k = slide_array.length - 1; k > 0; k--) {
                        slide_array[k] = slide_array[k-1];
                    }
                    slide_array[0] = tempValue;
                }
            } else {
                System.out.println("Сдвиг влево на " + n);
                for (int i = 0; i > n; i--) {
                    tempValue = slide_array[0];
                    for (int k = 0; k < slide_array.length -1; k++) {
                        slide_array[k] = slide_array[k + 1];
                    }
                    slide_array[slide_array.length - 1] = tempValue;
                }
            }
        } else if (Math.abs(n) == slide_array.length){
            if (n >= 0){
                System.out.println("Сдвиг вправо на " + n);
            } else {
                System.out.println("Сдвиг влево на " + n);
            }
        } else {
            n = n - slide_array.length * (n / slide_array.length);
            if (n >= 0){
                System.out.println("Сдвиг вправо на " + native_n);
                for (int i = 0; i < n; i++) {
                    tempValue = slide_array[slide_array.length - 1];
                    for (int k = slide_array.length - 1; k > 0; k--) {
                        slide_array[k] = slide_array[k-1];
                    }
                    slide_array[0] = tempValue;
                }
            } else {
                System.out.println("Сдвиг влево на " + native_n);
                for (int i = 0; i > n; i--) {
                    tempValue = slide_array[0];
                    for (int k = 0; k < slide_array.length -1; k++) {
                        slide_array[k] = slide_array[k + 1];
                    }
                    slide_array[slide_array.length - 1] = tempValue;
                }
            }
        }
        printArray(slide_array);
    }

    public static boolean checkBalance(int[] balance_array){
        int total_amount = balance_array[0];
        int current_sum = balance_array[0];
        for (int i = 1; i < balance_array.length; i++) {
            total_amount += balance_array[i];
        }

        for (int i = 1; i < balance_array.length; i++) {
            if (current_sum == total_amount - current_sum){
                return true;
            } else {
                current_sum += balance_array[i];
            }
        }
            return false;
    }

    public static void printArray (int[] array){
        for (int i = 0; i < array.length; i++) {
            if (i == 0){
                System.out.print("[");
            }
            System.out.print(array[i]);
            if (i == array.length - 1){
                System.out.println("]");
            } else {
                System.out.print(", ");
            }
        }
    }
}
