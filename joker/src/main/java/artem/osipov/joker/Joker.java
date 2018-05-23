package artem.osipov.joker;

import java.util.ArrayList;

public class Joker {

    private ArrayList<String> jokes = new ArrayList<>();
    private int currentJoke = 0;

    public Joker() {
        jokes.add("Programmer (noun) - A machine that turn coffee into code");
        jokes.add("A programmer puts two glasses on his bedside table before going to sleep. A full one, in case he gets thirsty, and an empty one, in case he doesn't.");
        jokes.add("Q: How many prolog programmers does it take to change a lightbulb?\n A: Yes.");
        jokes.add("There's no place like 127.0.0.1");
    }

    public String tellAJoke() {
        if (++currentJoke == jokes.size()) {
            currentJoke = 0;
        }
        return jokes.get(currentJoke);
    }
}
