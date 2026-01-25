def Calculator():
    num_1=int(input("ENTER THE FIRST NUMBER:"))
    num_2=int(input("ENTER THE SECOND NUMBER:"))

    print("Addition : ",num_1+num_2)
    print("Subtraction : ",num_1-num_2)
    print("Multiplication : ",num_1*num_2)
    if num_2!=0:
        print("Division : ",num_1/num_2)
    else:
        print("Division is not possible")

Calculator()