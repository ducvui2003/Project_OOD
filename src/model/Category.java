package model;

import java.util.ArrayList;
import java.util.Arrays;

public enum Category {
	SNACK, WATER, SODA, MILK, FRUIT;

	public static ArrayList<String> getArrayList() {
		ArrayList<String> result = new ArrayList<>();
		for (Category category : Category.values()) {
			result.add(category + "");
		}
		return result;
	}

	public static String[] getStringArray() {
		String[] result = new String[values().length + 1];
		result[0] = "ALL";
		for (int i = 1; i < result.length; i++) {
			result[i] = values()[i - 1].toString();
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(getStringArray()));
	}
}
