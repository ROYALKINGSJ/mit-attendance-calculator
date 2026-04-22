import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

df=pd.read_csv("../DATA_FILE/ipl.csv")

score_df=df.sort_values(by="Runs",ascending=False).head(5)
sns.barplot(x=score_df["Player"],y=score_df["Runs"])
plt.show()

match_df=df.sort_values(by="Winner",ascending=False).head(5)
sns.barplot(x=match_df["Player"],y=match_df["Winner"])
plt.show()

sns.boxplot(x=df["batting order"],y=df["Average"])
plt.show()

strike_df=df.sort_values(by="StrikeRate",ascending=False).head(10)
sns.barplot(x=strike_df["Player"],y=strike_df["StrikeRate"])
plt.show()

extras_by_team = df.groupby('bowling_team')['extras'].sum().sort_values(ascending=False)
sns.barplot(x=extras_by_team.index, y=extras_by_team.values)
plt.show()
