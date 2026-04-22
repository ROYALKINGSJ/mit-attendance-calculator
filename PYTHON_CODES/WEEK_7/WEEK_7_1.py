import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

df=pd.read_csv("../DATA_FILE/sentiment_dataset.csv")

print(df.head(5))

print(df[df.columns[0]])
print(len(df))

df["text"]=df["text"].str.lower()
print(df["text"])

df["text_length"]=df["text"].str.len()

df["word_count"]=df["text"].str.split().str.len()

neutral=len(df[df["sentiment"]=="neutral"])
positive=len(df[df["sentiment"]=="positive"])
negative=len(df[df["sentiment"]=="negative"])

sns.barplot(x=["neutral","positive","negative"],y=[neutral,positive,negative])
plt.show()

print("Mean word count:", df["word_count"].mean())

print("Max word count row(s):\n", df.loc[df["word_count"]==df["word_count"].max()])

sns.histplot(df["word_count"])
plt.show()