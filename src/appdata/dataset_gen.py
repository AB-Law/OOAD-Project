#Python file to create 17770 unique Clothing items and save them to a csv file
import random

def create_clothing_items():
    #Create a list of all the clothing items
    clothing_items = []
    #Create a list of all the clothing types
    clothing_types = ['Shirt', 'Pants', 'Shoes', 'T-Shirt', 'Jacket', 'Skirt', 'Dress', 'Belt', 'Socks']
    #Create a list of all the clothing colors
    clothing_colors = ['Black', 'Blue', 'Red', 'Green', 'Yellow', 'Purple', 'Orange', 'White', 'Gray', 'Pink', 'Brown']
    #Create a list of all the clothing sizes
    clothing_sizes = ['Small', 'Medium', 'Large', 'X-Large', 'XX-Large', 'XXXL']
    #Create a list of all the clothing materials
    clothing_materials = ['Cotton', 'Polyester', 'Leather', 'Silk', 'Wool', 'Nylon', 'Cotton', 'Polyester', 'Leather', 'Silk', 'Wool', 'Nylon']
    #Create a list of all the clothing styles
    clothing_styles = ['Casual', 'Formal', 'Sport', 'Casual', 'Formal', 'Sport', 'Casual', 'Formal', 'Sport', 'Casual', 'Formal', 'Sport']
    #Create a list of all the clothing prices

    gender = ["Male", "Female"]
    age_groups = ["0-18", "18-38", "38-58","58-78"]

    for i in range(0,17770):
        #Create a random clothing type
        clothing_type = random.choice(clothing_types)
        #Create a random clothing color
        clothing_color = random.choice(clothing_colors)
        #Create a random clothing size
        clothing_size = random.choice(clothing_sizes)
        #Create a random clothing material
        clothing_material = random.choice(clothing_materials)
        #Create a random clothing style
        clothing_style = random.choice(clothing_styles)
        if clothing_type == 'Skirt' or clothing_type == 'Dress':
            gen = gender[1]
        else:
            gen = random.choice(gender)
        age_group  = random.choice(age_groups)

        clothing_item =  clothing_color + ' ' + clothing_material + ' ' + clothing_size + ' ' + clothing_type  + ' ' + clothing_style + ',' + gen + ',' + age_group
        #Add the clothing item to the list
        clothing_items.append(clothing_item)
    #Return the list of clothing items
    return clothing_items


#write into a file called clothing_items numbers upto 17770, year and clothing_items
def write_clothing_items_to_file(clothing_items):
    #Open a file called clothing_items.csv
    f = open('clothing_items', 'w')
    #Write the clothing items
    for i in range(0,17770):
        f.write(str(i) + ',' + str(random.randint(1940,2021)) + ',' + clothing_items[i] + '\n')
    #Close the file
    f.close()

write_clothing_items_to_file(create_clothing_items())