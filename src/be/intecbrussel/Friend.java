package be.intecbrussel;

public class Friend {
    private String name;
    private boolean family;
    private int yearsKnown;
    private int friendShipLevel;

    public Friend(String name, boolean family, int yearsKnown, int friendShipLevel) {
        this.name = name;
        this.family = family;
        this.yearsKnown = yearsKnown;
        this.friendShipLevel = friendShipLevel;
    }

    public String getName() {
        return name;
    }

    public boolean isFamily() {
        return family;
    }

    public int getYearsKnown() {
        return yearsKnown;
    }

    public int getFriendShipLevel() {
        return friendShipLevel;
    }
}
