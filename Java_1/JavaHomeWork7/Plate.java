import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info(){
        System.out.println("Еды в тарелке: " + food);
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int foodCount){
        if (this.food >= foodCount) {
            this.food -= foodCount;
            System.out.println("Кот накормлен!");
            System.out.println("В тарелке осталось" + food);
            System.out.println();
            return true;
        } else {
            System.out.println("В тарелке недостаточно еды");
            System.out.println("Кот остался голодный =(");
            System.out.println();
            return false;
        }
    }
}
