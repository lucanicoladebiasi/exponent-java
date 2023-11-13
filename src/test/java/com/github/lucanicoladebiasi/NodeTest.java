package com.github.lucanicoladebiasi;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NodeTest {

    @Test
    void getLevelOrderTraversalValues() {
        final Node<Integer> tree = Node.of(1,
                Node.of(2),
                Node.of(3,
                        Node.of(6),
                        Node.of(7,
                                Node.of(11,
                                        Node.of(14)
                                )
                        )
                ),
                Node.of(4,
                        Node.of(8,
                                Node.of(12)
                        )
                ),
                Node.of(5,
                        Node.of(9,
                                Node.of(13)
                        ),
                        Node.of(10)
                )
        );
        final List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
        final List<Integer> actual = Node.valuesOf(tree.getLevelOrderTraversalNodes());
        assertEquals(expected, actual);
    }

    /**
     * https://www.geeksforgeeks.org/iterative-postorder-traversal-of-n-ary-tree/?ref=lbp
     */
    @Test
    void getPostOrderTraversalNodes() {
        final Node<Integer> tree = Node.of(1,
                Node.of(3,
                        Node.of(5),
                        Node.of(6)
                ),
                Node.of(2),
                Node.of(4)
        );
        final List<Integer> expected = List.of(5, 6, 3, 2, 4, 1);
        final List<Integer> actual = Node.valuesOf(tree.getPostOrderTraversalNodes());
        assertEquals(expected, actual);
    }

    /**
     * https://www.geeksforgeeks.org/preorder-traversal-of-a-n-ary-tree/?ref=lbp
     */
    @Test
    void getPreOrderTraversalNodes() {
        Node<Integer> tree = Node.of(1,
                Node.of(2,
                        Node.of(5,
                                Node.of(10)
                        ),
                        Node.of(6,
                                Node.of(11),
                                Node.of(12),
                                Node.of(13)
                        )
                ),
                Node.of(3),
                Node.of(4,
                        Node.of(7),
                        Node.of(8),
                        Node.of(9))
        );
        final List<Integer> expected = List.of(1, 2, 5, 10, 6, 11, 12, 13, 3, 4, 7, 8, 9);
        final List<Integer> actual = Node.valuesOf(tree.getPreOrderTraversalNodes());
        assertEquals(expected, actual);
    }
}