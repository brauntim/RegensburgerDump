using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using System;
using System.Collections.Generic;
using System.Linq;

class BTreeNode {
    public int t;
    public List<int> data;
    public List<BTreeNode> children;

    public BTreeNode(int t) {
        this.t = t;
        data = new List<int>(t);
        children = new List<BTreeNode>(t + 1);
    }

    public (BTreeNode? l, int root, BTreeNode? r) Insert(int data) {
        // Find insertion index
        int i;
        for (i = 0; i < this.data.Count; i++) {
            if (data < this.data[i]) break;
        }

        // Insert into Leaf
        if (children.Count == 0) {
            this.data.Insert(i, data);
        }

        // Insert into child
        else {
            (BTreeNode? l, int root, BTreeNode? r) = this.children[i].Insert(data);
            if (l is not null && r is not null) {
                this.data.Insert(i, root);
                this.children[i] = l;
                this.children.Insert(i + 1, r);
            }
        }

        // Split if needed
        if (this.data.Count == t) {
            int idx = t / 2;
            int root = this.data[idx];

            BTreeNode r = new(t);
            r.data.AddRange(this.data.Skip(idx + 1));
            this.data.RemoveRange(idx, t - idx);
            if (this.children.Count > 0) {
                r.children.AddRange(this.children.Skip(idx + 1));
                this.children.RemoveRange(idx + 1, t - idx);
            }
            return (this, root, r);
        }
        return (null, -1, null);
    }

private string GetConnector(int mode) {
    if (mode == -1) return "┌─  ";
    if (mode == 0) return "├─  ";
    return "└─  ";
}

public void PrintTree(string prefix = "", int mode = 1) {
    if (this.children.Count == 0) {
        Console.WriteLine(prefix + GetConnector(mode) + string.Join(", ", this.data));
        return;
    }

    this.children[0].PrintTree(prefix + (mode < -1 ? "|   " : "    "), -1);
    Console.WriteLine(prefix + "┌─  " + this.data[0]);
    for (int i = 1; i < this.data.Count - 1; i++) {
        this.children[i].PrintTree(prefix + "|   ", 0);
        Console.WriteLine(prefix + "├─  " + this.data[i]);
    }
    if (this.children.Count > 1) {
        Console.WriteLine(prefix + "└─  " + this.data[this.data.Count - 1]);
    }
    this.children[this.children.Count - 1].PrintTree(prefix + (mode > 1 ? "|   " : "    "), 1);
}



    // void PrintTree(const string& prefix = "", bool isLeft = true) const {
    //     if (right) {
    //         right->PrintTree(prefix + (isLeft ? "│   " : "    "), false);
    //     }

    //     cout << prefix << (isLeft ? "└── " : "┌── ") << data << endl;

    //     if (left) {
    //         left->PrintTree(prefix + (isLeft ? "    " : "│   "), true);
    //     }
    // }

//    ┌─ 1
// ┌─ 2
// |  ├─ 3
// |  4
// |  └─ 5, 6
// 7
// |  ┌─ 8, 9
// └─ 10
//    ├─ 11
//    12
//    └─ 13

}

public class BTree {
    BTreeNode root;
    int t;

    public BTree(int t) {
        this.t = t;
        root = new BTreeNode(t);
    }

    public void Insert(int data) {
        (BTreeNode? l, int root, BTreeNode? r) = this.root.Insert(data);
        if (l is not null && r is not null) {
            BTreeNode newRoot = new(t);
            newRoot.data.Add(root);
            newRoot.children.Add(l);
            newRoot.children.Add(r);
            this.root = newRoot;
        }
    }

    public void PrintTree() {
        root.PrintTree();
    }
}

public static class Program {
    public static void Main() {
        BTree root = new(3);
        List<int> numbers = Enumerable.Range(1, 10).ToList();
        for (int i = 0; i < numbers.Count; i++) {
            root.Insert(numbers[i]);
            root.PrintTree();
            Console.WriteLine();
        }
    }
}