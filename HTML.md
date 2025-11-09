# HTML Notes
Iframes:
https://www.bing.com/search?qs=MT&pq=what+are+if&sk=CSYN1&sc=16-11&pglt=2083&q=what+are+iframes&cvid=5f64eadcc3444e2b8719ec87c54e1f18&gs_lcrp=EgRlZGdlKgYIABAAGEAyBggAEAAYQDIGCAEQABhAMgYIAhAAGEAyBggDEAAYQDIGCAQQABhAMgYIBRAAGEAyBggGEAAYQDIGCAcQABhAMgYICBAAGEAyCAgJEOkHGPxV0gEIMjkzOGowajGoAgCwAgA&FORM=ANNAB1&PC=U531
### Types of Elements:
Inline(They only take space required for the element): a, span, input, button, img tag
Block(They take up entire horizontal space): p, div, h1-h6, header, footer tag
div and span are generic elements, but div is a block and span is an inline.
(Can change this with CSS Display Property).

inline elem ignore width, height.
    if you do display: block, it will accept it.
block doesnt.
    even if it has w & h, it will still take up entire line.
        inline-block allows to set w & h, but doesnt take up entire line.

Elements: hr: horizontal line, sup: superscript, sub: subscript
Entity Code: To use things like Copyright symbol.
Semantic Markup: Such as Block Semantic Tags: main, section, nav, article, header, footer.
Inline Semantic Tags: strong, em, abbr, cite, time, code.

### display: none & visiblity: hidden:
none removes the element from the page.
hidden just make it invisible. still takes space.
https://www.youtube.com/watch?v=zI6DW1Sinqc
https://www.youtube.com/watch?v=wsTv9y931o8

### Tables:
Tags: tr, th, td, thead, tbody, tfoot.
Colspan, Rowspan: To extend Column or Row to use more than 1 column or row (Spanning).

### Semantic Tags:
Clearly provide meaning about the content to the browser. Like nav, section, article.

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
input type = Checkbox Tag: When submitted, value is either 'on' or no value.
input type = Radio Tag: Group of radios with same name --> can click only one. Set value="" for each radio tag to send some data when submitting form.
```<input type="radio" name="Pos" value="W"> --> /tacos?Pos=W```
Select Tag: Select and Option tags are used. Each option should have a value to send.
Input type = range: A sliding bar. Can set min and max.
Textarea Tag: Can set initial number of rows and cols.
Form Validation attributes: minlength, maxlength, required, (min & max) for numbers, regular expressions, pattern (For 6 digit pincode: pattern="[0-9]{6}").

When using a select tag, the value will be changed to whatever option is pressed. Default value is "".

### Accepting files:
```
<input type='file' accept='.jpeg, .jpg, .pdf' multiple> -> multiple accepts multiple files
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

## Traverse HTML table:
```
driver.get("https://demoqa.com/webtables");
        WebElement table = driver.findElement(By.className("rt-tbody"));
        List<WebElement> rows = table.findElements(By.className("rt-tr-group"));
        for(WebElement row : rows) {
            System.out.println(row.getText());
//            List<WebElement> cells = row.findElements(By.className("rt-td"));
//            cells.stream()
//                    .forEach(cell -> System.out.print(cell.getText() + " "));
            System.out.println();
        }
```
```
function loopTableCells() {
    // 1. Get the table element by its ID
    const table = document.getElementById('myTable');

    // 2. The outer loop iterates through the rows
    // table.rows is an HTMLCollection of all <tr> elements (including <thead> and <tfoot> rows)
    for (let i = 0; i < table.rows.length; i++) {
        let row = table.rows[i];
        
        // Skip the header row if you only want data rows.
        // If you are using <thead>, you might start the loop at i=1 or use table.tBodies[0].rows
        if (i === 0) {
            console.log("--- Header Row Skipped ---");
            // continue; // Uncomment to skip the header row
        }

        // 3. The inner loop iterates through the cells (columns) in the current row
        for (let j = 0; j < row.cells.length; j++) {
            let cell = row.cells[j];
            
            // Access the content of the cell
            let cellContent = cell.textContent; 

            // Example action: Log the row/column and content
            console.log(`Row ${i}, Column ${j}: ${cellContent}`);

            // Example action: Modify a cell's style
            // cell.style.backgroundColor = 'yellow';
        }
    }
}

loopTableCells();
```