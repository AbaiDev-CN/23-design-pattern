package com.zhuzz.design.patternz;

/**
 * 命令模式
 *
 * @author zhuzz
 * 2023/8/29 17:47
 */
public class CommandPattern {

    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(livingRoomLightOn);
        remote.pressButton(); // 打开电灯

        remote.setCommand(livingRoomLightOff);
        remote.pressButton(); // 关闭电灯
    }

    interface Command {
        void execute();
    }

    static class LightOnCommand implements Command {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOn();
        }
    }

    static class LightOffCommand implements Command {
        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOff();
        }
    }

    static class Light {
        void turnOn() {
            System.out.println("Light is on");
        }

        void turnOff() {
            System.out.println("Light is off");
        }
    }

    static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }
    }

}
