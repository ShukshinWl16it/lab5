package shukshin.cat;

public class Funs {
    public static void meowsCare(Meowable m) {
        // Внутренняя логика метода - вызывает мяуканье несколько раз
        for (int i = 0; i < 5; i++) {
            m.meow();
        }
    }
}
