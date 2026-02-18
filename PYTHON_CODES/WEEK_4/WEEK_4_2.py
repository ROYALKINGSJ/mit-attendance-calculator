import pandas as pd

df=pd.DataFrame({
    "Roll":[1,2,3,4,5,6,7,8,9,10],
    "Name":["Alice","Bob","Charlie","David","Eve","Frank","Grace","Henry","Ivy","Jack"],
    "Gender":["Female","Male","Male","Male","Female","Male","Female","Male","Female","Male"],
    "Marks 1":[85,90,95,80,88,92,94,22,87,91],
    "Marks 2":[35,92,94,82,85,90,93,80,86,90],
    "Marks 3":[90,91,93,85,87,21,91,84,85,92]
})

print(df)
print("*"*50)
df["Total Marks"]=df["Marks 1"] + df["Marks 2"] + df["Marks 3"]
print(df)
print("*"*50)
print("Lowest marks in Marks 1 : ",df["Marks 1"].min())
print("*"*50)
print("Highest marks in Marks 2 : ",df["Marks 2"].max())
print("*"*50)
print("Average marks in Marks 3 : ",df["Marks 3"].mean())
print("*"*50)
print("Student with highest total marks : ",df.loc[df["Total Marks"]==df["Total Marks"].max()],sep="\n")
print("*"*50)
print("Student with marks<40 in marks 2 : ",df.loc[df["Marks 2"]<40],sep="\n")