package solutions.interview;

import com.sun.source.tree.Tree;
import solutions.interview.Models.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        int a = 5;
        int b = --a;

        // 1. How many buckets needed for the amount of coins.
        int[] coins = {14, 10, 5, 7, 24};

        for (int coin : coins) {
            System.out.printf("%d: %d buckets needed%n", coin, Buckets.bucketCounter(coin));
        }

        // 2. Phone number analyzer.
        String number = "122-456-7890";
        System.out.printf("Phone number is: %s\n", PhoneNumber.phoneNumberAnalyzer(number));

        number = "333-333-3333";
        System.out.println("Phone number is: %s".formatted(PhoneNumber.phoneNumberAnalyzer(number)));

        // 3. 2D array has common divisor.
        int[][] numbers = {
                {6, 4, 8},
                {6, 24, 10},
                {3, 18, 18}
        };
        System.out.println("Array is dividable: " + ArrayDivisors.isArrayDividable(numbers));

        // 4. Lambda exercise.
        LambdaExercise.LambdaFunctions();

        // 5. Is a binary search tree.
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(5);
        binaryTree.root.left = new TreeNode(4);
        binaryTree.root.right = new TreeNode(7);
        binaryTree.root.right.left = new TreeNode(2);

        System.out.println("Is tree a BST: " + binaryTree.isBinarySearchTree());

        // 5. Ransom note.
        RansomNote note = new RansomNote(List.of('c', 't', 'a', 'o', 'b', 'm'));
        System.out.println("Can it spell 'Taco': " + note.CanSpell("Taco"));

        // 6. Add two numbers together using linked lists.
        Node l1 = new Node(5, new Node(6, new Node(4, null)));
        Node l2 = new Node(2, new Node(4, new Node(3, null)));

        Node total = AddLinkedListNumbers.addTwoNumbersRecursively(l1, l2);
        System.out.println("Total for linked list numbers is: " + total);

        // 7. Two sum.
        int[] indices = TwoSum.findIndices(new int[] {2, 7, 11, 15}, 18);
        System.out.println("To find 18 in the array the indices were: " + Arrays.toString(indices));

        // 8. Futures and CompletableFutures.
        ExecutorService service = Executors.newFixedThreadPool(4);
        Future<Integer> future = service.submit(new Task());

        try {
            // This is a blocking call.
            Integer result = future.get();
            System.out.println("Result from Future: " + result);

            CompletableFuture.supplyAsync(Main::getRandom).thenAccept(i -> System.out.println("Result from CompletableFuture:" + i));

            service.shutdown();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        // 9. First and last indices of a number.
        indices = FirstLastIndices.findIndices(new int[] {1, 3, 3, 5, 7, 9, 9, 15}, 9);
        System.out.println("To first and last indices for the number 9 in the array is: " + Arrays.toString(indices));

        // 10. Permutations.
        String permuteString = "ABC";
        int[] permuteArray = {1, 2, 3};
        ArrayList<Integer> permuteList = new ArrayList<>(asList(1, 2, 3));

        // Permutation.permute(permuteString, 0, permuteString.length() - 1);
        // Permutation.permute(permuteArray, 0, permuteArray.length - 1);
        Permutation.permute2(permuteList, new ArrayList<>());

        // 11. Tree search.
        TreeNodeWithArray tree = new TreeNodeWithArray('a', new TreeNodeWithArray[] {
                new TreeNodeWithArray('b', new TreeNodeWithArray[] {
                        new TreeNodeWithArray('d', null),
                        new TreeNodeWithArray('e', null)
                }),
                new TreeNodeWithArray('c', new TreeNodeWithArray[] {
                        new TreeNodeWithArray('f', null)
                })
        });

        System.out.println("Depth first search (pre-order: ");
        tree.preOrder();

        System.out.println("Depth first search (post-order: ");
        tree.postOrder();

        System.out.println("Breath first search: ");
        tree.breathFirstSearch();

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(4);
        tree2.left.right = new TreeNode(5);
        tree2.right.left = new TreeNode(6);

        System.out.println("Depth first search (pre-order: ");
        System.out.println(TreeNode.preOrder(tree2));

        System.out.println("Depth first search (in-order: ");
        System.out.println(TreeNode.inOrder(tree2));

        System.out.println("Depth first search (post-order: ");
        System.out.println(TreeNode.postOrder(tree2));

        System.out.println("Breath first search: ");
        TreeNode.breathSearchFirst(tree2);

        // 12. Reconstruct queue based on height.
        int[][] queue = new int[][]{
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };
        QueueHeight.reconstructQueue(queue);

        // 13. Missing duplicate number.
        System.out.println(MissingDuplicateNumber.findMissingDuplicateNumber(new int[] {4, 3, 2, 4, 1, 3, 2}));

        // 14. Reverse a linked list.
        Node orderedListToReserve = new Node(1, new Node(2, new Node(3, null)));
        System.out.println("Ordered List: " + ReverseLinkedList.printLinkedList(orderedListToReserve));

        Node reversedList = ReverseLinkedList.reversedLinkedList(orderedListToReserve);
        System.out.println("Reversed List: " + ReverseLinkedList.printLinkedList2(reversedList));

        // 15. Implement stack with max number feature.
        MaxStack maxStack = new MaxStack();
        maxStack.push(1, 2, 3, 2);
        System.out.println(maxStack.pop());
        System.out.println(maxStack.max());
        System.out.println(maxStack.pop());
        System.out.println(maxStack.max());

        // 16. Fibonacci sequence.
        System.out.println("Fib: " + Fibonacci.fib(6));
        System.out.println("Fib: " + Fibonacci.fibWithMemoization(6, new Integer[7]));
        System.out.println("Fib: " + Fibonacci.fibWithBottomUp(6));

        // 17. String calculation.
        System.out.println("String calculation: " + StringCalculation.calculateString("5+5*5^2+1-1^5"));

        // 18. String calculation.
        System.out.println("String calculation: " + StringCalculation.calculateString(new String[] {"3", "5", "*", "2", "+", "5", "/"}));

        // 19. Minimum and maximum sum.
        MinMaxSum.minMaxSum(Arrays.asList( 2, 1, 5, 4, 3));

        // 20. Date time formatter.
        DateTimeFormatter timeInputFormat = DateTimeFormatter.ofPattern("hh:mm:ssa");
        DateTimeFormatter timeOutputFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime time = LocalTime.parse("07:05:45PM", timeInputFormat);
        System.out.println(time.format(timeOutputFormat));

        // 21. Minimum VMs required.
        System.out.println("Minimum VM's required: " + MinimumVMs.getMinimumRequiredVMs(Arrays.asList(new int[] {2, 5}, new int[] {3, 6}, new int[] {5, 7})));

        // 22. Pass by reference test.
        Person person = new Person("Nathan", "Zimmerly", 26);
        PassByReference.ChangeName(person);
        System.out.println(person.getLastName());

        // 23. Product of array except self.
        System.out.println(Arrays.toString(ProductOfArray.productOfArrayExceptSelf(new int[] {5, 2, 3, 4, 6})));

        // 24. Camel case.
        Scanner keyboardInput = new Scanner(System.in);

        /*do {
            System.out.print("Enter a command for camel case conversion (ex: S;M;plasticCup()): ");
            System.out.println(CamelCase.convertCamelCase(keyboardInput.nextLine()));
        } while (keyboardInput.hasNextLine());*/

        // 25. Divisible sum pairs.
        System.out.println(DivisibleSumPairs.divisibleCounterFast(6, 3, Arrays.asList(1, 3, 2, 6, 1, 2)));
        System.out.println(DivisibleSumPairs.divisibleCounterFast(6, 5, Arrays.asList(1, 2, 3, 4, 5, 6)));

        // 26. Invert binary tree.
        TreeNode tree3 = new TreeNode(4);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(7);
        tree3.left.left = new TreeNode(1);
        tree3.left.right = new TreeNode(3);
        tree3.right.left = new TreeNode(6);
        tree3.right.right = new TreeNode(9);

        InvertBinaryTree.invertBinaryTree(tree3);

        // 27. Flatten binary tree.
        TreeNode tree4 = new TreeNode(1);
        tree4.left = new TreeNode(2);
        tree4.right = new TreeNode(5);
        tree4.left.left = new TreeNode(3);
        tree4.left.right = new TreeNode(4);
        tree4.right.right = new TreeNode(6);

        FlattenBinaryTree.flatten(tree4, new TreeNode(0));
        TreeNode flattened = FlattenBinaryTree.flattened;
        ArrayList<Integer> flattenedArray = FlattenBinaryTree.flattenedArray;

        // 28. Pythagorean triplets.
        System.out.println("Pythagorean triplets exists? " + PythagoreanTriplets.findPythagoreanTriplets(Arrays.asList(3, 5, 12, 5, 13)));

        // 29. Push dominoes.
        System.out.println("Push dominoes: " + PushDominoes.pushDominoes("..R...L..R.".toCharArray()));

        // 30. Simple calculator.
        System.out.println("Simple calculator: " + SimpleCalculator.calculate("2+2"));

        // 31. Roman numeral converter.
        System.out.println("Roman numeral: " + RomanToNumber.translateRomanToNumber("MCMXCIV"));

        // 32. Double linked list.
        DoubleLinkedList doubleList = new DoubleLinkedList();
        doubleList.insert(2);
        doubleList.insert(4);
        doubleList.insert(5);
        doubleList.insert(7);

        doubleList.remove(5);

        // Temp solutions.
        Temp.main(null);

        // Test taking.
        // Testing.main(null);

        System.out.println("Finished.");
    }

    public static Integer getRandom() {
        return new Random().nextInt();
    }

    public static class Task implements Callable<Integer> {
        @Override
        public Integer call() {
            return new Random().nextInt();
        }
    }
}
