package patterns.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers;
    public Subject(){
        this.observers = new ArrayList<>();
    }

    public void attach(Observer observer){
        this.observers.add(observer);
    }

    public void detach(Observer observer){
        this.observers.remove(observer);
    }

    protected void updateObservers(String data){
        observers.forEach(observer -> observer.update(data));
    }
}
