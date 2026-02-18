import pandas as pd

df=pd.read_csv("Movies.csv")

highest_rating=df["Rating"].max()
print(df[df["Rating"] == highest_rating])

new_df=df["Language"]=="Hindi"
df[new_df].to_csv("HindiMovies.csv",index=False)
print("\nHindi movies data written to new 'HindiMovies.csv' file")
