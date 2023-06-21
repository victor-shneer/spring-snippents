package com.carmel;

import org.junit.jupiter.api.Test;
import patterns.structure.decorator.EmailDecorator;
import patterns.structure.decorator.INotifier;
import patterns.structure.decorator.MessengerDecorator;
import patterns.structure.decorator.Notifier;

public class DecoratorPatternTest {

    @Test
    void decoratorPatter(){
        INotifier notifier = new EmailDecorator(new MessengerDecorator(new Notifier("Hey")));
        notifier.send("update");
    }
}
