package com.zhuzz.design.patternz;

/**
 * 抽象工厂模式
 *
 * @author zhuzz
 * 2023/8/29 17:21
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        SoftwareFactory windowsFactory = new WindowsFactory();
        OperatingSystem windowsOS = windowsFactory.createOperatingSystem();
        Application windowsApp = windowsFactory.createApplication();

        windowsOS.run();
        windowsApp.open();

        SoftwareFactory linuxFactory = new LinuxFactory();
        OperatingSystem linuxOS = linuxFactory.createOperatingSystem();
        Application linuxApp = linuxFactory.createApplication();

        linuxOS.run();
        linuxApp.open();
    }

    interface OperatingSystem {
        void run();
    }

    static class WindowsOS implements OperatingSystem {
        @Override
        public void run() {
            System.out.println("Running Windows OS");
        }
    }

    static class LinuxOS implements OperatingSystem {
        @Override
        public void run() {
            System.out.println("Running Linux OS");
        }
    }

    static interface Application {
        void open();
    }

    static class WordApplication implements Application {
        @Override
        public void open() {
            System.out.println("Opening Word Application");
        }
    }

    static class ExcelApplication implements Application {
        @Override
        public void open() {
            System.out.println("Opening Excel Application");
        }
    }

    interface SoftwareFactory {
        OperatingSystem createOperatingSystem();

        Application createApplication();
    }

    static class WindowsFactory implements SoftwareFactory {
        @Override
        public OperatingSystem createOperatingSystem() {
            return new WindowsOS();
        }

        @Override
        public Application createApplication() {
            return new ExcelApplication();
        }
    }

    static class LinuxFactory implements SoftwareFactory {
        @Override
        public OperatingSystem createOperatingSystem() {
            return new LinuxOS();
        }

        @Override
        public Application createApplication() {
            return new WordApplication();
        }
    }
}


