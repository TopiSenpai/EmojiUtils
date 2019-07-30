package de.anteiku.emojiutils;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmojiUtils {

	private static Map<String, Emoji> EMOJIS = new HashMap<>();
	
	static {
		InputStream stream = EmojiUtils.class.getClassLoader().getResourceAsStream("emojis.json");
		JsonParser jp = new JsonParser();
		try {
			JsonElement emojis = jp.parse(new JsonReader(new InputStreamReader(stream, StandardCharsets.UTF_8)));
			if (emojis.isJsonArray()) {
				for(JsonElement a : emojis.getAsJsonArray()) {
					JsonObject o = a.getAsJsonObject();
					ArrayList<String> aliases = jsonArrayToList(o.get("aliases"));
					for(String s : aliases) {
						Emoji emoji = getEmoji(o);
						EMOJIS.put(s, emoji);
					}
				}
			}
		}
		catch (JsonIOException | JsonSyntaxException e) {
			e.printStackTrace();
		}
	}

	private static Emoji getEmoji(JsonObject j) {
		return new Emoji(j.get("emoji").getAsString(), j.get("emojiChar").getAsString(), j.get("description").getAsString(), jsonArrayToList(j.get("aliases")));
	}

	private static ArrayList<String> jsonArrayToList(JsonElement jArray) {
		if(!jArray.isJsonArray()) {
			return null;
		}
		ArrayList<String> list = new ArrayList<String>();
		
		for(JsonElement j : jArray.getAsJsonArray()) {
			list.add(j.getAsString());
		}
		return list;
	}

	public static String getUnicode(String alias) {
		return EMOJIS.get(alias).getUnicode();
	}

	public static String getEmoji(String alias) {
		return EMOJIS.get(alias).getEmoji();
	}

	public static ArrayList<String> getAliases(String alias) {
		return EMOJIS.get(alias).getAliases();
	}

	public static String getDescription(String alias) {
		return EMOJIS.get(alias).getDescription();
	}
	
}
