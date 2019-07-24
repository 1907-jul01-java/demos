let moviesElement = document.querySelector('#list');

function ListMovies(movies) {
    return `<div>
                ${movies.map(ListMovie).join('<hr>')}
            </div>
    `
}
function ListMovie(movie) {
    return `<div>
    			<p>${movie.id}</p>
                <p>${movie.name}</p>
            </div>
    `
}

let movies = []

let req = new XMLHttpRequest();
req.open('get', 'http://localhost:8080/rest-demo/api/v2/movies', true);

req.onload = function() {
    movies = JSON.parse(req.responseText)
    moviesElement.innerHTML = ListMovies(movies);
}
req.onerror = function() {
    console.log('oops')
}
req.send();