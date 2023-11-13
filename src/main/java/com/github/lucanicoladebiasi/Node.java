package com.github.lucanicoladebiasi;

import java.util.*;

public class Node<T> {

    public final T value;

    public final List<Node<T>> children;

    protected Node(final T value, final List<Node<T>> children) {
        this.value = value;
        this.children = children;
    }

    public Deque<Node<T>> getLevelOrderTraversalNodes() {
        final Deque<Node<T>> result = new ArrayDeque<>();
        final Deque<Node<T>> stack = new ArrayDeque<>();
        stack.push(this);
        visitLevelOrderTraversal(result, stack);
        return result;
    }

    public Deque<Node<T>> getPostOrderTraversalNodes() {
        final Deque<Node<T>> result = new ArrayDeque<>();
        final Deque<Node<T>> stack = new ArrayDeque<>();
        stack.push(this);
        visitPostOrderTraversal(result, stack);
        return result;
    }

    public Deque<Node<T>> getPreOrderTraversalNodes() {
        final Deque<Node<T>> result = new ArrayDeque<>();
        final Deque<Node<T>> stack = new ArrayDeque<>();
        stack.push(this);
        visitPreOrderTraversal(result, stack);
        return result;
    }


    public static <T> Node<T> of(T value) {
        return new Node<>(value, new ArrayList<>(0));
    }

    public static <T> Node<T> of(T value, Collection<Node<T>> children) {
        return new Node<>(value, new ArrayList<>(children));
    }

    @SafeVarargs
    public static <T> Node<T> of(T value, Node<T>... children) {
        return of(value, Arrays.asList(children));
    }

    public static <T> List<T> valuesOf(Collection<Node<T>> collection) {
        return collection.stream().map(node -> node.value).toList();
    }

    protected static <T> void visitLevelOrderTraversal(
            final Deque<Node<T>> result,
            final Deque<Node<T>> stack
    ) {
        while (!stack.isEmpty()) {
            final Node<T> node = stack.pop();
            result.add(node);
            stack.addAll(node.children);
        }
    }

    protected static <T> void visitPostOrderTraversal(
            final Deque<Node<T>> result,
            final Deque<Node<T>> stack
    ) {
        while (!stack.isEmpty()) {
            final Node<T> node = stack.pop();
            result.push(node);
            for (Node<T> child : node.children) {
                stack.push(child);
            }
        }
    }

    protected static <T> void visitPreOrderTraversal(
            final Deque<Node<T>> result,
            final Deque<Node<T>> stack
    ) {
        while (!stack.isEmpty()) {
            final Node<T> node = stack.pop();
            result.add(node);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
    }

}
