n=int(input("How many Elements : "))
dict={}
country_list=[]
wins_list=[]

for i in range(0,n):
    year=int(input("Enter Year "+str(i+1)+" : "))
    country=input("Enter Country "+str(i+1)+" : ")
    print("*"*50)
    if country not in country_list:
        country_list.append(country)
        wins_list.insert(country_list.index(country),1)
    elif country in country_list:
        wins_list[country_list.index(country)]=wins_list[country_list.index(country)]+1

print("*"*50)
print("Best Performing Country : ",country_list[wins_list.index(max(wins_list))]," with "+str(max(wins_list))+" wins")
print("*"*50)
print("Unique Country List : ",country_list)