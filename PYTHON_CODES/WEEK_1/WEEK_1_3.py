def Odd_Sequence():
    even_sum=0
    for i in range(1,101):
        if i%2==0:
            even_sum=even_sum+i
        elif i%2!=0:
            print(i,end="\n")

    print("Even Numbers Sum : ",even_sum)

Odd_Sequence()