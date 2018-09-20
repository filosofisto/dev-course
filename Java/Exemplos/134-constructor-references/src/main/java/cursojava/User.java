package cursojava;

public class User {

    private String name;

    private boolean moderator;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, Boolean moderator) {
        this.name = name;
        this.moderator = moderator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isModerator() {
        return moderator;
    }

    public void setModerator(boolean moderator) {
        this.moderator = moderator;
    }

    public void becameModerator() {
        setModerator(true);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", moderator=" + moderator +
                '}';
    }
}
