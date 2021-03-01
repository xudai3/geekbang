package com.xd.geekbang.datastructure.skiplist;

import java.util.Random;

public class SkipList2 {
    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;

    private Node head = new Node(MAX_LEVEL);
    private Random r = new Random();

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    // 优化1
    public void insert(int value) {
        int level = head.forwards[0] == null ? 1 : randomLevel();
        if (level > levelCount) {
            level = ++levelCount;
        }
        Node newNode = new Node(level);
        newNode.data = value;
        Node update[] = new Node[level];
        for (int i = 0; i < level; ++i) {
            update[i] = head;
        }

        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            if (level > i) {
                update[i] = p;
            }
        }

        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }
    }

    // 优化2
    public void insert2(int value) {
        int level = head.forwards[0] == null ? 1 : randomLevel();
        // 如果随机的层数大于当前最大层数，每次只增加一层
        if (level > levelCount) {
            level = ++levelCount;
        }
        Node newNode = new Node(level);
        newNode.data = value;
        Node p = head;

        // 最大层开始查找适合插入的前一节点
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            // 插入之后更新第0层节点编号
            if (i == 0) {
                newNode.idx = p.idx + 1;
                updateIdx(p, 1);
            }
            // 随机出来的level可能会小于当前的最大层数levelCount
            // 这个for循环是从levelCount开始的
            // 只需要插入到<level的层数就可以
            if (i < level) {
                // 如果前一节点的next是空的则直接插到后面
                if (p.forwards[i] == null) {
                    p.forwards[i] = newNode;
                } else {
                    // 否则需要先暂时保存后节点信息防止丢失
                    Node next = p.forwards[i];
                    p.forwards[i] = newNode;
                    newNode.forwards[i] = next;
                }
            }
        }
    }

    public void updateIdx(Node node, int update) {
        Node p = node;
        while (p.forwards[0] != null) {
            p = p.forwards[0];
            p.idx += update;
        }
    }

    public int findIdx(Node node, int val) {
        Node p = node;
        while (p != null) {
            if (p.data == val) {
                return p.idx;
            } else {
                p = p.forwards[0];
            }
        }
        return -1;
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        // 先找到每一层最后一个小于value的节点，让p指向它并且用update[]数组保存起来
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        // 上面p在最后一个循环指向的是第0层最后一个小于value的节点，p.forwards[0]就是要删除的节点，如果存在这个值的话
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                // 删除每一层data==value的节点，如果存在的话
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                    if (i == 0) {
                        updateIdx(update[i], -1);
                    }
                }
            }
        }
    }

    public void printAllBeautiful() {
        Node p = head;
        Node[] c = p.forwards;
        Node[] d = c;
        for (int i = levelCount - 1; i >= 0; i--) {
            int currentIdx = 0;
            do {
                int idx = findIdx(c[0], d[i].data);
                int diff = idx - currentIdx;
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        System.out.print("        ");
                    }
                }
                currentIdx = idx;
                if (d[i] != null) {
                    System.out.print(d[i].data + "-------");
                    currentIdx++;
                }
//                System.out.print((d[i] != null ? d[i].data : null) + "-------");
            } while (d[i] != null && (d = d[i].forwards)[i] != null);
            System.out.println();
            d = c;
        }
        System.out.println("-------------------------------------------------------------------");
    }

    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    public class Node {
        // data保存节点值
        private int data = -1;
        // forwards[]其实就是用来保存每层的next节点
        // forwards[0]表示这个节点在第0层的next节点
        private Node forwards[];
        private int maxLevel = 0;
        // 节点编号，仅用于美化输出跳表的格式，只记录第0层的节点
        private int idx = -1;
        public Node(int level) {
            // 生成一个几层的节点，就需要多长的forwards数组
            forwards = new Node[level];
            maxLevel = level;
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        SkipList2 list = new SkipList2();
        list.insert2(1);
        list.insert2(3);
        list.insert2(2);
        list.insert2(4);
        list.insert2(6);
        list.insert2(7);
        list.insert2(8);
        list.insert2(5);
        list.printAllBeautiful();
        list.delete(5);
        list.printAllBeautiful();
    }
}
