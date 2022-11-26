package com.midterm.appnauan1;

public class MenuFood {
    String avatar;
    String name;
    int key;

    public MenuFood(String avatar, String name, int key) {
        this.avatar = avatar;
        this.name = name;
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
