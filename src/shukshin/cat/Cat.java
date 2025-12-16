package shukshin.cat;

public class Cat implements Meowable {
    private final String name;
    private int meowCount=0;

    public Cat(String name){
        this.name=name;
    }
    public void meow(){
        System.out.println(name + ": мяу!");
        meowCount++;
    }
    public int getMeowCount(){
        return meowCount;
    }
    @Override
    public String toString() {
        return "кот: " + name;
    }
}


