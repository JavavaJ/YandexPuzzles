package robot;

import lombok.SneakyThrows;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static int KEY_WAIT_INTERVAL = 40;
    private final static int LONG_WAIT = 500;


    public static void main(String[] args) {
        Main obj = new Main();
        obj.run();
    }

    @SneakyThrows
    public void run() {
        Robot robot = new Robot();
        Map<Character, Integer> char2key = initKeyMap();

        robot.setAutoDelay(KEY_WAIT_INTERVAL);
        robot.setAutoWaitForIdle(true);

        int times = 170;
        saveManyTabs(robot, char2key, times);
    }

    private void saveManyTabs(Robot robot, Map<Character, Integer> char2key, int times) {
        for (int i = 0; i < times; i++) {
            saveOneTab(robot, char2key);
        }
    }


    private void saveOneTab(Robot robot, Map<Character, Integer> char2key) {
        // press cmd + s
        robot.delay(LONG_WAIT);
        pressSave(robot);

        // wait for 4 sec
        // input UUID
        inputId(robot, char2key);
        // press enter
        pressEnter(robot);
        longWait(robot);

        // press closeTab
        pressCloseTab(robot);
    }

    private void inputId(Robot robot, Map<Character, Integer> char2key) {
        int random = getRandom();
        typeNumber(random, robot, char2key);
    }

    private void longWait(Robot robot) {
        robot.delay(LONG_WAIT);
    }

    public void pressSave(Robot robot) {
        robot.delay(KEY_WAIT_INTERVAL);
        robot.keyPress(KeyEvent.VK_META);
        robot.delay(KEY_WAIT_INTERVAL);

        robot.keyPress(KeyEvent.VK_S);
        robot.delay(KEY_WAIT_INTERVAL);
        robot.keyRelease(KeyEvent.VK_S);
        robot.delay(KEY_WAIT_INTERVAL);

        robot.keyRelease(KeyEvent.VK_META);
        robot.delay(KEY_WAIT_INTERVAL);

        System.out.println("Pressed save!");
        longWait(robot);
        longWait(robot);
    }

    public void pressCloseTab(Robot robot) {
        robot.delay(KEY_WAIT_INTERVAL);
        robot.keyPress(KeyEvent.VK_META);
        robot.delay(KEY_WAIT_INTERVAL);

        robot.keyPress(KeyEvent.VK_W);
        robot.delay(KEY_WAIT_INTERVAL);
        robot.keyRelease(KeyEvent.VK_W);
        robot.delay(KEY_WAIT_INTERVAL);

        robot.keyRelease(KeyEvent.VK_META);
        robot.delay(KEY_WAIT_INTERVAL);

        System.out.println("Close tab save!");
        longWait(robot);
        longWait(robot);
    }

    public void pressEnter(Robot robot) {
        robot.delay(KEY_WAIT_INTERVAL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(KEY_WAIT_INTERVAL);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    private void typeNumber(int num, Robot robot, Map<Character, Integer> char2key) {
        String numStr = String.valueOf(num);
        System.out.println("Random: " + numStr);

        for (int i = 0; i < numStr.length(); i++) {
            Character character = numStr.charAt(i);
            pressKey(robot, character, char2key);
        }

    }

    @SneakyThrows
    public void pressKey(Robot robot,
                         Character character,
                         Map<Character, Integer> char2key) {
        Thread.sleep(KEY_WAIT_INTERVAL);
//        robot.delay(KEY_WAIT_INTERVAL);
        robot.keyPress(char2key.get(character));
        Thread.sleep(KEY_WAIT_INTERVAL);
//        robot.delay(KEY_WAIT_INTERVAL);
        robot.keyRelease(char2key.get(character));
    }

    private Map<Character, Integer> initKeyMap() {
        Map<Character, Integer> char2key = new HashMap<>();
        char2key.put('0', KeyEvent.VK_0);
        char2key.put('1', KeyEvent.VK_1);
        char2key.put('2', KeyEvent.VK_2);
        char2key.put('3', KeyEvent.VK_3);
        char2key.put('4', KeyEvent.VK_4);
        char2key.put('5', KeyEvent.VK_5);
        char2key.put('6', KeyEvent.VK_6);
        char2key.put('7', KeyEvent.VK_7);
        char2key.put('8', KeyEvent.VK_8);
        char2key.put('9', KeyEvent.VK_9);
        return char2key;
    }

    private int getRandom() {
        return (int) (Math.random() * 100000);
    }



}
