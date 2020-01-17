package utils;

import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class MapOperations {

    public static Optional<String> findFirstCorrespondingKey(Map<String,?> map, String str, Predicate<String> predicate) {
        return map.keySet()
                .stream()
                .filter(predicate)
                .findFirst();
    }

}
