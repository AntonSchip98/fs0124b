interface Book {
  img: string;
  title: string;
  price: number;
}

fetch("https://striveschool-api.herokuapp.com/books")
  .then((res) => res.json())
  .then((data: object[]) => {
    const books: Book[] = [];

    data.forEach((el: any) => {
      const book: Book = {
        img: el.img,
        title: el.title,
        price: el.price,
      };
      books.push(book);
    });

    createCard(books);

    function createCard(books: any) {
      // ELEMENTI ESISTENTI
      const containerCard: Element = document.querySelector("#card-container")!;
      const containerCart: Element = document.querySelector("#container-cart")!;

      books.forEach((book: any) => {
        // ELEMENTI CREATI CON JS PER LE CARD
        const div1 = document.createElement("div");
        div1.classList.add("col-6", "col-md-3");
        const div2 = document.createElement("div");
        div2.classList.add("card", "mt-3");
        const img = document.createElement("img");
        img.classList.add("card-img-top");
        img.src = book.img;
        const div3 = document.createElement("div");
        div3.classList.add("card-body");
        const h6 = document.createElement("h6");
        h6.classList.add("card-title");
        h6.innerText = book.title;
        const p = document.createElement("p");
        p.classList.add("card-text");
        p.innerText = `${book.price} €`;
        const btnRemove = document.createElement("button");
        btnRemove.classList.add("btn", "btn-danger", "p-1");
        btnRemove.innerText = "DELETE";
        const btnPurchase = document.createElement("button");
        btnPurchase.classList.add("btn", "btn-primary", "p-1", "ms-4");
        btnPurchase.innerText = "PURCHASE";

        btnRemove.addEventListener("click", () => {
          div1.remove();
        });

        btnPurchase.addEventListener("click", (e) => {
          const card: HTMLElement | null = (e.target as HTMLElement).closest(
            ".card"
          );
          console.log(card);
          if (card) {
            const title: HTMLElement | null = card.querySelector(".card-title");
            const price: HTMLElement | null = card.querySelector(".card-text");

            // SALVARE GLI ACQUISTI DENTRO SESSIONSTORAGE
            const cart = {
              title: title?.innerText,
              description: price?.innerText,
            };

            let cartSession: any[] = JSON.parse(
              sessionStorage.getItem("BookCart") || "[]"
            );
            cartSession.push(cart);
            sessionStorage.setItem("BookCart", JSON.stringify(cartSession));

            // ELEMENTI CREATI CON JS PER IL CARRELLO
            const li = document.createElement("li");
            li.classList.add(
              "list-group-item",
              "d-flex",
              "justify-content-between",
              "align-items-start"
            );
            const divList1: HTMLElement = document.createElement("div");
            divList1.classList.add("ms-2", "me-auto");
            const divList2: HTMLElement = document.createElement("div");
            divList2.classList.add("fw-bold");
            const btnRemoveCart = document.createElement("button");
            btnRemoveCart.classList.add("btn", "btn-danger");
            btnRemoveCart.innerText = "Remove";

            btnRemoveCart.addEventListener("click", () => {
              li.remove();
              sessionStorage.removeItem("BookCart");
            });

            if (title) {
              divList2.innerText = title?.innerText;
            }
            if (price) {
              divList1.innerText = price?.innerText;
            }
            containerCart.append(li);
            li.append(divList1);
            divList1.append(divList2);
            li.append(btnRemoveCart);
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
