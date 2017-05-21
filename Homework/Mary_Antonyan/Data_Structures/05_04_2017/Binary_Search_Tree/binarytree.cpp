#include "binarytree.hpp"
#include <iostream>
#include <algorithm>

namespace Tree {
    BinaryTree::BinaryTree()
        : root(nullptr)
    {}

    BinaryTree::BinaryTree(const BinaryTree& orig) 
        : root(nullptr) 
    {}

    BinaryTree::~BinaryTree() {
        remove(root);
    }

    bool BinaryTree::isEmpty() const {
        return (nullptr == root);
    }

    void BinaryTree::insert(const int& value) {
        node* newNode = new node(value);
        root = sortedInsert(root, newNode);
    }

    node* BinaryTree::sortedInsert(node* root, node* newNode) {
        if (nullptr == root) {
            return newNode;
        }
        if (root->data > newNode->data) {   
            root->left = sortedInsert(root->left, newNode);
        } else {
            root->right = sortedInsert(root->right, newNode);
        }
        return root;
    }

    void BinaryTree::traverse(const node* start) const {
        if (nullptr == start) {
            return;
        }
        std::cout << start->data << std::endl;
        traverse(start->left);
        traverse(start->right);
    }

    void BinaryTree::remove(node* start) {
        if (nullptr == start) {
            return;
        }
        remove(start->left);
        remove(start->right);
        delete start;
    }

    void BinaryTree::traverse() const {
        traverse(root);
    }

    int BinaryTree::size(const node* start) const {
        if (isEmpty()) {
            return 0;
        }
        return (size(start->left) + size(start->right) + 1);
    }

    int BinaryTree::height(const node* start) const {
        if (isEmpty()) {
            return 0;
        }
        return (std::max(height(start->left),height( start->right)) + 1);
    }

    bool BinaryTree::find(const int& value) const {
        return find(root, value);
    }

    bool BinaryTree::find(const node* root, const int& value) const {
        if (nullptr == root) {
            return false;
        }

        if (root->data == value) {
            return true;
        }

        if (nullptr != root->left && find(root->left, value)) {
            return true;
        }

        if (nullptr != root->right && find(root->right, value)) {
            return true;
        }
        return false;
    }

    node* BinaryTree::balancedInsert(node* root, node* newNode) {
        if (nullptr == root) {
            return newNode;
        }

        if (height(root->left) > height(root->right)) {   
            root->left = sortedInsert(root->left, newNode);
        } else {
            root->right = sortedInsert(root->right, newNode);
        }
        return root; 
    }
}
