#Given a tuple of numbers, iterate through it and print only those numbers which are divisible by 5
#Bonus points if you can make the user enter their own tuple.

# Given tuple
num_tuple = (10, 20, 33, 46, 55, 100, 200, 1000)
print("Given list is ", num_tuple)

# Print elements that are divisible by 5
print("Elements that are divisible by 5:")
for num in num_tuple:
    if (num % 5 == 0):
        print(num)