import java.util.ArrayList;

public class Robot {

    private int x;
    private int y;
    private String orientation;
    private String status;

    public Robot(int x, int y, String orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.status = "";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void addX(){
        this.x += 1;
    }

    public void minusX(){
        this.x -= 1;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addY(){
        this.y += 1;
    }

    public void minusY(){
        this.y -= 1;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void forward(){
        if (orientation.equals("N")){
            addY();
        }
        else if (orientation.equals("E")){
            addX();
        }
        else if (orientation.equals("S")){
            minusY();
        }
        else if (orientation.equals("W")){
            minusX();
        }
    }

    public void turnRight(){
        if (orientation.equals("N")){
            setOrientation("E");
        }
        else if (orientation.equals("E")){
            setOrientation("S");
        }
        else if (orientation.equals("S")){
            setOrientation("W");
        }
        else if (orientation.equals("W")){
            setOrientation("N");
        }
    }

    public void turnLeft(){
        if (orientation.equals("N")){
            setOrientation("W");
        }
        else if (orientation.equals("W")){
            setOrientation("S");
        }
        else if (orientation.equals("S")){
            setOrientation("E");
        }
        else if (orientation.equals("E")){
            setOrientation("N");
        }
    }

    public String getPosition(){
        return getX() + " " + getY() + " " + getOrientation() + " " + getStatus();
    }

    public String robotInstruction(ArrayList<String> instructions, ArrayList<Robot> robots){
        for (String instruction : instructions){
            int prevX = this.x;
            int prevY = this.y;
            if (instruction.equals("F")){
                this.forward();
            }
            else if (instruction.equals("L")){
                this.turnLeft();
            }
            else if (instruction.equals("R")){
                this.turnRight();
            }
            if (positionMatchLostRobot(robots) == true){
                setX(prevX);
                setY(prevY);
            }
            if (robotLost() == true) {
                return prevX + " " + prevY + " " + getOrientation() + " " + getStatus();
            }
        }

        return getPosition();
    }

    public boolean robotLost(){
        if (getX() > 5 || getX() < 0 || getY() > 3 || getY() < 0){
            setStatus("LOST");
            return true;
        }
        return false;
    }

    public boolean positionMatchLostRobot(ArrayList<Robot> robots){
        for (Robot robot : robots){
            if (getX() == robot.getX() && getY() == robot.getY() && robot.getStatus().equals("LOST")){
                return true;
            }
        }
        return false;
    }
}
