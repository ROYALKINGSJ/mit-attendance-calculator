import numpy as np
from random import randint

arr_1=np.array([[0,0,0],[0,0,0],[0,0,0]])
arr_2=np.array([[0,0,0],[0,0,0],[0,0,0]])

for i in range(0,3):
    for j in range(0,3):
        arr_1[i][j]=randint(1,100)
        arr_2[i][j]=randint(1,100)

print("Array 1 : "+arr_1.__str__())
print("Array 2 : "+arr_2.__str__())

print("*"*50)

print("Addition : "+(arr_1+arr_2).__str__())
print("Subtraction : "+(arr_1-arr_2).__str__())
print("Multiplication(element-wise) : "+(arr_1*arr_2).__str__())
print("Multiplication(dot product) : "+(arr_1.dot(arr_2)).__str__())
print("Transpose : "+(arr_1.transpose()).__str__())
print("Determinant : "+(np.linalg.det(arr_1)).__str__())

if (np.linalg.det(arr_1))!=0:
    print("Inverse : "+(np.linalg.inv(arr_1)).__str__())
else:
    print("Error in calculating inverse of matrix")