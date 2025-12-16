package shukshin.cat;

public class CountingMeowable implements Meowable {
    private final Meowable wrapped;
    private int meowCount = 0;

    public CountingMeowable(Meowable wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void meow() {
        wrapped.meow();
        meowCount++;
    }

    public int getMeowCount() {

        return meowCount;
    }
}

