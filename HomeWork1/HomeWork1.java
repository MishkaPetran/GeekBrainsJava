public class HomeWork1 {

    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {
        //2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        short s_h_o_r_t = 1;
        int i = 1;
        long l_o_n_g = 10L;
        byte b_y_t_e = 1;

        boolean is_true = true;

        char c_h_a_r = 'a';

        float f = 12.34f;
        double d_o_u_b_l_e = 123.4D;

//        3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные
//        параметры этого метода;
        int a = 40;
        int b = 30;
        int c = 20;
        int d = 10;
        System.out.println("Задание №3");
        expression(a, b, c, d);
        System.out.println("-----------");
        System.out.println();

//        4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до
//        20(включительно), если да – вернуть true, в противном случае – false;
        int x1 = 10;
        int x2 = 2;
        System.out.println("Задание №4");
        System.out.println(compare(x1, x2));
        System.out.println("-----------");
        System.out.println();

//        5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
//        положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.

        int n1 = 10;
        System.out.println("Задание №5");
        positive_or_not(n1);
        System.out.println("-----------");
        System.out.println();

//        6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true,
//        если число отрицательное;

        int n2 = -10;
        System.out.println("Задание №6");
        System.out.println(negative(n2));
        System.out.println("-----------");
        System.out.println();

//        7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести
//        в консоль сообщение «Привет, указанное_имя!»;

        String name = "Миша";
        System.out.println("Задание №7");
        say_hello(name);
        System.out.println("-----------");
        System.out.println();

//        8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
//        Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

        int year = 800;
        System.out.println("Задание №8*");
        leap_year(year);
        System.out.println("-----------");

    }

    public static void expression(int a, int b, int c, int d){
        if (d != 0){
            System.out.println(a * (b + (c /d)));
        } else {
            System.out.println("На ноль делить нельзя!");
        }
    }

    public  static boolean compare(int x1, int x2){
        if (10 < (x1 + x2) && 20 >= (x1 + x2)){
            return true;
        } else {
            return false;
        }
    }

    public static void positive_or_not(int n){
        if (n >=0){
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean negative(int n){
        if (n < 0){
            return true;
        } else {
            return false;
        }
    }

    public static void say_hello(String name){
        System.out.println("Привет, " + name + "!");
    }

    public static void leap_year(int year){
        if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)){
            System.out.println("Високосный");
        } else {
            System.out.println("Не високосный");
        }
    }
}
