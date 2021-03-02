import pickle
import pandas as pd
import sys


#Funzione per leggere il modello dal file
def readModel():
    read_file = open('model.obj', 'rb')
    model = pickle.load(read_file)
    return model

model = readModel()

answers = {sys.argv[1], sys.argv[2], sys.argv[3], sys.argv[4], sys.argv[5]}
predictions = []
probabilities = []

i = 0

for answer in answers:
    predictions.append(
        model.predict(pd.DataFrame({'answer' : [answer]}))
    )
    prediction_frame = pd.DataFrame(predictions[i])
    data_frame = pd.DataFrame({'char1' : [prediction_frame.loc[0, 'char1']],
                               'char2' : [prediction_frame.loc[0, 'char2']],
                               'char3' : [prediction_frame.loc[0, 'char3']],
                               'answer' : [answer]})
    probabilities.append(
        model.predict_probability(data_frame)
    )
    i += 1

results = pd.DataFrame(predictions)

print(results.loc[0, 'genre'])




