# CSS Notes
color
background-color
font-family
font-weight
line-height: space between lines
box-shadow: 12px 12px 12px 12px red (offset-x, offset-y, blur-radius, spread-radius, color)
cursor: pointer

### background:
background-image: url("")
background-size: contain(no crop of image, but might repeat) | cover(crop and cover whole area)
background-repeat: repeat
background-position: top (top part of the image is visible)

### CSS Selectors:
Define patterns to select the elements you want to style on a webpage. 

### Combinators:
Symbols that specify the relationship between selectors, like descendant, child, or adjacent sibling.

### Responsive Web Design (RWD):
Approach to design and development where content adjusts dynamically to fit various screen sizes and devices.

### Flexbox:
CSS layout model providing an efficient way to arrange, align, and distribute space among elements in a container.

### Adjacent Sibling Selectors:
h2 + button --> button tag which comes right after(side by side to h2) a h2 tag.

### Direct Descendant(child) Selectors:
footer > a --> anchor tag which is a direct child of footer tag.

### Genral sibling selectors:
div ~ p --> p is sibling of div, because they both have same parent (body)

### Attribute Selectors:
input[type="password"] --> only affect input with type attribute as password.
input[href*="google"] --> select href that has the word 'google' in the link.
a.User --> anchor tag with class "User".

### Pseudo Classes:
Keyword added to a selector that specifies the state of the element. Eg: button:hover
```.post:nth-of-type(3) --> Selects the 3 rd element in post class```
```.post:nth-of-type(1n) --> Selects every other element in post class```

### Pseudo Elements:
Denoted by ::
```h2::first-letter --> select first letter of every h2```
```p::selection { background-color: red; } --> change color when you select paragraphs```

### Cascade:
The final CSS properties is set. Eg. If you set h1 color as red in first css file and set h1 color as blue in second css file, the final color of h1 will be blue.

### Specificity:
When two or more elements have same CSS properties, there is a conflict. Now, whichever element is more specific wins.
```h2 { color: red } is less specific than .post h2 { color: blue } so blue is applied```
How specific? ID > Class, Pseudo class, Attributes > Element, Pseuedo elements

### CSS Inheritence
If you set color of body as red, red will be inherited to all elements in the body. But some elements like button, input wont inherit the properties. So you can set button / input color as inherit.

### Box Model:
*Flex works for child tags, inline or block works for the tags itself*
Width & Height, Border, Padding, Margin, Border Radius, Display, Units (Percentage, em, rem)

In chrome, Blue -> Content area, Green -> Padding, Orange -> Margin

For border, you need to set: border-width, border-color, border-style
If box width is 200px, and border width is 5px, the total box width will still be 210px.
```border-style: solid dashed inset none;``` (left right top bottom)
Short form: border: _width_ _style_ _color_
and can update each side like: border-left-style: dashed

box-sizing: border-box:
If box width is 200px, and border width is 5px, the total box width will still be 200px.

padding: top right bottom left (same for margin)

#### Display Property:
Inline:
If you use Span with inline attribute:
Width and Height are ignored.
Padding and Margin give horizontal space, no vertical space.
Padding is there vertically, but doesnt push other content away. (no force field)

Block:
Opposite of Inline.
Width, Height, Padding, Margin, everything is respected and content is pushed away. (force field)

Inline-Block:
When using Block element like 'div', element takes whole block space. If you change it to Inline by setting 'display: inline', then width and height are not respected (they are ignored). So we use 'inline-block'.

None:
Element isnt deleted, they show up in inspect. But they are not visible and their space is deleted.

### Sizing: (For font size)
em: 2em is twice the size of parent element. But if you add another css property like 1em (1em wont be size of parent element, instead it will be the computed font size i.e 2em)
```.parent { font-size: 20px; }```
```h2 { font-size: 2em; margin-left: 2em; } --> font-size = 40px and margin-left = 80px```
Disadvantage of em: When we use nested elements, the size changes for each nested element.

rem: Root element's font-size.
```html { font-size: 20px; }```

### Alpha & Opacity:
rgba(0, 0, 255, 0) --> last 0 is alpha, 0 is no transparency, 1 is fully transparent
opacity: 0 --> 0 to 1
Opacity impacts the opacity of all elements inside.
Alpha only affects specific color like background-color.

### position:
How an element is positioned in a document.

Static: Its the default. Its fixed in place even if you give top, right, left, bottom values.

Relative: setting top, right, left, bottom value here will put space on top, right, left or bottom of element. (relative to original position). In relative, even if you move the element, the orignal space is not occupied by other elements.

Absolute: The element is removed from normal document flow. i.e. if you have 3 boxes, and set box 2 to be absolute, box 3 will think that box 2 is removed and will move behind box 2. (Box 2 sits top of document flow, so other elements can move through box 2). Since its out of normal document flow, top: 50px is in respect to the ancestor with position property or the body tag.

Fixed: The element is removed from normal document flow and no space is left for it. But its fixed to the screen if you scroll.

-webkit-sticky: sticks to the top of the screen only when its about to go away from screen when you scroll. Nav bars are created using this.

### transition:
When you set :hover, it quickly switches from 'not being hovered' to 'being hovered'. transition is used to make it smooth with timing (seconds) eg. 1s.
```
transition: background-color 3s, border-radius 2s --> background-color takes 3s, border-radius takes 2s.
transition background-color 3s 1s --> 1s is delay.
transition-timing-function: linear / ease-in / ease-out / steps(6, end) --> moves step by step(6 steps) / cubic-bezier(0.85, 0, 0.15, 1) --> transition graph
```

### Centering:
margin: 10px auto --> horizontal centering
align-self: flex-start / flex-end / center
    align-self --> moves the container div to the right or left or center. But it doesnt affect the div or p inside the container div.
align-items: flex-start / flex-end / center
    aligns the items inside the div container.

### transform:
one full circle is 360deg, for grad it is 400grad.
rotate(360deg): Units are deg(360deg), grad(400grad), rad(6.2832rad) --> radians, turn(1 turn is one full circle). rotateX(), rotateY() --> 3d along x and y axis.
transform-origin: center, top left, bottom right, 50px 50px --> offset by pixels
scale(0.5), scaleX(), scaleY()
translateX(), translateY() move left, right or top, bottom. (similar to positon: relative)
skew(30deg)

### flexbox:
Has Main axis(X) and Cross axis(Y) by default, But if you do flex-direction: column (now main axix is Y).
The way how elements in a webpage, shrinks when the browser window is shrinked.
```
display: flex, flex-direction: row(default, elements are from left to right) / row-reverse(right to left) / column / column-reverse
```

#### justify-content:
start, end, center --> start is default(left to right, similar to flex-direction: row). end is opposite(right to left, similar to flex-direction: row-reverse (but that starts the first element from the right, justify-content: end just moves it to the end / right)). center, centers content along the main axis. space-between distributes space between elements but not on the outside edges. space-around: each element has a specific amount of space on left and right side(even on the outside edges). space-evenly: even spaces on the outside edge and between.

#### Difference between flex and inline, block:
Flex:
HTML:
```
<div id="container">
<div>One</div>
<div>Two</div>
</div>
```
CSS:
```
#container {
    display: flex; --> makes the container div, a flex container (all children inside are flex items, so they are ordered inline).
}
```

Inline:
HTML:
```
<div id="container">
<div>One</div>
<div>Two</div>
</div>
```
CSS:
```
#container div{
    display: inline; --> makes the div items inline, so they are ordered inline.
}
```


###
using flex --> use justify-content