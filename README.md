# EmojiUtils

Simple Java library for easy use of Emojis in Java applications

# How to use?

```java
import de.anteiku.emojiutils.EmojiUtils;

public class EmojiUtilsText{

  public static void main(String[] args){
    //Get the Emojin as 🦊
    System.out.println(EmojiUtils.getEmoji("fox"));
  
    //Get the Emoji as "\uD83E\uDD8A"
    System.out.println(EmojiUtils.getUnicode("fox"));
  }

}
```
