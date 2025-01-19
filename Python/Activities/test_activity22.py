#Calculator Test
#Activity 21
#Using pytest:
#Create a new test file and write test to validate the following cases:
#Sum of two numbers
#Difference of two numbers
#Product of two numbers
#Quotient of two numbers
import pytest
import math
#Addition test
def test_addition():
    num1 = 10
    num2 = 20
    sum = num1+num2
    assert sum == 30
#Subtraction test
def test_subtraction():
    num1=50
    num2=10
    diff =num1-num2
    assert diff ==40

#Multiplication test
	
@pytest.mark.activity
def test_multiplication():
    num1 = 5
    num2 = 10
    prod = num1*num2
    assert prod == 50

#Division test
	
@pytest.mark.activity
def test_division():
    num1 = 100
    num2 = 5
    quot = num1/num2
    assert quot == 20
