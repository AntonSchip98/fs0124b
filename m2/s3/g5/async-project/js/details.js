import Swal from "../node_modules/sweetalert2/src/sweetalert2.js";
import { getCall } from "./functions.js";

let url = new URLSearchParams(location.search);
let id = url.get("id");
let endPoint = `https://striveschool-api.herokuapp.com/api/product/${id}`;

document.addEventListener("DOMContentLoaded", () => {
  getCall(endPoint)
    .then((product) => {
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
    .catch((err) => {
      Swal.fire({
        icon: "error",
        title: "Errore durante il caricamento dei dati",
        text: err,
      });
    });
});
