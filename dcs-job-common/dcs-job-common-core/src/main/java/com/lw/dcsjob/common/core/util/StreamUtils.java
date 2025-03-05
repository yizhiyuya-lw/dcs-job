package com.lw.dcsjob.common.core.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream流工具类
 * @author lw
 * @create 2025-03-05-20:52
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StreamUtils {

    public static final String SEPARATOR = ",";

    /**
     * 将collection过滤
     *
     * @param collection
     * @param function
     * @param <E>
     * @return
     */
    public static <E> List<E> filter(Collection<E> collection, Predicate<E> function) {
        if (CollUtil.isEmpty(collection)) {
            return CollUtil.newArrayList();
        }

        return collection.stream().filter(function).collect(Collectors.toList());
    }

    /**
     * 将collection拼接
     *
     * @param collection
     * @param function
     * @param <E>
     * @return
     */
    public static <E> String join(Collection<E> collection, Function<E, String> function) {
        return join(collection, function, SEPARATOR);
    }

    public static <E> String join(Collection<E> collection, Function<E, String> function, CharSequence delimiter) {
        if (CollUtil.isEmpty(collection)) {
            return StrUtil.EMPTY;
        }
        return collection.stream().map(function).filter(Objects::nonNull).collect(Collectors.joining(delimiter));
    }

    /**
     * 将collection排序
     *
     * @param collection
     * @param comparing
     * @param <E>
     * @return
     */
    public static <E> List<E> sorted(Collection<E> collection, Comparator<E> comparing) {
        if (CollUtil.isEmpty(collection)) {
            return CollUtil.newArrayList();
        }
        return collection.stream().filter(Objects::nonNull).sorted(comparing).collect(Collectors.toList());
    }

    /**
     * 将collection转化为类型不变的map
     *
     * @param collection
     * @param key
     * @param <V>
     * @param <K>
     * @return
     */
    public static <V, K> Map<K, V> toIdentityMap(Collection<V> collection, Function<V, K> key) {
        if (CollUtil.isEmpty(collection)) {
            return MapUtil.newHashMap();
        }
        return collection.stream().filter(Objects::nonNull).collect(Collectors.toMap(key, Function.identity(), (l, r) -> l));
    }

    /**
     * 将collection转为map
     *
     * @param collection
     * @param key
     * @param value
     * @param <E>
     * @param <K>
     * @param <V>
     * @return
     */
    public static <E, K, V> Map<K, V> toMap(Collection<E> collection, Function<E, K> key, Function<E, V> value) {
        if (CollUtil.isEmpty(collection)) {
            return MapUtil.newHashMap();
        }
        return collection.stream().filter(Objects::nonNull).collect(Collectors.toMap(key, value, (l, r) -> l));
    }

    /**
     * 将collection按规则分类成map
     *
     * @param collection
     * @param key
     * @param <E>
     * @param <K>
     * @return
     */
    public static <E, K> Map<K, List<E>> groupByKey(Collection<E> collection, Function<E, K> key) {
        if (CollUtil.isEmpty(collection)) {
            return MapUtil.newHashMap();
        }
        return collection.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(key, LinkedHashMap::new, Collectors.toList()));
    }

    /**
     * 将collection转化为list，但是两者泛型不同
     *
     * @param collection
     * @param function
     * @param <E>
     * @param <T>
     * @return
     */
    public static <E, T> List<T> toList(Collection<E> collection, Function<E, T> function) {
        if (CollUtil.isEmpty(collection)) {
            return CollUtil.newArrayList();
        }
        return collection.stream().map(function).filter(Objects::nonNull).collect(Collectors.toList());
    }

    /**
     * 将collection转化为set
     *
     * @param collection
     * @param function
     * @param <E>
     * @param <T>
     * @return
     */
    public static <E, T> Set<T> toSet(Collection<E> collection, Function<E, T> function) {
        if (CollUtil.isEmpty(collection) || function == null) {
            return CollUtil.newHashSet();
        }
        return collection.stream().map(function).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    /**
     * collection元素进行展平，合并后转换成集合
     * @param collection
     * @param mapper
     * @param function
     * @return
     * @param <T>
     * @param <U>
     * @param <R>
     */
    public static <T, U, R> Set<R> toSetByFlatMap(Collection<T> collection,
                                                  Function<? super T, ? extends U> mapper,
                                                  Function<U, ? extends Stream<? extends R>> function) {
        if (CollUtil.isEmpty(collection)) {
            return CollUtil.newHashSet();
        }
        return collection.stream().map(mapper).filter(Objects::nonNull)
                .flatMap(function).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    /**
     * collection元素进行展平，合并后转换成集合
     * @param collection
     * @param function
     * @return
     * @param <T>
     * @param <U>
     */
    public static <T, U> Set<U> toSetByFlatMap(Collection<T> collection, Function<T, ? extends Stream<? extends U>> function) {
        if (CollUtil.isEmpty(collection)) {
            return CollUtil.newHashSet();
        }
        return collection.stream().filter(Objects::nonNull)
                .flatMap(function).filter(Objects::nonNull).collect(Collectors.toSet());
    }
}
