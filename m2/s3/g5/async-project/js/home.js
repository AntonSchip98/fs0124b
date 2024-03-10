import Swal from "../node_modules/sweetalert2/src/sweetalert2.js";
import { getCall, generaClone, endPoint } from "./functions.js";

const contaierProduct = document.querySelector("#product-container");
const loading = document.getElementById("loading-spinner");

document.addEventListener("DOMContentLoaded", async () => {
  loading.style.display = "inline";
  getCall(endPoint)
    .then((res) =>
      res.forEach((product) => {
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
        loading.style.display = "none";
      })
    )
    .catch((err) => {
      Swal.fire({
        icon: "error",
        title: "Errore durante il caricamento dei dati",
        text: err,
      });

      loading.style.display = "none";
    });
});
