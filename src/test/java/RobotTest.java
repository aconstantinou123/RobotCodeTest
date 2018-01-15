import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class RobotTest {

    Robot robot1;
    Robot robot2;
    Robot robot3;
    Robot robot4;
    Robot robot5;
    Robot robot6;
    Robot robot7;
    Robot robot8;
    ArrayList<Robot> robots;

    @Before
    public void before(){

        robots = new ArrayList<>();
        robot1 = new Robot(0, 0, "N");
        robot2 = new Robot(0, 0, "E");
        robot3 = new Robot(0, 0, "S");
        robot4 = new Robot(0, 0, "W");
        robot5 = new Robot(3, 2, "N");
        robot6 = new Robot(0, 3, "W");
        robot7 = new Robot(1, 1, "E");
        robot8 = new Robot(3, 3, "E");
        robots.add(robot5);
        robots.add(robot6);
        robots.add(robot7);

    }

    @Test
    public void getX(){
        assertEquals(0, robot1.getX());
    }

    @Test
    public void canAddX(){
        robot1.addX();
        assertEquals(1, robot1.getX());
    }

    @Test
    public void canminusX(){
        robot1.minusX();
        assertEquals(-1, robot1.getX());
    }


    @Test
    public void getCoordinate(){
        assertEquals("N", robot1.getOrientation());
    }

    @Test
    public void forwardR1(){
        robot1.forward();
        assertEquals(1, robot1.getY());
        assertEquals(0, robot1.getX());
        robot1.forward();
        assertEquals(2, robot1.getY());
        assertEquals(0, robot1.getX());
    }

    @Test
    public void forwardR2(){
        robot2.forward();
        assertEquals(1, robot2.getX());
        assertEquals(0, robot2.getY());
    }

    @Test
    public void forwardR3(){
        robot3.forward();
        assertEquals(0, robot3.getX());
        assertEquals(-1, robot3.getY());
    }

    @Test
    public void forwardR4(){
        robot4.forward();
        assertEquals(-1, robot4.getX());
        assertEquals(0, robot4.getY());
    }

    @Test
    public void changeDirectionRight(){
        robot1.turnRight();
        assertEquals("E", robot1.getOrientation());
        robot2.turnRight();
        assertEquals("S", robot2.getOrientation());
        robot3.turnRight();
        assertEquals("W", robot3.getOrientation());
        robot4.turnRight();
        assertEquals("N", robot4.getOrientation());
        robot1.turnRight();
        assertEquals("S", robot1.getOrientation());
    }

    @Test
    public void changeDirectionLeft(){
        robot1.turnLeft();
        assertEquals("W", robot1.getOrientation());
        robot2.turnLeft();
        assertEquals("N", robot2.getOrientation());
        robot3.turnLeft();
        assertEquals("E", robot3.getOrientation());
        robot4.turnLeft();
        assertEquals("S", robot4.getOrientation());
        robot1.turnLeft();
        assertEquals("S", robot1.getOrientation());
    }

    @Test
    public void canGetPosition(){
        assertEquals("0 0 N ", robot1.getPosition());
        robot1.turnRight();
        robot1.forward();
        robot1.forward();
        robot1.turnLeft();
        robot1.forward();
        assertEquals("2 1 N ", robot1.getPosition());
    }

    @Test
    public void canInstructRobot(){
        assertEquals("0 0 N ", robot1.getPosition());
        ArrayList<String> instructions = new ArrayList<>();
        instructions.add("R");
        instructions.add("F");
        instructions.add("F");
        instructions.add("L");
        instructions.add("F");
        assertEquals("2 1 N ", robot1.robotInstruction(instructions, robots));
    }

    @Test
    public void canInstructRobot2(){
        assertEquals("3 2 N ", robot5.getPosition());
        ArrayList<String> instructions = new ArrayList<>();
        instructions.add("F");
        instructions.add("R");
        instructions.add("R");
        instructions.add("F");
        instructions.add("L");
        instructions.add("L");
        instructions.add("F");
        instructions.add("F");
        instructions.add("R");
        instructions.add("R");
        instructions.add("F");
        instructions.add("L");
        instructions.add("L");
        assertEquals("3 3 N LOST", robot5.robotInstruction(instructions, robots));

    }

    @Test
    public void canInstructRobot3(){
        assertEquals("3 2 N ", robot5.getPosition());
        ArrayList<String> instructions = new ArrayList<>();
        instructions.add("F");
        instructions.add("R");
        instructions.add("R");
        instructions.add("F");
        instructions.add("L");
        instructions.add("L");
        instructions.add("F");
        instructions.add("F");
        instructions.add("R");
        instructions.add("R");
        instructions.add("F");
        instructions.add("L");
        instructions.add("L");
        assertEquals("3 3 N LOST", robot5.robotInstruction(instructions, robots));
        assertEquals("0 3 W ", robot6.getPosition());
        ArrayList<String> instructions1 = new ArrayList<>();
        instructions1.add("L");
        instructions1.add("L");
        instructions1.add("F");
        instructions1.add("F");
        instructions1.add("F");
        instructions1.add("L");
        instructions1.add("F");
        instructions1.add("L");
        instructions1.add("F");
        instructions1.add("L");
        assertEquals("2 3 S ", robot6.robotInstruction(instructions1, robots));

//        LLFFFLFLFL
    }

    @Test
    public void canInstructRobot4(){
        assertEquals("1 1 E ", robot7.getPosition());
        ArrayList<String> instructions = new ArrayList<>();
        instructions.add("R");
        instructions.add("F");
        instructions.add("R");
        instructions.add("F");
        instructions.add("R");
        instructions.add("F");
        instructions.add("R");
        instructions.add("F");
        assertEquals("1 1 E ", robot7.getPosition());
    }

    @Test
    public void canInstructRobot5(){
        assertEquals("1 1 E ", robot7.getPosition());
        ArrayList<String> instructions = new ArrayList<>();
        instructions.add("R");
        instructions.add("F");
        instructions.add("R");
        instructions.add("F");
        instructions.add("R");
        instructions.add("F");
        instructions.add("R");
        instructions.add("F");
        instructions.add("L");
        instructions.add("L");
        instructions.add("F");
        instructions.add("F");
        instructions.add("R");
        instructions.add("R");
        instructions.add("F");
        instructions.add("L");
        instructions.add("R");
        instructions.add("F");
        instructions.add("R");
        instructions.add("F");
        instructions.add("L");
        instructions.add("L");
        instructions.add("F");
        instructions.add("F");
        instructions.add("R");
        instructions.add("R");
        instructions.add("F");
        instructions.add("L");
        assertEquals("0 1 W LOST", robot7.robotInstruction(instructions, robots));
    }


}
