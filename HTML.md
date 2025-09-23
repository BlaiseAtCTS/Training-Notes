# HTML Notes
### Types of Elements:
Inline(They only take space required for the element): a, span tag
Block(They take up entire horizontal space): p, div tag
div and span are generic elements, but div is a block and span is an inline.
(Can change this with CSS Display Property).

Elements: hr: horizontal line, sup: superscript, sub: subscript
Entity Code: To use things like Copyright symbol.
Semantic Markup: Such as Block Semantic Tags: main, section, nav, article, header, footer.
Inline Semantic Tags: strong, em, abbr, cite, time, code.

### Tables:
Tags: tr, th, td, thead, tbody, tfoot.
Colspan, Rowspan: To extend Column or Row to use more than 1 column or row (Spanning).

### Forms: 
Label: Associate an input tag with a text. Useful for screen readers.
```<label for="cheese"> ---> <input id="cheese"> ('for' connects to 'id')```
```<form action="/tacos"> (any button inside the form will redirect page to /tacos unless explicitly set not to)```
```<button> --> submits the form```
```<button type="button"> --> doesnt submit the form```
```<input type="submit"> --> submits the form```
Name tag: Used to define elements sent to server.
Eg. If you submit a form to /tacos, with a productID entered in input tag, with tags name as "ProdID", it will be sent with url /tacos?ProdID=100
```<input type="text" name="ProdID"> --> /tacos?ProdID=100```
Data is visible in url (Because this is a GET request).
Checkbox Tag: When submitted, value is either 'on' or no value.
Radio Tag: Group of radios with same name --> can click only one. Set value="" for each radio tag to send some data when submitting form.
```<input type="radio" name="Pos" value="W"> --> /tacos?Pos=W```
Select Tag: Select and Option tags are used. Each option should have a value to send.
Range Tag: A sliding bar. Can set min and max.
Textarea Tag: Can set initial number of rows and cols.
Form Validation attributes: minlength, maxlength, required, (min & max) for numbers, regular expressions, pattern (For 6 digit pincode: pattern="[0-9]{6}").

When using a select tag, the value will be changed to whatever option is pressed. Default value is "".

### Accepting files:
```
<input type='file' accept='.jpeg, .jpg, .pdf'>
```

### Pattern attribute:
```
+ -> one or more occurences of the given characters.
pattern='[A-Za-z ]+' -> names like ' ', 'Adam', 'Adam Smith' are allowed.
If you dont want just space as name --> pattern='.*[A-Za-z].*' -> '.*' means anything(including space) before or after alphabets.

* -> zero or more occurences of the given characters.
```

#### Automation testing:
Html attribute called data-test="testdata"