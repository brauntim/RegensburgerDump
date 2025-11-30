class AVLBaum:
    def __init__(self, initial_value):
        self.value = initial_value
        self.smallerFollower = None
        self.largerFollower = None
        self.height = 1

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
                self.smallerFollower = AVLBaum(new_value)
            
            else:
                self.smallerFollower.insert_value(new_value)
        
        else:
            if (self.largerFollower is None):
                self.largerFollower = AVLBaum(new_value)
            
            else:
                self.largerFollower.insert_value(new_value)
    
    def calculate_height(self) -> int:
        height = 1

        if (self.smallerFollower):
            smaller_height = self.smallerFollower.calculate_height() + 1
        
        if (self.largerFollower):
            larger_height = self.largerFollower.calculate_height() + 1
        
        if (smaller_height > larger_height):
            height = smaller_height
        
        else:
            height = larger_height

        return height

    def get_balance(self) -> int:
        if self.smallerFollower and self.largerFollower:
            return self.largerFollower.height - self.smallerFollower.height

        elif self.smallerFollower:
            return - self.smallerFollower.height

        elif self.largerFollower:
            return self.largerFollower.height

        else:
            return 0
    
    def rotate_left():
        pass

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