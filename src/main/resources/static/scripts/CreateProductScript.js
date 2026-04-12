let SubmitButton = document.getElementById("submitFormID")

let priceInput = document.getElementById("priceInCentsID");

priceInput.addEventListener("input", ()=> {
    let price = String(document.getElementById("priceInCentsID").value);
    newPrice = price.replace(/[a-zA-Z]+/g, "");
    document.getElementById("priceInCentsID").value = Number(newPrice);
    console.log(newPrice);
})

function ValidatePrice() {
    let price = String(document.getElementById("priceInCentsID").value);
    price = price.replace(".", "");
    price = price.replace(",", "");
    price = price.replace("+", "");
    price = price.replace("-", "");
    price = price.replace(/[^0-9]+/g, "");
    return Number(price)
};

SubmitButton.addEventListener("click", ()=> {
    event.preventDefault();
    let price = ValidatePrice();
    document.getElementById("ProductID").submit();
})