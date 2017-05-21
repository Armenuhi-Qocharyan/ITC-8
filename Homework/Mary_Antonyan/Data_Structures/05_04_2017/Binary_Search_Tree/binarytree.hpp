#ifndef BINARYTREE_HPP
#define BINARYTREE_HPP

namespace Tree {
    struct node {
        int data;
        node* left;
        node* right;
        node(int value) : data (value), left(nullptr), right(nullptr) {}
    };

    class BinaryTree {
        public:
            BinaryTree();
            BinaryTree(const BinaryTree& orig);
            virtual ~BinaryTree();
            bool isEmpty() const;    
            int size(const node* start) const;
            int height(const node* start) const;
            void remove(node* start);
            void insert(const int& value);
            void traverse() const;
            bool find(const int& value) const;

        private:
            node* root;   
            node* sortedInsert(node* root, node* newNode);
            node* balancedInsert(node* root, node* newNode);
            bool find(const node* root, const int& value) const;
            void traverse(const node* start) const;
    };
}

#endif
