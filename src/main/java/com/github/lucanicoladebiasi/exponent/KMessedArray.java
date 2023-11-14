package com.github.lucanicoladebiasi.exponent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * The class extends {@link ArrayList} implementing the
 * <a href="https://www.tryexponent.com/courses/software-engineering/swe-practice/k-messed-array-sort">k-messed array sort</a>
 * algorithm.
 *
 * @param <T>
 */
public class KMessedArray<T> extends ArrayList<T> {

    public KMessedArray(Collection<? extends T> collection) {
        super(collection);
    }

    @SuppressWarnings("unchecked")
    public KMessedArray<T> sort(
            final int k
    ) {
        return sort(k, (o1, o2) -> {
            if ((o1 instanceof Comparable<?>) && (o2 instanceof Comparable<?>)) {
                return ((Comparable<T>) o1).compareTo(o2);
            }
            return o1.toString().compareTo(o2.toString());
        });
    }

    public KMessedArray<T> sort(
            final int k,
            final Comparator<? super T> comparator
    ) {
        final PriorityQueue<T> priorityQueue = new PriorityQueue<>(k, comparator);
        int i = 0;
        while (i < size() && i <= k) {
            priorityQueue.add(get(i));
            i++;
        }
        int j = 0;
        while (i < size()) {
            set(j, priorityQueue.poll());
            priorityQueue.add(get(i));
            i++;
            j++;
        }
        while (j < size() && !priorityQueue.isEmpty()) {
            set(j, priorityQueue.poll());
            j++;
        }
        return this;
    }

}
