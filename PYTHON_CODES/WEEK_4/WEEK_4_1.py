import pandas as pd
import random

def random_value_gen():
    return random.randint(1,100)

lst=[]

for i in range(7):
    lst.append(random_value_gen())

sr=pd.Series(lst,index=["Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"])

print("lst : ",lst)
print("*"*50)
print("Average temperature : ",sr.mean())
print("*"*50)
print("Min & Max temperature : ",sr.loc[sr==sr.min()],sr.loc[sr==sr.max()],sep=" \t\t ")
print("*"*50)
print("Temperatures greater than 38 : ",sr.loc[sr>38])
print("*"*50)
print("Temp in farenheit : ",(sr*(9/5)) + 32)
print("*"*50)
print("Temp greater than avg : ",sr.loc[sr>sr.mean()])