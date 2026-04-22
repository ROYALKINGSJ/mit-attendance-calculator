import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

order_details_df=pd.read_csv("../DATA_FILE/northwind_order_details.csv")
orders_df=pd.read_csv("../DATA_FILE/northwind_orders.csv")

quantity_df=order_details_df.sort_values(by="quantity",ascending=False).head(5)
sns.barplot(x=quantity_df["product_id"],y=quantity_df["quantity"])
plt.show()

country_df=orders_df.groupby("ship_country")["order_id"].count().reset_index().sort_values(by="order_id",ascending=False).head(5)
sns.barplot(x=country_df["ship_country"], y=country_df["order_id"])
plt.show()

sns.lineplot(x=orders_df["order_date"],y=orders_df["freight"])
plt.show()

employee_df=orders_df.groupby("employee_id")["order_id"].count().reset_index().sort_values(by="order_id",ascending=False).head(5)
sns.barplot(x=employee_df["employee_id"],y=employee_df["order_id"])
plt.show()