import java.util.Random;

public class Dog extends Animals {
    private static double ClassMaxRunDistance = 500;
    private static double ClassMaxSwimDistance = 10;
    private static double ClassMaxJumpHeight = 0.5;

    private static byte dogCount = 2; // Указать количество собак для массого тестирования

    public static void main(String[] args) throws InterruptedException {
        // Для массового тестирования (закомментировать при одиночном тестировании)
        Dog[] dogs = new Dog[dogCount];

        for (int i = 0; i < dogs.length; i++) {
            dogs[i] = new Dog(
                    getRandomAttributeOrDistance(ClassMaxRunDistance),
                    getRandomAttributeOrDistance(ClassMaxSwimDistance),
                    getRandomAttributeOrDistance(ClassMaxJumpHeight)
            );
        }

        //Прохождение дистанции всей команды
        for (int i = 0; i < dogs.length; i++) {
            dogs[i].run(getRandomAttributeOrDistance(ClassMaxRunDistance));
            dogs[i].swim(getRandomAttributeOrDistance(ClassMaxSwimDistance));
            dogs[i].jump(getRandomAttributeOrDistance(ClassMaxSwimDistance));
        }


        //Для тестирования одиночной собаки (Закомментировать при массовом тестировании)
//        Dog dog = new Dog(400, 9, 0.4);
//        dog.run(400);
//        dog.swim(10);
//        dog.jump(0.3);

    }

    @Override
    public String toString() {
        return "Dog{" +
                "MaxRunDistance=" + MaxRunDistance +
                ", MaxSwimDistance=" + MaxSwimDistance +
                ", MaxJumpHeight=" + MaxJumpHeight +
                '}';
    }

    public Dog(double maxRunDistance, double maxSwimDistance, double maxJumpHeight) {
        super(maxRunDistance, maxSwimDistance, maxJumpHeight);
    }

    //Случайные характеристики для собак и слуяайные препятсвия
    private static double getRandomAttributeOrDistance(double classMaxAttribute){
        Random random = new Random();
        return random.nextDouble() * classMaxAttribute;
    }

}
