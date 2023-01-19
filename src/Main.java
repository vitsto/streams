import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

//        List<Integer> list = new LinkedList<>(); // выдает null,null
        findMinMax(list.stream(), Integer::compareTo, (min, max) -> {
            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
        });

        List<String> list2 = new LinkedList<>(List.of("a", "ab", "abc", "abcd"));
        findMinMax(list2.stream(), String::compareTo, (min, max) -> {
            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
        });
        System.out.println(countEven(list));
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> comparator,
                                      BiConsumer<? super T, T> minMaxConsumer) {
        List<? extends T> list = stream.sorted(comparator).toList();
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        }

        minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
    }

    public static long countEven(List<Integer> list) {
        return list.stream().filter(e -> e % 2 == 0).count();
    }
}