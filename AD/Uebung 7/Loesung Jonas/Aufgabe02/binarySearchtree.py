class BinarySearchtree:
    def __init__(self, initial_value):
        self.value = initial_value
        self.smallerFollower = None
        self.largerFollower = None

    def is_smallestNode(self) -> bool:
        if self.smallerFollower == None:
            return True
        else:
            return False
    
    def is_largestNode(self) -> bool:
        if self.largerFollower == None:
            return True
        else:
            return False

    def insert_value(self, new_value):
        if (new_value <= self.value):
            if (self.smallerFollower is None):
                self.smallerFollower = BinarySearchtree(new_value)
            
            else:
                self.smallerFollower.insert_value(new_value)
        
        else:
            if (self.largerFollower is None):
                self.largerFollower = BinarySearchtree(new_value)
            
            else:
                self.largerFollower.insert_value(new_value)

    def delete_value(self, target: int):
        if target < self.value:
            if self.smallerFollower:
                self.smallerFollower = self.smallerFollower.delete_value(target)
            return self

        elif target > self.value:
            if self.largerFollower:
                self.largerFollower = self.largerFollower.delete_value(target)
            return self

        else:
            if self.smallerFollower is None and self.largerFollower is None:
                return None

            if self.smallerFollower is None:
                return self.largerFollower

            if self.largerFollower is None:
                return self.smallerFollower

            smallestSuccessor = self.largerFollower
            while smallestSuccessor.smallerFollower:
                smallestSuccessor = smallestSuccessor.smallerFollower

            self.value = smallestSuccessor.value
            self.largerFollower = self.largerFollower.delete_value(smallestSuccessor.value)

            return self