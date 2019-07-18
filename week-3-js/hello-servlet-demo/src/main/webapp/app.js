let greeter = function() {
    return 'Welcome';
};

let greetingElement = document.querySelector('#greeting');
greetingElement.innerHTML = greeter();

/*
When a function gets declared, it contains a function
definition and a closure. The closure is a collection
of all the variables in scope at the time
of creation of the function
*/
function counter() {
    let count = 0;
    let getCount = function() {
        count += 1;
        return count;
    }
    return getCount;
}

let increment = counter();
let c1 = increment();
let c2 = increment();
let c3 = increment();
console.log('counts', c1, c2, c3);

let animes = [
    {
        title: 'One Punch Man',
        episodes: 24,
        genre: 'Shonen'
    },
    {
        title: 'Black Clover',
        episodes: 54,
        genre: 'Shonen'
    },
    {
        title: 'Attack On Titan',
        episodes: 30,
        genre: 'Shonen'
    },
    {
        title: 'Food Wars',
        episodes: 54,
        genre: 'Comedy'
    }
];

let animesElement = document.querySelector('#animes');
function ListAnimes(animes) {
    return `<div>
                ${animes.map(ListAnime).join('<hr>')}
            </div>
    `
}
function ListAnime(anime) {
    return `<div>
                <h2>${anime.title}</h2>
                <h3>${anime.episodes}</h3>
                <h4>${anime.genre}</h4>
            </div>
    `
}
animesElement.innerHTML = ListAnimes(animes);

// AJAX
let req = new XMLHttpRequest();
req.open('get', 'http://localhost:8080/servlet-demo/goodbye');
// req.onreadystatechange = function() {
//     if (this.readyState == 4) {
//         console.log(req.response);
//     };
// }
req.onload = function() {
    console.log(req.responseText);
}
req.onerror = function() {
    console.log('oops')
}
req.send();

// Promise + AJAX
function get(url) {
	return new Promise(function(resolve, reject) {
		let xhr = new XMLHttpRequest();
		xhr.open('get', url);
		xhr.onload = function() {
			if (xhr.response.status == 200) {
				resolve(xhr.response);
			} else {
				reject(Error(xhr.response));
			}
		}
		xhr.onerror = function() {reject(Error("Network error"))};
		xhr.send();
	}) 
}

//get("http://localhost:8080/servlet-demo/hello")
//	.then(function(response) {
//		console.log("success");
//	}, function(err) {
//		console.log(err);
//	});


function call() {
    get("http://localhost:8080/servlet-demo/hello")
	.then(function(response) {
		console.log(response);
	})
	.catch(function(err) {
		console.log(err);
    });
    
};