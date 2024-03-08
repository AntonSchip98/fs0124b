let url = new URLSearchParams(location.search);
let id = url.get("id");

const apiKey =
  "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGE4NTJkN2IxMTAwMTkwZTZkZjIiLCJpYXQiOjE3MDk4OTAxODEsImV4cCI6MTcxMTA5OTc4MX0.yiZeHOSSs45-l2pcM08ZnyxALMjy-L3POlgASv7Sya0";
let endPoint = `https://striveschool-api.herokuapp.com/api/product/${id}`;

console.log(id);

document.addEventListener("DOMContentLoaded", function () {
  fetch(endPoint, {
    method: "GET",
    headers: {
      Authorization: apiKey,
    },
  })
    .then((res) => res.json())
    .then((product) => {
      console.log(product);

      let cardImg = document.querySelector(".img-fluid");
      let cardTitle = document.querySelector("#title");
      let descriptionCard = document.querySelector("#description");
      let priceCard = document.querySelector("#price-details");
      let brandCard = document.querySelector("#brand");

      cardImg.src = product.imageUrl;
      cardTitle.innerText = product.name;
      descriptionCard.innerText = product.description;
      priceCard.innerText = `€${product.price}`;
      brandCard.innerText = product.brand;
    })
    .catch((error) => {
      alert("Errore durante la richiesta:", error);
    });
});
