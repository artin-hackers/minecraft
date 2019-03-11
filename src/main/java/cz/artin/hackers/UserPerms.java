package cz.artin.hackers;

import java.util.UUID;

public class UserPerms {
    public UUID id;
    public int level;

    public UserPerms(UUID id, int level) {
        this.id = id;
        this.level = level;
    }



    public int increaseLevel() {
        level++;
        return level;
    }
    public int getLevel() {

        return level;
    }
    public int getPermLevel() {

        return level;
    }
    public boolean equals(UserPerms permise) {
        return id.equals(permise.id);
    }
    public boolean equals(UUID uuid) {
        return id.equals(uuid);
    }
    public int setLevelToMax() {
       level++;
       level++;
       level++;
       return level;
    }
    public int decreaseLevel() {
        level--;
        return level;
    }

}
