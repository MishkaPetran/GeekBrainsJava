import java.util.Random;

public class Cat extends Animals {
    private static double ClassMaxRunDistance = 200;
    private static double ClassMaxSwimDistance = 0;
    private static double ClassMaxJumpHeight = 2;

    private static byte catsCount = 2; // Указать количество собак для массого тестирования

    public static void main(String[] args) throws InterruptedException {
        // Для массового тестирования (закомментировать при одиночном тестировании)
        Cat[] cats = new Cat[catsCount];

        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat(
                    getRandomAttributeOrDistance(ClassMaxRunDistance),
                    getRandomAttributeOrDistance(ClassMaxSwimDistance),
                    getRandomAttributeOrDistance(ClassMaxJumpHeight)
            );
        }

        //Прохождение дистанции всей команды
        for (int i = 0; i < cats.length; i++) {
            cats[i].run(getRandomAttributeOrDistance(ClassMaxRunDistance));
            cats[i].swim(getRandomSwimDistance());
            cats[i].jump(getRandomAttributeOrDistance(ClassMaxJumpHeight));
        }


        //Для тестирования одиночной собаки (Закомментировать при массовом тестировании)
//        Cat cat = new Cat(400, 9, 0.4);
//        cat.run(400);
//        cat.swim(10);
//        cat.jump(0.3);

    }

    @Override
    public String toString() {
        return "Cat{" +
                "MaxRunDistance=" + MaxRunDistance +
                ", MaxSwimDistance=" + MaxSwimDistance +
                ", MaxJumpHeight=" + MaxJumpHeight +
                '}';
    }

    public Cat(double maxRunDistance, double maxSwimDistance, double maxJumpHeight) {
        super(maxRunDistance, maxSwimDistance, maxJumpHeight);
    }

    //Случайные характеристики для котов и слуяайные препятсвия
    private static double getRandomAttributeOrDistance(double classMaxAttribute){
        Random random = new Random();
        return random.nextDouble() * classMaxAttribute;
    }

    //Случайная дистанция для плавания
    private static double getRandomSwimDistance(){
        Random random = new Random();
        return random.nextDouble() * 25; // 25 как стандартная длина плпвательной дорожки
    }

}
