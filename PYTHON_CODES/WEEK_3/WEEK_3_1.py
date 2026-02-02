import numpy as np
import random

sum_total=0
sum_row=[0,0,0,0]
arr=np.array([[0,0,0,0],[0,0,0,0],[0,0,0,0]])
#arr=np.array([[],[],[]])

for i in range(0,3):
    for j in range(0,4):
        arr[i][j]=random.randint(1,50)
        sum_total=sum_total+arr[i][j]
        sum_row[i]=sum_row[i]+arr[i][j]

print(np.mean(arr),np.median(arr),np.std(arr),sep="\n")
print("Sum Total : "+str(sum_total)+"\nSum Row : "+str(sum_row))

print(arr.reshape(2,6))