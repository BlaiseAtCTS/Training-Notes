# Javascript Notes
Only 1 integer type: Number,
NaN(Not a Number) is Number type :\
'var' is the old way of using variables, now we use let and const.

<table>
<tr><th>Type</th><th>Stored as</th></tr>
<tr><td>Primitive (e.g., number, string, boolean)</td>Value</td></tr>
<tr><td>Reference (e.g., array, object, function)</td><td>Reference</td></tr>
</table>

### Strings:
Cant change single character in a string.
Properties dont have paranthesis. Eg. string.length
#### Methods:
Methods have paranthesis. Eg. let result = string.toUpperCase() (this is non destructive, doesnt change original string)
string.trim() is also non destructive.
string.split(",") -> returns an array

#### Methods with arguments:
.indexOf('a') --> returns first occurence, returns -1 if value not present
.slice(), .replace()

##### String Literals:
Instead of doing: "Price: " + 10 + 20 +"rs."
We can do `Price: ${10 + 20}rs.` --> Need to use 'back tick and $'.

### Null and Undefined:
Null: Intentional absence of data.
Undefined: Variables that dont have an assigned value.

### Math Object:
Contains properties and methods for maths.
Math.PI
Math.floor(23.999) = 23, Math.ceil(23.01) = 24, Math.random() -> give number from 0 to before 1.
Math.round(), Math.pow(), Math.abs()

### Console:
console is an object which has many methods like log(), warn().
There is also alert(), prompt() -> takes input as a string.

### parse:
parseInt("101adsd") -> 101

### Truthy or Falsy:
All js elements are inherently true or false.
Falsy values: false, 0, "", null, undefined, Nan.

### Arrays:
typeOf(array) -> object
Can have multiple variable types.
Mutable.
#### Spread operator:
```
const fruits = ['apple', 'mango'];
const moreFruits = [...fruits, 'pineapple'];
console.log(moreFruits) -> ['apple', 'mango', 'pineapple'];
```
#### Array methods:
.push("") -> end of array, .pop() -> gives last element and removes it, .shift() -> pops element from front, .unshift() -> push in front.
arr1.concat(arr2), arr1.includes(""), arr1.indexOf("").
arr1.reverse() --> destructive method
.slice(3) -> get elements from index 3 to last.
.splice() -> destructive (start index, number of elements to delete after it), can also use it to insert in array like: .splice(2, 0, "value").
arr.sort() -> sorts based on UTF-16 code (not reliable for numberic values), destructive.
arr.toString()
arr.join() -> returns string
arr.includes(3) --> like contains in Java
arr.filter((elem) => {return true}) --> uses a predicate(a function which checks and return true or false). This filter will return the same arr.
arr.filter((elem) => {return elem%2==0}) --> filtering and returning only the even number.
arr.find((elem) => {return elem%2==0}) --> returns 1st element which satisfies the condition.
arr.some((elem) => {return elem%2==0}) --> returns true if there are some elements that satisfy the condition.
arr.every((elem) => {return elem%2==0}) --> returns true if every element satisfies the condition.
arr.map((elem) => {return 1}) --> uses a callback function. All values in arr is changed to 1 and returned. Changes the given array unlike filter which just checks a condition.
arr.reduce()
#### map method:
```
Similar to forEach,
const movies = [
    {
        title: '2012',
        rating: 8
    },
    {
        title: 'Superman',
        rating: 10
    }
]
const titles = movies.map(funtion(movie) { ---> this is called a callback function
    return movie.title;
})
```

### Call back function:
A function to execute for each element in the array. Its return value is added as a single element in the new array.

### Memory:
There is a max amount of numbers that can be stored in one number. Eg. .99999999999999 -> 1
Arrays dont have this limit. Eg. let arr = [1, 2, 3] -> arr holds a reference to [1, 2, 3]. So when you do arr2 = [1, 2, 3] -> this arr2 references a new address in memory. So arr === arr2 -> false. If you instead do let arr2 = arr -> both share same reference.
When using const arr -> has it holds reference, we can still push in array.

### Object (Collections):
```const data = { Name: "Hugo" };```
Property = Key : Value
Can have different variable types inside.
Accessing Object Elements: data.Name or data["Name"];
```Object.values(data) -> will give all the values as an array``` --> can add .length to get size
Cant use .length property for objects.
All keys are automatically converted to string, except Symbols.
```
const time = { 1990: true };
time[1990] -> 1990 is converted to string first(because it cant be a variable with number starting first).
const data = { name: "Hugo" };
data[name] -> doesnt work (because js searching for a variable)
data["name"] -> works
data.name -> looks for a key
data["na" + "me"] -> works
```

### For loop:
Can also do: for(sub of subreddits)
syntax: for(varialbe of iterable)
Arrays are iterable.
Objects are not iterables -> use for(sub in subreddits)
#### For each:
```
const arr = [1, 2, 3];
arr.forEach(function(element) { --> can get index with function(element, index)
    console.log(element);
})
```

### Functions:
```
function greet(person){
    console.log(`Hello ${person}`);
}
```
```
let add = function(x, y) { -> parameters
    return x + y;
}
add(2, 2); -> arguments
```
Functions are values in js, they can be sent as arguments etc.
#### Block Scope:
When declaring a variable inside an conditional or loop with 'let' keyword, it cant be used outside of the block. if you use 'var', we can use it outside the block.

### This:
Arrow functions dont have 'this'.
```
const cat = {
    name: 'Blue',
    meow() {
        console.log(name) -> wont work, name is searched as a variable.
        console.log(this=.name) -> works
    }
}
```
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/this
```
Example 1:
const cat = {
    name: 'Blue',
    color: 'grey',
    meow: () => console.log(`This is ${this}`)
}
cat.meow(); -> returns the object left of '.' (which is 'cat') Output: This is {name: 'Blue', color: 'grey', meow: f}

Example 2:
const meow2 = cat.meow();
meow2() / window.meow2() -> Output: This is Window {}
```
#### By default, all commands use window object. Like alert(), prompt() etc actually use window.alert()

