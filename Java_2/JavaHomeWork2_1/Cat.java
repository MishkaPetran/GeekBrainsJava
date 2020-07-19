public class Cat implements Runnable, Jumpable {
    private int endurance;
    private float springAbility;

    public Cat(int endurance, int springAbility) {
        this.endurance = endurance;
        this.springAbility = springAbility;
    }

    public void run(){
        System.out.println("Кот бежит...");
    }

    public void jump(){
        System.out.println("Кот прыгает");
    }

    @Override
    public boolean run(Track track) {
        System.out.printf("Кот [бег: %s] бежит... \n", this.endurance);
        if (track.getLength() <= this.endurance){
            System.out.println("Успешно пробежал!");
            System.out.println();
            return true;
        } else {
            System.out.println("Не смог пробежать");
            System.out.println();
            return false;
        }
    }

    @Override
    public String getRussianClassName() {
        return "Кот";
    }

    @Override
    public boolean jump(Wall wall) {
        System.out.printf("Кот [прыжок %s] прыгает... \n", this.springAbility);
        if (wall.getHeight() <= this.springAbility){
            System.out.println("Успешно перепрыгнул!");
            System.out.println();
            return true;
        } else {
            System.out.println("не смог перепрыгнуть.");
            System.out.println();
            return false;
        }
    }
}
