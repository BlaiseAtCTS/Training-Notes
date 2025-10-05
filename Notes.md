Exceptions, Errors
difference:
checked exceptions is mandatory to handle
unchecked exceptions 
even if you return in try, 
catch block is not mandatory, only try and finally is.
array vs arraylist
comparison in collections: dynamic, peformance (respect to addition in the middle and last, deleting)
adding it in middle in arraylist is slower, because elements need to be shifted.
runtime polymorphism child object put to parent class

[2] === [2] false
```
try
    {
        int result = 10 / 0; 
    }
 
    catch (Exception ex)     {
        Console.WriteLine($"An unexpected error occurred: {ex.Message}");
    }
    catch (DivideByZeroException ex)
    {
        Console.WriteLine("Error: Division by zero occurred.");
    }
```
compiler error, the most generic should be at last.

let customers = [
   {
      'id': 001,
      'f_name': 'Abby',
      'l_name': 'Thomas',
      'gender': 'M',
      'married': true,
      'age': 32,
      'expense': 500,
      'purchased': ['Shampoo', 'Toys', 'Book']
   },
   {
      'id': 002,
      'f_name': 'Jerry',
      'l_name': 'Tom',
      'gender': 'M',
      'married': true,
      'age': 64,
      'expense': 100,
      'purchased': ['Stick', 'Blade']
   },
   {
      'id': 003,
      'f_name': 'Dianna',
      'l_name': 'Cherry',
      'gender': 'F',
      'married': true,
      'age': 22,
      'expense': 1500,
      'purchased': ['Lipstik', 'Nail Polish', 'Bag', 'Book']
   },
   {
      'id': 004,
      'f_name': 'Dev',
      'l_name': 'Currian',
      'gender': 'M',
      'married': true,
      'age': 82,
      'expense': 90,
      'purchased': ['Book']
   },
   {
      'id': 005,
      'f_name': 'Maria',
      'l_name': 'Gomes',
      'gender': 'F',
      'married': false,
      'age': 7,
      'expense': 300,
      'purchased': ['Toys']
   }
];

for(let c of customers) {
   if(c.expense > 60) {
      for(let l of c.purchased) {
        console.log(l);
      }
   }
}

for(let c of customers) {
   if(c.gender == 'M') {
      c[full_name] = "Mr." + f_name + " " + l_name;
   }
   else if(c.gender == 'F' && c.married == true) {
      c[full_name] =  "Mrs." + f_name + " " +l_name;
   }
   else if(c.gender == 'F' && c.married == false) {
      c[full_name] = "Ms." + f_name + " " + l_name;
   }
}

constructor chaining
method hiding
immutability of String
hashCode, from Object (hashCode)

contract between equals and hashCode method.
two objects can be different but have same hashCode. 
