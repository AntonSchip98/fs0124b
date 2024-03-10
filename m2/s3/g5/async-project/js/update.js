import Swal from "../node_modules/sweetalert2/src/sweetalert2.js";
import { getCall, putCall, deleteCall } from "./functions.js";

let url = new URLSearchParams(location.search);
let id = url.get("id");
let endPointId = `https://striveschool-api.herokuapp.com/api/product/${id}`;

document.addEventListener("DOMContentLoaded", function () {
  getCall(endPointId)
    .then((products) => {
      let nameEdit = document.querySelector("#name");
      let brandEdit = document.querySelector("#brand");
      let priceEdit = document.querySelector("#price");
      let imageUrlEdit = document.querySelector("#imageUrl");
      let descriptionEdit = document.querySelector("#description");

      nameEdit.value = products.name;
      brandEdit.value = products.brand;
      priceEdit.value = products.price;
      imageUrlEdit.value = products.imageUrl;
      descriptionEdit.value = products.description;
    })
    .catch((err) => {
      Swal.fire({
        icon: "error",
        title: "Errore durante il caricamento dei dati",
        text: err,
      });
    });

  // BOTTONE PER FARE L'UPDATE
  const btnSave = document.querySelector("#save");
  btnSave.addEventListener("click", (e) => {
    e.preventDefault();

    let nameEdit = document.querySelector("#name").value;
    let brandEdit = document.querySelector("#brand").value;
    let priceEdit = Number(document.querySelector("#price").value);
    let imageUrlEdit = document.querySelector("#imageUrl").value;
    let descriptionEdit = document.querySelector("#description").value;

    let product = {
      name: nameEdit,
      description: descriptionEdit,
      brand: brandEdit,
      imageUrl: imageUrlEdit,
      price: priceEdit,
    };
    putCall(endPointId, product)
      .then((res) => {
        location.href = "home.html";
      })
      .catch((err) => {
        Swal.fire({
          icon: "error",
          title: "Errore durante il salvataggio dei dati",
          text: err,
        });
      });
  });

  // BOTTONE PER IL DELETE DEL PRODOTTO:
  const btnDelete = document.querySelector("#delete");
  btnDelete.addEventListener("click", (e) => {
    e.preventDefault();

    Swal.fire({
      title: "Sei sicuro?",
      text: "Questa azione eliminerà definitivamente l'elemento. Sei sicuro di voler procedere?",
      icon: "warning",
      showCancelButton: true,
      confirmButtonText: "Sì, elimina!",
      cancelButtonText: "Annulla",
      confirmButtonColor: "#d33",
    }).then((result) => {
      if (result.isConfirmed) {
        deleteCall(endPointId)
          .then((el) => {
            console.log("elemento eliminato" + el);
            location.href = "home.html";
          })
          .catch((err) => {
            Swal.fire({
              icon: "error",
              title: "Errore durante la rimozione dei dati",
              text: err,
            });
          });
      }
    });
  });

  // BOTTONE PER IL RESET DEL FORM
  const btnReset = document.querySelector("#reset");
  btnReset.addEventListener("click", (e) => {
    Swal.fire({
      title: "Sei sicuro?",
      text: "Le modifiche attuali andranno perse, sei sicuro di voler resettare?",
      icon: "question",
      showCancelButton: true,
      confirmButtonText: "Sì, resetta!",
      cancelButtonText: "Annulla",
    })
      .then((res) => {
        if (!res.isConfirmed) {
          e.preventDefault();
        } else {
          getCall(endPointId).then((data) => {
            let nameEdit = document.querySelector("#name");
            let brandEdit = document.querySelector("#brand");
            let priceEdit = document.querySelector("#price");
            let imageUrlEdit = document.querySelector("#imageUrl");
            let descriptionEdit = document.querySelector("#description");

            nameEdit.value = data.name;
            brandEdit.value = data.brand;
            priceEdit.value = data.price;
            imageUrlEdit.value = data.imageUrl;
            descriptionEdit.value = data.description;
          });
        }
      })
      .catch((err) => {
        Swal.fire({
          icon: "error",
          title: "Errore durante il caricamento dei dati",
          text: err,
        });
      });
  });
});

// BOTTONE PER IL RESET DEL FORM
const btnReset = document.querySelector("#reset");
btnReset.addEventListener("click", (e) => {
  Swal.fire({
    title: "Sei sicuro?",
    text: "Le modifiche attuali andranno perse, sei sicuro di voler resettare?",
    icon: "question",
    showCancelButton: true,
    confirmButtonText: "Sì, resetta!",
    cancelButtonText: "Annulla",
  })
    .then((res) => {
      if (!res.isConfirmed) {
        e.preventDefault();
      } else {
        getCall(endPointId).then((data) => {
          let nameEdit = document.querySelector("#name");
          let brandEdit = document.querySelector("#brand");
          let priceEdit = document.querySelector("#price");
          let imageUrlEdit = document.querySelector("#imageUrl");
          let descriptionEdit = document.querySelector("#description");

          nameEdit.value = data.name;
          brandEdit.value = data.brand;
          priceEdit.value = data.price;
          imageUrlEdit.value = data.imageUrl;
          descriptionEdit.value = data.description;
        });
      }
    })
    .catch((err) => {
      Swal.fire({
        icon: "error",
        title: "Errore durante il caricamento dei dati",
        text: err,
      });
    });
});
