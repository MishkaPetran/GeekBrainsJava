/*
1. Расширить задачу про котов и тарелки с едой
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
 */

import java.util.Random;

public class Main {
    private static int catsCount = 10; // Сколько котов будет создано
    private static int maxApetite = 30; // Максимальный апптетит
    private static int amountofFood = 75; // Сколько еды положим в тарелку

    public static void main(String[] args) {
        Cat cat = new Cat("Барсик", 10);
        Plate plate = new Plate(amountofFood);

        Cat[] cats = new Cat[catsCount];


//        catIni(cats); // Автоматическое кормление случайных котов (закомментировать в случае ручного кормления)


        // Ручное кормление котов (закомментировать в случае автоматического кормления)
        cats[0] = new Cat("Ешка", 10);
        cats[1] = new Cat("Барсик", 10);
        cats[2] = new Cat("Кузя", 10);
        cats[3] = new Cat("Том", 10);
        cats[4] = new Cat("Яшка", 10);
        cats[5] = new Cat("Саймон", 10);
        cats[6] = new Cat("Томас", 10);
        cats[7] = new Cat("Макс", 10);
        cats[8] = new Cat("Кот", 10);
        cats[9] = new Cat("Ежкинкот", 2);
        // Конец ручного кормления


        eatTime(cats, plate);
        catsStatus(cats);
    }

    // Создаем котов
    public static void catIni(Cat[] cats){
        for (int i = 0; i < catsCount; i++) {
            cats[i] = new Cat(catName(), catAppetite());
        }
    }

    // Выбираем рандомное имя для кота
    public static String catName(){
        String[] catNames = {"Ешка", "Барсик", "Кузя", "Том", "Яшка", "Саймон", "Томас", "Макс"};
        Random random = new Random();
        return catNames[random.nextInt(catNames.length)];
    }

    // Генерируем аппетит кота с учетом максимального
    public static int catAppetite(){
        Random random = new Random();
        return random.nextInt(maxApetite);
    }

    // Кормим котов
    public static void eatTime(Cat[] cats, Plate plate){
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }
    }

    public static void catsStatus(Cat[] cats){
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i].toString());
        }
    }
}
