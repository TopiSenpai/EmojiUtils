package de.anteiku.emojiutils;

import java.util.ArrayList;

public class Emoji {
	
	private String unicode;
    private String emoji;
    private String description;
    private ArrayList<String> aliases;

    public Emoji(String unicode, String emoji, String description, ArrayList<String> aliases){
        this.unicode = unicode;
        this.emoji = emoji;
        this.description = description;
        this.aliases = aliases;
    }

    public String getUnicode() {
        return unicode;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getAliases() {
        return aliases;
    }

}
