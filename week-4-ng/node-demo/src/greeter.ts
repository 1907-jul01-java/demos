// export function hello(name: string): string {
//     return "hello " + name
// }

export namespace com{ 
    export class greeter {
        private name: string;

        constructor(name: string) {
            this.name = name;
        }

        public get value() : string {
            return this.name;
        }
    }   
}
