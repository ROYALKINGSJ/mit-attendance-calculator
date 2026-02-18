import pandas as pd

df_1=pd.read_csv("Cereal.csv")

df_2 = pd.DataFrame(columns=["MIN","Q1","MEDIAN","Q3","MAX"])
# print(df_2)

# data_buffer = []

row_list=['Calories', 'Protein (g)', 'Fat', 'Sodium', 'Dietary Fiber', 'Carbs', 'Sugars', 'Display Shelf', 'Potassium', 'Vitamins and Minerals', 'Serving Size Weight', 'Cups per Serving']

for item in row_list:
    df_2.loc[item]=[df_1[item].min(),
                      df_1[item].quantile(0.25),
                      df_1[item].median(),
                      df_1[item].quantile(0.75),
                      df_1[item].max()
                      ]
# print(df_2)
print("\n")
for var_1,var_2 in df_2.head(3).iterrows():
    print(var_1)
    # print("\n")
    print(var_2["MIN"])
    print("\n\n")
