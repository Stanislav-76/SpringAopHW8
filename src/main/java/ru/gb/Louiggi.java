package ru.gb;

import org.slf4j.event.Level;
import org.springframework.stereotype.Component;
import ru.gb.aspect.Loggable;
import ru.gb.hw.LogPerformance;
import ru.gb.hw.RecoverException;

import java.util.NoSuchElementException;

@Component
public class Louiggi implements Brother {

  @Loggable(level = Level.WARN)
  public void method1(String arg1, int arg2) {
    throw new IllegalArgumentException("IllegalArgumentExceptionmsg");
  }

  @Loggable(level = Level.WARN)
  public String method2() {
    return "value";
  }

  public String method3() {
    throw new RuntimeException("runtimeexceptionmsg");
  }

}
