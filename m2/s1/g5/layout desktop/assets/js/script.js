window.addEventListener("scroll", function () {
  const navbar = document.querySelector("#nav-bar");
  const right = document.querySelector(".right-side");
  let target = this.window.scrollY;

  if (target >= 300) {
    navbar.style.backgroundColor = "white";
  } else {
    navbar.style.backgroundColor = "";
  }

  if (target >= 800) {
    right.classList.add("fixed");
  } else {
    right.classList.remove("fixed");
  }
});
