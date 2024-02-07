const inputTask = document.querySelector(".inputTask");
const btnAdd = document.querySelector(".btnAdd");
const taskList = document.querySelector(".taskList");

// Aggiungere task
btnAdd.addEventListener("click", function () {
  const task = inputTask.value.trim();

  if (task !== "") {
    // creazione elementi del div contenente li e button
    const div = document.createElement("div");
    const li = document.createElement("li");
    const btnRemove = document.createElement("button");
    btnRemove.textContent = "X";
    li.textContent = task;
    div.classList.add("divEl");
    li.classList.add("taskElement");
    btnRemove.classList.add("btnRemove");
    taskList.append(div);
    div.append(li, btnRemove);

    // resettare l input
    inputTask.value = "";

    // evento per il li
    li.addEventListener("click", function () {
      li.classList.toggle("lineThrough");
    });
    // evento per il btnRemove
    btnRemove.addEventListener("click", function () {
      div.remove();
    });
  }
});

// sbarrare la task
