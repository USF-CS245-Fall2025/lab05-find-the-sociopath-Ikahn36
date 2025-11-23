/* 
 * This class provides a method to find the sociopath in a group based on who likes whom. 
 * I also built test cases in manually and ran them in the main method. I tried using JUnit but
 * I couldn't get it to work properly.
 */

import java.util.List;


public class Sociopath {

	public int findTheSociopath (int groupSize, List<int []> likeList) {
		if(groupSize <= 0) {
			return -1;
		}
		int[][] sociopathCheck = new int[groupSize][2];
		for (int[] pair : likeList) {
			if(pair[0] <= 0 || pair[0] > groupSize || pair[1] <= 0 || pair[1] > groupSize) {
				return -1;
			}
			int liker = pair[0] - 1;
			int liked = pair[1] - 1;
			sociopathCheck[liker][0]++;
			sociopathCheck[liked][1]++;
		}
		for (int i = 0; i < groupSize; i++) {
			if (sociopathCheck[i][1] == groupSize - 1 && sociopathCheck[i][0] == 0) {
				return i+1;
			}
		}
		return -1;
	}

	private void sizeTwoWithSociopath() {
		int groupSize = 2;
		List<int []> likeList = new java.util.ArrayList<>();
		likeList.add(new int[]{1, 2});
		int result = findTheSociopath(groupSize, likeList);
		if (result != 2) {
			System.out.println("Result was: " + result + ", expected 2");
		} else {
			System.out.println("Test passed: sizeTwoWithSociopath");
		}
	}

	private void sizeThreeNoOneLikesThree() {
		int groupSize = 3;
		List<int []> likeList = new java.util.ArrayList<>();
		likeList.add(new int[]{1, 2});
		int result = findTheSociopath(groupSize, likeList);
		if (result != -1) {
			System.out.println("Result was: " + result + ", expected -1");
		} else {
			System.out.println("Test passed: sizeThreeNoOneLikesThree");
		}
	}

	private void sizeThreeWithSociopath() {
		int groupSize = 3;
		List<int []> likeList = new java.util.ArrayList<>();
		likeList.add(new int[]{1, 2});
		likeList.add(new int[]{1, 3});
		likeList.add(new int[]{2, 3});
		int result = findTheSociopath(groupSize, likeList);
		if (result != 3) {
			System.out.println("Result was: " + result + ", expected 3");
		} else {
			System.out.println("Test passed: sizeThreeWithSociopath");
		}
	}

	private void sizeThreeNoSociopath() {
		int groupSize = 3;
		List<int []> likeList = new java.util.ArrayList<>();
		likeList.add(new int[]{1, 3});
		likeList.add(new int[]{2, 3});
		likeList.add(new int[]{3, 1});
		int result = findTheSociopath(groupSize, likeList);
		if (result != -1) {
			System.out.println("Result was: " + result + ", expected -1");
		} else {
			System.out.println("Test passed: sizeThreeNoSociopath");
		}
	}

	private void invalidSize() {
		int groupSize = 0;
		List<int []> likeList = new java.util.ArrayList<>();
		likeList.add(new int[]{1, 2});
		int result = findTheSociopath(groupSize, likeList);
		if (result != -1) {
			System.out.println("Result was: " + result + ", expected -1");
		} else {
			System.out.println("Test passed: invalidSize");
		}
	}

	private void invalidPerson() {
		int groupSize = 3;
		List<int []> likeList = new java.util.ArrayList<>();
		likeList.add(new int[]{1, 0});
		int result = findTheSociopath(groupSize, likeList);
		if (result != -1) {
			System.out.println("Result was: " + result + ", expected -1");
		} else {
			System.out.println("Test passed: invalidPerson");
		}
	}
	public static void main(String[] args) {
		Sociopath test = new Sociopath();
		test.sizeTwoWithSociopath();
		test.sizeThreeNoOneLikesThree();
		test.sizeThreeWithSociopath();
		test.sizeThreeNoSociopath();
		test.invalidSize();
		test.invalidPerson();
	}
}
