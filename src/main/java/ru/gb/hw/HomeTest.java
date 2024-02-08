package ru.gb.hw;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@LogPerformance
@Component
@AllArgsConstructor
public class HomeTest {
    @RecoverException(noRecoverFor = {IllegalArgumentException.class, NoSuchElementException.class})
    public String method1(String arg1, int arg2) {
        return "value";
    }

//    @LogPerformance
    @RecoverException(noRecoverFor = {IllegalArgumentException.class, NoSuchElementException.class})
    public String method2() {
        String text = "text";
        throw new RuntimeException("runtimeexceptionmsg");
    }

    @RecoverException(noRecoverFor = {IllegalArgumentException.class, NoSuchElementException.class})
    public String method3() {
        throw new IllegalArgumentException("IllegalArgumentExceptionmsg");
    }
}
