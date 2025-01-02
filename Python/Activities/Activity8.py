#Given a list of numbers, return True if first and last number of a list is same.
# Given list of numbers
numList = [10, 20, 30, 50, 10]
print("Given list is ", numList)
 
# Get first element in list
firstElement = numList[0]
# Get last element in list
lastElement = numList[-1]
 
# Check if first and last element are equal
if (firstElement == lastElement):
    print(True)
else:
    print(False)