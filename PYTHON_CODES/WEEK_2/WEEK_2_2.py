element_1=input("ENTER ELEMENT 1 : ")
element_2=input("ENTER ELEMENT 2 : ")
element_3=input("ENTER ELEMENT 3 : ")
element_4=input("ENTER ELEMENT 4 : ")
element_5=input("ENTER ELEMENT 5 : ")

tup=(element_1,element_2,element_3,element_4,element_5)

try:
    tup[0]=50
except:
    TypeError

print("TypeError: 'tuple' object does not support item assignment")