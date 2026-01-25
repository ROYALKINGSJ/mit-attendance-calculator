def Adder():
    element_1=input("ENTER ELEMENT 1 : ")
    element_2=input("ENTER ELEMENT 2 : ")
    try:
        print("SUM : ",float(element_1)+float(element_2))
    except ValueError:
        print("SUM : "+element_1+" "+element_2)
    
Adder()