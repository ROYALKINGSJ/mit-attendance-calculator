import pandas as pd

df_1=pd.read_csv("Cereal.csv")
print("*"*50)
print("*"*50)
print("DataFrame 1 : ",df_1)
print("*"*50)
print("*"*50)




df_2 = pd.DataFrame(columns=["MIN","25%","MEDIAN","75%","MAX"])

row_list=['Calories', 'Protein (g)', 'Fat', 'Sodium', 'Dietary Fiber', 'Carbs', 'Sugars', 'Display Shelf', 'Potassium', 'Vitamins and Minerals', 'Serving Size Weight', 'Cups per Serving']

for item in row_list:
    df_2.loc[item]=df_1[item].describe()[['min','25%','50%','75%','max']].values

print("*"*50)
print("*"*50)
print("A : ",df_2)
print("*"*50)
print("*"*50)




# B APPLIED
for items in row_list:
    valid_mean=df_1[df_1[items]!=-1][items].mean()
    df_1[items]=df_1[items].replace(-1,valid_mean)
# B APPLIED

for items in row_list:
    df_2.loc[items]=(df_1[items]).describe()[['min','25%','50%','75%','max']].values
print("*"*50)
print("*"*50)
print("C : ",df_2,sep="\n")
print("*"*50)
print("*"*50)




# D APPLIED
for items in row_list:
    valid_median=df_1[(df_1[items]<=100) & (df_1[items]>=0)][items].median()
    df_1.loc[df_1[items]>100,items]=valid_median
# D APPLIED

for items in row_list:
    df_2.loc[items]=(df_1[items]).describe()[['min','25%','50%','75%','max']].values
print("*"*50)
print("*"*50)
print("E : ",df_1,sep="\n")
print("*"*50)
print("*"*50)
