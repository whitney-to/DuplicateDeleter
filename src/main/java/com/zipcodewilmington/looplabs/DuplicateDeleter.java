package com.zipcodewilmington.looplabs;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by leon on 1/25/18.
 */
public abstract class DuplicateDeleter<T> implements DuplicateDeleterInterface<T> {
    protected T[] array;

    public DuplicateDeleter(T[] intArray) {
        this.array = intArray;
    }

     public T[] removeDuplicates(int maxNumberOfDuplications){
         return Arrays.stream(array).filter((val)
                         -> (Arrays.stream(array).filter((ele) -> ele.equals(val))
                         .count()) < maxNumberOfDuplications)
                 .toArray(size -> Arrays.copyOf(array,size));
    };
     public T[] removeDuplicatesExactly(int exactNumberOfDuplications){
         return Arrays.stream(array).filter((val)
                         -> (Arrays.stream(array).filter((ele) -> ele.equals(val))
                         .count()) != exactNumberOfDuplications)
                 .toArray(size -> Arrays.copyOf(array,size));
     };
}
