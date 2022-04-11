import FourTwoSum.TwoSum;
import OneValidBinarySearchTree.BinaryTree;
import OneValidBinarySearchTree.BinaryTreeVerifier;
import SevenSortListOfThreeNumbers.SevenHelper;
import ThreeAddTwoNumbersAsLinkedList.AddLinkedListsHelper;
import ThreeAddTwoNumbersAsLinkedList.Nodell;
import TwoRansomNote.RansomNote;
import eightQueReconstructionByHeight.EightHelper;
import fiveFirstAndLastIndices.FiveHelper;
import sixPermutations.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TechLeadPractice {

    public static void main(String[] args) {
        // #1 - Valid Binary Search Tree.
        /*BinaryTree binaryTree1 = new BinaryTree(
                5,
                new BinaryTree(4),
                new BinaryTree(7, new BinaryTree(6), null)
        );

        BinaryTreeVerifier btVerifier = new BinaryTreeVerifier();
        boolean isValid = btVerifier.verifyFinal(binaryTree1);
        System.out.println("Is Binary Tree Valid: " + isValid);*/

        // #2 - Ransom Note.
        /*char[] availableCharacters = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        String word = "bed";

        boolean canCreateWord = new RansomNote().canSpellCountingLetters(word, availableCharacters);
        System.out.println("Can create word: " + canCreateWord);*/

        // #3 - Add two numbers as a linked list.
        /*Nodell listA = new Nodell(2, new Nodell(4, new Nodell(3)));
        Nodell listB = new Nodell(5, new Nodell(6, new Nodell(4)));

        System.out.println(listA);
        System.out.println("+");
        System.out.println(listB);
        System.out.println("=");
        Nodell result = new AddLinkedListsHelper().addLinkedListsRecursive(listA, listB);
        System.out.println(result);
        result = new AddLinkedListsHelper().addLinkedListsIterative(listA, listB);
        System.out.println(result);*/

        // #4 - Two Sum.
        /*int target = 18;
        int[] options = new int[]{2, 7, 11, 18};

        System.out.println("Target: " + target + ". Options: " + Arrays.toString(options) + ".");
        System.out.println("Result: " + Arrays.toString(new TwoSum().twoSumB(target, options)));*/

        // #5 - First and Last Indices...
        /*int target = 9;
        int[] values = new int[]{1, 3, 3, 5, 7, 8, 9, 9, 15};

        System.out.println("Target: " + target + ". Values: " + Arrays.toString(values) + ".");
        System.out.println("Result: " + Arrays.toString(new FiveHelper().getFirstAndLastIndices(target, values)));*/

        // #6 - Permutations.
        /*int[] values = new int[]{1, 2, 3};
        ArrayList<int[]> result = new Permutations().getPermutations(values);


        System.out.println("values: " + Arrays.toString(values));
        System.out.print("Result: ");
        for (int[] array:
             result) {
            System.out.print(Arrays.toString(array) + ", ");
        }*/

        // #7 - Sort List of Three Numbers.
        /*int[] values = new int[]{3, 3, 2, 1, 3, 2};

        System.out.println("Values: " + Arrays.toString(values));
        System.out.println("Result: " + Arrays.toString(new SevenHelper().sort(values)));*/

        // #8 Queue Reconstruction By Height
        /*int[][] values = new int[][]{
                new int[]{7, 0},
                new int[]{4, 4},
                new int[]{7, 1},
                new int[]{5, 0},
                new int[]{6, 1},
                new int[]{5, 2}};

        System.out.println("Values: ");
        for (int[] value:
                values) {
            System.out.print(Arrays.toString(value) + ", ");
        }

        System.out.println("Result: ");

        ArrayList<int[]> results = new EightHelper().sortByHeight(values);
        for (int[] value:
                results) {
            System.out.print(Arrays.toString(value) + ", ");
        }*/

        int[] input = new int[]{-1, 0 ,5};
        System.out.println(new EightHelper().search(input, 5));
    }

}
