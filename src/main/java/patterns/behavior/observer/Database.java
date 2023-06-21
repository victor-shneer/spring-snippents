package patterns.behavior.observer;

public class Database extends Subject{
    private String data;

    public void setData(String data){
        this.data = data;
        updateObservers(data);
    }

    public String getData(){
        return this.data;
    }
}


