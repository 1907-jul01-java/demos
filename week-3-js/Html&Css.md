# HTML
Hypertext Markup Language, or HTML, provides a structures to hypertext parsed by a browser. HTML documents are organized by element tags with attributes and values which are parsed, styled by CSS, and manipulated by JavaScript to render web sites and web apps.

## Document Object Model (DOM)
When parsing an HTML document, a virtual tree is constructed by a browser known as the DOM. This allows a browser to change and alter the content through stylesheets or scripts without affecting the original document file.

### HTML document
```html
<!doctype html>
<html>
  <head>
    <title>Index</title>
  </head>
  <body>
    <h1>Hello, world!</h1>
  </body>
</html>
```

### DOM
html
  └── head
  |    └── title
  |         └── Index
  └── body
       └── h1
            └── Hello, world!

## Critical Render Path
HTML document -> parsed -> DOM -> CSSOM -> Render Tree -> Layout -> Paint -> Composite
1. Constructing the DOM Tree
2. Constructing the CSSOM Tree
3. Running JavaScript
4. Creating the Render Tree
5. Generating the Layout
6. Painting

CSS is a render blocking resource, holding up the Render Tree, while JavaScript is a parser blocking resource pausing at each `<script>` tag without an `async` attribute. The Render Tree is the combination of the DOM and CSSOM. The Layout is determined by the viewport, default 980px width if not set like below:
`<meta name="viewport" content="width=device-width,initial-scale=1">`
