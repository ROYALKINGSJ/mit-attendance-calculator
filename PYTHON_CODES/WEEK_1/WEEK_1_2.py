def Check_For_Prime(a:int):
    if a <= 1:
        return False
    else:
        divisible_by=2
        for i in range(2,int(a/2)+1):
            if a%i==0:
                divisible_by=divisible_by+1
        if divisible_by==2:
            return True
        else:
            return False

num=int(input("ENTER THE NUMBER TO CHECK FOR PRIME:"))
print(Check_For_Prime(num))