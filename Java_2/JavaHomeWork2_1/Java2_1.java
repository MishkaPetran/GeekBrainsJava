/*
1.  Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
    Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).

2.  Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
    соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль\
    (успешно пробежал, не смог пробежать и т.д.).

3.  Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.

    * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
    Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
 */

public class Java2_1 {
    public static void main(String[] args) {
        // Создаем препятствия
        Barrier[] barriers = new Barrier[10];
        for (int i = 0; i < barriers.length; i++) {
            if (i % 2 == 0){
                barriers[i] = new Wall((float) (i * 0.5));
            } else {
                barriers[i] = new Track(i);
            }
        }

        // Создаем участников
        Runnable[] team = new Runnable[3];
        team[0] = new Human(10,1);
        team[1] = new Cat(1,2);
        team[2] = new Robot(5,2);



        for (int i = 0; i < team.length; i++) {
            System.out.printf("Преодоление препятсвий начинает [%s] \n", team[i].getRussianClassName());
            for (int j = 0; j < barriers.length; j++) {
                if (barriers[j].getClass().equals(Track.class)){
                    System.out.printf("Нужно пробежать %s метров! \n", ((Track) barriers[j]).getLength());
                    if (team[i].run((Track) barriers[j])){

                    } else {
                        System.out.println("-------------------- Выступление участника закончено! --------------------");
                        System.out.println();
                        break;
                    }
                } else {
                    System.out.printf("Нужно перепрыгнуть стену выстой %s \n", ((Wall) barriers[j]).getHeight());
                    if (((Jumpable) team[i]).jump((Wall) barriers[j])){

                    } else {
                        System.out.println("-------------------- Выступление участника закончено! --------------------");
                        System.out.println();
                        break;
                    }

                }
            }
        }
    }
}
