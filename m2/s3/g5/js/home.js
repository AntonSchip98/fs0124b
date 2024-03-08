const apiKey =
  "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZGE4NTJkN2IxMTAwMTkwZTZkZjIiLCJpYXQiOjE3MDk4OTAxODEsImV4cCI6MTcxMTA5OTc4MX0.yiZeHOSSs45-l2pcM08ZnyxALMjy-L3POlgASv7Sya0";
const endPoint = "https://striveschool-api.herokuapp.com/api/product/";
const contaierProduct = document.querySelector("#product-container");

document.addEventListener("DOMContentLoaded", function () {
  fetch(endPoint, {
    method: "GET",
    headers: {
      Authorization: apiKey,
    },
  })
    .then((res) => res.json())
    .then((data) => {
      data.forEach((product) => {
        let cardProduct = generaClone();

        let cardImg = cardProduct.querySelector(".card-img-top");
        let cardTitle = cardProduct.querySelector(".card-title");
        let descriptionCard = cardProduct.querySelector(".card-text");
        let priceCard = cardProduct.querySelector(".text-muted");
        let btnEdit = cardProduct.querySelector("#edit-btn");
        let btnInfo = cardProduct.querySelector("#info-btn");

        cardImg.src = product.imageUrl;
        cardTitle.innerText = product.name;
        descriptionCard.innerText = product.description;
        priceCard.innerText = `€ ${product.price}`;
        btnEdit.href = `update.html?id=${product._id}`;
        btnInfo.href = `details.html?id=${product._id}`;

        contaierProduct.append(cardProduct);
      });
    })
    .catch((error) => {
      console.error("Errore durante la richiesta:", error);
    });
});

// function call(url, method) {
//   return fetch(url, {
//     method: method,
//     headers: {
//       authorization: apiKey,
//     },
//   });
// }

function generaClone() {
  let template = document.querySelector("#card-template");
  let clone = template.content.cloneNode(true);

  return clone;
}