### Set:
set operations are O(1).
const seen = new Set();
seen.has(n)
seen.add(n)

### Hashmap:
O(1).
Key can be any type, unline Objects where keys are only strings.
map.set(key, value)
map.get(key)
map.delete(key)
map.has(key)
Iteration: map.forEach() / for(n of map)

### DOM:
Html + Css goes in and js objects come out. The relation between different html elements liked div inside another div is captured by a tree structure in js. The root of the tree is Document Object (similar to window).
#### Element properties:
Eg. JS converts html tag 'img' into dom. So the attributes like 'src' can be accessed from dom using: img.src = "new image url"

#### getAttribute() & setAttribute():
const link = document.querySelector('a');
link.getAttribute('href') --> gives similar result to 'link.href', but link.href gets href from javascript object(so link will be like: file://www.google.com), getAttribute('href') gets href directly from html (so link will be like: www.google.com).

link.setAttribute('href', '{new url}')

```
document --> in inspect, shows html of the document
console.dir(document) --> shows the js objects inside the document (js objects version of the html content, every html is converted to js object)
```
HTML Page:
```
<b></b>
<p></p>
```
JS objects of the page:
```
When we inspect and use command 'console.dir(document)', it gives us js object version of the html page. We have a key called 'all': which has values like b, p, section and every tag used in the html. When clicking these tags, it shows the innerText, innerHTML etc.
document.all --> gives the value inside the key 'all' (which is an array)
document.all[5] --> will give us b tag. (document.all[0] is html tag).
document.all[5].innerText = "new Name" --> name changed via the DOM.
```

#### Selecting in DOM:
```
document.getElementById() --> returns null if no id is found.
document.getElementById("chicken") --> in inspect, it will give html element with chicken id. So, to see it as js object, 
const chicken = document.getElementById("chicken");
console.dir(chicken);
getElementById is inside document -> prototype html document -> prototype document
getElementById returns a reference to the element with that id.
```
```
document.getElementsByTagName('p') --> in inspect, it provides html collection with js objects (which looks like an array, but not an js array). can traverse it like an array. If no element is found, it returns empty HTML collection.
document.getElementByClassName('square') --> can traverse it like an array. If no element is found, it returns empty HTML collection.
```
```
document.querySelector('#banner') / ('.square') / ('h1') --> selects 1st element (but you can do ('img:nth-of-type(2)') and get 2nd element), returns element itself as a js object.
can also do ('a[title='Java']') --> same as CSS, selecting by attribute. Can also do ('p a') etc like in CSS.

document.querySelectorAll('h1') --> returns all h1 tags, returned as NodeList
```

#### appendChild:
```
const body = document.body;
body.appendChild(div);
```

#### Creating:
document.createElement('option') --> creates an option element
Select tag, creating and adding option to it via DOM:
HTML for select tag with class eventSelection:
```
<select id="eventSelection" onchange="eventOnChange()" required> --> onchange: method in document object. Calls method when option which is selected changes.
    <option value="" hidden>--Select Event--</option> --> placeholder(has no value and is hidden)
</select>
```
hidden: if you want it to appear until you select another option, then it dissappears.
disabled: if you want it to appear, but unselectable.
JS for select tag with class ticket:
```
const ticket = document.getElementById('ticket'); --> this is a select tag
ticket.innerHTML = ""; --> clear pre existing options html inside select tag.
Can add own html using innerHTML but only like 'res.innerHTML = table'.

EXAMPLE:
```
let table = `
<table>
<tr>
    <th>Name</th>
    <th>Age</th>
    <th>Height</th>
    <th>Weight</th>
</tr>
`;

for(let arr of obj_array) {
    table += `
    <tr>
        <td>${arr.name}</td>
        <td>${arr.age}</td>
        <td>${arr.height}</td>
        <td>${arr.weight}</td>
    </tr>
    `;
}
table += '</table>';
res.innerHTML = table;
```
const clear = document.createElement('option');
clear.value = "";
clear.innerText = "--Select--";
clear.hidden = true;
ticket.add(clear);
```

#### remove:
document.getElementById('chicken').remove() --> remove element with that id

#### DOM Manipulation:
```
const span = document.querySelector('span');
span.textContent = 'Disgusting'; --> same as innerText(the text inside the tag), but textContent wont show the text inside tags that are set to display: none. (it shows whatever we see on screen).
span.innerHTML = '<b>Disgusting</b>'; --> html tags given here will be considered as html tags. On the screen it the text Digusting will be bold.
span.innerText = 'Disgusting'; --> shows not only what we see on screen, but also texts inside tags that are display: none.
```

### class, constructor:
```
class Student {
    constructor(studentId, studentName, department, contactNumber, status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.contactNumber = contactNumber;
        this.status = status;
    }
}

const student = new Student(studentId, studentName, department, contactNumber, status);
console.log(student.studentName);
```

### onclick, onchange, onsubmit:
```
<select id="eventSelection" onchange="eventOnChange()" required>
<form onsubmit="return false">
<button onclick="function()">
```
```
eventSelection.addEventListener("change", () => { --> eventSelection is select tag.

})
```

### CSS Selctors:
document.getElemetById('spl').style.color=red;
document.getElementById('check').checked --> returns true or false(boolean)
document.querySelector('#check.checked')
document.querySelector('input[type="checkbox"]:checked')

.checked --> js property access
:checked --> CSS selector matching (psuedo class selector)