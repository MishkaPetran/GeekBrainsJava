import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {
//        1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать
//        это число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное,
//        или меньше.
//        После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

        System.out.println("Программа загадала случайное число от 0 до 9.");
        System.out.println("У вас есть 3 попытки чтобы его отгадать.");
        System.out.println("Пользуйтесь подказками, удачи!");

        int random_number;
        Scanner scanner1 = new Scanner(System.in);
        int answer;
        boolean lets_go = true;


        while (lets_go){
            boolean victory = false;
            random_number = getRandomNumber();
            for (int i = 3; i > 0; i--) {
                System.out.println();
                System.out.println("Введите число");
                answer = scanner1.nextInt();
                if (answer > random_number) {
                    System.out.println("Загаданное число меньше");
                } else if (answer < random_number){
                    System.out.println("Загаданное число больше");
                } else {
                    victory = true;
                    break;
                }
            }

            if (victory){
                System.out.println("Поздравляем, Вы угадали!");
            } else {
                System.out.println("Ваши попытки закончились. К сожалению, Вы проиграли.");
            }

            lets_go = retry();
        }


/*
2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
"carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
"pear", "pepper", "pineapple", "pumpkin", "potato"};

При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно, можно пользоваться:
String str = "apple";
str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово
Используем только маленькие буквы
 */

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        System.out.println("Загадано слово. Попробуйте отгадать его целиком.");
        String secret_word = getRandomFromArray(words);

        //Для проверки
//        System.out.println("Слово " + secret_word);

        Scanner scanner2 = new Scanner(System.in);

        boolean win = false;

        while (!win){
            String player_word = scanner2.nextLine();

            if (secret_word.equals(player_word)){
                System.out.println("Поздравляем, вы угадали");
                win = true;
                continue;
            } else {
                for (int i = 0; i < minLetters(secret_word, player_word); i++) {
                    if (secret_word.charAt(i) == player_word.charAt(i)){
                        System.out.print(secret_word.charAt(i));
                    } else {
                        System.out.print("#");
                    }
                }
            }
            for (int i = 0; i < 15 - secret_word.length(); i++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }

    public static int getRandomNumber(){
        Random random = new Random();
        return random.nextInt(9);
    }

    public static boolean retry(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Повторить игру еще раз? 1 - да/ 0 - нет");
        int retry_answer;
        while (true){
            retry_answer = scanner.nextInt();
            if (retry_answer == 1){
                return true;
            } else if (retry_answer == 0){
                return false;
            } else {
                System.out.println("Введенное число отличается от 0 и 1");
            }
        }
    }

    //Выбираем случайное слово из массива
    public static String getRandomFromArray(String[] array){
        Random random = new Random();
        int index = random.nextInt(array.length);
        String word = array[index];
        return word;
    }

    //Чтобы не выйти за пределы максимума букв в слове, проверяем в каком слове букв меньше
    public static int minLetters(String word, String word2){
        if (word.length() >= word2.length()){
            return word2.length();
        } else {
            return word.length();
        }
    }
}
