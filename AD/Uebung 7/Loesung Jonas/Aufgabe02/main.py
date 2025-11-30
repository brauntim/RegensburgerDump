from binarySearchtree import BinarySearchtree

def print_binarySearchtree(tree: BinarySearchtree, depth):
    if (tree.smallerFollower != None):
        print_binarySearchtree(tree.smallerFollower, depth + 1)
    
    for i in range(0, depth):
        print(" ", end="")
    print(tree.value)
    
    if (tree.largerFollower != None):
        print_binarySearchtree(tree.largerFollower, depth + 1)

def get_binarySearchtree_from_preAndInorder(preorder: list[int], inorder: list[int]):
    result = BinarySearchtree(preorder[0])

    for preorder_position in range(1, len(preorder)):
        result.insert_value(preorder[preorder_position])
    
    return result

def get_binarySearchtree_from_inAndPostorder(inorder: list[int], postorder: list[int]):
    if not inorder or not postorder:
        return None
    
    root = BinarySearchtree(postorder.pop())

    middle = inorder.index(root.value)

    left_inorder = inorder[:middle]
    right_inorder = inorder[middle+1:]

    left_postorder = postorder[:middle]
    right_postorder = postorder[middle+1:]

    root.smallerFollower = get_binarySearchtree_from_inAndPostorder(left_inorder, left_postorder)
    root.largerFollower = get_binarySearchtree_from_inAndPostorder(right_inorder, right_postorder)

    return root

def get_preorderList_from_binarySearchtree(root: BinarySearchtree) -> list[int]:
    result = [root.value]

    if root.smallerFollower is not None:
        result.extend(get_preorderList_from_binarySearchtree(root.smallerFollower))
    
    if root.largerFollower is not None:
        result.extend(get_preorderList_from_binarySearchtree(root.largerFollower))

    return result

def get_inorderList_from_binarySearchtree(root: BinarySearchtree) -> list[int]:
    result = []

    if root.smallerFollower:
        result.extend(get_inorderList_from_binarySearchtree(root.smallerFollower))

    result.append(root.value)

    if root.largerFollower:
        result.extend(get_inorderList_from_binarySearchtree(root.largerFollower))

    return result

def get_postorderList_from_binarySearchtree(root: BinarySearchtree) -> list[int]:
    result = []

    if root.largerFollower:
        result.extend(get_postorderList_from_binarySearchtree(root.largerFollower))
    
    if root.smallerFollower:
        result.extend(get_postorderList_from_binarySearchtree(root.smallerFollower))
    
    result.append(root.value)

    return result

def main():
    list = [6, 3, 2, 4, 5, 8, 7, 9, 10]
    tree = get_binarySearchtree_from_preAndInorder(list, list)

    other_list = get_preorderList_from_binarySearchtree(tree)
    print(other_list)

    other_list = get_inorderList_from_binarySearchtree(tree)
    print(other_list)

    other_list = get_postorderList_from_binarySearchtree(tree)
    print(other_list)

main()