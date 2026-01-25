def Vowels_Consonants_Counter(s:str):
    vowels=0
    consonants=0
    vowels_list=["a","e","i","o","u"]
    print(s)
    s=s.lower()
    for char in s:
        if char.isalpha()==True:
            if char in vowels_list:
                vowels=vowels+1
            else:
                consonants=consonants+1
    print("Vowels : "+str(vowels)+"\nConsonants : "+str(consonants))

Vowels_Consonants_Counter(input("ENTER THE STRING:"))