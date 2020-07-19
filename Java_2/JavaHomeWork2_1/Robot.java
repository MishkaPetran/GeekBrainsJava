public class Robot implements Runnable, Jumpable {
    private int endurance;
    private float springAbility;

    public Robot(int endurance, int springAbility) {
        this.endurance = endurance;
        this.springAbility = springAbility;
    }

    public void run(){
        System.out.println("Робот бежит...");
    }

    public void jump(){
        System.out.println("Робот прыгает...");
    }

    @Override
    public boolean run(Track track) {
        System.out.printf("Робот [бег: %s] бежит... \n", this.endurance);
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
        return "Робот";
    }

    @Override
    public boolean jump(Wall wall) {
        System.out.printf("Робот [прыжок %s] прыгает... \n", this.springAbility);
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
