#include <algorithm>
#include <iostream>
#include <fstream>
#include <cassert>
#include <vector>

using namespace std;


class AVLNode {
public:
    int data;
    int height;
    AVLNode* left;
    AVLNode* right;

    AVLNode(int data) : data(data), height(0), left(nullptr), right(nullptr) {}
    AVLNode(int data, AVLNode* left, AVLNode* right) : data(data), height(0), left(left), right(right) {
        UpdateHeight();
    }

    ~AVLNode() {
        if (left) delete left;
        if (right) delete right;
    }

    void PrintTree(const string& prefix = "", bool isLeft = true) const {
        if (right) {
            right->PrintTree(prefix + (isLeft ? "│   " : "    "), false);
        }

        cout << prefix << (isLeft ? "└── " : "┌── ") << data << endl;

        if (left) {
            left->PrintTree(prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    void ReassignValuesInOrder(int& currentValue) {
        if (left) left->ReassignValuesInOrder(currentValue);
        data = currentValue++;
        if (right) right->ReassignValuesInOrder(currentValue);
    }

    static int GetHeight(const AVLNode* node) {
        return node ? node->height : -1;
    }

    void UpdateHeight() {
        height = max(GetHeight(right), GetHeight(left)) + 1;
    }

    int CalcDiff() {
        return GetHeight(right) - GetHeight(left);
    }

    static AVLNode* RotateL(AVLNode* node) {
        if (!node || !node->right) return node;

        AVLNode* tmp = node->right;
        node->right = tmp->left;
        tmp->left = node;

        node->UpdateHeight();
        tmp->UpdateHeight();

        return tmp;
    }

    static AVLNode* RotateR(AVLNode* node) {
        if (!node || !node->left) return node;

        AVLNode* tmp = node->left;
        node->left = tmp->right;
        tmp->right = node;

        node->UpdateHeight();
        tmp->UpdateHeight();

        return tmp;
    }
    
    static AVLNode* Balance(AVLNode* node) {
        int diff = node->CalcDiff();
        if (diff < -1) {
            if (node->left && node->left->CalcDiff() > 0)
                node->left = RotateL(node->left);
            node = RotateR(node);
        } else if (diff > 1) {
            if (node->right && node->right->CalcDiff() < 0)
                node->right = RotateR(node->right);
            node = RotateL(node);
        }

        node->UpdateHeight();
        return node;
    }

    static AVLNode* Insert(AVLNode* node, int data) {
        if (!node) return new AVLNode(data);

        if (data < node->data) {
            node->left = Insert(node->left, data);
        } else {
            node->right = Insert(node->right, data);
        }

        return Balance(node);
    }

    static AVLNode* RemoveSmallest(AVLNode* node, int* data) {
        if (node == nullptr) return nullptr;

        if (node->left == nullptr) {
            node->height--;
            *data = node->data;
            AVLNode* tmp = node->right;
            delete node;
            return tmp;
        }

        node->left = RemoveSmallest(node->left, data);
        node = Balance(node);
        return node;
    }

    static AVLNode* Delete(AVLNode* node, int data) {
        if (!node) return nullptr;

        if (data < node->data) {
            node->left = Delete(node->left, data);
        }
        else if (data > node->data) {
            node->right = Delete(node->right, data);
        }
        else {
            if (!node->right) {
                AVLNode* tmp = node->left;
                delete node;
                return tmp;
            }

            node->right = RemoveSmallest(node->right, &node->data);
        }
        
        node = Balance(node);
        return node;
    }
};


void TestInsert() {
    AVLNode* root = nullptr;
    root = AVLNode::Insert(root, 10);
    assert(root != nullptr);
    assert(root->data == 10);
    assert(root->height == 0);

    root = AVLNode::Insert(root, 20);
    assert(root->right != nullptr);
    assert(root->right->data == 20);
    assert(root->height == 1);

    root = AVLNode::Insert(root, 5);
    assert(root->left != nullptr);
    assert(root->left->data == 5);
    assert(root->height == 1);

    root = AVLNode::Insert(root, 4);
    assert(root->left->left != nullptr);
    assert(root->left->left->data == 4);
    assert(root->height == 2);

    root = AVLNode::Insert(root, 15);
    assert(root->right->left != nullptr);
    assert(root->right->left->data == 15);
    assert(root->height == 2);
}

void TestRotations() {
    AVLNode* root = nullptr;
    root = AVLNode::Insert(root, 10);
    root = AVLNode::Insert(root, 20);
    root = AVLNode::Insert(root, 30); // Should trigger left rotation

    assert(root->data == 20);
    assert(root->left->data == 10);
    assert(root->right->data == 30);

    root = AVLNode::Insert(root, 5);
    root = AVLNode::Insert(root, 1); // Should trigger right rotation

    assert(root->data == 20);
    assert(root->left->data == 5);
    assert(root->left->left->data == 1);
    assert(root->left->right->data == 10);
}

void TestHeightAndBalance() {
    AVLNode* root = nullptr;
    root = AVLNode::Insert(root, 10);
    root = AVLNode::Insert(root, 20);
    root = AVLNode::Insert(root, 30);

    assert(root->height == 1);
    assert(root->CalcDiff() == 0);

    root = AVLNode::Insert(root, 5);
    root = AVLNode::Insert(root, 1);

    assert(root->height == 2);
    assert(root->CalcDiff() == -1);
}

void TestDelete() {
    AVLNode* root = nullptr;
    root = AVLNode::Insert(root, 10);
    root = AVLNode::Insert(root, 20);
    root = AVLNode::Insert(root, 5);
    root = AVLNode::Insert(root, 4);
    root = AVLNode::Insert(root, 15);

    // Delete leaf node
    root = AVLNode::Delete(root, 4);
    assert(root->left->left == nullptr);
    assert(root->height == 2);

    // Delete node with one child
    root = AVLNode::Delete(root, 5);
    assert(root->left->data == 10);
    assert(root->height == 1);

    // Delete node with two children
    root = AVLNode::Delete(root, 10);
    assert(root->data == 15);
    assert(root->left == nullptr);
    assert(root->right->data == 20);
    assert(root->height == 1);

    // Delete root node
    root = AVLNode::Delete(root, 15);
    assert(root->data == 20);
    assert(root->left == nullptr);
    assert(root->right == nullptr);
    assert(root->height == 0);

    // Delete last node
    root = AVLNode::Delete(root, 20);
    assert(root == nullptr);
}


void TestsA3() {
    AVLNode* root = nullptr;

    int toAdd[] = {5, 6, 9, 12, 13, 3, 8, 10, 11, 16, 15, 14, 4, 2, 1};
    for (int i = 0; i < 15; i++) {
        root = AVLNode::Insert(root, toAdd[i]);
        cout << "Inserted: " << toAdd[i] << endl;
        root->PrintTree();
        cout << endl;
    }

    int toRemove[] = {12, 8, 5, 4, 3, 6, 15, 14};
    for (int i = 0; i < 8; i++) {
        root = AVLNode::Delete(root, toRemove[i]);
        cout << "Deleted: " << toRemove[i] << endl;
        root->PrintTree();
        cout << endl;
    }
}


vector<AVLNode*> GetAllMinimal(int height, int min, int max) {
    if (height < 0) return {nullptr};
    if (height == 0) return {new(AVLNode)((min + max) / 2)};

    int val = (min + max + 1) / 2;

    vector<AVLNode*> result;

    for (AVLNode* left : GetAllMinimal(height - 1, min, val - 1)) {
        for (AVLNode* right : GetAllMinimal(height - 2, val + 1, max)) {
            result.push_back(new AVLNode(val, left, right));
        }
    }
    for (AVLNode* left : GetAllMinimal(height - 2, min, val - 1)) {
        for (AVLNode* right : GetAllMinimal(height - 1, val + 1, max)) {
            result.push_back(new AVLNode(val, left, right));
        }
    }

    return result;
}

vector<AVLNode*> GetAllMinimal(int height) {
    vector<AVLNode*> result = GetAllMinimal(height, 0, INT_MAX);
    for (AVLNode* node : result) {
        int currentValue = 1;
        node->ReassignValuesInOrder(currentValue);
    }
    return result;
}


int main() {
    // TestInsert();
    // TestRotations();
    // TestHeightAndBalance();
    // TestDelete();

    // TestsA3();

    ofstream outFile("A4-bäume.txt");
    streambuf* coutbuf = cout.rdbuf(); // Save old buf
    cout.rdbuf(outFile.rdbuf()); // Redirect cout to output.txt

    vector<AVLNode*> result = GetAllMinimal(4);
    cout << "Number of trees: " << result.size() << endl;
    for (AVLNode* node : result) {
        node->PrintTree();
        cout << endl;
    }

    cout.rdbuf(coutbuf); // Reset to standard output again

    return 0;
}