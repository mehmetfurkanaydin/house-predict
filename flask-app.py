#!/usr/bin/env python
# coding: utf-8

import pandas as pd
import numpy as np
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error, r2_score
from sklearn.datasets import load_boston
from sklearn.model_selection import train_test_split

boston_dataset = load_boston()
print(boston_dataset.keys())

bostondf = pd.DataFrame(boston_dataset.data, columns=boston_dataset.feature_names)
bostondf.head()

bostondf['MEDV'] = boston_dataset.target

features = ['LSTAT', 'RM']
target = bostondf['MEDV']

X = pd.DataFrame(np.c_[bostondf['LSTAT'], bostondf['RM']], columns = ['LSTAT','RM'])
Y = bostondf['MEDV']

X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 0.2, random_state=5)

lin_model = LinearRegression()
lin_model.fit(X_train, Y_train)

# model evaluation for training set
y_train_predict = lin_model.predict(X_train)
rmse = (np.sqrt(mean_squared_error(Y_train, y_train_predict)))
r2 = r2_score(Y_train, y_train_predict)

print("The model performance for training set")
print("--------------------------------------")
print('RMSE is {}'.format(rmse))
print('R2 score is {}'.format(r2))
print("\n")

# model evaluation for testing set
y_test_predict = lin_model.predict(X_test)
rmse = (np.sqrt(mean_squared_error(Y_test, y_test_predict)))
r2 = r2_score(Y_test, y_test_predict)

print("The model performance for testing set")
print("--------------------------------------")
print('RMSE is {}'.format(rmse))
print('R2 score is {}'.format(r2))

from flask import Flask
app = Flask(__name__)

from pymongo import MongoClient
client = MongoClient()
col = client['swift_demo']['house_prices']
from bson.objectid import ObjectId

@app.route('/predict/<houseId>')
def hello_world(houseId):
    founded = col.find_one({'_id': ObjectId(houseId)})
    X_bla = pd.DataFrame(np.c_[founded['LSTAT'], founded['RM']], columns = ['LSTAT','RM'])
    y_train_predict_bla = lin_model.predict(X_bla)
    return str(round(y_train_predict_bla[0],2))

if __name__ == '__main__':
   app.run()

