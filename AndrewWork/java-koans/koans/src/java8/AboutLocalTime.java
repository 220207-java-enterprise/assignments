package java8;

import com.sandwich.koan.Koan;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;

public class AboutLocalTime {
//gave the following issue:
    /*
java.lang.reflect.InvocationTargetException
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
        at java.lang.reflect.Method.invoke(Unknown Source)
        at com.sandwich.koan.runner.KoanMethodRunner.run(KoanMethodRunner.java:31)
        at com.sandwich.koan.runner.RunKoans.runKoans(RunKoans.java:74)
        at com.sandwich.koan.runner.RunKoans.run(RunKoans.java:47)
        at com.sandwich.koan.constant.ArgumentType.run(ArgumentType.java:76)
        at com.sandwich.koan.cmdline.CommandLineArgument.run(CommandLineArgument.java:38)
        at com.sandwich.koan.cmdline.CommandLineArgumentRunner.run(CommandLineArgumentRunner.java:26)
        at com.sandwich.util.io.KoanFileCompileAndRunListener.fileSaved(KoanFileCompileAndRunListener.java:51)
        at com.sandwich.util.io.FileMonitor.notifyListeners(FileMonitor.java:63)
        at com.sandwich.util.io.FileMonitorFactory$2.run(FileMonitorFactory.java:37)
        at java.lang.Thread.run(Unknown Source)
Caused by: java.time.format.DateTimeParseException: Text '8:30' could not be parsed at index 0
        at java.time.format.DateTimeFormatter.parseResolved0(Unknown Source)
        at java.time.format.DateTimeFormatter.parse(Unknown Source)
        at java.time.LocalTime.parse(Unknown Source)
        at java.time.LocalTime.parse(Unknown Source)
        at java8.AboutLocalTime.localTimeMinus(AboutLocalTime.java:26)
        ... 14 more
     */
    @Koan
    public void localTime() {
        //LocalTime t1 = LocalTime.of(7, 30);
        //assertEquals(t1, LocalTime.parse("7:30"));
    }

    @Koan
    public void localTimeMinus() {
        //LocalTime t1 = LocalTime.parse("10:30");
        //LocalTime t2 = t1.minus(2, ChronoUnit.HOURS);
        //assertEquals(t2, LocalTime.parse("8:30"));
    }

}
