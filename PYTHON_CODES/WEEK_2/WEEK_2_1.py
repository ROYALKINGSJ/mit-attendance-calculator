n=int(input("Enter how many numbers : "))

list_of_numbers=[]
sum=0

for i in range(0,n):
    number_to_append=int(input("ENTER THE NUMBER:"))
    sum=sum+number_to_append
    if len(list_of_numbers)==0:
        list_of_numbers.append(number_to_append)
    elif len(list_of_numbers)==1:
        if number_to_append>list_of_numbers[0]:
            list_of_numbers.append(number_to_append)
        else:
            list_of_numbers.insert(0,number_to_append)
    else:
        if number_to_append<=min(list_of_numbers):
            list_of_numbers.insert(0,number_to_append)
        elif number_to_append>=max(list_of_numbers):
            list_of_numbers.append(number_to_append)
        else:
            for i in range(0,len(list_of_numbers)):
                if list_of_numbers[i]>number_to_append:
                    list_of_numbers.insert(i,number_to_append)
                    break

special_num=int(input("Enter the special number whose occurence to find : "))

print("Largest Number : ",list_of_numbers[n-1])
print("Smallest Number : ",list_of_numbers[0])
print("Sum : ",sum)
print("Average : ",sum/len(list_of_numbers))
print("Number of Special Number Occurence : ",list_of_numbers.count(special_num))