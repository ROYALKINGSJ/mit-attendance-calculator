word_dict={}
sentence=input("Enter Your Sentence : ")

sentence=sentence.split(" ")

for word in sentence:
    if word not in word_dict:
        word_dict[word]=1
    else:
        word_dict[word]=word_dict[word]+1

print(word_dict)


