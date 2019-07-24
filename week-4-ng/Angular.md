# Angular
## Requirements
To build an Angular application, you will need Node.js and the Angular CLI tool. Installing Node.js will also install `npm`, the Node Package Manager which you can use to install Angular CLI:
>npm install @angular/cli -g

The `-g` flag will install the tool globally, so don't forget it! Use `ng -v` to check that you have Angular CLI correctly installed.

## Getting Started
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