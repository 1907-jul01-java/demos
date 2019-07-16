# JavaScript
JavaScript is an object-oriented scripting language supported by most web browsers using an engine such as **V8** on Chrome and **SpiderMonkey** on Firefox. Source code is directly translated (and now JIT compiled as well) into instructions to be run by the browser. JavaScript is **loosely-typed** and supports **higher-order functions**.

## Features
* **Loose typing**: 
Variables in JavaScript are dynamically typed, and not constrained to one type. Any variable can be assigned and re-assigned values of any type.

* **Automatic Type Coercion**
JavaScript will attempt to coerce values of different types into a single, compatible type to evaluate expressions.

* **Object-Oriented**:
Objects are maps between keys and values, and the basis of most other complex data types in JavaScript. A *function* is an object which intrinsically returns something. An *array* is an object with a special relationship between enumerated keys and values.

* **Prototypical Inheritance**
Objects in JavaScript inherit properties not through is-a relationships with other object types but through a property that links another object: the prototype.

## JSON
JSON (**JavaScript Object Notation**) is a lightweight data format resembling JavaScript objects for simple exchange of data between different programming languages. It can be saved as a text file or sent through an HTTP payload. A JSON message either represents a key/value collection or an array of key/value collections.
#### exampleSingle.json
```json
{
    "id":7,
    "name":"Example Name"
}
```
#### exampleList.json
```json
[
    {
        "id":7,
        "name":"Example Name"
    },
    {
        "id":8,
        "name":"Another Example"
    }
]
```

## JSON Parse/Stringify
The `JSON` API in JavaScript can parse this into a proper Object using `JSON.parse('example.json')`, while `JSON.stringify(exampleObject)` will turn an object into a JSON string.
```javascript
// From string to object
let jsonString = `{"id":7, "name":"Example Name"}`;
let jsonObject = JSON.parse(jsonString);

// From object to string
let jsonObject = {id:7, name:'Example Name'};
let jsonString = JSON.stringify(jsonObject);
```