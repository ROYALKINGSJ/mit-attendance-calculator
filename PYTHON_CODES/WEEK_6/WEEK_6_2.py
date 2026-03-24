import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns


df=pd.read_csv("Cereals.csv")
sugar_df=df.sort_values(by="sugars",ascending=False).head(5)


#Top sugary cereals (Bar chart)
sns.barplot(y=sugar_df["name"],x=sugar_df["sugars"])
plt.show()
#Top sugary cereals (Bar chart)


#Sugar vs Rating correlation (Scatter + regression)
sns.regplot(x=df["sugars"],y=df["rating"])
plt.show()
#Sugar vs Rating correlation (Scatter + regression)


#Manufacturer comparison (Boxplot)
sns.boxplot(x=df["mfr"],y=df["rating"])
plt.show()
#Manufacturer comparison (Boxplot)


#Correlation heatmap
heat_df=df.corr(numeric_only=True)
sns.heatmap(data=heat_df.corr(),annot=True)
plt.show()
#Correlation heatmap


#Hot vs Cold cereal comparison
sns.boxplot(x=df["type"],y=df["rating"])
plt.show()
#Hot vs Cold cereal comparison


#Fiber vs Rating relationship
sns.regplot(x=df["fiber"],y=df["rating"])
plt.show()
#Fiber vs Rating relationship


#Calories distribution
sns.histplot(x=df["calories"])
plt.show()
#Calories distribution