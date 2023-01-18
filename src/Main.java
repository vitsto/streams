import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
//        List<Integer> list = new LinkedList<>(); // выдает null,null
        findMinMax(list.stream(), Integer::compareTo, (integer, integer2) -> {
            System.out.println("Min: " + integer);
            System.out.println("Max: " + integer2);
        });
        System.out.println(countEven(list));
    }

    public static void findMinMax(Stream<? extends Integer> stream,
                                  Comparator<? super Integer> comparator,
                                  BiConsumer<? super Integer, ? super Integer> minMaxConsumer) {
        List<Integer> integers = stream.map(Integer::valueOf).toList();
        Integer min = integers.stream().min(comparator).orElse(null);
        Integer max = integers.stream().max(comparator).orElse(null);
        if (min == null) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(min, max);
        }
    }

    public static long countEven(List<Integer> list) {
        return list.stream().filter(e -> e % 2 == 0).count();
    }
}