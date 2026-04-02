let SubmitButton = document.getElementById("submitFormID")

let priceInput = document.getElementById("price_in_centsID");

priceInput.addEventListener("input", ()=> {
    let price = String(document.getElementById("price_in_centsID").value);
    newPrice = price.replace(/[a-zA-Z]+/g, "");
    document.getElementById("price_in_centsID").value = Number(newPrice);
    console.log(newPrice);
})

function ValidatePrice() {
    let price = String(document.getElementById("price_in_centsID").value);
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