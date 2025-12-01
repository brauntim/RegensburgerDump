class binSearchTree {
    struct node {
        node *left  = nullptr;
        node *right = nullptr;
        int val;

        node(int);
        ~node();

        void descendInPreOrder(int*, int*, int, int, int&);

        void insert(int);
        void swapNextInorder();
        void remove(int, node&);

        void inorderTreeLike(int);
        void inorder();
        void preorder();
    };
    node *root = nullptr;
    void fromInAndPreOrder(int*, int*, unsigned);

public:
    binSearchTree();
    binSearchTree(node*);
    ~binSearchTree();
    void insert(int val);
    void remove(int a);
    void inorder();
    void preorder();
    void inorderTreeLike();
    friend binSearchTree createTree(int*, int*, unsigned int);
};

binSearchTree createTree(int*, int*, unsigned int);
