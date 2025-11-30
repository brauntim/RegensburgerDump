from binarySearchtree import BinarySearchtree

def get_binarySearchtree_from_values(values: list[int]) -> BinarySearchtree:
    if len(values) > 0:
        result = BinarySearchtree(values[0])

        for position in range(1, len(values)):
            result.insert_value(values[position])
        
        return result
    
def print_binarySearchtree(tree: BinarySearchtree, depth):
    if (tree.smallerFollower != None):
        print_binarySearchtree(tree.smallerFollower, depth + 1)
    
    for i in range(0, depth):
        print(" ", end="")
    print(tree.value)
    
    if (tree.largerFollower != None):
        print_binarySearchtree(tree.largerFollower, depth + 1)

def get_preorderList_from_binarySearchtree(root: BinarySearchtree) -> list[int]:
    result = [root.value]

    if root.smallerFollower is not None:
        result.extend(get_preorderList_from_binarySearchtree(root.smallerFollower))
    
    if root.largerFollower is not None:
        result.extend(get_preorderList_from_binarySearchtree(root.largerFollower))

    return result

def main ():
    values = [50, 20, 100, 75, 70, 80, 125, 120, 130]
    tree = get_binarySearchtree_from_values(values)

    tree.delete_value(100)

    print_binarySearchtree(tree, 0)

    print("")

    tree.delete_value(20)
    print_binarySearchtree(tree, 0)

    print("")

    tree.delete_value(50)
    print_binarySearchtree(tree, 0)

main()