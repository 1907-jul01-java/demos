# Soap-Demo
Contract Last example generating a JAX-WS Soap service. WSDL generated and found at:
http://localhost:8080/hello?WSDL

Example message to sayHello() method:
```xml
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <sayHello xmlns="http://soap.revature.com/">
            <name xmlns="">YourNameHere</name>
        </sayHello>
    </Body>
</Envelope>
```

To generate client code:
>wsimport -d generated -keep http://localhost:8080/hello?WSDL