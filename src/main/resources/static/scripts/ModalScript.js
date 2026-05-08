const ProductsList = document.querySelectorAll(".ProductDiv");

let name = "";
let priceInCents = "";
let quantity = "";
let category = "";

for (let i = 0; i < ProductsList.length; i++){
    ProductsList[i].addEventListener("click", (e)=>{
        
        name = String(ProductsList[i].querySelector(":nth-of-type(1)").innerHTML);
        priceInCents = ProductsList[i].querySelector(":nth-of-type(2)").innerHTML;
        quantity = ProductsList[i].querySelector(":nth-of-type(3)").innerHTML;
        category = ProductsList[i].querySelector(":nth-of-type(4)").innerHTML;
        
        const Values = ValuesHandler(name, priceInCents, quantity, category);
        
        document.getElementById("ProductsContainerID").style.display = "none";
        OpenModal(Values[0], Values[1], Values[2], Values[3]);
    })
}

function ValuesHandler(name, price, quantity, category){
    
    const ArrayValues = [name, price, quantity, category];

    for (i = 0; i < ArrayValues.length; i++){
        ArrayValues[i] = String(ArrayValues[i]).replaceAll("<b>", "");
        ArrayValues[i] = String(ArrayValues[i]).replaceAll("<b ", "");
        ArrayValues[i] = String(ArrayValues[i]).replace(/id="priceID"/g, "");
        ArrayValues[i] = String(ArrayValues[i]).replaceAll("</b>", "");
        ArrayValues[i] = String(ArrayValues[i]).replace(">", "");
    }

    return ArrayValues;
}

function OpenModal() {
    const modal = document.querySelector('.ModalWindow');
    /*modal.innerHTML = `${name}<br>${price}<br>${quantity}<br>${category}`*/

    modal.classList.add('open');
}

function CloseModal() {
    const modal = document.querySelector('.ModalWindow');
    document.getElementById("ProductsContainerID").style.display = "flex";
    modal.classList.remove("open");
}