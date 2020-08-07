public class Java1_7_Cat {
    private String name;
    private int appetite;
    private boolean full = false;

    public Java1_7_Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.full = false;
    }

    public void eat(Plate plate){
        System.out.println(this.toString() + " пытается поесть...");
        if (plate.decreaseFood(appetite)){
            this.full = true;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", full=" + full +
                '}';
    }

}
