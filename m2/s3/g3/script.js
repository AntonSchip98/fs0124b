fetch("https://striveschool-api.herokuapp.com/books")
    .then(function (res) { return res.json(); })
    .then(function (data) {
    var books = [];
    data.forEach(function (el) {
        var book = {
            img: el.img,
            title: el.title,
            price: el.price,
        };
        books.push(book);
    });
    createCard(books);
    function createCard(books) {
        // ELEMENTI ESISTENTI
        var containerCard = document.querySelector("#card-container");
        var containerCart = document.querySelector("#container-cart");
        books.forEach(function (book) {
            // ELEMENTI CREATI CON JS PER LE CARD
            var div1 = document.createElement("div");
            div1.classList.add("col-6", "col-md-3");
            var div2 = document.createElement("div");
            div2.classList.add("card", "mt-3");
            var img = document.createElement("img");
            img.classList.add("card-img-top");
            img.src = book.img;
            var div3 = document.createElement("div");
            div3.classList.add("card-body");
            var h6 = document.createElement("h6");
            h6.classList.add("card-title");
            h6.innerText = book.title;
            var p = document.createElement("p");
            p.classList.add("card-text");
            p.innerText = "".concat(book.price, " \u20AC");
            var btnRemove = document.createElement("button");
            btnRemove.classList.add("btn", "btn-danger", "p-1");
            btnRemove.innerText = "DELETE";
            var btnPurchase = document.createElement("button");
            btnPurchase.classList.add("btn", "btn-primary", "p-1", "ms-4");
            btnPurchase.innerText = "PURCHASE";
            btnRemove.addEventListener("click", function () {
                div1.remove();
            });
            btnPurchase.addEventListener("click", function (e) {
                var card = e.target.closest(".card");
                console.log(card);
                if (card) {
                    var title = card.querySelector(".card-title");
                    var price = card.querySelector(".card-text");
                    // SALVARE GLI ACQUISTI DENTRO SESSIONSTORAGE
                    var cart = {
                        title: title === null || title === void 0 ? void 0 : title.innerText,
                        description: price === null || price === void 0 ? void 0 : price.innerText,
                    };
                    var cartSession = JSON.parse(sessionStorage.getItem("BookCart") || "[]");
                    cartSession.push(cart);
                    sessionStorage.setItem("BookCart", JSON.stringify(cartSession));
                    // ELEMENTI CREATI CON JS PER IL CARRELLO
                    var li_1 = document.createElement("li");
                    li_1.classList.add("list-group-item", "d-flex", "justify-content-between", "align-items-start");
                    var divList1 = document.createElement("div");
                    divList1.classList.add("ms-2", "me-auto");
                    var divList2 = document.createElement("div");
                    divList2.classList.add("fw-bold");
                    var btnRemoveCart = document.createElement("button");
                    btnRemoveCart.classList.add("btn", "btn-danger");
                    btnRemoveCart.innerText = "Remove";
                    btnRemoveCart.addEventListener("click", function () {
                        li_1.remove();
                        sessionStorage.removeItem("BookCart");
                    });
                    if (title) {
                        divList2.innerText = title === null || title === void 0 ? void 0 : title.innerText;
                    }
                    if (price) {
                        divList1.innerText = price === null || price === void 0 ? void 0 : price.innerText;
                    }
                    containerCart.append(li_1);
                    li_1.append(divList1);
                    divList1.append(divList2);
                    li_1.append(btnRemoveCart);
                }
            });
            // APPENDS
            containerCard.append(div1);
            div1.append(div2);
            div2.append(img);
            div2.append(div3);
            div3.append(h6);
            div3.append(p);
            div3.append(btnRemove);
            div3.append(btnPurchase);
        });
    }
});
