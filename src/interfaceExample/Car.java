package interfaceExample;

public class Car implements Vehicle{
    private String type;
    private String color;
    private String speed;

    public Car(String type, String color, String speed) {
        this.type = type;
        this.color = color;
        this.speed = speed;
    }


    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getSpeed() {
        return speed;
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
