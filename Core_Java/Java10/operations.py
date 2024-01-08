import xml.etree.ElementTree as ET

# Parse the XML data
tree = ET.parse('c:/Users/MUDIT JAIN/OneDrive/Desktop/ISS Assignment/Java10/library.xml')
root = tree.getroot()

# Accessing elements
for book in root.findall('.//book'):
    title = book.find('title').text
    author = book.find('author').text
    year = book.find('published_year').text
    print(f'Title: {title}, Author: {author}, Year: {year}')

# Adding a new book
new_book = ET.Element('book')
new_title = ET.SubElement(new_book, 'title')
new_title.text = 'Advanced XML Techniques'
new_author = ET.SubElement(new_book, 'author')
new_author.text = 'Sandesh Jain'
new_year = ET.SubElement(new_book, 'published_year')
new_year.text = '2022'

# Adding the new book to the root
root.append(new_book)

# Saving the modified XML
tree.write('modified_library.xml')


# Updating the year of the first book
first_book = root.find('.//book[1]')
first_book.find('published_year').text = '2023'

# Saving the modified XML
tree.write('updated_library.xml')

# Deleting the second book
second_book = root.find('.//book[2]')
root.remove(second_book)

# Saving the modified XML
tree.write('reduced_library.xml')
