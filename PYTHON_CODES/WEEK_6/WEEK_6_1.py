import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt


df=pd.read_csv("mtcars.csv")
df.drop("model",axis=1,inplace=True)


# #What influences fuel efficiency (mpg)?
sns.heatmap(data=df.corr(),annot=True)
plt.title("Correlation Heatmap")
plt.show()
#What influences fuel efficiency (mpg)?


#How design choice affects performance
sns.regplot(x=df["cyl"],y=df["hp"])
plt.title("Design Choice VS Performance(HP)")
plt.show()

sns.regplot(x=df["vs"],y=df["hp"])
plt.title("Design Choice VS Performance(HP)")
plt.show()


sns.regplot(x=df["cyl"],y=df["qsec"])
plt.title("Design Choice VS Performance(QSEC)")
plt.show()

sns.regplot(x=df["vs"],y=df["qsec"])
plt.title("Design Choice VS Performance(QSEC)")
plt.show()
#How design choice affects performance


#Whether manual cars are more efficient?
sns.boxplot(x=df["am"],y=df["mpg"])
plt.xticks([0,1],["Automatic","Manual"])
plt.title("Manual/Automatic VS MPG")
plt.show()
#Whether manual cars are more efficient?


#Trade-offs between power and efficiency?
sns.regplot(x=df["hp"],y=df["mpg"])
plt.title("Power VS Efficiency")
plt.show()
#Trade-offs between power and efficiency?