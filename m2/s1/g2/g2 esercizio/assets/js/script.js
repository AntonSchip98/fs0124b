window.addEventListener("scroll", function () {
  var header = document.querySelector("header");
  var scrollPosition = window.scrollY;

  if (scrollPosition > 200) {
    header.classList.add("fixed-top");
  } else {
    header.classList.remove("fixed-top");
  }
});
