public class Dog extends Animals {
    private double ClassMaxRunDistance = 500;
    private double ClassMaxSwimDistance = 10;
    private double ClassMaxJumpHeight = 0.5;

    public Dog(double maxRunDistance, double maxSwimDistance, double maxJumpHeight) {
        super(maxRunDistance, maxSwimDistance, maxJumpHeight);
        this.ClassMaxRunDistance = ClassMaxRunDistance;
        this.ClassMaxSwimDistance = ClassMaxSwimDistance;
        this.ClassMaxJumpHeight = ClassMaxJumpHeight;
    }
}
