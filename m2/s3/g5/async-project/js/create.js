import Swal from "../node_modules/sweetalert2/src/sweetalert2.js";
import { postCall } from "./functions.js";

const btnSave = document.querySelector("#save");

btnSave.addEventListener("click", (e) => {
  e.preventDefault();

  let name = document.querySelector("#name").value.trim();
  let description = document.querySelector("#description").value.trim();
  let brand = document.querySelector("#brand").value.trim();
  let imageUrl = document.querySelector("#imageUrl").value.trim();
  let price = document.querySelector("#price").value.trim();

  let product = {
    name,
    description,
    brand,
    imageUrl,
    price,
  };

  if (!name || !price || !imageUrl || !brand || !description) {
    Swal.fire({
      icon: "warning",
      title: "Assicurati di compilare tutti i campi.",
    });
    e.preventDefault();
  } else {
    postCall(product)
      .then((res) => (location.href = "home.html"))
      .catch((err) =>
        Swal.fire({
          icon: "error",
          title: "Errore durante il caricamento dei dati",
          text: err,
        })
      );
  }
});
