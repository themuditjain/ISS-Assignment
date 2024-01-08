const jsonData = {
  "person": {
    "name": "Mudit Jain",
    "age": 22,
    "address": {
      "city": "Meerut",
      "state": "UP",
      "zip": "250002"
    },
    "emails": [
      "1muditjain1@gmail.com",
      "2muditjain2@gmail.com"
    ],
    "isStudent": false
  },
  "languages": ["JavaScript", "Python", "Java"],
  "hobbies": ["Photography", "Traveling", "Videography"]
};

// Accessing values
console.log("Person's name:", jsonData.person.name);
console.log("Second email:", jsonData.person.emails[1]);
console.log("First hobby:", jsonData.hobbies[0]);

// Modifying values
jsonData.person.age = 31;
jsonData.person.emails.push("mudit.jain2020@vitstudent.ac.in");
jsonData.hobbies.push("Coding");

// Deleting values
jsonData.person.emails.splice(1, 1);
jsonData.hobbies.pop();

// Display the modified data
console.log("Modified JSON data:", jsonData);

// Convert JSON data to a string
const jsonString = JSON.stringify(jsonData, null, 2);

// Save the JSON string to a file (Node.js example)
const fs = require('fs');
fs.writeFileSync('output.json', jsonString);

console.log('JSON data saved to output.json');
