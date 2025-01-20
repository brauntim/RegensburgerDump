package uebung_6_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
	private String name;
	private String text;

	private List<String> likesList = new ArrayList<String>();
	private List<String> lovesList = new ArrayList<String>();
	private List<String> hatesList = new ArrayList<String>();

	public Person(String text) {
		this.text = text;
	}

	// splits the text at the "," char, so we can analyze each part of the text
	public void analyze() {
		// ["Jim likes Larry and Jean", "loves Tom", "but hates Kim"]
		String split_text[] = this.text.split(",");
		if (split_text.length > 0) {
			analyzeFirstPart(split_text[0]);
		}

		if (split_text.length > 1) {
			analyzeOtherParts(split_text[1]);
		}

		if (split_text.length > 2) {
			analyzeOtherParts(split_text[2]);
		}

	}

	// Analyzing the first part by applying the pattern-rules for the first part
	private void analyzeFirstPart(String firstPart) {
		String sub_split_text[];
		List<String> temp = getCorrectList(firstPart);

		this.name = firstPart.split(" ")[0];

		String firstName = firstPart.split(" ")[2];
		temp.add(firstName.trim());

		sub_split_text = firstPart.split("and");

		for (int i = 1; i < sub_split_text.length; i++) {
			temp.add(sub_split_text[i].trim());
		}
	}

	// Analyzing the other parts by applying the pattern-rules for all other parts
	private void analyzeOtherParts(String part) {
		String sub_split_text[];
		List<String> temp = getCorrectList(part);

		sub_split_text = part.split(" ");
		temp.add(sub_split_text[sub_split_text.length - 1].trim());

		for (int i = sub_split_text.length - 1; i >= 0; i -= 2) {
			if ((i - 1) >= 0 && sub_split_text[i - 1].equals("and")) {
				if ((i - 2) >= 0) {
					temp.add(sub_split_text[i - 2].trim());
				}
			}
		}
	}

	private List<String> getCorrectList(String text) {
		if (text.contains("likes")) {
			return this.likesList;
		}
		if (text.contains("loves")) {
			return this.lovesList;
		}
		if (text.contains("hates")) {
			return this.hatesList;
		}
		return null;
	}

	public void print() {
		System.out.println(
				this.name + " likes: " + this.likesList + " loves: " + this.lovesList + " hates: " + this.hatesList);
	}
}