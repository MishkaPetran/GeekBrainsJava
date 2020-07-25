import static java.lang.Thread.sleep;

public class Animals {
/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
или высоту (для прыжков).
3. У каждого животного есть ограничения на действия(
бег: кот 200 м., собака 500 м.;
прыжок: кот 2 м., собака 0.5 м.;
плавание: кот не умеет плавать, собака 10 м.).
4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
(Например, dog1.run(150); -> результат: run: true)
5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м.,
у другой 600 м.
 */

    protected double MaxRunDistance;
    protected double MaxSwimDistance;
    protected double MaxJumpHeight;

    //Конструктор класса
    public Animals(double maxRunDistance, double maxSwimDistance, double maxJumpHeight) {
        MaxRunDistance = maxRunDistance;
        MaxSwimDistance = maxSwimDistance;
        MaxJumpHeight = maxJumpHeight;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "MaxRunDistance=" + MaxRunDistance +
                ", MaxSwimDistance=" + MaxSwimDistance +
                ", MaxJumpHeight=" + MaxJumpHeight +
                '}';
    }

    // Методы класса
    public void run(double runDistance) throws InterruptedException {
        String animalType = classIdentify(String.valueOf(this.getClass()));
        System.out.printf("%s (Максимальная дальность бега: %s) готовится пробежать дистанцию %s м.", animalType, this.MaxRunDistance, runDistance);
        sleep(500);
        System.out.print(".");
        sleep(500);
        System.out.print(".");
        sleep(500);
        System.out.println(".");

        if (runDistance <= this.MaxRunDistance){
            System.out.println("Поздравляем! Дистанция успешно преодолена");
            System.out.println("run: " + true);
        } else {
            System.out.println("Животное не справилось с дистанцией");
            System.out.println("run: " + false);
        }

        System.out.println();
    }

    public void swim(double swimDistance) throws InterruptedException {
        String animalType = classIdentify(String.valueOf(this.getClass()));
        if (animalType.equals("Кот") && swimDistance != 0 && this.MaxSwimDistance == 0) {
            System.out.println("К сожалению коты не умеют плавать, дистанция не преодолена");
            System.out.println("swim: " + false);
        } else {
            System.out.printf("%s (Максимальная дальность плавания: %s) готовится проплыть дистанцию %s м.", animalType, this.MaxSwimDistance, swimDistance);
            sleep(500);
            System.out.print(".");
            sleep(500);
            System.out.print(".");
            sleep(500);
            System.out.println(".");

            if (swimDistance <= this.MaxSwimDistance) {
                System.out.println("Поздравляем! Дистанция успешно преодолена");
                System.out.println("swim: " + true);
            } else {
                System.out.println("Животное не справилось с дистанцией");
                System.out.println("swim: " + false);
            }
        }

        System.out.println();
    }

    public void jump(double jumpHeight) throws InterruptedException {
        String animalType = classIdentify(String.valueOf(this.getClass()));
        System.out.printf("%s (Максимальная высота прыжка: %s) готовится преодолеть барьер %s м.", animalType, this.MaxJumpHeight, jumpHeight);
        sleep(500);
        System.out.print(".");
        sleep(500);
        System.out.print(".");
        sleep(500);
        System.out.println(".");

        if (jumpHeight <= this.MaxJumpHeight){
            System.out.println("Поздравляем! Барьер успешно преодолен");
            System.out.println("jump: " + true);
        } else {
            System.out.println("Животное не справилось с барьером");
            System.out.println("jump: " + false);
        }

        System.out.println();
    }

    protected String classIdentify(String className){
        if (className.contains("D")){
            return "Собака";
        } else {
            return "Кот";
        }
    }
}
