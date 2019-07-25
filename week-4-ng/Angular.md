# Angular
## Requirements
To build an Angular application, you will need Node.js and the Angular CLI tool. Installing Node.js will also install `npm`, the Node Package Manager which you can use to install Angular CLI:
>npm install @angular/cli -g

The `-g` flag will install the tool globally, so don't forget it! Use `ng -v` to check that you have Angular CLI correctly installed.

## Angular CLI
To begin a new project, use the `ng new` command:
>ng new yourApp

This creates a `yourApp` folder with a bootstrapped Angular project ready to go. The `new` keyword has several options such as `--minimal` which will bootstrap a project with only the necessary files while `--routing` will incorporate the Angular Routing module into the bootstrapping.

To test it out, enter the project directory and then run:
>ng serve

This bundles and deploys the application onto a development server at `localhost:4200`.

Angular bootstraps an App Module and an App Component for you to start, but you can start generating new components, services, and routes with the `ng generate` command.
>ng generate component your-component

Or `ng g c your-component` for short. The `generate component` command also has serveral options for its bootstrapping such as `--flat=true` to create files at the top level of the project structure,  `--inlineStyle=true` to add internal CSS instead of creating an external file, `--inlineTemplate=true` to do the same for HTML, or `--skipTests=true` to skip test file generation.

The `generate` command can also create and scaffold Services, Route Guards, Directives, Classes, and other Angular elements.

When building the project for release, run:
>ng build 

This will place build artifacts in the dist/ directory using the default environment. Use options to specify the environment to build toward, such as `--prod` for production.

## Single Page Application
Angular is a framework designed around the Single Page Application, an architectural style where a single HTML file loads the entirety of the application, organized into reusable components. When the application state must change, Angular will dynamically alter the DOM using one of its many `Directive` elements and attributes:
- Components: a template, style sheet, and controller logic bundled as a single unit.
- Structural: logical conditions and control statements to alter the DOM structure.
- Attribute: properties changing style and behavior of elements.

## Templates
Angular templates extend basic HTML syntax with data-binding expressions that map to objects in TypeScript controllers:

### Interpolation
Denoted by double curly braces surrounding an expression which binds the tag to its output.
```html
<p>Counter: {{ counter }} </p>
```

### Event binding
Denoted by parenthesis surrounding a browser event and defined by a method call. It can be used to bind an event listener between them.
```html
<button (click)="incrementCounter()">Increment Counter</button>
```
### Property binding
Denoted by square brackets surrounding a DOM property and defined by a template expression. It can also be used to attach an object to an attribute directive or provide input to child components.
```html
<div [ngStyle]="styleObject">
    <p>This div is styled using property binding.</p>
</div>

<app-child [childObject]="parentObject"></app-child>
```

### Two-Way Data Binding
Defined by a pair of square brackets surrounding parenthesis surrounding an attribute directive. It combines the one-way behavior of event binding with the opposite direction one-way behavior of property binding. It can be used with the `ngModel` directive (`import { FormModule } from @angular/forms`).

```html
<input [(ngModel)]="styleObject.color" name="color" type="text">
```

## Pipes & filtering expressions
Pipes are a way to write display-value transformations that you can declare in your HTML. Add a `|` character after an expression to filter with default or custom filters.

```html
Current date with medium date and lowercase pipes: {{currentTime | date:'medium' | lowercase}}
```

```ts
setInterval(() => { this.currentTime = new Date(); }, 1000 );
```

## Routing
Angular single page applications sometimes need to change the component layout completely. To replace the normal behavior of the HTML anchor tag, the attribute directive `routerLink` is mapped to a component:

```html
<a routerLink="/http">HTTP</a>
```

A `router-outlet` directive is where Angular will dynamically insert and remove components loaded by a route.

## RxJS Observables
The `HttpClientModule` provides access to `HttpClient`, an API for making HTTP calls. Create and inject an Angular Service into a component to fetch data from a web service and update a template.

### Service
```ts
@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private httpClient: HttpClient) { }

  getPosts(): Observable<any> {
    return this.httpClient.get('http://jsonplaceholder.typicode.com/posts').pipe(
      map(res => res)
    );
  }
}
```

### Component
```html
<p *ngFor="let post of posts | async">
    {{post.id}}. {{post.title}}
</p>
```

```ts
export class HttpComponent implements OnInit {
  posts: Observable<any>;

  constructor(private httpService: HttpService) { }

  ngOnInit() {
    this.posts = this.httpService.getPosts();
  }
}
```