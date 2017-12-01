package top.dongpeili.model;

import java.util.HashMap;
import java.util.Map;

public class PageData {

	Map<String, String> map = new HashMap<>();

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public String get(String s) {
		return map.get(s);
	}

	public void put(String key, String value) {
		map.put(key, value);
	}
}
