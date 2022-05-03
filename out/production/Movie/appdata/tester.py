#create a dataset going from 1 to 1508 with the 2nd value being a random value between 1 and 17770, and the 3rd value being a random one precision float between 1 and 5

import random

def create_dataset():
    dataset = []
    for i in range(1,1508):
        #creates random numbers of current value of i
        for j in range(0,random.randint(1,25)):
            #pick a random number between 1 and 17770
            var = random.randint(1,17770)
            #create a one decimal float between 1 and 5
            var2 = random.uniform(1,5)
            var2 = round(var2, 1)
            if var2==5:
                #value between 4 and 5
                var2 = random.uniform(4,4.99)
            #create a tuple of the current value of i and the random number and the random one precision float
            dataset.append((i,var,var2))
    return dataset



#write into a file called dataset
def write_dataset_to_file(dataset):
    #Open a file called dataset.csv
    f = open('dataset', 'w')
    #Write the dataset
    for i in range(0,len(dataset)):
        f.write(str(dataset[i][0]) + ' ' + str(dataset[i][1]) + ' ' + str(dataset[i][2]) + '\n')
    #Close the file
    f.close()

write_dataset_to_file(create_dataset())


