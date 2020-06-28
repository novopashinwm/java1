package ru.progwards.java2.lessons.trees;

import java.util.function.Consumer;

public class AvlTree<K extends Comparable<K>, V>  {

    private static final String KEYEXIST = "Key already exist";
    private static final String KEYNOTEXIST = "Key not exist";

    private AvlLeaf root;

    class AvlLeaf<K extends Comparable<K>, V> {
        K key;
        V value;
        AvlLeaf parent;
        AvlLeaf left;
        AvlLeaf right;
        private int height;

        public AvlLeaf(K key, V value) {
            this.key = key;
            this.value = value;
            height= 1;
        }


        private AvlLeaf<K,V> find(K key) {
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


        public String toString() {
            return "("+key+","+value+")";
        }

        public void process(Consumer<AvlLeaf<K,V>> consumer) {
            if (left != null)
                left.process(consumer);
            consumer.accept(this);
            if (right != null)
                right.process(consumer);
        }
    }

    private int getHeight(AvlLeaf leaf) {
        if (leaf == null) return 0;
        return leaf.height;
    }

    private AvlLeaf rightRotate(AvlLeaf y) {
        AvlLeaf x = y.left;
        AvlLeaf temp = x.right;

        // Perform rotation
        x.right = y;
        y.left = temp;

        // Update heights
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        // Return new root
        return x;
    }

    private AvlLeaf leftRotate(AvlLeaf x)
    {
        AvlLeaf y = x.right;
        AvlLeaf temp = y.left;

        //Rotation
        y.left = x;
        x.right = temp;

        //update heights
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) +1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) +1;

        return y;
    }

    private int getBalance(AvlLeaf leaf)
    {
        if (leaf== null) return 0;
        return getHeight(leaf.left) - getHeight(leaf.right);
    }

    public void put(K key, V value) {
       root = insert(root, key, value);
    }

    AvlLeaf insert (AvlLeaf node, K key, V value) {
        if (node == null)
            return new AvlLeaf(key,value);
        int cmp = key.compareTo((K)node.key);
        if (cmp <0)
            node.left = insert(node.left, key,value);
        else if (cmp>0)
            node.right = insert(node.right, key, value);
        else
            return node;

        updateHeight(node);

        int balance = getBalance(node);
        int cmp_left = 0;
        if (node.left != null)
            cmp_left = key.compareTo((K) node.left.key);
        int cmp_right = 0;

        if (node.right !=null)
            cmp_right = key.compareTo((K) node.right.key);

        if (balance >  1 && cmp_left  < 0) return rightRotate(node);
        if (balance < -1 && cmp_right > 0) return leftRotate(node);

        if (balance >  1 && cmp_left  > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && cmp_right < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    AvlLeaf delete(AvlLeaf node, K key) {
        int cmp = node.key.compareTo(key);
        if (node == null) {
            return node;
        } else if (cmp > 0) {
            node.left = delete(node.left, key);
        } else if (cmp < 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                AvlLeaf mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, (K) node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    private AvlLeaf mostLeftChild(AvlLeaf node) {
        AvlLeaf current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private AvlLeaf rebalance(AvlLeaf z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (getHeight(z.right.right) > getHeight(z.right.left)) {
                z = leftRotate(z);
            } else {
                z.right = rightRotate(z.right);
                z = leftRotate(z);
            }
        } else if (balance < -1) {
            if (getHeight(z.left.left) > getHeight(z.left.right)) {
                z = rightRotate(z);
            } else {
                z.left = leftRotate(z.left);
                z = rightRotate(z);
            }
        }
        return z;
    }

    private void updateHeight(AvlLeaf n) {
        n.height = 1 + Math.max(getHeight(n.left), getHeight(n.right));
    }

    AvlLeaf findinner(K key) {
        AvlLeaf current = root;
        while (current != null) {
            if (current.key.compareTo(key) == 0) {
                break;
            }
            current = current.key.compareTo(key) < 0 ? current.right : current.left;
        }
        return current;
    }

    public V find(K key) {
        AvlLeaf node = findinner(key);
        return (V)node.value;
    }

    public void change(K oldKey, K newKey) {
        AvlLeaf node =  findinner(oldKey);
        node.key = newKey;
        rebalance(node);
    }

    public void process(Consumer<AvlLeaf<K,V>> consumer) {
        if (root != null)
            root.process(consumer);
    }

    void preOrder(AvlLeaf node) {
        if (node != null) {
            System.out.print(node.key + " " + node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AvlTree<Integer, String> tree = new AvlTree();
        tree.put(10, "");
        tree.put(20, "");
        tree.put(30, "");
        tree.put(40, "");
        tree.put(50, "");
        tree.put(25, "");
        tree.preOrder(tree.root);
    }

}
