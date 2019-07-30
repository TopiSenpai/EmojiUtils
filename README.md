# EmojiUtils

Simple Java library for easy use of Emojis in Java applications

# How to use?

```java
import de.anteiku.emojiutils.EmojiUtils;

public class EmojiUtilsText{

  public static void main(String[] args){
    //Get the Emojin as 🦊
    EmojiUtils.getEmoji("fox");
  
    //Get the Emoji as "\uD83E\uDD8A"
    EmojiUtils.getUnicode("fox");
  }

}
```

Full list of all Emojis supported can be found [here](https://github.com/TopiSenpai/EmojiUtils/blob/master/src/main/resources/emojis.json)
