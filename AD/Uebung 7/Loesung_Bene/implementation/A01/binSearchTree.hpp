class binSearchTree {
    struct node {
        node *left  = nullptr;
        node *right = nullptr;
        int depth   = 0;
        int val;

        node(int);
        ~node();

        void insert(int);
        void swapNextInorder();
        void remove(int, node&);

        void inorderTreeLike(int);
        void inorder();
    };
    node *root = nullptr;


public:
    binSearchTree();
    ~binSearchTree();
    void insert(int val);
    void remove(int a);
    void inorder();
    void inorderTreeLike();
};
