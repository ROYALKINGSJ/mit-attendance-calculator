n1=int(input("Enter Number of Elements for Set 1 : "))
n2=int(input("Enter Number of Elements for Set 2 : "))

s1=set()
s2=set()

for i in range(0,n1):
    s1.add(int(input("Enter Element "+str(i+1)+" for Set 1 : ")))

for i in range(0,n2):
    s2.add(int(input("Enter Element "+str(i+1)+" for Set 2 : ")))

print("Union : ",s1.union(s2))
print("Intersection : ",s1.intersection(s2))
print("Difference : ",s1.difference(s2))
print("Symmetric Difference : ",s1.symmetric_difference(s2))