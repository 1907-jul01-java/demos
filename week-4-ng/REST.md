# REST
Representational State Transfer, or REST, describles the architectural constraints of a web service governing access to representations of stateful resources. A RESTful web service exposes several endpoints for various operations over HTTP requests and responses, which can be used by many different web technologies.

## Constraints of REST
### Uniform interface
A RESTful web service relies on an HTTP request's URL and method to identify and manipulate specific resources. A `GET` should simply request a resource, a `POST` will likely create one, and a URL such as `people/21` should identify and return the person whose id is 21.

### Client–server
Assuming transactions occur between a client and a server, a RESTful HTTP request should only interact with the interface representing available resources without concern for the details of how the data is stored or accessed on the server.

### Stateless
An HTTP request carries only what is needed to access a resource, and no client information is stored by the server.

### Cacheable
Resources should be safe to cache on one or more points between the client and the server to speed up repetitive communication.

### Layered system
A client should have no knowledge of the server's network architecture, and only request from the API's exposed endpoints.

### Code on demand (optional)
A server can deliver snippets of code to the client to provide extra functionality.

## HATEOS - Hypermedia as the engine of application state
Some RESTful web services not only send a representation of a resource, but provide hypertext links to other related resources on the server. This allows client applications to dynamically discover available actions and endpoints without extensive documentation or repetitive requests.