
class BTreeNode {
    public int t;
    public List<int> data;
    public List<BTreeNode> children;

    public BTreeNode(int t) {
        this.t = t;
        data = new List<int>(t);
        children = new List<BTreeNode>(t + 1);
    }

    public void PrintTree(string prefix = "", int mode = 1) {
        string connector = mode == -1 ? "┌─  " : (mode == 0 ? "├─  " : "└─  ");
        string branchUp = mode < 1 ? "|   " : "    ";
        string branchDown = mode > -1 ? "|   " : "    ";

        if (this.children.Count == 0) {
            Console.WriteLine(prefix + connector + string.Join(", ", this.data));
            return;
        }

        this.children[0].PrintTree(prefix + branchDown, -1);
        Console.WriteLine(prefix + connector + this.data[0]);
        for (int i = 1; i < this.children.Count - 1; i++) {
            this.children[i].PrintTree(prefix + branchUp, 0);
            Console.WriteLine(prefix + branchUp + this.data[i]);
        }
        this.children[this.children.Count - 1].PrintTree(prefix + branchUp, 1);
    }

    public (BTreeNode? l, int root, BTreeNode? r) Insert(int data) {
        // Find insertion index
        int i = this.data.FindIndex(d => d >= data);
        if (i == -1) i = this.data.Count;

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

    private int FindSmallest() =>
        this.children.Count == 0 ? this.data[0] : this.children[0].FindSmallest();

    public void Delete(int data, BTreeNode? parent, int idxInParent) {
        // Find deletion index
        int i = this.data.FindIndex(d => d >= data);
        if (i == -1) i = this.data.Count;
        bool isEqual = i < this.data.Count && this.data[i] == data;


        // Delete from leaf
        if (this.children.Count == 0) {
            // Item was not found, nothing to delete
            if (!isEqual) return;

            this.data.RemoveAt(i);
        }

        // Replace with inorder successor and delete
        else if (isEqual) {
            int successor = this.children[i+1].FindSmallest();
            this.data[i] = successor;
            this.children[i+1].Delete(successor, this, i+1);
        }

        // Delete from child
        else {
            this.children[i].Delete(data, this, i);
        }


        // Node has enough elements
        int minChildren = (t - 1) / 2;
        if (this.data.Count >= minChildren) return;


        // Move or union
        if (parent is null) return;
        
        // Right child exists
        if (idxInParent < parent.children.Count - 1 &&
                parent.children[idxInParent + 1].data.Count > minChildren) {
            BTreeNode rightChild = parent.children[idxInParent + 1];

            int successorData = rightChild.data[0];
            rightChild.data.RemoveAt(0);

            if (this.children.Count > 0) {
                this.children.Add(rightChild.children[0]);
                rightChild.children.RemoveAt(0);
            }

            this.data.Add(parent.data[idxInParent]);
            parent.data[idxInParent] = successorData;

            return;
        } 

        // Left child exists
        if (idxInParent > 0 &&
                parent.children[idxInParent - 1].data.Count > minChildren) {
            BTreeNode leftChild = parent.children[idxInParent - 1];

            int predecessorData = leftChild.data[leftChild.data.Count - 1];
            leftChild.data.RemoveAt(leftChild.data.Count - 1);

            if (this.children.Count > 0) {
                this.children.Insert(0, leftChild.children[leftChild.children.Count - 1]);
                leftChild.children.RemoveAt(leftChild.children.Count - 1);
            }

            this.data.Insert(0, parent.data[idxInParent - 1]);
            parent.data[idxInParent - 1] = predecessorData;

            return;
        }

        // Move merge index left if right does not exist
        if (idxInParent == parent.children.Count - 1) {
            idxInParent--;
        }

        // Merge idx and idx+1
        parent.children[idxInParent].data.Add(parent.data[idxInParent]);
        parent.children[idxInParent].data.AddRange(parent.children[idxInParent + 1].data);
        parent.children[idxInParent].children.AddRange(parent.children[idxInParent + 1].children);
        parent.data.RemoveAt(idxInParent);
        parent.children.RemoveAt(idxInParent + 1);
    }
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

    public void Delete(int data) {
        this.root.Delete(data, null, -1);
        if (this.root.data.Count == 0 && this.root.children.Count > 0) {
            this.root = this.root.children[0];
        }
    }

    public void PrintTree() {
        root.PrintTree();
    }
}

public static class Program {
    public static void Main() {
        Console.OutputEncoding = System.Text.Encoding.GetEncoding(65001);
        Console.InputEncoding  = System.Text.Encoding.GetEncoding(65001);

        Random r = new(0); // Seed 0 for reproducibility

        List<int> numbers = Enumerable.Range(1, 50).ToList();
        List<int> shuffled = numbers.OrderBy(x => r.Next()).ToList();
        List<int> toDelete = shuffled.OrderBy(x => r.Next()).Take(30).ToList();

        BTree root = new(3);
        for (int i = 0; i < shuffled.Count; i++) {
            Console.WriteLine("\nInserting: " + shuffled[i]);
            root.Insert(shuffled[i]);
            root.PrintTree();
        }
        for (int i = 0; i < toDelete.Count; i++) {
            Console.WriteLine("\nDeleting: " + toDelete[i]);
            root.Delete(toDelete[i]);
            root.PrintTree();
        }
    }
}