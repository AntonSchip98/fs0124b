"use strict";
console.log("ciao");
fetch("https://striveschool-api.herokuapp.com/books")
    .then((res) => res.json())
    .then((data) => console.log(data));
