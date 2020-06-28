package ru.progwards.java2.lessons.trees;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

public class BinaryTree<K extends Comparable<K>, V> {
    private static final String KEYEXIST = "Key already exist";
    private static final String KEYNOTEXIST = "Key not exist";

    class TreeLeaf<K extends Comparable<K>, V> {
        K key;
        V value;
        TreeLeaf parent;
        TreeLeaf left;
        TreeLeaf right;

        public TreeLeaf(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private TreeLeaf<K,V> find(K key) {
            int cmp = key.compareTo(this.key);
            if (cmp > 0)
                if (right != null)
                    return right.find(key);
                else
                    return this;
            if (cmp < 0)
                if (left != null)
                    return left.find(key);
                else
                    return this;
            return this;
        }

        void add(TreeLeaf<K, V> leaf) throws TreeException {
            int cmp = leaf.key.compareTo(key);
            if (cmp == 0)
                throw new TreeException(KEYEXIST);
            if (cmp > 0) {
                right = leaf;
                leaf.parent = this;
            } else {
                left = leaf;
                leaf.parent = this;
            }
        }

        void delete() throws TreeException {
            if (parent.right == this) {
                parent.right = right;
                if (right != null)
                    right.parent = parent;
                if (left != null)
                    parent.find(left.key).add(left);
            } else {
                parent.left = left;
                if (left != null)
                    left.parent = parent;
                if (right != null)
                    parent.find(right.key).add(right);
            }
        }

        public String toString() {
            return "("+key+","+value+")";
        }

        public void process(Consumer<TreeLeaf<K,V>> consumer) {
            if (left != null)
                left.process(consumer);
            consumer.accept(this);
            if (right != null)
                right.process(consumer);
        }
    }
    private TreeLeaf<K, V> root;

    public TreeLeaf<K, V> getRoot() {
        return root;
    }

    public V find(K key) {
        if (root == null)
            return null;
        TreeLeaf found = root.find(key);
        return found.key.compareTo(key) == 0 ? (V)found.value : null;
    }

    public void add(TreeLeaf<K, V> leaf) throws TreeException {
        if (root == null)
            root = leaf;
        else
            root.find(leaf.key).add(leaf);
    }

    public void add(K key, V value) throws TreeException {
        add(new TreeLeaf<>(key, value));
    }

    public void delete(K key) throws TreeException {
        internaldDelete(key);
    }

    public TreeLeaf<K, V> internaldDelete(K key) throws TreeException {
        if (root == null)
            throw new TreeException(KEYNOTEXIST);

        TreeLeaf found = root.find(key);
        int cmp = found.key.compareTo(key);
        if (cmp != 0)
            throw new TreeException(KEYNOTEXIST);
        if (found.parent == null) {
            if (found.right != null) {
                root = found.right;
                if (found.left != null)
                    add(found.left);
            } else if (found.left != null)
                root = found.left;
            else
                root = null;
        } else
            found.delete();
        return found;
    }

    public void change(K oldKey, K newKey) throws TreeException {
        TreeLeaf<K, V> current = internaldDelete(oldKey);
        current.key = newKey;
        add(current);
    }

    public void process(Consumer<TreeLeaf<K,V>> consumer) {
        if (root != null)
            root.process(consumer);
    }

    public TreeIterator<K,V> getIterator() {

        return new TreeIterator<>(this);
    }

    public static void main(String[] args) throws TreeException {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.add(8,"");
        tree.add(3,"");
        tree.add(10,"");
        tree.add(1,"");
        tree.add(6,"");
        tree.add(14,"");
        tree.add(4,"");
        tree.add(7,"");
        tree.add(13,"");
        //ArrayList<BinaryTree.TreeLeaf> sorted =new ArrayList<>();
        //tree.process(System.out::println);
        /*

        Имеем дерево.
             8
          3       10
        1  6    14
          4 7 13

    8 3 1 6 4 7 10 14 13

    Прямой обход (NLR)
    Прямой обход: 8 3 1 6 4 7 10 14 13

    Проверяем, не является ли текущий узел пустым или null.
    Показываем поле данных корня (или текущего узла).
    Обходим левое поддерево рекурсивно, вызвав функцию прямого обхода.
    Обходим правое поддерево рекурсивно, вызвав функцию прямого обхода.

    */
        for (TreeIterator<Integer, String> it = tree.getIterator(); it.hasNext(); ) {
            var leaf = it.next();
            System.out.println(leaf);
        }
    }
}

