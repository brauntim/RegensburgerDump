
#include <iostream>
#include <cassert>
#include <algorithm>

class BSTNode {
public:
    int data;
    BSTNode* left;
    BSTNode* right;

    BSTNode(int data) {
        this->data = data;
        this->left = this->right = nullptr;
    }

    static BSTNode* Insert(BSTNode* node, int data) {
        if (node == nullptr) {
            return new BSTNode(data);
        }

        if (data < node->data) {
            node->left = Insert(node->left, data);
        }
        else {
            node->right = Insert(node->right, data);
        }
        return node;
    }

    void Delete() {
        if (this->left) this->left->Delete();
        if (this->right) this->right->Delete();
        delete this;
    }

    static BSTNode* Delete(BSTNode* node, int data) {
        if (node == nullptr) return nullptr;

        // Incorrect Branch
        if (data < node->data) {
            node->left = Delete(node->left, data);
            return node;
        }
        else if (data > node->data) {
            node->right = Delete(node->right, data);
            return node;
        }

        // Only left or right branch
        if (node->left == nullptr) {
            BSTNode* tmp = node->right;
            delete node;
            return tmp;
        }
        else if (node->right == nullptr) {
            BSTNode* tmp = node->left;
            delete node;
            return tmp;
        }

        // Get successor
        BSTNode* parent = node;
        BSTNode* smallest = node->right;
        while (smallest->left) {
            parent = smallest;
            smallest = smallest->left;
        }

        // Move successor up and delete node
        node->data = smallest->data;
        if (parent->left == smallest) {
            delete parent->left;
            parent->left = nullptr;
        }
        else {
            delete parent->right;
            parent->right = nullptr;
        }
        return node;
    }

    // Funktioniert mit inorder und postorder gespiegelt gleich.
    static BSTNode* BuildTree(int preorder[], int inorder[], int count) {
        if (count <= 0)
            return nullptr;

        BSTNode* node = new BSTNode(preorder[0]);
        int split = std::distance(inorder, std::find(inorder, inorder + count - 1, preorder[0]));
        
        node->left = BuildTree(preorder + 1, inorder, split);
        node->right = BuildTree(preorder + 1 + split, inorder + 1 + split, count - split - 1);
        return node;
    }
};



void testInsert() {
    BSTNode* root = nullptr;
    root = BSTNode::Insert(root, 10);
    root = BSTNode::Insert(root, 5);
    root = BSTNode::Insert(root, 15);
    root = BSTNode::Insert(root, 3);
    root = BSTNode::Insert(root, 7);

    assert(root->data == 10);
    assert(root->left->data == 5);
    assert(root->right->data == 15);
    assert(root->left->left->data == 3);
    assert(root->left->right->data == 7);

    root->Delete();
}

void testDelete() {
    BSTNode* root = nullptr;
    root = BSTNode::Insert(root, 10);
    root = BSTNode::Insert(root, 5);
    root = BSTNode::Insert(root, 15);
    root = BSTNode::Insert(root, 3);
    root = BSTNode::Insert(root, 7);

    root = BSTNode::Delete(root, 5);
    assert(root->left->data == 7);
    assert(root->left->left->data == 3);

    root = BSTNode::Delete(root, 10);
    assert(root->data == 15);

    root->Delete();
}

void testBuildTree() {
    int preorder[] = {10, 5, 3, 7, 15};
    int inorder[] = {3, 5, 7, 10, 15};
    BSTNode* root = BSTNode::BuildTree(preorder, inorder, 5);

    assert(root->data == 10);
    assert(root->left->data == 5);
    assert(root->right->data == 15);
    assert(root->left->left->data == 3);
    assert(root->left->right->data == 7);

    root->Delete();
}

int main() {
    testInsert();
    testDelete();
    testBuildTree();
    std::cout << "All tests passed!" << std::endl;
    return 0;
}